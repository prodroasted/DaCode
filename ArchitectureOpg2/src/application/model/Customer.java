package application.model;

public class Customer {
    private String navn;

    public Customer(String navn) {
        this.navn = navn;
    }

    @Override
    public String toString() {
        return navn;
    }

}
