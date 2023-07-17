package utils.Display;

import DAO.Enums.ELinkFile;
import Model.Reservation;
import Model.Room;
import utils.DateFormat;
import utils.Serializable;

import java.util.List;

public class DisplayReservation {
    public static void displayReservation() {
        List<Room> rooms = (List<Room>) Serializable.deserialize
                (ELinkFile.ROOMS.getFilePath());
        List<Reservation> reservations = (List<Reservation>) Serializable.deserialize(
                ELinkFile.RESERVATIONS.getFilePath());
        if (reservations == null) {
            System.out.println("Không có đặt phòng nào.");
            return;
        }
        System.out.println("Thông tin cuộc hẹn:");
        System.out.println("\t\t\t\t===================================================================================================================================================");
        System.out.printf("\t\t\t\t%-5s %-10s %-20s %-25s %-20s %-20s %-25s  \n", "ID ", "ID Khách", "Tên khách", "Ngày giờ", "Tên phòng", "Trạng thái", "Loại"/*,"Giá phòng"*/);
        for (
                Reservation reservation : reservations) {
            DateFormat.convertDateTypeWithHours(reservation.getTimeExpected());
            System.out.printf("\t\t\t\t%-5d %-10s %-15s %-30s %-20s %-20s %-25s \n"
                    , reservation.getReservationId(), reservation.getCustomerId(), reservation.getCustomerName()
                    , DateFormat.formatDateWithHours(reservation.getTimeExpected())
                    , reservation.getRoom().getRoomName(), reservation.getReservationRoomStatus()
                    , reservation.getRoom().getRoomType());
        }
        System.out.println("\t\t\t\t====================================================================================================================================================\n\n");
    }

    public static void main(String[] args) {
        displayReservation();
    }
}
