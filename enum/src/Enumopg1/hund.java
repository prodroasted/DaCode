package Enumopg1;

import java.util.ArrayList;

enum Race{PUDDEL, BOKSER, TERRIER}

public class hund {
    private String navn;
    private boolean stamtavle;
    private int pris;
    private Race race;

    public hund (String navn, boolean stamtavle, int pris, Race race){
        this.navn = navn;
        this.stamtavle = stamtavle;
        this.pris = pris;
        this.race = race;

    }

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

    public void setStamtavle(boolean stamtavle) {
        this.stamtavle = stamtavle;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public static int samletPris(ArrayList<hund> hunde, Race race){
        int sum = 0;
        for (hund i : hunde){
            if (i.race == race){
                sum += i.pris;
            }
        }
        return sum;
    }
}
