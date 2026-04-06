import java.sql.*;

public class IV {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/colleges";
        String user = "root";
        String password = "Karthik2006";

        String query = "SELECT id, name FROM Students";

        try (
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
        ) {

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " " + rs.getString("name")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}