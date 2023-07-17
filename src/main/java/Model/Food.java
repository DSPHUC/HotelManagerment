package Model;

import DAO.Enums.ECategory;
import Service.iService.IModel;

import java.io.Serializable;

public class Food implements IModel<Food>, Serializable {
    static int currentID = 0;
    private int foodID;
    private String foodName;
    private Double foodPrice;
    private ECategory eCategory;

    public Food() {
    }

    public Food(int foodID, String foodName, ECategory eCategory, Double foodPrice) {
        this.foodID = currentID++;
        this.foodName = foodName;
        this.eCategory = eCategory;
        this.foodPrice = foodPrice;
    }

    public ECategory getECategory() {
        return eCategory;
    }

    public void setECategory(ECategory eCategory) {
        this.eCategory = eCategory;
    }

    public static int getCurrentID() {
        return currentID;
    }

    public static void setCurrentID(int currentID) {
        Food.currentID = currentID;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodId=" + foodID +
                ", foodName='" + foodName + '\'' +
                ", eCategory='" + eCategory + '\'' +
                ", foodPrice=" + foodPrice +
                '}';
    }

    @Override
    public int getId() {
        return foodID;
    }

    @Override
    public String getName() {
        return foodName;
    }

    @Override
    public void update(Food obj) {
        this.foodID=obj.foodID;
        this.foodName=obj.foodName;
        this.foodPrice=obj.foodPrice;
        this.eCategory=obj.eCategory;
    }
}
