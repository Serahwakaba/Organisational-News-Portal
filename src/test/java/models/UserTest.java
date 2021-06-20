package models;

import org.junit.Test;
import static org.junit.Assert.*;
public class UserTest {
    User user = new User("Moses", 1, "Maintain servers");
    @Test
    public void userInatanciatesCorrectly() {

        assertEquals(true, user instanceof User);
    }
    @Test
    public void getUserName() {
        assertEquals("Moses", user.getName());
    }
    @Test
    public void getsUserDepartmentId() {
        assertEquals(1, user.getDepartmentId());
    }
    @Test
    public void getsUserRole() {
        assertEquals("Maintain servers", user.getRole());
    }
    @Test
    public void setsUserName() {
        user.setName("Moses");
        assertEquals("Moses", user.getName());
    }
    @Test
    public void setsUserDepartmentId() {
        user.setDepartmentId(1);
        assertEquals(1, user.getDepartmentId());
    }
    @Test
    public void setsUserRole() {
        user.setName("Maintain servers");
        assertEquals("Maintain servers", user.getRole());
    }
    @Test
    public void setId() {
        user.setId(5);
        assertEquals(5, user.getId());
    }

}