package DAO.Enums;

import java.util.Objects;

public enum ERoomPrice {
    RIVER_VIEW_1_2(1, 1300000.0),
    RIVER_VIEW_1_3(2, 2300000.0),
    RIVER_VIEW_2_2(3,2400000.0),
    RIVER_VIEW_2_3(4,4000000.0),
    CITY_VIEW_2(5, 1100000.0),
    CITY_VIEW_3(6, 2200000.0);
    private int id;
    private Double price;

    ERoomPrice(int id, Double price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public static ERoomPrice getRoomPriceById(int id) {
        ERoomPrice[] var1 = values();
        for (ERoomPrice eRoomPrice : var1) {
            if (Objects.equals(eRoomPrice.getId(), id)) {
                return eRoomPrice;
            }
        }
        throw new IllegalArgumentException("Please enter again");
    } public static ERoomPrice getRoomPrice(Double price) {
        ERoomPrice[] var1 = values();
        for (ERoomPrice eRoomPrice : var1) {
            if (Objects.equals(eRoomPrice.getPrice(), price)) {
                return eRoomPrice;
            }
        }
        throw new IllegalArgumentException("Please enter again");
    }
}
