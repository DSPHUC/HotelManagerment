package DAO.Enums;

import java.util.Objects;

public enum ERoomView {
    RIVER_VIEW(1, "River"),
    CITY_VIEW(2, "City");
    private int id;
    private String name;

    ERoomView(int id, String name) {
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

    public static ERoomView getRoomViewById(int id) {
        ERoomView[] var1 = values();
        for (ERoomView roomView : var1) {
            if (Objects.equals(roomView.getId(), id)) {
                return roomView;
            }
        }
        throw new IllegalArgumentException("Please enter again");
    }

    public static ERoomView getRoomViewByName(String name) {
        ERoomView[] var1 = values();
        for (ERoomView roomView : var1) {
            if (Objects.equals(roomView.getName(), name)) {
                return roomView;
            }
        }
        throw new IllegalArgumentException("Please enter again");
    }

}
