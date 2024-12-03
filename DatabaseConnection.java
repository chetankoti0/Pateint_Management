package HospitalPateintManagementSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/patients"; 
	private static final String USER = "root"; 
    private static final String PASSWORD = "Chetankoti@04"; // Replace with your MySQL password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
