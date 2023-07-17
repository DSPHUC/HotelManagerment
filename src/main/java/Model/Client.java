package Model;

import DAO.Enums.EGender;
import DAO.Enums.ERole;

import java.io.Serializable;

public class Client extends Person implements Serializable {

    public Client(String name, EGender gender, String email, String password, String phoneNumber) {
        super(name,gender, email, password, phoneNumber, ERole.Client);
    }

    public Client() {
    }

    public Client(int id, String name, EGender gender, String email, String password, String phone) {
        this.setId(id);
        this.setName(name);
        this.setGender(gender);
        this.setEmail(email);
        this.setPassword(password);
        this.setPhoneNumber(phone);
    }

    @Override
    public String toString() {
        return super.getId() + " " +
                super.getEmail() + " " +
                super.getGender() + " " +
                super.getName();
    }
}
