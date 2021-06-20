package dao;

import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class sql2oNewsDao implements NewsDao {
    private final Sql2o sql2o;
    public sql2oNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    @Override
    public List<News> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM news")
                    .executeAndFetch(News.class);
        }
    }
}
