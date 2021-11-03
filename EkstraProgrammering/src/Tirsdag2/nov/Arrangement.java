package Tirsdag2.nov;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Arrangement {

    private String navn;
    private boolean offentlig;
    private int pris;
    private int maxAntal;
    private ArrayList<String> deltager;

    public Arrangement(String navn, boolean offentlig, int pris, int maxAntal) {
        this.navn = navn;
        this.offentlig = offentlig;
        this.pris = pris;
        this.maxAntal = 45;


    }

    public String getNavn() {
        return navn;
    }

    public boolean isOffentlig() {
        return offentlig;
    }

    public int getPris() {
        return pris;
    }

    public int getMaxAntal() {
        return maxAntal;
    }

    public boolean addDeltager(String navn) {
        if (deltager.size() < 45) {
            offentlig = true;
            addDeltager(this.navn);
            return offentlig;
        } else if (deltager.size() == 45) {
            offentlig = false;
        }
        return offentlig;
    }


    public String toString() {
        String s = ("Arrangementets navn: " + navn + '\n' + "Er det offentligt: " + offentlig + "Arrangementets Pris: " + pris + "Arrangementets antal pladser: " + maxAntal);
        return s;
    }
}
