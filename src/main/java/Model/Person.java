package Model;

import DAO.Enums.EGender;
import DAO.Enums.ERole;

import java.io.Serializable;

public class Person implements Serializable {
    private int id;
    private String name;
    private EGender gender;
    private String email;
    private String password;
    private String phoneNumber;
    private ERole eRole;

    public Person() {

    }

    public Person(String name,EGender gender, String email, String password, String phoneNumber, ERole eRole) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public Person(String name, String email, EGender gender, String password, String phoneNumber, ERole eRole) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }

    public ERole geteRole() {
        return eRole;
    }

    public void seteRole(ERole eRole) {
        this.eRole = eRole;
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password/*.getPasscode()*/ + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
