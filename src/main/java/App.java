import static spark.Spark.*;

import com.google.gson.Gson;
import exceptions
        .ApiException;
import models.*;
import dao.*;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);
        sql2oUserDao UserDao;
        sql2oDepartmentDao DepartmentDao;
        sql2oNewsDao NewsDao;
        Connection conn;
        Gson gson = new Gson();

        staticFileLocation("/public");
        Sql2o sql2o = DB.sql2o;
        DepartmentDao = new sql2oDepartmentDao(sql2o);
        UserDao = new sql2oUserDao(sql2o);
        NewsDao = new sql2oNewsDao(sql2o);

        get(("/"), (request, response) -> {
            response.redirect("/users");
            return null;
        });

        post("/departments/new", "application/json", (request, response) -> {
            Department department = gson.fromJson(request.body(), Department.class);
            DepartmentDao.add(department);
            response.status(201);
            return gson.toJson(department);
        });

        get("/departments", "application/json", (req, res) -> {
            res.type("application/json");
            System.out.println(DepartmentDao.getAll());
            if(DepartmentDao.getAll().size() > 0){
                return gson.toJson(
                        DepartmentDao.getAll());
            }
            else {
                return "{\"message\":\"I'm sorry, but no departments are currently listed in the database.\"}";
            }
        });
        get("/departments/:id", "application/json", (req, res) -> {

            int departmentId = Integer.parseInt(req.params("id"));
            Department departmentToFind = DepartmentDao.findById(departmentId);
            if (departmentToFind == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
            }
            res.type("application/json");
            return gson.toJson(departmentToFind);
        });
        get("/departments/:id/news", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));

            Department departmentToFind = DepartmentDao.findById(departmentId);
            List<News> allNews;

            if (departmentToFind == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
            }
            allNews = NewsDao.getAllNewsByDepartment(departmentId);
            res.type("application/json");
            return gson.toJson(allNews);
        });
        post("/users/new", "application/json", (req, res) -> {
            User user = gson.fromJson(req.body(), User.class);
            UserDao.add(user);
            res.status(201);
            res.type("application/json");
            return gson.toJson(user);
        });
        get("/users", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(UserDao.getAll());

        });
        post("/news/new", "application/json", (req, res) -> {
            res.type("application/json");
            News news = gson.fromJson(req.body(), News.class);
            NewsDao.add(news);
            res.status(201);
            res.type("application/json");
            return gson.toJson(news);
        });
        get("/news", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(NewsDao.getAll());
        });


        //FILTERS
        exception(ApiException.class, (exception, req, res) -> {
            ApiException err = exception;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
            res.status(err.getStatusCode());
            res.body(gson.toJson(jsonMap));
        });


        after((req, res) ->{
            res.type("application/json");
        });
    }
}
