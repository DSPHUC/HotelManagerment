package utils.Display;

import DAO.Enums.ELinkFile;
import Model.Room;
import View.Client.ClientView;
import utils.CurrencyFormat;
import utils.Serializable;

import java.util.List;

public class DisplayRoom {
    public static void displayRoom() {
        List<Room> rooms = (List<Room>) Serializable.deserialize
                (ELinkFile.ROOMS.getFilePath());
        System.out.println("Thông tin phòng:");
        System.out.println("\t\t\t\t===========================================================================================================");
        System.out.printf("\t\t\t\t%-5s %-15s %-16s %-22s %-25s %-13s %10s \n", "ID", "Tên phòng", "Loại phòng", "View","Trạng thái", "Sức chứa","Giá phòng");
        for (Room room : rooms) {
            System.out.printf("\t\t\t\t%-7s %-14s %-15s %-17s %-30s %-13s %10s \n",
                    room.getRoomId(),
                    room.getRoomName(),
                    room.getRoomType().getName(),
                    room.getRoomView().getName(),
                    room.getRoomStatus().getName(),
                    room.getRoomCapacity().getName(),
                    CurrencyFormat.covertPriceToString(room.getRoomPrice().getPrice())
            );
        }
        System.out.println("\t\t\t\t===========================================================================================================\n\n");
        ClientView.clientMenu();
    }

    public static void main(String[] args) {
        displayRoom();
    }
}
