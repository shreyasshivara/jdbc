package com.xworkz.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HotelForUpdate {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String jdbcUrl="jdbc:mysql://localhost:3306/hotel";
        String userName="root";
        String password="Xworkzodc@123";
        String updateQuery="update Hotel_info set h_owner='Shreyas' where id=1";
        String updateQuery1="update Hotel_info set h_owner='hemanth' where id=2";
        String updateQuery2="update Hotel_info set h_owner='sagar' where id=3";
        String updateQuery3="update Hotel_info set h_owner='sampath' where id=4";
        String updateQuery4="update Hotel_info set h_owner='sudeep' where id=5";
        String updateQuery5="update Hotel_info set h_owner='anand' where id=6";
        String updateQuery6="update Hotel_info set h_owner='yogi' where id=7";
        String updateQuery7="update Hotel_info set h_owner='pradeep' where id=8";
        String updateQuery8="update Hotel_info set h_owner='adarsh' where id=9";
        String updateQuery9="update Hotel_info set h_owner='Shreyas' where id=10";
        Connection connection=null;
        Statement statement=null;
        try {
           connection= DriverManager.getConnection(jdbcUrl,userName,password);
           statement=connection.createStatement();
           int result=statement.executeUpdate(updateQuery);
           int result1=statement.executeUpdate(updateQuery1);
           int result2=statement.executeUpdate(updateQuery2);
           int result3=statement.executeUpdate(updateQuery3);
           int result4=statement.executeUpdate(updateQuery4);
           int result5=statement.executeUpdate(updateQuery5);
           int result6=statement.executeUpdate(updateQuery6);
           int result7=statement.executeUpdate(updateQuery7);
           int result8=statement.executeUpdate(updateQuery8);
           int result9=statement.executeUpdate(updateQuery9);
            System.out.println("updated successfully!!!!!!!!!!!!!!!!!!");

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
