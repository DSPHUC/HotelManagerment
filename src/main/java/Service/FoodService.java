package Service;

import DAO.Enums.ECategory;
import DAO.Enums.ELinkFile;
import Model.Client;
import Model.Food;
import Service.iService.IBasicCRUD;
import utils.AppUtils;
import utils.Serializable;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FoodService implements IBasicCRUD<Food> {
    public static List<Food> foodList;
    private static int nextId;

    public FoodService() {
    }

    static {
        foodList = (List<Food>) Serializable.deserialize(ELinkFile.FOODS.getFilePath());
        if (foodList == null) {
            nextId = 1;
        } else {
            nextId = AppUtils.getNextId(foodList.stream().map(Food::getFoodID).collect(Collectors.toList()));
        }
    }

    public static void save() {
        Serializable.serialize(foodList, ELinkFile.FOODS.getFilePath());
    }
    public static void loadFood() {
        utils.Serializable.deserialize( ELinkFile.FOODS.getFilePath());
    }

    public Food bookFood(String foodName, Double foodPrice, ECategory eCategory){
        Food food=new Food();
        food.setFoodName(foodName);
        food.setFoodPrice(foodPrice);
        food.setECategory(eCategory);
        return food;
    }
    @Override
    public Food getById(String str) {
        return null;
    }

    //    public Food
    @Override
    public Food getById(int foodId) {
        Food foundFood = new Food();
        for (Food food : foodList) {
            if (food.getFoodID() == foodId) {
                foundFood = food;
            }
        }
        return foundFood;
    }


    @Override
    public Food getObjById(List<Food> foods, String str) {
        int foodID = AppUtils.getInt(str);
        return foods.stream().filter(e -> e.getFoodID() == foodID).findFirst().orElse(null);
    }

    @Override
    public List<Food> getAll() {
        return foodList;
    }

    @Override
    public boolean create(Food food) {
        if (foodList.stream().anyMatch(e -> e.getFoodName().equals(food.getFoodName()))) {
            return false;
        }
        foodList.add(food);
        save();
        return true;
    }

    @Override
    public boolean isExist(int foodId) {
        Food food = foodList.stream()
                .filter(e -> Objects.equals(e.getId(), foodId))
                .findFirst()
                .orElse(null);
        return food != null;
    }

    @Override
    public void update(Food food) {
        foodList.stream().filter(e -> e.getFoodID() == food.getFoodID()).findFirst().ifPresent(e -> {
            int i = foodList.indexOf(e);
            foodList.set(i, food);
            save();
        });

    }

//    @Override
//    public void update(int idFood) {
//        Food foodToUpdate = getById(idFood);
//        if (foodToUpdate != null) {
//            System.out.println("Nhập thông tin mới cho thực phẩm:");
//            String foodName = getString("Nhập tên thực phẩm");
//            Double foodPrice = getDouble("Nhập giá tiền");
//            ECategory eCategory =ECategory.getCategoryByName(getIntWithBound("Nhập vào"+
//                    "loại thực phẩm(1. Thức ăn/2. Nước uống/3. Khác)",1,3));
//        }
//    }

    @Override
    public void delete(int foodId) {
        foodList = foodList.stream()
                .filter(e -> !Objects.equals(e.getId(), foodId))
                .collect(Collectors.toList());
        save();
    }
}
