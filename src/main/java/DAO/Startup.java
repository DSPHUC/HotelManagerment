package DAO;

import DAO.Enums.*;
import Model.*;
import Service.ClientService;
import Service.ManagerService;
import Service.RoomService;
import utils.AppUtils;
import utils.Serializable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Startup {
    public static RoomService roomService = new RoomService();

    public static void init() {
        initManager();
        initClients();
        initCategory();
        initRoom();
        initReservation();
    }

    public static void initRoom() {
        Room room = new Room(1, "T1-1", ERoomType.PREMIUM, ERoomView.RIVER_VIEW
                , ERoomStatus.Vacant_And_Reddy, ERoomCapacity.PEOPLE_3, ERoomPrice.RIVER_VIEW_1_3);
        Room room1 = new Room(2, "T1-2", ERoomType.PREMIUM, ERoomView.RIVER_VIEW
                , ERoomStatus.Vacant_And_Reddy, ERoomCapacity.PEOPLE_2, ERoomPrice.RIVER_VIEW_1_2);
        Room room2 = new Room(3, "T1-3", ERoomType.KING, ERoomView.RIVER_VIEW
                , ERoomStatus.Vacant_And_Reddy, ERoomCapacity.PEOPLE_2, ERoomPrice.RIVER_VIEW_2_2);
        Room room3 = new Room(4, "T1-4", ERoomType.KING, ERoomView.RIVER_VIEW
                , ERoomStatus.Vacant_And_Reddy, ERoomCapacity.PEOPLE_3, ERoomPrice.RIVER_VIEW_2_3);
        Room room4 = new Room(5, "T1-5", ERoomType.PREMIUM, ERoomView.CITY_VIEW
                , ERoomStatus.Vacant_And_Reddy, ERoomCapacity.PEOPLE_2, ERoomPrice.CITY_VIEW_2);
        Room room5 = new Room(6, "T1-6", ERoomType.PREMIUM, ERoomView.CITY_VIEW
                , ERoomStatus.Vacant_And_Reddy, ERoomCapacity.PEOPLE_2, ERoomPrice.CITY_VIEW_2);
        Room room6 = new Room(7, "T1-7", ERoomType.PREMIUM, ERoomView.CITY_VIEW
                , ERoomStatus.Vacant_And_Reddy, ERoomCapacity.PEOPLE_3, ERoomPrice.CITY_VIEW_3);
        Room room7 = new Room(8, "T1-8", ERoomType.PREMIUM, ERoomView.CITY_VIEW
                , ERoomStatus.Vacant_And_Reddy, ERoomCapacity.PEOPLE_3, ERoomPrice.CITY_VIEW_3);
        RoomService.roomList = Arrays.asList(room, room1, room2, room3, room4, room5, room6, room7);
        Serializable.serialize(RoomService.roomList, ELinkFile.ROOMS.getFilePath());

        RoomService.save();
    }
//  2023-07-20 22:00:00
//  2023-07-22 22:00:00
//    Vinh
//    1
//    vinh@gmail.com
//    0314569875

    private static void initClients() {
        Client client1 = new Client(1, "Đạt",EGender.MALE, "dat@gmail.com", "9999", "0999999999");
        Client client2 = new Client(2, "Quang Tuấn",EGender.MALE, "qtuan@gmail.com", "12345", "0888888888");
        ClientService.clientList = Arrays.asList(client1, client2);
        Serializable.serialize(client1, ELinkFile.CLIENTS.getFilePath());
        Serializable.serialize(client2, ELinkFile.CLIENTS.getFilePath());
        ClientService.save();
    }

    public static void initManager() {
        Manager manager = new Manager("Mr Phuc",EGender.MALE, "phuc@gmail.com", "9999", "099999999");
        List<Manager> listManagers = new ArrayList<>();
        listManagers.add(manager);
        ManagerService.listManagers = listManagers;
        Serializable.serialize(manager, ELinkFile.MANAGER.getFilePath());
        ManagerService.save();

    }

    public static void initCategory() {
        List<Food> foods = new ArrayList<>();
        Food Huda = new Food(0, "Beer Huda", ECategory.DRINK, 20000.0);
        Food Heineken = new Food(1, "Beer Heineken", ECategory.DRINK, 20000.0);
        Food Strongbow = new Food(2, "Beer Strongbow", ECategory.DRINK, 20000.0);
        Food Tiger = new Food(3, "Beer Tiger", ECategory.DRINK, 20000.0);
        Food Lavie = new Food(4, "drink water", ECategory.DRINK, 20000.0);
        Food FruitDish = new Food(5, "fruit dish", ECategory.FOOD, 40000.0);
        foods.add(Huda);
        foods.add(Heineken);
        foods.add(Strongbow);
        foods.add(Tiger);
        foods.add(Lavie);
        foods.add(FruitDish);
        Serializable.serialize(foods, ELinkFile.FOODS.getFilePath());
    }
    public static void initReservation() {


        LocalDateTime date = AppUtils.parseDateTime("2023-07-17 10:10:10");
        LocalDateTime date1 = AppUtils.parseDateTime("2023-07-17 10:10:10");
        LocalDateTime date2 = AppUtils.parseDateTime("2023-07-17 10:10:10");

        Reservation reservation = new Reservation();
        reservation.setReservationId(1);
        reservation.setCustomerId(101);
        reservation.setCustomerName("Phúc");
        reservation.setRoom(RoomService.roomList.get(0));
        reservation.setExpectedCheckIn(date);
        reservation.setReservationRoomStatus(ERoomStatus.getRoomStatusById(1));
        RoomService.roomList.get(0).setExpectedCheckOut(AppUtils.parseDateTime("2023-07-18 10:10:10"));
        RoomService.roomList.get(0).setExpectedCheckIn(AppUtils.parseDateTime("2023-07-17 10:10:10"));
        RoomService.roomList.get(0).setRoomStatus(ERoomStatus.Occupied);

        Reservation reservation1 = new Reservation();
        reservation1.setReservationId(2);
        reservation1.setCustomerId(102);
        reservation1.setCustomerName("Duy");
        reservation1.setRoom(RoomService.roomList.get(1));
        reservation1.setExpectedCheckIn(date1);
        reservation1.setReservationRoomStatus(ERoomStatus.getRoomStatusById(1));
        RoomService.roomList.get(1).setExpectedCheckOut(AppUtils.parseDateTime("2023-07-27 10:10:10"));
        RoomService.roomList.get(1).setExpectedCheckIn(AppUtils.parseDateTime("2023-07-17 10:10:10"));
        RoomService.roomList.get(1).setRoomStatus(ERoomStatus.Occupied);

        Reservation reservation2 = new Reservation();
        reservation2.setReservationId(3);
        reservation2.setCustomerId(103);
        reservation2.setCustomerName("Thắng");
        reservation2.setRoom(RoomService.roomList.get(3));
        reservation2.setExpectedCheckIn(date2);
        reservation2.setReservationRoomStatus(ERoomStatus.getRoomStatusById(1));
        RoomService.roomList.get(3).setExpectedCheckOut(AppUtils.parseDateTime("2023-07-23 10:10:10"));
        RoomService.roomList.get(3).setExpectedCheckIn(AppUtils.parseDateTime("2023-07-19 10:10:10"));
        RoomService.roomList.get(3).setRoomStatus(ERoomStatus.Occupied);

        List<Reservation> reservations = new ArrayList<>();
        reservations.add(reservation1);
        reservations.add(reservation2);
        reservations.add(reservation);

        Serializable.serialize(reservations,
                ELinkFile.RESERVATIONS.getFilePath());

    }

    public static void main(String[] args) {
//        initClients();
//        initCategory();

        init();
//        initManager();
    }
}
