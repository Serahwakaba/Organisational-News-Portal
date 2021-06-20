package models;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DepartmentTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testTestEquals() {
    }

    public void testTestHashCode() {
    }
    @Test
    public void departmentInstanciatesCorrectly() {
        Department department = new Department("Accounting", "Deals with Accounting", 50);
        assertEquals (true, department instanceof Department);
    }

    public void testSetId() {
        Department department = new Department("Accounting", "Deals with Accounting", 50);
        department.setId(5);
        assertEquals(5, department.getId());
    }

    public void testTestGetName() {
        Department department = new Department("Accounting", "Deals with Accounting", 50);
        assertEquals ("Accounting", department.getName());
    }

    public void testTestSetName() {
        Department department = new Department("Accounting", "Deals with Accounting", 50);
        department.setName("Accounting");
        assertEquals("Accounting", department.getName());
    }

    public void testGetDescription() {
        Department department = new Department("Accounting", "Deals with Accounting", 50);
        assertEquals ("Deals with Accounting", department.getDescription());
    }

    public void testSetDescription() {
        Department department = new Department("Accounting", "Deals with Accounting", 50);
        department.setDescription("Deals with Accounting");
        assertEquals("Deals with Accounting", department.getDescription());
    }

    public void testGetNumberofemployees() {
        Department department = new Department("Accounting", "Deals with Accounting", 50);
        assertEquals (50, department.getNumberofemployees());
    }

    public void testSetNumberofemployees() {
        Department department = new Department("Accounting", "Deals with Accounting", 50);
        department.setNumberofemployees(50);
        assertEquals(50, department.getNumberofemployees());
    }
}