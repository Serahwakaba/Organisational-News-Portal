package models;

public class Department {
    private int id;
    private String name;
    private String description;



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
