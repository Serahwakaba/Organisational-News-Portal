package dao;
import models.*;

import java.util.List;

public interface DepartmentDao {

    // LIST
    List<Department> getAll();
    List<User> getUsers(int departmentid);
    List<News> getNews(int departmentid);

    //create
    void add (Department department);

    //read
    Department findById(int id);

    // Delete
    void deleteById(int id);
    void clearAll();

}
