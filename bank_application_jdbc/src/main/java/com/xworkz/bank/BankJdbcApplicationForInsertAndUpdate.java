package com.xworkz.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BankJdbcApplicationForInsertAndUpdate {
    public static void main(String[] args)  {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String jdbcUrl="jdbc:mysql://localhost:3306/Bank_Application";
        String userName="root";
        String password="Xworkzodc@123";
        String insert="INsert into bank_info values(2,'axis','BANGLORE','jaynagar','axisN0007911')";
        String insert1="INsert into bank_info values(5,'carporation','Hassan','k.r puram','carp000086'),(6,'karnataka','MYSORE','JP NAGAR','BOB7T447')";
        String insert2="Insert into bank_info values(7,'canara','Banglore','HSR layout','CNRB00022'),(8,'HDFC','Mysore','hebbal ','HDFCB00022'),(9,'Axis','Hassan','kuvempu nagar','CNRB00022'),(10,'Grameena','M shivra','Channarayapatna','GB00022')";
        String update="update bank_info set IFSC='SBIN007912' where id=1";
        String update1="update Bank_info set IFSC='axis000791'where id=2";
        String update9="update Bank_info set IFSC='icici7911'where id=3";
        String update2="update Bank_info set IFSC='BOB7911'where id=4";
        String update3="update Bank_info set IFSC='Carp0007911'where id=5";
        String update4="update Bank_info set IFSC='karb0007911'where id=6";
        String update5="update Bank_info set IFSC='canr0007911'where id=7";
        String update6="update Bank_info set IFSC='hdfc0007911'where id=8";
        String update7="update Bank_info set IFSC='axisba000791'where id=9";
        String update8="update Bank_info set IFSC='grb0007911'where id=10";
try {
            Connection connection =DriverManager.getConnection(jdbcUrl,userName,password);
            Statement statement =connection.createStatement();
             int result=statement.executeUpdate(update9);

            System.out.println(result);
            System.out.println("inserted data into bank_info");
            System.out.println("Connection successFull!!!!!!!!!!!!!!!!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
}
