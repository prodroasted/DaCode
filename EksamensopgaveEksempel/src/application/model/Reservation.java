package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Reservation {
    private LocalDate start;
    private LocalDate slut;
    private ArrayList<Plads> pladser = new ArrayList<>();

    public Reservation(LocalDate start, LocalDate slut){
        this.start = start;
        this.slut = slut;
    }

    public LocalDate getSlut() {
        return slut;
    }

    public void setSlut(LocalDate slut) {
        this.slut = slut;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public ArrayList<Plads> getPladser() {
        return pladser;
    }

    public void addPlads (Plads plads){
        if (!pladser.contains(plads)){
            pladser.add(plads);
            plads.addReservation(this);
        }
    }

    public void removePlads (Plads plads){
        if (pladser.contains(plads)){
            pladser.remove(plads);
            plads.removeReservation(this);
        }
    }
}
