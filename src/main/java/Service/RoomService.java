package Service;

import DAO.Enums.*;
import Model.Room;
import Service.iService.IBasicCRUD;
import View.Client.ClientView;
import utils.AppUtils;
import utils.Serializable;
import utils.TimeCalculator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static utils.AppUtils.*;

public class RoomService implements IBasicCRUD<Room> {
    public static List<Room> roomList;
    static int nextId;

    static {
        roomList = (List<Room>) Serializable.deserialize(ELinkFile.ROOMS.getFilePath());
        if (roomList == null) {
            nextId = 1;
        } else {
            nextId = AppUtils.getNextId(roomList.stream().map(Room::getRoomId).collect(Collectors.toList()));
        }
    }

    public RoomService() {
        roomList = getAll();
    }


    public static void main(String[] args) {

    }

    public static void save() {
        Serializable.serialize(roomList, ELinkFile.ROOMS.getFilePath());
    }

    public static void loadRoom() {
        Serializable.deserialize(ELinkFile.ROOMS.getFilePath());
    }


    public static List<Room> getAvailableRoom(LocalDateTime checkInDate, LocalDateTime checkOutDate) {
        List<Room> list1 = roomList.stream().filter(room -> room.getExpectedCheckOut() == null
                || room.getExpectedCheckIn() == null
                || room.getRoomStatus() == ERoomStatus.Vacant_And_Reddy).toList();

        return roomList.stream()
                .filter(room -> (room.getExpectedCheckIn() == null || room.getExpectedCheckOut() == null) ||
                        (room.getExpectedCheckIn().isBefore(checkInDate) && room.getExpectedCheckOut().isBefore(checkInDate)) ||
                        (room.getExpectedCheckIn().isAfter(checkOutDate) && room.getExpectedCheckOut().isAfter(checkOutDate)) ||
                        room.getRoomStatus() == ERoomStatus.Vacant_And_Reddy)
                .toList();
    }

    public static void printList(List<Room> rooms) {
        if (rooms.size() == 0) {
            System.out.println("Tạm thời hết phòng");
            return;
        }
        for (Room r : rooms) {
            System.out.println(r.toString());
        }
    }

    public Room bookRoom(LocalDateTime expectedCheckIn, LocalDateTime expectedCheckOut, ERoomType eroomType) {
        Room room = new Room();
        room.setClient(ClientService.currentClient);
        room.setRoomType(eroomType);
        room.setExpectedCheckIn(expectedCheckIn);
        room.setExpectedCheckOut(expectedCheckOut);
        room.setExpectedStay(TimeCalculator.timeCalculator(expectedCheckIn, expectedCheckOut));


        return room;
    }


    public static void printAvailableRoom() {
        for (Room room : roomList.stream().filter(e -> e.getRoomStatus() != ERoomStatus.Vacant_And_Reddy).collect(Collectors.toList())) {

            ClientView.clientMenu();
        }
    }

    public Room getById(String str) {
        int id = getInt(str);
        Room room = roomList.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        if (room == null) {
            System.out.println("Room not found. Please try again!");
            getById(str);
        }
        return room;
    }

    @Override
    public Room getById(int roomId) {
        Room foundRoom = new Room();
        for (Room room : roomList) {
            if (room.getId() == roomId) {
                foundRoom = room;
            }
        }
        return foundRoom;
    }

    @Override
    public Room getObjById(List<Room> rooms, String str) {
        int roomID = getInt(str);
        return rooms.stream().filter(e -> e.getRoomId() == roomID).findFirst().orElse(null);
    }

    @Override
    public List<Room> getAll() {
        return roomList;
    }

    @Override
    public boolean create(Room room) {
        if (roomList.stream().anyMatch(e -> e.getRoomName().equals(room.getRoomName()))) {
            return false;
        }
        roomList.add(room);
        save();
        return true;
    }


    @Override
    public void update(Room room) {
        roomList.stream().filter(e -> e.getRoomId() == room.getRoomId())
                .findFirst().ifPresent(e -> {
                    int i = roomList.indexOf(e);
                    roomList.set(i, room);
                    save();
                });
    }

    @Override
    public boolean isExist(int roomId) {
        Room room = roomList.stream()
                .filter(e -> Objects.equals(e.getId(), roomId))
                .findFirst()
                .orElse(null);
        return room != null;
    }

    @Override
    public void delete(int roomId) {
        Room roomToDelete = getById(roomId);
        if (roomToDelete != null) {
            roomList.remove(roomToDelete);
            System.out.println("Phòng có ID " + roomId + " đã được xóa.");
            Serializable.serialize(roomList, ELinkFile.ROOMS.getFilePath());
        } else {
            System.out.println("Không tìm thấy phòng có ID là " + roomId);
        }
        roomList = roomList.stream()
                .filter(e -> !Objects.equals(e.getId(), roomId))
                .collect(Collectors.toList());
        save();
    }


    public void print() {
        for (Room room : roomList) {
            System.out.println(room.toString());
        }
    }

//    public void assignRoomToGuest(Room room, Client guest){
//        room.setGuest(guest);
//        update(room);
//    }
}

