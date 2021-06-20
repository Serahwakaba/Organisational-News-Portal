package models;

import java.util.Objects;

public class Department {

    private int id;
    private String name;
    private String description;
    private int numberofemployees;

    public Department(String name, String description, int numberofemployees) {
        this.name = name;
        this.description = description;
        this.numberofemployees = numberofemployees;
    }
    public int getId() {
        return id;
    }
    public String getDepartmentName() {
        return name;
    }
    public String getdepartmentDescription() {
        return description;
    }
    public int getNumberOfEmployees() {
        return numberofemployees;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setDepartmentName(String departmentname) { this.name = name; }
    public void setDepartmentDescription(String departmentdescription) { this.description = description; }
    public void setNumberOfEmployees(int numberofemployees) { this.numberofemployees = numberofemployees; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return numberofemployees == that.numberofemployees &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, description, numberofemployees);
    }
}