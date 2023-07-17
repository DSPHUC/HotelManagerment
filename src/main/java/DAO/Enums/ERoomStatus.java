package DAO.Enums;

import java.util.Objects;

public enum ERoomStatus {
    Occupied(1, "Đang có khách"),           //phòng đang có khách
    Cleaning_In_Progress(2, "Đang dọn phòng"), //đang dọn dẹp
    Vacant_And_Reddy(3, "Phòng trống và đã dọn dẹp"),       //phòng đã dọn dẹp và sẵn sàng nhận khách
    Under_Maintenance(4, "Đang bảo trì");      //phòng đang bảo trì
    private int id;
    private String name;

    ERoomStatus(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ERoomStatus getRoomStatusById(int id) {
        ERoomStatus[] var1 = values();
        for (ERoomStatus roomStatus : var1) {
            if (Objects.equals(roomStatus.getId(), id)) {
                return roomStatus;
            }
        }
        throw new IllegalArgumentException("Please enter again");
    }

    public static ERoomStatus getRoomStatusByName(String name) {
        ERoomStatus[] var1 = values();
        for (ERoomStatus roomStatus : var1) {
            if (Objects.equals(roomStatus.getName(), name)) {
                return roomStatus;
            }
        }
        throw new IllegalArgumentException("Please enter again");
    }
}
