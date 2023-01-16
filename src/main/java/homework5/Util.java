package homework5;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {
    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/people5";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "1qaz2wsx";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
