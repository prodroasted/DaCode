package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class FlightTest {

    public static void main(String[] args) {
        Flight flight = new Flight("AY025", "Seoul");
        flight.createPassenger("Arnold", 31);
        flight.createPassenger("Bruce", 59);
        flight.createPassenger("Dolph", 24);
        flight.createPassenger("Linda", 59);
        flight.createPassenger("Jennifer", 65);

        System.out.println(flight.toString());
        System.out.println(flight.getDestination());
        System.out.println(flight.getFlightNumber());


        //Flight flight = new Flight("AY025", "Seoul");
        //flight.createPassenger("Arnold", 31);
        //flight.createPassenger("Bruce", 59);
        //flight.createPassenger("Dolph", 24);
        //flight.createPassenger("Linda", 59);
        //flight.createPassenger("Jennifer", 65);
    }

}

