import java.sql.Connection;
public class Main {
    public static void main (String[] args) {
        System.out.println("media tracker started!");
        DatabaseManager d = new DatabaseManager();
        Connection var = d.connect();
        if (var == null) {
            System.out.println("Connection Failed.");
        } else {
            System.out.println("Connection Successful!");
        }
    }
}