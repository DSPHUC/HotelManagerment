package DAO.Enums;

import java.util.Objects;

public enum EGender {
    MALE(1, "Nam"),
    FEMALE(2, "Nữ");
    private int id;
    private String name;

    EGender(int id, String name) {
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

    public static EGender getEGenderById(int id) {
        for (EGender gender : values()) {
            if (Objects.equals(gender.getId(), id)) {
                return gender;
            }
        }
        throw new IllegalArgumentException("Please enter again");
    }

    public static EGender getEGenderByName(String name) {
        for (EGender gender : values()) {
            if (Objects.equals(gender.getName(), name)) {
                return gender;
            }
        }
        throw new IllegalArgumentException("Please enter again");
    }
}
