import java.sql.*;

public class jdbcsql {

    public static void main(String[] args) {
        // Database connection parameters
        String userName = "root";
        String url = "jdbc:mysql://localhost:3306/testingjdbc";
        String password = "Shivam.23@@!!";

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            // Establish connection
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection is established");

            // Create statement
            st = conn.createStatement();
            String sqlQuery = "SELECT * FROM Employees";

            // Execute query
            rs = st.executeQuery(sqlQuery);

            // Process the result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");
                Date hireDate = rs.getDate("hire_date");
                double salary = rs.getDouble("salary");

                System.out.println("ID: " + id + ", First Name: " + first_name +
                        ", Last Name: " + last_name + ", Email: " + email +
                        ", Hire Date: " + hireDate + ", Salary: " + salary);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
