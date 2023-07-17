package DAO.Enums;

import java.util.Objects;

public enum ERoomType {

    PREMIUM(1,"Premium"),
    KING(2, "King");
    private int id;
    private String name;
    ERoomType(int id, String name) {
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

    public static ERoomType getRoomTypeById(int id) {
        ERoomType[] var1 = values();
        for (ERoomType eRoomType : var1) {
            if (Objects.equals(eRoomType.getId(), id)) {
                return eRoomType;
            }
        }
        throw new IllegalArgumentException("Please enter again");
    } public static ERoomType getRoomTypeName(String name) {
        ERoomType[] var1 = values();
        for (ERoomType eRoomType : var1) {
            if (Objects.equals(eRoomType.getName(), name)) {
                return eRoomType;
            }
        }
        throw new IllegalArgumentException("Please enter again");
    }

}
