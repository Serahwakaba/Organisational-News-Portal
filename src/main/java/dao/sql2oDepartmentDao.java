package dao;

import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;

public class sql2oDepartmentDao implements DepartmentDao {
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

    @Override
    public void add(Department department) {
        String sql = "INSERT INTO departments(name,description,numberofemployees) VALUES(:name,:description,:numberofemployees)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .addParameter("name",department.getDepartmentName())
                    .addParameter("description",department.getdepartmentDescription())
                    .addParameter("numberofemployees",department.getNumberOfEmployees())
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Department findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Department.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from departments WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();

        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from departments";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

}
