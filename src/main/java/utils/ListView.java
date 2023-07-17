package utils;

import java.util.Arrays;
import java.util.List;

public class ListView {
    public static List<String> menuLoginList = Arrays.asList("Welcome to Hotel",
            "1. Login", "2. Sign up", "0. Quit");
    public static List<String> menuClientList = Arrays.asList("Client Menu",
            "1. List Room", "2. Book room", "3. Oder/to be  update", "4. Show book room", "5. Show book food/to be  update", "0. Log out");
    public static List<String> managerMenuList = Arrays.asList("Manger Menu", "1. Room manger",
            "2. Staff manger", "3. Client manger", "0. Back to home menu");
    public static List<String> RoomManager = Arrays.asList("Room Manager Menu","1.List Room","2. To update....");
    public static List<String> FoodManager = Arrays.asList("Food Manager Menu","1.List Food","2. To update....");
    public static List<String> staffMenuList = Arrays.asList("Staff Menu", "1. Room manger",
            "2. Client manger", "3.update", "4. update", "0. Back to LoginView menu");

    public static List<String> updateGuestList = Arrays.asList("Select field you want to update: ",
            "1. Name", "2. Password", "3. Phone number", "0. Back to Client menu");

    public static List<String> roomMenuList = Arrays.asList("Room manager menu", "1. List Room",
            "2. Add new Room", "3. Remove Room", "4. Assign Room", "5. Get Room Information",
            "6. Update Room Information", "0. Back to main menu");
    public static List<String> updateRoomMenuList = Arrays.asList(
            "1. Edit name for room", "2. Edit type for room", "3. Edit status for room",
            "4. Edit capacity for room", "5. Edit price for room", "0. Back to Cars manager menu "
    );

    public static void printMenu(List<String> menu) {
        for (String str : menu) {
            System.out.println(str);
        }
    }
}
