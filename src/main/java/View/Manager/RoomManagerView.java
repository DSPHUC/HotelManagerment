package View.Manager;

import Service.RoomService;
import utils.AppUtils;
import utils.ListView;

public class RoomManagerView {
    static RoomService roomService = new RoomService();

    public static void roomMenu() {
        ListView.printMenu(ListView.roomMenuList);
        int choice;
        choice = AppUtils.getIntWithBound(" Input choice: ", 0, ListView.roomMenuList.size() - 2);

        switch (choice) {
            case 1:
                roomService.print();
                break;
            case 2:
//                addRoom();
                break;
            case 3:
                removeRoom();
                break;
            case 4:
                assignRoom();
                break;
        }
    }




//    private static void addRoom() {
//        String roomName = AppUtils.getString(" Input name for room");
//        ERoomType roomType = AppUtils.getIntWithBound(" Input type for room:(1. Premium/ 2. King ", 1, 2)
//                == 1 ? ERoomType.PREMIUM : ERoomType.KING;
//        ERoomView roomView = AppUtils.getIntWithBound(" Input view for room(1. River/2. City", 1, 2)
//                == 1 ? ERoomView.RIVER_VIEW : ERoomView.CITY_VIEW;
//        ERoomStatus roomStatus = AppUtils.getIntWithBound(" Input status for room now:(1. Đang có khách/2. Đang dọn phòng/3. Phòng trống và đã dọn dẹp/4. Đang bảo trì", 1, 4)
//                == 1 ? ERoomStatus.Occupied :
//                AppUtils.getIntWithBound("Input status for room now:(1. Đang có khách/2. Đang dọn phòng/3. Phòng trống và đã dọn dẹp/4. Đang bảo trì", 1, 4)
//                        == 2 ? ERoomStatus.Cleaning_In_Progress
//                        : AppUtils.getIntWithBound("Input status for room now:(1. Đang có khách/2. Đang dọn phòng/3. Phòng trống và đã dọn dẹp/4. Đang bảo trì", 1, 4)
//                        == 3 ? ERoomStatus.Vacant_And_Reddy : ERoomStatus.Under_Maintenance;
//        ERoomCapacity roomCapacity = AppUtils.getIntWithBound("Input capacity for room:1. People/ 2.People 3", 1, 2)
//                == 1 ? ERoomCapacity.PEOPLE_2 : ERoomCapacity.PEOPLE_3;
//        ERoomPrice roomPrice = AppUtils.getIntWithBound("Input price for room:(1. 1300000.0/ 2. 2300000.0/ 3. 2400000.0/ 4. 4000000.0/ 5. 1100000.0/ 6. 2200000.0", 1, 6)
//                == 1 ? ERoomPrice.RIVER_VIEW_1_2
//                : AppUtils.getIntWithBound("Input price for room:(1. 1300000.0/ 2. 2300000.0/ 3. 2400000.0/ 4. 4000000.0/ 5. 1100000.0/ 6. 2200000.0", 1, 6)
//                == 2 ? ERoomPrice.RIVER_VIEW_1_3
//                : AppUtils.getIntWithBound("Input price for room:(1. 1300000.0/ 2. 2300000.0/ 3. 2400000.0/ 4. 4000000.0/ 5. 1100000.0/ 6. 2200000.0", 1, 6)
//                == 3 ? ERoomPrice.RIVER_VIEW_2_2
//                : AppUtils.getIntWithBound("Input price for room:(1. 1300000.0/ 2. 2300000.0/ 3. 2400000.0/ 4. 4000000.0/ 5. 1100000.0/ 6. 2200000.0", 1, 6)
//                == 4 ? ERoomPrice.RIVER_VIEW_2_3
//                : AppUtils.getIntWithBound("Input price for room:(1. 1300000.0/ 2. 2300000.0/ 3. 2400000.0/ 4. 4000000.0/ 5. 1100000.0/ 6. 2200000.0", 1, 6)
//                == 5 ? ERoomPrice.CITY_VIEW_2 : ERoomPrice.CITY_VIEW_3;
//        Room room = new Room(roomName, roomType, roomView, roomStatus, roomCapacity, roomPrice);
//        roomService.create(room);
//    }

    static void removeRoom() {
        try {
            roomService.print();
            int roomId = AppUtils.getInt("Input room id to remove: ");
            if (!roomService.isExist(roomId)) {
                System.out.printf("Not found %d.\n", roomId);
                removeRoom();
            }
            roomService.delete(roomId);
            System.out.println("Remove room successfully!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void assignRoom() {
        System.out.println("Assign room");

    }
}
