package Car;

public class Car {
    private String License;
    private Double pricePerDay;
    private int purchaseYear;

    public Car (String license, int purchaseYear) {
        this.License = license;
        this.purchaseYear = purchaseYear;
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
