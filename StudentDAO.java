import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {

    public void addStudent(String name, String rollNumber, String department, int semester, double marks) {
        String sql = "INSERT INTO students (name, roll_number, department, semester, marks) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, rollNumber);
            stmt.setString(3, department);
            stmt.setInt(4, semester);
            stmt.setDouble(5, marks);

            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Student added successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }
    public void viewAllStudents() {
    String sql = "SELECT * FROM students";

    try (Connection conn = DBConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") +
                    " | Name: " + rs.getString("name") +
                    " | Roll No: " + rs.getString("roll_number") +
                    " | Dept: " + rs.getString("department") +
                    " | Semester: " + rs.getInt("semester") +
                    " | Marks: " + rs.getDouble("marks"));
        }

    } catch (SQLException e) {
        System.out.println("Error fetching students: " + e.getMessage());
    }
}
public void updateStudent(int id, String name, String rollNumber, String department, int semester, double marks) {
    String sql = "UPDATE students SET name = ?, roll_number = ?, department = ?, semester = ?, marks = ? WHERE id = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, name);
        stmt.setString(2, rollNumber);
        stmt.setString(3, department);
        stmt.setInt(4, semester);
        stmt.setDouble(5, marks);
        stmt.setInt(6, id);

        int rowsUpdated = stmt.executeUpdate();

        if (rowsUpdated > 0) {
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("No student found with that ID.");
        }

    } catch (SQLException e) {
        System.out.println("Error updating student: " + e.getMessage());
    }
}
public void deleteStudent(int id) {
    String sql = "DELETE FROM students WHERE id = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);

        int rowsDeleted = stmt.executeUpdate();

        if (rowsDeleted > 0) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("No student found with that ID.");
        }

    } catch (SQLException e) {
        System.out.println("Error deleting student: " + e.getMessage());
    }
}
}