package models;

import java.util.Objects;

public class User {
    private int id;
    private String name;
    private int departmentid;
    private String role;

    public User(String name, int departmentid, String role) {
        this.name = name;
        this.departmentid = departmentid;
        this.role = role;
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

    public void setName(String userName) {
        this.name = name;
    }

    public int getDepartmentId() {
        return departmentid;
    }

    public void setDepartmentId(int departmentid) {
        this.departmentid = departmentid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return departmentid == user.departmentid &&
                Objects.equals(name, user.name) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, departmentid, role);
    }
}

