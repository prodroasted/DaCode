package application.model;

public class Ledsager {
    private String navn;
    private int ledsagerNummer;

    public Ledsager (String navn, int ledsagerNummer){
        this.navn = navn;
        this.ledsagerNummer = ledsagerNummer;
    }

    // Getter's and setter's

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getLedsagerNummer() {
        return ledsagerNummer;
    }

    public void setLedsagerNummer(int ledsagerNummer) {
        this.ledsagerNummer = ledsagerNummer;
    }
}
