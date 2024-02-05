package com.xworkz.service;

import com.xworkz.dto.FlightBooking;

import java.util.List;

public interface FlightBookingService {
    public void save(FlightBooking flightBooking);
    public void saveAll(List<FlightBooking> flightBookings);
    public void update(String flightName, String departure,String destination);
    public void delete(String flightName);
    public FlightBooking findByName(String flightName);

}
