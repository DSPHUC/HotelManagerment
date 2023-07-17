package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bill implements Serializable {
    static int currentId = 0;
    private int id;
    private Room room;
    private Date roomRealTimeIn;
    private Date roomRealTimeOut;
    private Food food;
    private User user;
    private final List<Bill> bills = new ArrayList<>();

    public Bill() {

    }

    public Bill(int id, Room room, Date roomRealTimeIn, Date roomRealTimeOut, Food food, User user) {
        this.id = currentId++;
        this.room = room;
        this.roomRealTimeIn = roomRealTimeIn;
        this.roomRealTimeOut = roomRealTimeOut;
        this.user = user;
        this.food = food;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        Bill.currentId = currentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getRoomRealTimeIn() {
        return roomRealTimeIn;
    }

    public void setRoomRealTimeIn(Date roomRealTimeIn) {
        this.roomRealTimeIn = roomRealTimeIn;
    }

    public Date getRoomRealTimeOut() {
        return roomRealTimeOut;
    }

    public void setRoomRealTimeOut(Date roomRealTimeOut) {
        this.roomRealTimeOut = roomRealTimeOut;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public List<Bill> getBills() {
        return bills;
    }
}
