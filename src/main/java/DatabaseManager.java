import java.sql.Connection; // connects to a serverless database
import java.sql.DriverManager; // creates a bridge between databse and URL connection
import java.sql.SQLException; // handles any URl errors

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:mediatracker.db";
    public Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(URL);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Invalid connection! " + e.getMessage());
            return null;
        }
    }
}