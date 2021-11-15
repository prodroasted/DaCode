package storage;

import application.model.Deltager;
import application.model.Hotel;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Deltager> deltagers = new ArrayList<>();
    private static ArrayList<Hotel> hotels = new ArrayList<>();


    //--------------------------------------------------------------------------------------------

    public static ArrayList<Deltager> getDeltagers(){return new ArrayList<Deltager>(deltagers);}

    public static void addDeltager(Deltager deltager){deltagers.add(deltager);}

    public static void removeDeltager(Deltager deltager){deltagers.remove(deltager);}

    //--------------------------------------------------------------------------------------------

    public static ArrayList<Hotel> getHotels(){return new ArrayList<Hotel>(hotels);}

    public static void addHotel(Hotel hotel){hotels.add(hotel);}

    public static void removeHotel(Hotel hotel){hotels.remove(hotel);}
}
