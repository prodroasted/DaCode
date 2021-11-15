package application.model;

import java.util.ArrayList;

public class Plads {
    private int nr;
    private Areal areal;
    private ArrayList<Reservation> reservations = new ArrayList<>();
    private static int standardTimePris = 50;

    public Plads(int nr){
        this.nr = nr;
    }

    public static int getStandardTimePris() {
        return standardTimePris;
    }

    public static void setStandardTimePris(int standardTimePris) {
        Plads.standardTimePris = standardTimePris;
    }

    public double pris(int timer){
        double pris = 0.00;
        if (areal == Areal.VIP){
            pris += getStandardTimePris() * 1.25;
            return pris;
        }
        else if (areal == Areal.BØRNE){
            pris += getStandardTimePris() * 1.20;
            return pris;
        }
        else if (areal == Areal.TURNERING){
            pris += getStandardTimePris() * 1.10;
            return pris;
        }
        return standardTimePris;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void addReservation (Reservation reservation){
        if(!reservations.contains(reservation)){
            reservations.add(reservation);
            reservation.addPlads(this);
        }
    }

    public void removeReservation (Reservation reservation){
        if (reservations.contains(reservation)){
            reservations.remove(reservation);
            reservation.removePlads(this);
        }
    }


}
