package models;


import org.junit.Test;
import static org.junit.Assert.*;
public class DepartmentTest {
    @Test
    public void departmentInstanciatesCorrectly() {
        Department department = new Department("Accounting", "Deals with Accounting", 50);
        assertEquals (true, department instanceof Department);
    }

    @Test
    public void getsDepartmentName() {
        Department department = new Department("Accounting", "Deals with Accounting", 50);
        assertEquals ("Accounting", department.getDepartmentName());
    }
    @Test
    public void getsDepartmentDescription() {
        Department department = new Department("Accounting", "Deals with Accounting", 50);
        assertEquals ("Deals with Accounting", department.getdepartmentDescription());
    }
    @Test
    public void getsDepartmentEmployees() {
        Department department = new Department("Accounting", "Deals with Accounting", 50);
        assertEquals (50, department.getNumberOfEmployees());
    }
    @Test
    public void setsDepartmentName() {
        Department department = new Department("Accounting", "Deals with Accounting", 50);
        department.setDepartmentName("Accounting");
        assertEquals("Accounting", department.getDepartmentName());
    }
    @Test
    public void setsDepartmentDescription() {
        Department department = new Department("Accounting", "Deals with Accounting", 50);
        department.setDepartmentDescription("Deals with Accounting");
        assertEquals("Deals with Accounting", department.getdepartmentDescription());
    }
    @Test
    public void setsDepartmentEmployees() {
        Department department = new Department("Accounting", "Deals with Accounting", 50);
        department.setNumberOfEmployees(50);
        assertEquals(50, department.getNumberOfEmployees());
    }
    @Test
    public void setId() {
        Department department = new Department("Accounting", "Deals with Accounting", 50);
        department.setId(5);
        assertEquals(5, department.getId());
    }
}
