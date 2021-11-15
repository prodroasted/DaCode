package application.model;

public class Hotel {
    private String navn;
    private double priser;
    private Tilmelding tilmelding;

    public Hotel (String navn, double priser){
        this.navn = navn;
        this.priser = priser;
    }

    // Getter's and setter's

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getPriser() {
        return priser;
    }

    public void setPriser(double priser) {
        this.priser = priser;
    }

    public String toString (){
        return "Hotel navn " + navn + " Pris pr. Nat " + priser;
    }

    // Link Attribut metoder til tilmelding


    public Tilmelding getTilmelding() {
        return tilmelding;
    }

    public void setTilmelding(Tilmelding tilmelding) {
        if (this.tilmelding != tilmelding) {
            this.tilmelding = tilmelding;
        }
    }
}
