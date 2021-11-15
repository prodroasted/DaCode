package application.model;

public class Destination {
    private String navn;
    private int pris;

    public Destination (String navn, int pris){
        this.navn = navn;
        this.pris = pris;
    }

    // Getter's and setter's

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }
}
