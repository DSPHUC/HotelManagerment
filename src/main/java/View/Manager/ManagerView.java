package View.Manager;

import Service.RoomService;
import utils.AppUtils;
import utils.ListView;

import java.util.Scanner;

import static View.LoginView.loginMenu;
//client
//dang nhap vao
// hien thi phong trong theo khoang ngay
// dat phong
//them dich vu
//tinh tien phong(tra phong)

// manager
// hien thi doanh thu(danh sach dat phong) theo khoang ngay
// hien thi doanh thu // theo thang

public class ManagerView {
    static RoomService roomService = new RoomService();

    static Scanner scanner = new Scanner(System.in);

    public static void managerMenu() {
        ListView.printMenu(ListView.managerMenuList);
        int choice = AppUtils.getIntWithBound("Input choice ", 0, 5);
        switch (choice) {
            case 1:
                ListView.printMenu(ListView.RoomManager);


                break;
            case 2:
                ListView.printMenu(ListView.FoodManager);
                break;
            case 3:
                System.out.println("Upgrading...");
                break;
            case 4:
                System.out.println("Upgrading..");
                break;
            case 0:
                System.out.println("Back to Logi menu");
                loginMenu();
                break;

        }
        managerMenu();
    }

}
