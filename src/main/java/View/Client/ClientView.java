package View.Client;

import DAO.Enums.ERoomStatus;
import Model.Food;
import Model.OrderFood;
import Model.Reservation;
import Model.Room;
import Service.ClientService;
import Service.FoodService;
import Service.ReservationService;
import Service.RoomService;
import Service.authServices.LoginService;
import utils.AppUtils;
import utils.CurrencyFormat;
import utils.Display.DisplayRoom;
import utils.ListView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static Service.ReservationService.reservationList;
import static Service.RoomService.printList;
import static View.LoginView.loginMenu;
import static utils.AppUtils.getInt;

public class ClientView {
    static RoomService roomService = new RoomService();
    static ClientService clientService = new ClientService();
    static ReservationService reservationService = new ReservationService();

    public static void clientMenu() {
        ListView.printMenu(ListView.menuClientList);
        int choice = AppUtils.getIntWithBound("Input choice ", 0, 5);
        switch (choice) {
            case 1:
                DisplayRoom.displayRoom();
                break;
            case 2:
                bookRoomUI();
                break;
            case 3:
                bookFoodUI();
                break;
            case 4:
                showBookRoom();
                break;
            case 5:
                showPreOrderFood();
                break;
            case 0:
                System.out.println("Back to Login menu");
                loginMenu();
                break;
        }
        clientMenu();
    }

    private static void showBookRoom() {
        String customerName = LoginService.getName();
        List<Reservation> myReservations = new ArrayList<>();
        if (reservationList == null) {
            return;
        }
        for (Reservation reservation : reservationList) {
            if (reservation.getCustomerName().equals(customerName)) {
                myReservations.add(reservation);
            }
        }
        if (myReservations.isEmpty()) {
            System.out.println("Bạn chưa đặt phòng nào.");
        } else {
            System.out.println("Danh sách các phòng bạn đã đặt:");
            System.out.println("\t\t\t\t===================================================================================================================================================");
            System.out.printf("\t\t\t\t%-1s %-15s %-18s %-16s %-10s %-19s %-10s %-20s\n", "ID ", "Tên khách", "Ngày giờ vào", "Ngày giờ ra ", "Phòng", "Trạng thái", "Loại", "Giá phòng");
            for (Reservation reservation : myReservations) {
                System.out.printf("\t\t\t\t%-3s %-12s %-18s %-19s %-9s %-20s %-9s %-10s\n"
                        , reservation.getReservationId()
                        , reservation.getCustomerName()
                        , reservation.getExpectedCheckIn()
                        , reservation.getExpectedCheckOut()
                        , reservation.getRoom().getRoomName()
                        , ERoomStatus.Vacant_And_Reddy
                        , reservation.getRoom().getRoomType()
                        , CurrencyFormat.covertPriceToString(reservation.getRoom().getRoomPrice().getPrice()));
            }
        }
        clientMenu();
    }

    private static void bookFoodUI() {
        FoodService.loadFood();
        String customerName = LoginService.getName();
        List<Reservation> myReservations = new ArrayList<>();
        for (Reservation reservation : reservationList) {
            if (reservation.getCustomerName().equals(customerName)) {
                myReservations.add(reservation);
            }
        }
        if (myReservations.isEmpty()) {
            System.out.println("Bạn chưa đặt phòng nào.");
            return;
        }
        System.out.println("Danh sách các phòng bạn đã đặt:");
        System.out.println("\t\t\t\t===================================================================================================================================================");
        System.out.printf("\t\t\t\t%-10s %-20s %-25s %-20s %-10s %-15s %-30s \n", "ID ", "Tên khách", "Ngày giờ vào", "Ngày giờ ra", "Phòng", "Trạng thái", "Loại", "Giá");
        for (Reservation reservation : myReservations) {
            System.out.printf("\t\t\t\t%-10d  %-15s %-30s %30s %-20s %-10s %-15s %-20s \n"
                    , reservation.getReservationId()
                    , reservation.getCustomerName()
                    , reservation.getTimeExpected()
                    , reservation.getRoom().getRoomName()
                    , ERoomStatus.Vacant_And_Reddy
                    , reservation.getRoom().getRoomType(),
                    CurrencyFormat.covertPriceToString(reservation.getRoom().getRoomPrice().getPrice()));
        }
        int reservationId = getInt("Nhập ID của đặt phòng bạn muốn đặt trước đồ ăn:");
        Reservation reservationToPreOrder = null;
        for (Reservation reservation : myReservations) {
            if (reservation.getReservationId() == reservationId) {
                reservationToPreOrder = reservation;
                break;
            }
        }
        if (reservationToPreOrder == null) {
            System.out.println("Không tìm thấy đặt phòng có ID là " + reservationId + ".");
            return;
        }
        List<Food> foodList = FoodService.foodList;
        if (foodList.isEmpty()) {
            System.out.println("Hiện tại không có đồ ăn nào để đặt.");
            return;
        }
        System.out.println("Danh sách các món ăn:");
        System.out.println("\t\t\t\t===========================================================================");
        System.out.printf("\t\t\t\t%-10s %-30s %-20s \n", "ID", "Tên món ăn", "Giá tiền");
        for (Food food : foodList) {
            System.out.printf("\t\t\t\t%-10d %-30s %-20s \n", food.getFoodID(), food.getFoodName(), CurrencyFormat.covertPriceToString(food.getFoodPrice()));
        }

        List<OrderFood> orderFoodList = new ArrayList<>();
        List<OrderFood> preOrderFoodList = reservationToPreOrder.getPreOrderFoodList();
        if (preOrderFoodList == null) {
            preOrderFoodList = new ArrayList<OrderFood>();
        }
        preOrderFoodList.addAll(orderFoodList);
        reservationToPreOrder.setPreOrderFoodList(preOrderFoodList);
        while (true) {
            int foodId = getInt("Nhập ID của món ăn bạn muốn đặt (nhập 0 để kết thúc đặt đồ ăn):");
            if (foodId == 0) {
                break;
            }
            Food foodToOrder = null;
            for (Food food : foodList) {
                if (food.getFoodID() == foodId) {
                    foodToOrder = food;
                    break;
                }
            }
            if (foodToOrder == null) {
                System.out.println("Không tìm thấy món ăn có ID là " + foodId + ".");
            } else {
                int quantity = getInt("Nhập số lượng món ăn bạn muốn đặt:");
                if (quantity > 0) {
                    OrderFood orderFood = new OrderFood(foodToOrder, quantity);
                    orderFoodList.add(orderFood);
                    System.out.println("Đã đặt trước " + quantity + " phần của món " + foodToOrder.getFoodName() + ".");
                } else {
                    System.out.println("Số lượng phải lớn hơn 0.");
                }
            }
        }
        if (!orderFoodList.isEmpty()) {
            preOrderFoodList = reservationToPreOrder.getPreOrderFoodList();
            preOrderFoodList.addAll(orderFoodList);
            reservationToPreOrder.setPreOrderFoodList(preOrderFoodList);
            System.out.println("Đã đặt trước đồ ăn cho đặt phòng có ID là " + reservationId + ".");
        } else {
            System.out.println("Bạn chưa đặt trước đồ ăn nào cho đặt phòng có ID là " + reservationId + ".");
        }

    }

