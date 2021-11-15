package application.model;

enum Deltagertype {PENTIONIST, STUDERENDE, ARBEJDSLØS, FIRMA}

public class Deltager {
    private String navn, adresse, by, land, firmaNavn;
    private int mobilnr;
    private Deltagertype deltagertype;

    public Deltager (String navn, String adresse, String by, String land, String firmaNavn, int mobilnr){
        this.navn = navn;
        this.adresse = adresse;
        this.by = by;
        this.land = land;
        this.firmaNavn = firmaNavn;
        this.mobilnr = mobilnr;
    }

    // Getter's and setter's

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getFirmaNavn() {
        return firmaNavn;
    }

    public void setFirmaNavn(String firmaNavn) {
        this.firmaNavn = firmaNavn;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public int getMobilnr() {
        return mobilnr;
    }

    public void setMobilnr(int mobilnr) {
        this.mobilnr = mobilnr;
    }

    public String toString (){
        return navn + adresse +  by + land + firmaNavn + mobilnr;
    }
}
