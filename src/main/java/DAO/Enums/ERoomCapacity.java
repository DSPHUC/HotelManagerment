package DAO.Enums;

import java.util.Objects;

public enum ERoomCapacity {
    PEOPLE_2(1, "People 2"),

    PEOPLE_3(2, "People 3");
    private int id;
    private String name;

    ERoomCapacity(int id, String name) {
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

    public static ERoomCapacity getRoomCapacityById(int id) {
        ERoomCapacity[] var1 = values();
        for (ERoomCapacity eRoomCapacity : var1) {
            if (Objects.equals(eRoomCapacity.getId(), id)) {
                return eRoomCapacity;

            }
        }
        throw new IllegalArgumentException("Please enter again");
    }

    public static ERoomCapacity getRoomCapacityByName(String name) {
        ERoomCapacity[] var1 = values();
        for (ERoomCapacity eRoomCapacity : var1) {
            if (Objects.equals(eRoomCapacity.getName(), name)) {
                return eRoomCapacity;

            }
        }
        throw new IllegalArgumentException("Please enter again");
    }
}
