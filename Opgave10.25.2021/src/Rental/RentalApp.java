package Rental;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.temporal.TemporalAmount;

public class RentalApp {

    public static void main(String[] args) {
        LocalDate rental1startdato = LocalDate.of(2021, 11, 1);
        LocalDate rental2startdato = LocalDate.of(2022, 8, 25);
        Rental s = new Rental(10, 24, 50,rental1startdato);
        Rental b = new Rental(11, 12, 50, rental2startdato);

        System.out.println("Vehicle trip one:");

        System.out.println("*****************************");
        System.out.println("The price for the vehicle is " + s.getPricePrDay() + " a day");
        System.out.println("The total price is " + s.getDays() * s.getPricePrDay() + " For the designated trip");
        System.out.println("The enddate for your trip will be " + s.getEnddate());
        System.out.println("We will notify you one day ahead of the trip, which would be " + (rental1startdato.minusDays(1)));
        System.out.println("*****************************");

        System.out.println("Vehicle trip two");

        System.out.println("*****************************");
        System.out.println("The price for the vehicle is " + b.getPricePrDay() + " a day");
        System.out.println("The total price is " + b.getDays() * b.getPricePrDay() + " For the designated trip");
        System.out.println("The enddate for your trip will be " + b.getEnddate());
        System.out.println("We will notify you one day ahead of the trip, which would be " + (rental2startdato.minusDays(1)));
        System.out.println("*****************************");

        System.out.println("*****************************");
        System.out.println("Antallet af år, måneder og dage mellem den første og anden udlejning er " + rental2startdato.until(rental1startdato));
        System.out.println("*****************************");

    }
}
