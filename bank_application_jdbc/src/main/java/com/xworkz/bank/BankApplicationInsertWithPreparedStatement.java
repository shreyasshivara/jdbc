package com.xworkz.bank;

import java.sql.*;

public class BankApplicationInsertWithPreparedStatement {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String jdbcUrl = "jdbc:mysql://localhost:3306/bank_Application";
        String userName = "root";
        String password = "Xworkzodc@123";
        String query = "Insert into bank_info values(?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "IDFC");
            preparedStatement.setString(3, "BTM");
            preparedStatement.setString(4, "madivala");
            preparedStatement.setString(5, "IDFC1234");
            ResultSet resultSet =preparedStatement.executeQuery();
            System.out.println(resultSet);
            while (resultSet.next()){
                System.out.println(resultSet);
            }
            System.out.println("prepared statement updated successfully!!!!!!!!!!!!!!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
