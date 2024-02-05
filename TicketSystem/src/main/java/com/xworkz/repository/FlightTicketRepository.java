package com.xworkz.repository;

import com.xworkz.dto.FlightBooking;

import java.util.List;

public interface FlightTicketRepository {
    void flightTicketBookingDetails(FlightBooking flightBooking);


    void saveAll(List<FlightBooking> flightBookings);
    public void update(String flightName, String departure,String destination);
    public void delete(String flightName);
    public FlightBooking findByName(String flightName);
/*
    public void updateAll(String flightName, String departure);
*/

}
