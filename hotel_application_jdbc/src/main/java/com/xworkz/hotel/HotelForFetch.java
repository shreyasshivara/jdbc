package com.xworkz.hotel;

import java.sql.*;

public class HotelForFetch {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String jdbcUrl="jdbc:mysql://localhost:3306/hotel";
        String userName="root";
        String password="Xworkzodc@123";
        String selectQuery="Select*from hotel_info";
        Connection connection=null;
        Statement statement =null;
        try {
            connection=DriverManager.getConnection(jdbcUrl,userName,password);
            statement=connection.createStatement();
            ResultSet result=statement.executeQuery(selectQuery);
            System.out.println(result);
            while (result.next()){
                System.out.println(result.getString("h_name"));

                System.out.println(result.getString("h_owner"));
                System.out.println(result.getString("id"));
                System.out.println(result.getString("h_location"));
                System.out.println(result.getString("ph_no"));
                System.out.println("==============================");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
