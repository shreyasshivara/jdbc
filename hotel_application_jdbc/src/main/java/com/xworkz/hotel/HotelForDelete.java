package com.xworkz.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HotelForDelete {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String jdbcUrl="jdbc:mysql://localhost:3306/hotel";
        String userName="root";
        String password="Xworkzodc@123";
        String deleteQuery="Delete from hotel_info where h_owner='Shreyas'";
        Connection connection=null;
        Statement statement=null;
        try {
            connection=DriverManager.getConnection(jdbcUrl,userName,password);
            statement=connection.createStatement();
            int result=statement.executeUpdate(deleteQuery);
            System.out.println(result);
            System.out.println("Delete query executed successfully!!!!!!!!!!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
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
