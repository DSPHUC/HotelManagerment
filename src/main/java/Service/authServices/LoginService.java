package Service.authServices;

import Model.Client;
import Service.ClientService;
import Service.ManagerService;
import utils.AppUtils;

import static View.Client.ClientView.clientMenu;
import static View.Manager.ManagerView.managerMenu;

public class LoginService {
    private static final StringBuilder result;

    static {
        result = new StringBuilder();
    }

    public static String getName() {
        return result.toString();
    }

    public static void login() {
        String email = AppUtils.getString("Input name");
        String password = AppUtils.getString("Input password");
        if (ManagerService.getByEmail(email) != null && ManagerService.getByEmail(email).getPassword().equals(password)) {
            ManagerService.currentManager = ManagerService.getByEmail(email);
            managerMenu();
        } else
        if (ClientService.getByEmail(email) != null && ClientService.getByEmail(email).
                getPassword().equals(password)) {
            Client client = ClientService.getByEmail(email);
            result.append(client.getName());
            clientMenu();
        } else {
            System.out.println("Invalid account");
            login();
        }
        login();
    }
}
