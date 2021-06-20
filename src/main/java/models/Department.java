package models;

import java.util.Objects;

public class Department {
    private int id;
    private String name;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id && numberofemployees == that.numberofemployees && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, numberofemployees);
    }

    public Department(int id, String name, String description, int numberofemployees) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.numberofemployees = numberofemployees;
    }

    private int numberofemployees;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberofemployees() {
        return numberofemployees;
    }

    public void setNumberofemployees(int numberofemployees) {
        this.numberofemployees = numberofemployees;
    }



}
