package com.xworkz.repository;

import com.xworkz.dto.FlightBooking;

import java.sql.*;
import java.util.List;

public class FlightTicketBookingRepositoryImpl implements FlightTicketRepository {
    @Override
    public void flightTicketBookingDetails(FlightBooking flightBooking) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String jdbcUrl = "jdbc:mysql://localhost:3306/Ticket_system";
        String userName = "root";
        String password = "Xworkzodc@123";
        String insertQuery = "INSERT into Air_Ticket(Flight_name,Departure,Destination,price) values(?,?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, flightBooking.getFlightName());
            preparedStatement.setString(2, flightBooking.getDeparture());
            preparedStatement.setString(3, flightBooking.getDestination());
            preparedStatement.setInt(4, flightBooking.getPrice());

            preparedStatement.execute();
            System.out.println("values inserted successfully!!!!!!!!!!");

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




    @Override
    public void saveAll(List<FlightBooking> flightBookings) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String jdbcUrl = "jdbc:mysql://localhost:3306/Ticket_system";
        String userName = "root";
        String password = "Xworkzodc@123";
        String insertQuery = "INSERT into Air_Ticket(Flight_name,Departure,Destination,price) values(?,?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
            preparedStatement = connection.prepareStatement(insertQuery);
            for (FlightBooking flightBooking:flightBookings
                 ) {
                preparedStatement.setString(1, flightBooking.getFlightName());
                preparedStatement.setString(2, flightBooking.getDeparture());
                preparedStatement.setString(3, flightBooking.getDestination());
                preparedStatement.setInt(4, flightBooking.getPrice());
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(String flightName, String departure, String destination) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String jdbcUrl="jdbc:mysql://localhost:3306/Ticket_system";
        String userName="root";
        String password="Xworkzodc@123";
        String updateQuery="Update air_ticket set destination=?, departure=? where flight_name=?";

        try {
            Connection connection=DriverManager.getConnection(jdbcUrl,userName,password);
            PreparedStatement preparedStatement=connection.prepareStatement(updateQuery);
            preparedStatement.setString(1,destination);
            preparedStatement.setString(2,departure);
            preparedStatement.setString(3,flightName);
            preparedStatement.execute();
            System.out.println("updated successfully!!!!!!!!!!!!!!!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(String flightName) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String jdbcUrl="jdbc:mysql://localhost:3306/Ticket_System";
        String userName="root";
        String password="Xworkzodc@123";
        String deleteQuery="Delete from air_Ticket where flight_name=?";
        try {
            Connection connection=DriverManager.getConnection(jdbcUrl,userName,password);
            PreparedStatement preparedStatement=connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1,flightName);
            preparedStatement.execute();
            System.out.println("delete query inserted successfully!!!!!!!!!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public FlightBooking findByName(String flightName) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String jdbcUrl="jdbc:mysql://localhost:3306/Ticket_system";
        String userName="root";
        String password="Xworkzodc@123";
        String query="select*from air_ticket where flight_name=?";
        FlightBooking flightBooking=null;
        try {
           Connection connection= DriverManager.getConnection(jdbcUrl,userName,password);
           PreparedStatement preparedStatement=connection.prepareStatement(query);
           preparedStatement.setString(1,flightName);
           ResultSet resultSet=preparedStatement.executeQuery();
           if (resultSet.next()){
               System.out.println(resultSet.getString("departure"));
               System.out.println(resultSet.getString("destination"));
               System.out.println(resultSet.getString("price"));
                flightBooking=new FlightBooking();

               flightBooking.setFlightName(resultSet.getString("Flight_name"));
               flightBooking.setDeparture(resultSet.getString("departure"));
               flightBooking.setDestination(resultSet.getString("destination"));
               flightBooking.setPrice(resultSet.getInt("price"));
           }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flightBooking;
    }

  /*  @Override
    public void updateAll(String flightName, String departure) {

    }*/


}


