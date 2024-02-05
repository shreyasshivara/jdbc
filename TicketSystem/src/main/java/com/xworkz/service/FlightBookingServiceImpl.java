package com.xworkz.service;

import com.xworkz.dto.FlightBooking;
import com.xworkz.repository.FlightTicketBookingRepositoryImpl;
import com.xworkz.repository.FlightTicketRepository;

import java.util.List;

public class FlightBookingServiceImpl implements FlightBookingService {
    FlightTicketRepository flightTicketRepository = new FlightTicketBookingRepositoryImpl();

    @Override
    public void save(FlightBooking flightBooking) {
        if (flightBooking.getFlightName().isEmpty()) {
            System.out.println("please enter valid flight name");

        } else {
            flightTicketRepository.flightTicketBookingDetails(flightBooking);
        }


    }

    @Override
    public void saveAll(List<FlightBooking> flightBookings) {
        for (FlightBooking bookings : flightBookings
        ) {
            if (bookings.getFlightName().isEmpty()) {
                System.out.println("enter valid flight name");
            }
        }

        flightTicketRepository.saveAll(flightBookings)
        ;


    }

    @Override
    public void update(String flightName, String departure, String destination) {
        if (flightName == null || flightName.isEmpty()) {
            System.out.println("enter valid flight name");
        } else {
            flightTicketRepository.update(flightName, departure, destination);

        }

    }

    @Override
    public void delete(String flightName) {
        if (flightName == null || flightName.isEmpty()) {
            System.out.println("enter valid name");
        } else {
            flightTicketRepository.delete(flightName);
        }
    }

    @Override
    public FlightBooking findByName(String flightName) {

        if (flightName == null) {
            System.out.println("please enter valid name");
        } else {
            FlightBooking flightBooking = flightTicketRepository.findByName(flightName);
            return flightBooking;
        }
        return null;

    }

}
