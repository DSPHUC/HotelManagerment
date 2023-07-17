package Service;

import DAO.Enums.ELinkFile;
import Model.Client;
import Service.iService.IBasicCRUD;
import utils.AppUtils;
import utils.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ClientService implements IBasicCRUD<Client> {
    public static List<Client> clientList;
    private static ClientService instance;
    private static int nextId;
    public static ClientService getInstance() {
        if (instance == null) {
            instance = new ClientService();
        }
        return instance;
    }

    public static Client currentClient;

    static {
        clientList = new ArrayList<>( (List<Client>) Serializable.deserialize(ELinkFile.CLIENTS.getFilePath()));


        if (clientList==null){
            nextId=1;
        }else {
            nextId = AppUtils.getNextId(clientList.stream().map(Client::getId).collect(Collectors.toList()));
        }
    }

    public ClientService() {

    }

    @Override
    public Client getById(String str) {
        int clientId = AppUtils.getInt(str);
        Client client = clientList.stream().filter(e -> e.getId() == clientId).findFirst().orElse(null);
        if (client == null) {
            System.out.println("Client not found. Please try again!");
            getById(str);
        }
        return client;
    }
    @Override
    public Client getById(int id) {

        return clientList.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }
    @Override
    public Client getObjById(List<Client> clients, String str) {
        int roomID = AppUtils.getInt(str);
        return clients.stream().filter(e -> e.getId() == roomID).findFirst().orElse(null);
    }

    public static Client getByEmail(String email) {
        return clientList.stream()
                .filter(e -> e.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    } public static Client getByName(String name) {
        return clientList.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Client> getAll() {
        return clientList;
    }

    @Override
    public boolean create(Client client) {
        if (clientList.stream().anyMatch(e -> e.getEmail().equals(client.getEmail()))) {
            return false;
        }
        clientList.add(client);
        save();
        return true;
    }

    @Override
    public void update(Client client) {
        for (int i = 0; i < clientList.size(); i++) {
            Client existingClient = clientList.get(i);
            if (existingClient.getId() == client.getId()) {
                clientList.set(i, client);
                break;
            }
        }
    }

    public boolean isExist(int guestId) {
        Client client = clientList.stream()
                .filter(e -> Objects.equals(e.getId(), guestId))
                .findFirst().orElse(null);
        return client != null;
    }

    @Override
    public void delete(int guestId) {
        clientList = clientList.stream().filter(e -> Objects.equals(e.getId(), guestId))
                .collect(Collectors.toList());
    }

    public void print() {
        for (Client client : clientList) {
            System.out.println(client.toString());
        }
    }

    public static void save() {
        Serializable.serialize(clientList, ELinkFile.CLIENTS.getFilePath());
    }

    public void isExit(int clientId) {
    }
}
