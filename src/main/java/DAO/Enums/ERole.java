package DAO.Enums;

import java.util.Objects;

public enum ERole {
    ADMIN(1,"Manager"),
    STAFF(2,"Staff"),
    Client(3,"Client");
    private int id;
    private String name;

    ERole(int id, String name) {
        this.id = id;
        this.name = name;
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
    public static ERole getRoleByName(String name){
        ERole[] var1 = values();
        int var2 = var1.length;
        for (ERole role : var1) {
            if (Objects.equals(role.getName(), name)) {
                return role;
            }
        }
        return null;
    }public static ERole getRoleById(int id){
        ERole[] var1 = values();
        int var2 = var1.length;
        for (ERole role : var1) {
            if (Objects.equals(role.getId(), id)) {
                return role;
            }
        }
        return null;
    }
}
