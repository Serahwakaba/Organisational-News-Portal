package dao;
import models.User;

import java.util.List;

public interface UserDao {
    // LIST
    List<User> getAll();
    List<User> getAllUsersByDepartment(int departmentId);

    //create
    void add(User user);

    //read
    User findById(int id);

    //delete
    void deleteById(int id);
    void clearAll();
}
