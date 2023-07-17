package View;

import DAO.Enums.EGender;
import Model.Client;
import Service.authServices.LoginService;
import Service.authServices.RegisterService;
import utils.AppUtils;
import utils.ListView;

public class LoginView {
    public static void loginMenu() {
        try {
            ListView.printMenu(ListView.menuLoginList);
            int choice = AppUtils.getIntWithBound("Input choice", 0, 2);
            if (choice == 0) {
                System.exit(1);
            }
            if (choice == 1) {
                LoginService.login();
            } else {
                register();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            loginMenu();
        }

    }

    private static void register() {
        System.out.println("Register: ");
        String name = AppUtils.getString("Input Name");
        EGender eGender = EGender.getEGenderById(AppUtils.getIntWithBound("Input Gender",1,2));
        String email = AppUtils.getString("Input Email");
        String password = AppUtils.getString("Input Password");
        String phoneNumber = AppUtils.getString("Input Phone number");
        Client client = new Client(name,eGender, email, password, phoneNumber);
        if(RegisterService.register(client)){
            System.out.println("Register successful!!");
            loginMenu();
        } else {
            System.out.println("Register error!! Please try again");
            register();
        }
    }
}
