package Model;

import DAO.Enums.ERoomPrice;
import DAO.Enums.ERoomStatus;
import Service.iService.IModel;
import utils.CurrencyFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Reservation implements IModel<Reservation>, Serializable {
    static int currentId = 0;
    private LocalDateTime expectedCheckOut;
    private LocalDateTime expectedCheckIn;

    private int reservationId;
    private int customerId;
    private String customerName;
    Room room;
    private String roomName;
    private Date timeExpected;

    private ERoomStatus reservationRoomStatus;
    private ERoomPrice eRoomPrice;

    public Reservation() {

    }

    public Reservation(int customerId, String customerName, Date timeExpected
            , Room room, ERoomStatus reservationRoomStatus, ERoomPrice eRoomPrice) {
        this.reservationId = ++currentId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.timeExpected = timeExpected;
        this.room = room;
        this.reservationRoomStatus = reservationRoomStatus;
        this.eRoomPrice=eRoomPrice;
    }

    public Reservation(String customerName, LocalDateTime expectedCheckIn, LocalDateTime expectedCheckOut
            , Room room, ERoomStatus eRoomStatus) {
        this.customerName = customerName;
        this.expectedCheckIn = expectedCheckIn;
        this.expectedCheckOut = expectedCheckOut;
        this.reservationRoomStatus = eRoomStatus;
        this.room = room;

    }



    public List<OrderFood> preOrderFoodList;

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        Reservation.currentId = currentId;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<OrderFood> getPreOrderFoodList() {
        return preOrderFoodList;
    }

    public void setPreOrderFoodList(List<OrderFood> preOrderFoodList) {
        preOrderFoodList = preOrderFoodList;
    }


    public ERoomPrice getERoomPrice() {
        return eRoomPrice;
    }

    public void setERoomPrice(ERoomPrice eRoomPrice) {
        this.eRoomPrice = eRoomPrice;
    }

    public LocalDateTime getExpectedCheckOut() {
        return expectedCheckOut;
    }

    public void setExpectedCheckOut(LocalDateTime expectedCheckOut) {
        this.expectedCheckOut = expectedCheckOut;
    }

    public LocalDateTime getExpectedCheckIn() {
        return expectedCheckIn;
    }

    public void setExpectedCheckIn(LocalDateTime expectedCheckIn) {
        this.expectedCheckIn = expectedCheckIn;
    }

    public Room getRoom() {
        return room;
    }

    public int getReservationId() {
        return reservationId;
    }


    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public Date getTimeExpected() {
        return timeExpected;
    }

    public void setTimeExpected(Date timeExpected) {
        this.timeExpected = timeExpected;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public ERoomStatus getReservationRoomStatus() {
        return reservationRoomStatus;
    }

    public void setReservationRoomStatus(ERoomStatus reservationRoomStatus) {
        this.reservationRoomStatus = reservationRoomStatus;
    }


    @Override
    public int getId() {
        return reservationId;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void update(Reservation obj) {

        this.customerId = obj.customerId;
        this.customerName = obj.customerName;
        this.timeExpected = obj.timeExpected;
        this.roomName = obj.roomName;
        this.reservationRoomStatus = obj.reservationRoomStatus;
//        this.roomPrice=obj.roomPrice;
    }


    public String reservationView() {
        return String.format("            ║ %-6s║ %-14s║ %-29s║ %-30s║ %-15s║ %-15s║ %-14s║", this.reservationId,
                this.customerId, this.customerName, this.timeExpected,
                this.reservationRoomStatus, this.roomName/*,this.roomPrice*/);
    }

    public void displayPreOrderFoodList() {
        System.out.println("Danh sách các món ăn đã đặt trước:");
        System.out.println("\t\t\t\t=====================================================================================================");
        System.out.printf("\t\t\t\t%-30s %-20s %-10s %-20s\n", "Tên món ăn", "Giá tiền", "Số lượng", "Số tiền dự kiến");
        for (OrderFood orderedFood : preOrderFoodList) {
            double expectedTotalPrice = orderedFood.getFood().getFoodPrice() * orderedFood.getQuantity();
            System.out.printf("\t\t\t\t%-30s %-20s %-10d %-20s\n", orderedFood.getFood().getFoodName()
                    , CurrencyFormat.covertPriceToString(orderedFood.getFood().getFoodPrice())
                    , orderedFood.getQuantity(),
                    CurrencyFormat.covertPriceToString(expectedTotalPrice));
        }
    }
}
