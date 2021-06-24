package dao;

import org.junit.Test;
import models.*;
import static org.junit.Assert.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.junit.*;




public class sql2oDepartmentDaoTest {
    private static Connection conn;
    private static sql2oDepartmentDao DepartmentDao;
    private static sql2oUserDao UserDao;
    private static sql2oNewsDao NewsDao;

    @BeforeClass                //changed to @BeforeClass (run once before running any tests in this file)
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/organisational_api_test";
        Sql2o sql2o = new Sql2o(connectionString, "moringa", "12345");
        DepartmentDao = new sql2oDepartmentDao(sql2o);
        UserDao = new sql2oUserDao(sql2o);
        NewsDao = new sql2oNewsDao(sql2o);
        conn = sql2o.open();        //open connection once before this test file is run
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        DepartmentDao.clearAll();
        UserDao.clearAll();
        NewsDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception{ //changed to static
        conn.close(); // close connection once after this entire test file is finished
        System.out.println("connection closed");
    }


    @Test
    public void addingDepartmentSetsId() throws Exception {
        Department newdepartment = new Department("a","b",1);
        int originalDepartmentid = newdepartment.getId();
        DepartmentDao.add(newdepartment);
        assertNotEquals(originalDepartmentid, newdepartment.getId());
    }
    @Test
    public void getAll() {
        Department department=new Department("a","b",1);

        Department otherDepartment=new Department("a","b",1);
        DepartmentDao.add(department);
        DepartmentDao.add(otherDepartment);
        Assert.assertEquals(department,DepartmentDao.getAll().get(0));
        Assert.assertEquals(otherDepartment,DepartmentDao.getAll().get(1));
    }

    @Test
    public void addedDepartmentsAreReturnedFromGetAll() throws Exception{
        Department newdepartment = new Department("a","b",1);
        DepartmentDao.add(newdepartment);
        assertEquals(1, DepartmentDao.getAll().size());
    }
    @Test
    public void noDepartmentsReturnsEmptyList() throws Exception {
        Department newdepartment = new Department("a","b",1);
        assertEquals(0, DepartmentDao.getAll().size());
    }
    @Test
    public void findByIdReturnsCorrectDepartment() throws Exception {
        Department newdepartment = new Department("a","b",1);
        DepartmentDao.add(newdepartment);
        Department newdepartment1 = new Department("c","d",3);
        assertEquals(newdepartment, DepartmentDao.findById(newdepartment.getId()));
    }
    @Test
    public void deleteByIdDeletesCorrectDepartment() throws Exception {
        Department newdepartment = new Department("a","b",1);
        DepartmentDao.deleteById(newdepartment.getId());
        assertEquals(0, DepartmentDao.getAll().size());
    }
    @Test
    public void clearAll() throws Exception {
        Department newdepartment = new Department("a","b",1);
        Department newdepartment1 = new Department("c","d",3);
        DepartmentDao.clearAll();
        assertEquals(0, DepartmentDao.getAll().size());
    }
}
