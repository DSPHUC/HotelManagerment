package Service.authServices;

import Model.Client;
import Service.ClientService;

public class RegisterService {
    public static boolean register(Client client) {
        return ClientService.getInstance().create(client);
    }

}
