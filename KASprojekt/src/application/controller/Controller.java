package application.controller;

import application.model.Deltager;
import application.model.Hotel;
import storage.Storage;

import java.util.ArrayList;

public class Controller {

    public static Hotel createHotel(String navn, double pris){
        Hotel hotel = new Hotel(navn, pris);
        Storage.addHotel(hotel);
        return hotel;
    }

    public static void deleteHotel (Hotel hotel){Storage.removeHotel(hotel);}

    public static ArrayList<Hotel> getHotels(){return Storage.getHotels();}

    public static Deltager createDeltager(String navn, String adresse, String by, String land, String firmaNavn, int mobilnr){
        Deltager deltager = new Deltager(navn, adresse, by, land, firmaNavn, mobilnr);
        Storage.addDeltager(deltager);
        return deltager;
    }

    public static void deleteDeltager (Deltager deltager){Storage.removeDeltager(deltager);}

    public static ArrayList<Deltager> getDeltager(){return Storage.getDeltagers();}

    public static void updateDeltager (Deltager deltager, String navn, String adresse, String by, String land, String firmaNavn, int mobilnr){
        deltager.setNavn(navn);
        deltager.setAdresse(adresse);
        deltager.setBy(by);
        deltager.setLand(land);
        deltager.setFirmaNavn(firmaNavn);
        deltager.setMobilnr(mobilnr);
    }

    public static void initStorage(){
        Hotel c1 = Controller.createHotel("Destiny", 399.99);
        Hotel c2 = Controller.createHotel("Dream Palace", 500.00);
    }

    public static void init(){
        initStorage();
    }
}
