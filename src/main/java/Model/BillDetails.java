package Model;

import java.io.Serializable;

public class BillDetails implements Serializable {
    Bill bill;
    Room room;
    Food food;
    public BillDetails(Bill bill, Food food, Room room) {
        this.bill = bill;
        this.food = food;
        this.room = room;
    }
    public BillDetails(){

    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public static void main(String[] args) {
        BillDetails billDetails = new BillDetails();
        String roomName =  billDetails.getRoom().getName();
    }
}
