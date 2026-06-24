import java.sql.Connection; // connects to a serverless database
import java.sql.DriverManager; // creates a bridge between databse and URL connection
import java.sql.SQLException; // handles any URl errors
import java.sql.Statement; // executes statements and returns results

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
    public void createMoviesTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS movies (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "title TEXT NOT NULL," + 
            "genre TEXT," + 
            "rating REAL," +
            "date_watched TEXT," +
            "notes TEXT)";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error found! " + e.getMessage());
        }
    }
}