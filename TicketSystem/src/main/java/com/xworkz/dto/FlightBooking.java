package com.xworkz.dto;

import lombok.*;

@Getter
@ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightBooking {

    private String flightName;
    private String departure;
    private String destination;
    private int price;

}
