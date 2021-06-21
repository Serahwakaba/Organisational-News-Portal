import org.sql2o.*;
import java.net.URI;
import java.net.URISyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class DB {
    private static URI dbUri;
    public static Sql2o sql2o;
    static Logger logger = LoggerFactory.getLogger(DB.class);
    static {

        try {
            if (System.getenv("DATABASE_URL") == null) {
                dbUri = new URI("jdbc:postgresql://localhost:5432/organisational_api");
                String connectionString = "jdbc:postgresql://localhost:5432/organisational_api"; } else {
                dbUri = new URI(System.getenv("DATABASE_URL"));
                int port = dbUri.getPort();
                String host = dbUri.getHost();
                String path = dbUri.getPath();
                String username = (dbUri.getUserInfo() == null) ? "postgres" : dbUri.getUserInfo().split(":")[0];
                String password = (dbUri.getUserInfo() == null) ? "12345" : dbUri.getUserInfo().split(":")[1];
                sql2o = new Sql2o("jdbc:postgresql://" + host + ":" + port + path, username, password);
            }

        } catch (URISyntaxException e ) {
            logger.error("Unable to connect to database.");
        }
    }
}