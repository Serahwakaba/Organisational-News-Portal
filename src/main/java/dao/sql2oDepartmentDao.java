package dao;

import models.Department;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;
import java.util.List;

public class sql2oDepartmentDao {
    private final Sql2o sql2o;
    public sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Department> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM departments")
                    .executeAndFetch(Department.class);
        }

    }
    @Override
    public List<User> getUsers(int departmentid) {
        String sql = "SELECT * FROM users where departmentid=:departmentid";
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("departmentid", departmentid)
                    .executeAndFetch(User.class);
        }
    }
    @Override
    public List<News> getNews(int departmentid) {
        String sql = "SELECT * FROM news where departmentid=:departmentid";
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("departmentid", departmentid)
                    .executeAndFetch(News.class);
        }
    }
}
