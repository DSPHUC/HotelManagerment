package Model;

import DAO.Enums.EGender;
import DAO.Enums.ERole;

import java.io.Serializable;

public class Staff extends Person implements Serializable {
    static final int auth = 2;
    static final String role = ERole.STAFF.getName();
    public Staff(){
    }
    public Staff(String name, EGender eGender, String email, String password, String phoneNumber) {
        super(name,eGender, email, password, phoneNumber,ERole.STAFF);
    }

}
