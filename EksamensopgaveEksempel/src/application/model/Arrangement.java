package application.model;

import java.util.ArrayList;

public class Arrangement {
    private String navn;
    private boolean offentlig;
    private ArrayList<Reservation> reservations = new ArrayList<>();

    public Arrangement(String navn, boolean offentlig){
        this.navn = navn;
        this.offentlig = offentlig;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setOffentlig(boolean offentlig) {
        this.offentlig = offentlig;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void addReservation (Reservation reservation){
        if(!reservations.contains(reservation)){
            addReservation(reservation);
        }
    }

    public void removeReservation (Reservation reservation){
        if (reservations.contains(reservation)){
            removeReservation(reservation);
        }
    }

    public int antalReserveredePladser(ArrayList<Reservation> reservations){
        int a = 0;
        for (Reservation i : reservations){
            a += i.getPladser().size();
        }
        return a;
    }
}
