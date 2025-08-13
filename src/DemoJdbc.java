import java.sql.*;

public class DemoJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/demo";
        String userName = "postgres";
        String password = "sino ";

        int id = 0;
        String sql = "select * from student where sid > ?";

        Connection con = DriverManager.getConnection(url, userName, password);
        System.out.println("Connected to PostgreSQL database");

        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            System.out.print("Id: " + rs.getInt(1));
            System.out.print(" Name: " + rs.getString(2));
            System.out.println(" Marks: " + rs.getInt(3));
        }

        con.close();
        System.out.println("Connection closed");
    }
}
