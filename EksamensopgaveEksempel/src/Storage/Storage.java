package Storage;

import java.util.ArrayList;
import application.model.Arrangement;
import application.model.Reservation;
import application.model.Plads;

public class Storage {

    public static ArrayList<Arrangement> arrangements = new ArrayList<>();
    public static ArrayList<Reservation> reservations = new ArrayList<>();
    public static ArrayList<Plads> pladser = new ArrayList<>();

    public static ArrayList<Plads> getPladser() {
        return pladser;
    }

    public static ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public static ArrayList<Arrangement> getArrangements() {
        return arrangements;
    }
}
