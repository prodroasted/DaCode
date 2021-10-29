package Rental;

import java.awt.print.PrinterException;
import java.time.LocalDate;

public class Rental {

    int number;
    int days;
    LocalDate startdate;
    double price;



    public Rental(int number, int days, double price, LocalDate startdate) {
        this.price = price;
        this.number = number;
        this.days = days;
        this.startdate = startdate;

    }

    public double getPricePrDay(){
        return price;
    }

    public void setDays(int days){
        this.days = days;
    }

    public int getDays(){
        return days;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public LocalDate getEnddate(){
    return startdate.plusDays(days);
    }

}
