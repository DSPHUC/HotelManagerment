//package Service;
//
//import Model.Person;
//import utils.AppUtils;
//
//import java.io.IOException;
//
//import static View.Manager.ManagerView.managerMenu;
//
//public class LoginService {
//    public static Person currentUser;
//
//    public static void login() throws IOException {
//        String email = AppUtils.getString("Input username: ");
//        String password = AppUtils.getString("Input password");
//        if (ManagerService.getByEmail(email) != null
//                && ManagerService.getByEmail(email).getPassword().equals(password)) {
//
//            managerMenu();currentUser = ManagerService.getByEmail(email);
//        }
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
