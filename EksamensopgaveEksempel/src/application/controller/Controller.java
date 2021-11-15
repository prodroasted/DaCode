package application.controller;

import Storage.Storage;
import application.model.Arrangement;
import application.model.Plads;
import application.model.Reservation;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static ArrayList<Arrangement> getArrangement (){
        return Storage.getArrangements();
    }

    public static Arrangement createArrangement(String navn, boolean offentlig){
        Arrangement arrangement = new Arrangement(navn, offentlig);
        Storage.arrangements.add(arrangement);
        return arrangement;
    }

    public static ArrayList<Reservation> getReservation(){
        return Storage.getReservations();
    }

    public static Reservation createReservation(LocalDate start, LocalDate slut){
        Reservation reservation = new Reservation(start, slut);
        Storage.reservations.add(reservation);
        return  reservation;
    }

    public static ArrayList<Plads> getPladser (){
        return Storage.getPladser();
    }

    public static Plads createPlads(int nr){
        Plads plads = new Plads(nr);
        Storage.pladser.add(plads);
        return plads;
    }

    public static void initStorage(){

        Plads p1 = Controller.createPlads(1);
        Plads p2 = Controller.createPlads(2);
        Plads p3 = Controller.createPlads(3);
        Plads p4 = Controller.createPlads(4);
        Plads p5 = Controller.createPlads(5);
        Plads p6 = Controller.createPlads(6);

        Arrangement a1 = Controller.createArrangement("Dota 2 tournament", true);
        Arrangement a2 = Controller.createArrangement("CS-GO tournament", false);

        Reservation r1 = Controller.createReservation(LocalDate.of(2019, 8, 12), LocalDate.of(2019, 8, 12));
        Reservation r2 = Controller.createReservation(LocalDate.of(2019, 8, 13), LocalDate.of(2019, 8, 13));
        Reservation r3 = Controller.createReservation(LocalDate.of(2019, 8, 14), LocalDate.of(2019, 8, 14));
    }

    public static void init(){
        initStorage();
    }
}
