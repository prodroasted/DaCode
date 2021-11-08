package Car;

import java.util.ArrayList;

public class Car {
    private String License;
    private Double pricePerDay;
    private int purchaseYear;
    private ArrayList<Rental> rentals = new ArrayList<Rental>();

    public Car (String license, int purchaseYear) {
        this.License = license;
        this.purchaseYear = purchaseYear;
    }

    public void addRental (Rental rental){
        if(!rentals.contains(rental)){
            rentals.add(rental);
            rental.addCar(this);
        }
    }

    public void removeRental (Rental rental){
        if(rentals.contains(rental)){
            rentals.remove(rental);
            rental.addCar(this);
        }
    }

    public int maxDays (){
        int day = 0;
        for(int i = 0; i < rentals.size(); i++){
            if (day < rentals.get(i).getDays()){
                day = rentals.get(i).getDays();
            }
        }
        return day;
    }

    public void setPricePerDay (double price) {
        this.pricePerDay = price;
    }

    public Double getPricePerDay () {
        return pricePerDay;
    }

    public String getLicense () {
        return License;
    }

    public int getPurchaseYear() {
        return purchaseYear;
    }



}
