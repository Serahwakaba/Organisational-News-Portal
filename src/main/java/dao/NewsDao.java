package dao;
import models.News;

import java.util.List;

public interface NewsDao {
    // LIST
    List<News> getAll();
    List<News> getAllNewsByDepartment(int departmentId);

    //create
    void add(News news);

    //read
    News findById(int id);

    //delete
    void deleteById(int id);
    void clearAll();
}
