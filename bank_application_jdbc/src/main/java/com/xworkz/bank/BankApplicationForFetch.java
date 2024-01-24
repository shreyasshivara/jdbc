package com.xworkz.bank;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class BankApplicationForFetch {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String jdbcUrl="jdbc:mysql://localhost:3306/Bank_Application";
        String userName="root";
        String password="Xworkzodc@123";

        String fetch="Select*From bank_info ";
        Connection connection=null;
        Statement statement=null;

        try {
            connection=DriverManager.getConnection(jdbcUrl,userName,password);
            statement=connection.createStatement();
            ResultSet resultset=statement.executeQuery(fetch);
            System.out.println(resultset);
            while (resultset.next()){
                System.out.println(resultset.getString("name"));
                System.out.println(resultset.getString("location"));
                System.out.println(resultset.getString("ifsc"));
                System.out.println(resultset.getString("branch"));
                System.out.println(resultset.getString("id"));
            }
            /*if(resultset.next()){
                System.out.println(resultset.getString("name"));
                System.out.println(resultset.getString("location"));
                System.out.println(resultset.getString("ifsc"));
                System.out.println(resultset.getString("branch"));
                System.out.println(resultset.getString("id"));

            }*/
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
