package HospitalPateintManagementSystem;
import java.sql.*;
import java.util.Scanner;
public class HospitalPateintManagementSystem {

	
    public void addPatient(variable newP) {
        String query = "INSERT INTO Patients (patientId, Pname, age, gender, contactNumber, bloodGroup, doctorInCharge, disease, emergencyNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, newP.patientId);
            pstmt.setString(2, newP.Pname);
            pstmt.setInt(3, newP.age);
            pstmt.setString(4, newP.gender);
            pstmt.setString(5, newP.contactNumber);
            pstmt.setString(6, newP.bloodGroup);
            pstmt.setString(7, newP.doctorInCharge);
            pstmt.setString(8, newP.disease);
            pstmt.setString(9, newP.emergencyNumber);
            pstmt.executeUpdate();
            System.out.println("Patient added successfully.");
        } catch (SQLException e) {
            System.out.println("Error while adding a new patient: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
    public void displayAllPatients() {
        String query = "SELECT * FROM Patients";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("patientId"));
                System.out.println("Name: " + rs.getString("Pname"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Gender: " + rs.getString("gender"));
                System.out.println("Contact Number: " + rs.getString("contactNumber"));
                System.out.println("-------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void searchById(int id) {
        String query = "SELECT * FROM Patients WHERE patientId = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Patient Found:");
                System.out.println("ID: " + rs.getInt("patientId"));
                System.out.println("Name: " + rs.getString("Pname"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Gender: " + rs.getString("gender"));
                System.out.println("Contact Number: " + rs.getString("contactNumber"));
            } else {
                System.out.println("Patient not found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deletePatientById(int id) {
    	String query="DELETE FROM patients where patientId=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, id); 
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Patient with ID " + id + " deleted successfully.");
            } else {
                System.out.println("No patient found with ID " + id + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        HospitalPateintManagementSystem p = new HospitalPateintManagementSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Hospital Patient Management System ---");
            System.out.println("1. Add New Patient");
            System.out.println("2. Search Patient by ID");
            System.out.println("3. Display All Patients");
            System.out.println("4.Delete using ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 : {
                    System.out.print("Enter Patient ID: ");
                    int patientId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String Pname = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Gender: ");
                    String gender = sc.nextLine();
                    System.out.print("Enter Contact Number: ");
                    String contactNumber = sc.nextLine();
                    System.out.print("Enter Blood Group: ");
                    String bloodGroup = sc.nextLine();
                    System.out.print("Enter Doctor In Charge: ");
                    String doctorInCharge = sc.nextLine();
                    System.out.print("Enter Disease: ");
                    String disease = sc.nextLine();
                    System.out.print("Enter Emergency Contact Number: ");
                    String emergencyNumber = sc.nextLine();
                 
                    variable newP = new variable(patientId, Pname, age, gender, contactNumber, bloodGroup, doctorInCharge, disease, emergencyNumber);
                    p.addPatient(newP);
                    break;
                }
                case 2 : {
                    System.out.print("Enter Patient ID to search: ");
                    int id = sc.nextInt();
                    p.searchById(id);
                    break;
                }
                case 3 : {p.displayAllPatients();
                			break;}
                case 4 : 
                	System.out.print("enter ID to be deleted:");
                	int id=sc.nextInt();
                	p.deletePatientById(id);
                	break;
                case 5 : {
                    System.out.println("Exiting program. Goodbye!");
                    sc.close();
                    System.exit(0);
                }
                default : System.out.println("Invalid choice. Please try again.");
            }
        }
     
    }
}

