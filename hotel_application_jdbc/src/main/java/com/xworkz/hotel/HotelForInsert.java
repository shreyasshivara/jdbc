package com.xworkz.hotel;

import java.sql.*;

public class HotelForInsert {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String jdbcUrl = "jdbc:mysql://localhost:3306/hotel";
        String userName = "root";
        String password = "Xworkzodc@123";

        String query = "Insert into hotel_info values(1,'Hanumanthu','Mysore','vijay',0987654321)";
        String query1="Insert into hotel_info values(2,'taj','mumbai','anil',9876543210),(3,'empire','kormangala','kiran',8765432109),(4,'ayodya','channarayapatna','nandish',7654321098),(5,'Raasta','DVG','madhu mohan',5432109876),(6,'tambi','crp','tambi',1234567890),(7,'adyas','crp','aadya',56789012345),(8,'nandagokula','hassan','nanda',2345678901),(9,'manasa','hassan','manasa',5678909876),(10,'kabab magic','hsr layout','hemanth',4567899876)" ;
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
            statement = connection.createStatement();
            boolean result = statement.execute(query1);

            System.out.println(result);
            System.out.println("Query inserted successfully!!!!!!!!!!!!!!!!!!!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

