package src;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hackathon_db",
                "root",
                "msn@160906"
            );
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
