package Model;

import DAO.Enums.*;
import Service.iService.IModel;
import utils.AppUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

import static Service.RoomService.roomList;


public class Room implements IModel<Room>, Serializable {
    private int currentID = 0;
    private int roomId;
    private Client client;
    private String roomName;
    private ERoomType roomType;
    private ERoomView roomView;
    private ERoomStatus roomStatus;
    private ERoomCapacity roomCapacity;
    private ERoomPrice roomPrice;
    private LocalDateTime expectedCheckIn;
    private  LocalDateTime expectedCheckOut;
    private  LocalDateTime actualCheckOut;
    private static LocalDateTime bookTime;
    private Integer expectedStay;

    public Room() {
    }

    static {
        bookTime = AppUtils.getDateTimeNow();
    }

    public Room(int roomId, String roomName, ERoomType roomType, ERoomView roomView
            , ERoomStatus roomStatus, ERoomCapacity roomCapacity, ERoomPrice roomPrice) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomType = roomType;
        this.roomStatus = roomStatus;
        this.roomView = roomView;
        this.roomCapacity = roomCapacity;
        this.roomPrice = roomPrice;

    }

    public Room(Client client, ERoomType roomType, ERoomPrice roomPrice, LocalDateTime expectedCheckIn, int expectedStay) {
        this.roomId = getNextId();
        this.client = client;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.expectedCheckIn = expectedCheckIn;

        this.expectedStay = expectedStay;
        this.roomStatus= ERoomStatus.Vacant_And_Reddy;

    }

    public ERoomView getRoomView() {
        return roomView;
    }

    public void setRoomView(ERoomView roomView) {
        this.roomView = roomView;
    }

    public ERoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(ERoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public int getCurrentID() {
        return currentID;
    }

    public void setCurrentID(int currentID) {
        this.currentID = currentID;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getExpectedCheckIn() {
        return expectedCheckIn;
    }

    public void setExpectedCheckIn(LocalDateTime expectedCheckIn) {
        this.expectedCheckIn = expectedCheckIn;
    }

    public LocalDateTime getExpectedCheckOut() {
        return expectedCheckOut;
    }

    public void setExpectedCheckOut(LocalDateTime expectedCheckOut) {
        this.expectedCheckOut = expectedCheckOut;
    }

    public LocalDateTime getActualCheckOut() {
        return actualCheckOut;
    }

    public void setActualCheckOut(LocalDateTime actualCheckOut) {
        this.actualCheckOut = actualCheckOut;
    }

    public static LocalDateTime getBookTime() {
        return bookTime;
    }

    public static void setBookTime(LocalDateTime bookTime) {
        Room.bookTime = bookTime;
    }

    public Integer getExpectedStay() {
        return expectedStay;
    }

    public void setExpectedStay(Integer expectedStay) {
        this.expectedStay = expectedStay;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public ERoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(ERoomType roomType) {
        this.roomType = roomType;
    }

    public ERoomCapacity getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(ERoomCapacity roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public ERoomPrice getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(ERoomPrice roomPrice) {
        this.roomPrice = roomPrice;
    }

    public static int getNextId() {
        int max = 0;
        if (roomList != null) {
            for (Room room : roomList) {
                if (room.getId() > max) {
                    max = room.getId();
                }
            }
        }
        return max + 1;
    }

    @Override
    public int getId() {
        return this.roomId;
    }

    @Override
    public String getName() {
        return this.roomName;
    }

    @Override
    public void update(Room obj) {
        this.roomId = obj.currentID++;
        this.roomName = obj.roomName;
        this.roomType = obj.roomType;
        this.roomStatus = obj.roomStatus;
        this.roomView = obj.roomView;
        this.roomCapacity = obj.roomCapacity;
        this.roomPrice = obj.roomPrice;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", roomType=" + roomType +
                ", roomStatus=" + roomStatus +
                ", roomView=" + roomView +
                ", roomCapacity=" + roomCapacity +
                ", roomPrice=" + roomPrice +
                '}';
    }

}
