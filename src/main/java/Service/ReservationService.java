package Service;

import DAO.Enums.ELinkFile;
import Model.Reservation;
import Model.Room;
import Service.iService.IBasicCRUD;
import utils.AppUtils;
import utils.Serializable;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationService implements IBasicCRUD<Reservation> {
    public static List<Reservation> reservationList;
    public static List<Room> rooms;

    static {
        reservationList = new ArrayList<>((List<Reservation>) Serializable.deserialize
                (ELinkFile.RESERVATIONS.getFilePath()));
        rooms = new ArrayList<>((List<Room>) Serializable.deserialize
                (ELinkFile.ROOMS.getFilePath()));
    }

    public ReservationService() {
    }

    public static void save() {
        Serializable.serialize(reservationList, ELinkFile.RESERVATIONS.getFilePath());
    }

    @Override
    public Reservation getById(String str) {
        return null;
    }

    @Override
    public Reservation getById(int reservationId) {
        Reservation foundRreservation = new Reservation();
        for (Reservation reservation : reservationList) {
            if (reservation.getId() == reservationId) {
                foundRreservation = reservation;
            }
        }
        return foundRreservation;
    }

    @Override
    public Reservation getObjById(List<Reservation> reservations, String str) {
        int reservationID = AppUtils.getInt(str);
        return reservations.stream().filter(e -> e.getReservationId() == reservationID).findFirst().orElse(null);
    }

    @Override
    public List<Reservation> getAll() {
        return null;
    }

    @Override
    public boolean create(Reservation obj) {
        reservationList.add(obj);
        ReservationService.save();
        return true;
    }

    @Override
    public boolean isExist(int id) {
        return false;
    }

    @Override
    public void update(Reservation obj) {

    }

    @Override
    public void delete(int id) {
    }

    public static void main(String[] args) throws IOException {
        System.out.println(LocalDateTime.now());
    }
}
