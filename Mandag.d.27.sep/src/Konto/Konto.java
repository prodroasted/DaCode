package Konto;

import java.util.Set;

public class Konto {
    private int nr;
    private int saldo;
    private String kontotype;
    private String status;
    private double indsætbeløb;


    public Konto (int nr, String kontotype, double beløb) {
        this.nr = nr;
        this.saldo = 0;
        this.kontotype = kontotype;
        this.status = "åben";
        this.indsætbeløb = indsætbeløb;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;

    }

    public int getSaldo () {
        return saldo;
    }

    public void setIndsætbeløb(double indsætbeløb) {
        this.indsætbeløb = indsætbeløb;
        if (status == "lukket");
        System.out.println("Kontoen er lukket.");
    }

    public double getIndsætbeløb() {
        return indsætbeløb;
    }

     public void setNr (int nr) {
        this.nr = nr;
     }

     public int getNr() {
        return nr;
     }

     public void setKontotype(String kontotype) {
        this.kontotype = kontotype;
     }

     public String getKontotype() {
        return kontotype;
     }

}
