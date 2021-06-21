package dao;

import models.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;

public class sql2oUserDaoTest {
    private static Connection conn;
    private static sql2oDepartmentDao DepartmentDao;
    private static sql2oUserDao UserDao;
    private static sql2oNewsDao NewsDao;

    @BeforeClass                //changed to @BeforeClass (run once before running any tests in this file)
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/organisational_api_test";
        Sql2o sql2o = new Sql2o(connectionString, "postgres", "1234");
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
/*
    @Test
    public void addingUsersSetsId() throws Exception {
        User testUsers = setupUser();
        assertEquals(1, testUsers.getId());
    }
    @Test
    public void getAll() throws Exception {
        User Users = setupUser();
        User  Users2 = setupUser();
        assertEquals(2, UserDao.getAll().size());
    }

 */



}