    public static void showPreOrderFood() {
        RoomService.loadRoom();
        String customerName = LoginService.getName();
        List<Reservation> myReservations = new ArrayList<>();
        for (Reservation reservation : reservationList) {
            if (reservation.getCustomerName().equals(customerName)) {
                myReservations.add(reservation);
            }
        }
        if (myReservations.isEmpty()) {
            System.out.println("Bạn chưa đặt phòng nào.");
            return;
        }
        System.out.println("Danh sách các phòng bạn đã đặt:");
        System.out.println("\t\t\t\t===================================================================================================================================================");
        System.out.printf("\t\t\t\t%-10s %-20s %-25s %-20s %-10s %-15s %-20s %-20s\n", "ID ", "Tên khách", "Ngày giờ ", "Phòng", "Trạng thái", "Loại");
        for (Reservation reservation : myReservations) {
            System.out.printf("\t\t\t\t%-10d  %-15s %-30s %-20s %-10s %-15s %-20s %-20s\n"
                    , reservation.getReservationId()
                    , reservation.getCustomerName()
                    , reservation.getTimeExpected()
                    , reservation.getRoom().getRoomName()
                    , ERoomStatus.Vacant_And_Reddy
                    , reservation.getRoom().getRoomType(),
                    CurrencyFormat.covertPriceToString(reservation.getRoom().getRoomPrice().getPrice()));
        }
        int reservationId = getInt("Nhập ID của phòng bạn muốn xem:");
        boolean foundReservation = false;
        for (Reservation reservation : myReservations) {
            if (reservationId == reservation.getReservationId()) {
                reservation.displayPreOrderFoodList();
                foundReservation = true;
                break;
            }
        }
        if (!foundReservation) {
            System.out.println("ID nhập vào không hợp lệ.");
        }
    }

    private static void bookRoomUI() {
//        RoomService.loadRoom();
        String customerName = LoginService.getName();
//
        LocalDateTime checkInDate = AppUtils.getCheckInDate();
        LocalDateTime checkOutDate = AppUtils.getCheckOutDate(checkInDate);
        printList(RoomService.getAvailableRoom(checkInDate, checkOutDate));
        if (RoomService.getAvailableRoom(checkInDate, checkOutDate).size() == 0) {
            return;
        }
        Room room = roomService.getById("Nhập Id Phòng: ");
        if (room.getRoomStatus() != ERoomStatus.Vacant_And_Reddy) {
            return;
        }
        Reservation reservation1 = new Reservation(customerName, checkInDate, checkOutDate, room, ERoomStatus.Vacant_And_Reddy);
        System.out.println("Xác nhận đặt phòng: ");
        int choice = AppUtils.getIntWithBound("Nhấn 1 để đặt phòng hoặc 0 để quay lại menu trước", 0, 1);
        if (choice == 0) {
            bookRoomUI();
        } else {
            if (reservationService.create(reservation1)) {
                System.out.println("Đặt phòng thành oông");

                room.setRoomStatus(ERoomStatus.Occupied);
                return;
            }
            System.out.println("Đặt phòng thất bại - Vui lòng đặt lại");
        }
    }

    public static void main(String[] args) {
        clientMenu();
    }

}
