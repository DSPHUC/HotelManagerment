package Model;

import DAO.Enums.EGender;
import DAO.Enums.ERole;

import java.io.Serializable;

public class Manager extends Person implements Serializable {
    static final int auth = 1;
    static final String role = ERole.ADMIN.getName();

    public Manager() {
    }

    public Manager(String name, EGender eGender, String email, String password, String phoneNumber) {
        super(name,eGender, email, password, phoneNumber,ERole.ADMIN);
    }
}
