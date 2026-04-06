import java.sql.*;
import java.util.Scanner;
public class V {
    public static void main(String[] args) {
        try {
            // 1. Create connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/colleges",
                "root",
                "Karthik2006"
            );

            Scanner sc = new Scanner(System.in);

            // 2. Take input
            System.out.print("Enter ID to delete: ");
            int id = sc.nextInt();

            // 3. DELETE query
            String deleteQuery = "DELETE FROM Students WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(deleteQuery);
            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();

            // 4. Show delete result
            if (rows > 0) {
                System.out.println("Record deleted successfully");
            } else {
                System.out.println("No record found");
            }

            // 5. DISPLAY remaining data
            System.out.println("\nRemaining Records:");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Students");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " " + rs.getString("name")
                );
            }

            // 6. Close connection
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}