package DAO.Enums;

import java.util.Objects;

public enum ECategory {
    FOOD(1, "Thức ăn"),
    DRINK(2, "Nước uống"),
    OTHER(3, "Khác");
    private int Id;
    private String name;

    ECategory(int id, String name) {
        Id = id;
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ECategory getCategoryById(int id) {
        ECategory[] var1 = values();
        for (ECategory eCategory : var1) {
            if (Objects.equals(eCategory.getId(), id)) {
                return eCategory;

            }
        }
        throw new IllegalArgumentException("Please enter again");
    }

    public static ECategory getCategoryByName(String name) {
        ECategory[] var1 = values();
        for (ECategory eCategory : var1) {
            if (Objects.equals(eCategory.getName(), name)) {
                return eCategory;

            }
        }
        throw new IllegalArgumentException("Please enter again");
    }
}
