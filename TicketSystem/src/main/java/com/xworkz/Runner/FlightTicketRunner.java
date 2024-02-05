package com.xworkz.Runner;

import com.xworkz.dto.FlightBooking;
import com.xworkz.repository.FlightTicketBookingRepositoryImpl;
import com.xworkz.repository.FlightTicketRepository;
import com.xworkz.service.FlightBookingService;
import com.xworkz.service.FlightBookingServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class FlightTicketRunner {
    public static void main(String[] args) {
/*
        FlightTicketRepository flightTicketRepository=new FlightTicketBookingRepositoryImpl();
*/
        FlightBooking flightBooking=new FlightBooking("air india","KIA","Goa",5000);
        FlightBooking flightBooking1=new FlightBooking("air asia","KIA","dehli",1000);
        FlightBooking flightBooking2=new FlightBooking("indigo","KIA","chennai",6000);
        FlightBooking flightBooking3=new FlightBooking("Qatar","KIA","doha",25000);
/*
        flightTicketRepository.flightTicketBookingDetails(flightBooking1);

*/
        FlightBookingService flightBookingService=new FlightBookingServiceImpl();
        /*flightBookingService.save(flightBooking);*/
       /* flightBookingService.save(flightBooking1);*/
        List<FlightBooking> list=new ArrayList<>();

        list.add(flightBooking2);
        list.add(flightBooking3);
//        flightBookingService.saveAll(list);

/*flightBookingService.delete("air  india");*/
        FlightBooking flightBooking4=flightBookingService.findByName("indigo");
        if(flightBooking4==null){
            System.out.println("please enter valid name");
        }
        else {
            System.out.println(flightBooking4.getFlightName());
        }
    }
}
