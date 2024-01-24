package com.xworkz.bank;

import java.sql.*;

public class BankApplicationForDelete {
    public static void main(String[] args)  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String jdbcUrl="jdbc:mysql://localhost:3306/Bank_Application";
        String userName="root";
        String password="Xworkzodc@123";
        String query="delete from bank_info where name='SBI'";
        Connection connection=null;
        Statement statement=null;
        try {
             connection=DriverManager.getConnection(jdbcUrl,userName,password);
             statement =connection.createStatement();
            int result=statement.executeUpdate(query);
            System.out.println(result);
            System.out.println("deleted successfully!!!!!!!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
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
