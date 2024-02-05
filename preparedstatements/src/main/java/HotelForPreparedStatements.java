import java.sql.*;

public class HotelForPreparedStatements {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);

        }
        String jdbcUrl = "jdbc:mysql://localhost:3306/Hotel";
        String userName = "root";
        String password = "Xworkzodc@123";
        String updateQuery = "update Hotel_info set h_location=?, where H_name=?";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, "hsr LAYOUT ");
            preparedStatement.setString(2, "Shreyas ");
            preparedStatement.execute();
            System.out.println("updated prepared statement successfully!!!!!!!!!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {


            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
