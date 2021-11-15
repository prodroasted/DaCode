package application.model;

public class Udflugt {
    private String udflugtNavn;
    private double priser;
    private boolean frokost;

    public Udflugt (String udflugtNavn, double priser, boolean frokost){
        this.udflugtNavn = udflugtNavn;
        this.priser = priser;
        this.frokost = frokost;
    }

    // Getter's and setter's

    public void setPriser(double priser) {
        this.priser = priser;
    }

    public double getPriser() {
        return priser;
    }

    public void setUdflugtNavn(String udflugtNavn) {
        this.udflugtNavn = udflugtNavn;
    }

    public String getUdflugtNavn() {
        return udflugtNavn;
    }

    public void setFrokost(boolean frokost) {
        this.frokost = frokost;
    }
}
