package Model;

import DAO.Enums.EGender;
import DAO.Enums.ERole;
import Service.iService.IModel;

import java.io.Serializable;
import java.util.Date;

public class User implements IModel<User>, Serializable {
    private int currentID = 0;
    private int id;
    private String name;
    private Date dob;
    private EGender gender;
    private String address;
    private String email;
    private String password;
    private String phoneNumber;
    private ERole erole;

    public User(int id, String name, Date dob, EGender gender, String address
            , String email, String password, String phoneNumber, ERole erole) {
        this.id = currentID++;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.erole = erole;
    }


    public void setId(int id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ERole getErole() {
        return erole;
    }

    public void setErole(ERole erole) {
        this.erole = erole;
    }

    @Override
    public int getId() {
        return id;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void update(User obj) {
        this.id = obj.id;
        this.name = obj.name;
        this.dob = obj.dob;
        this.gender = obj.gender;
        this.address = obj.address;
        this.email = obj.email;
        this.password = obj.password;
        this.phoneNumber = obj.phoneNumber;
        this.erole = obj.erole;
    }

    @Override
    public String toString() {
        return "User{" +
                ", Id='" + id + '\'' +
                ", Name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", address=" + address + '\'' +
                ", email=" + email + '\'' +
                ", phoneNumber=" + phoneNumber + '\'' +
                ", role=" + erole + '\'' +
                '}';
    }
}
