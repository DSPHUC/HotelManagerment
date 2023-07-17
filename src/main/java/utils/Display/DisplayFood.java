package utils.Display;

import DAO.Enums.ELinkFile;
import Model.Food;
import utils.CurrencyFormat;
import utils.Serializable;

import java.util.List;

public class DisplayFood {
    public static void displayCategories() {
        List<Food> foods = (List<Food>) Serializable.deserialize
                (ELinkFile.FOODS.getFilePath());
        System.out.println("Danh sách sản phẩm : ");
        System.out.println("\t\t\t\t=========================================================================================================================");
        System.out.printf("\t\t\t\t%-10s %-25s %-30s %-15s  \n", "ID", "Tên sản phẩm", "Loại sản phẩm", "Giá");
        for (Food food : foods) {
            System.out.printf("\t\t\t\t%-10d %-25s %-30s %-25s \n",
                    food.getId(),
                    food.getFoodName(),
                    food.getECategory().getName(),
                    CurrencyFormat.covertPriceToString(food.getFoodPrice()));
        }
        System.out.println("\t\t\t\t=========================================================================================================================\n\n");
    }

    public static void main(String[] args) {
        displayCategories();
    }
}
