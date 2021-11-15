package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tilmelding {
    private boolean foredragsholder, hotel, udflugt;
    private LocalDate ankomstdato, afrejsedato;
    private ArrayList<Deltager> deltagers = new ArrayList<>();
    private ArrayList<Hotel> hotels = new ArrayList<>();

    public Tilmelding (boolean foredragsholder, boolean hotel, boolean udflugt, LocalDate ankomstdato, LocalDate afrejsedato){
        this.foredragsholder = foredragsholder;
        this.hotel = hotel;
        this.udflugt = udflugt;
        this.ankomstdato = ankomstdato;
        this.afrejsedato = afrejsedato;
    }

    // Getter's and setter's
    public LocalDate getAfrejsedato() {
        return afrejsedato;
    }

    public void setAfrejsedato(LocalDate afrejsedato) {
        this.afrejsedato = afrejsedato;
    }

    public LocalDate getAnkomstdato() {
        return ankomstdato;
    }

    public void setAnkomstdato(LocalDate ankomstdato) {
        this.ankomstdato = ankomstdato;
    }

    public void setForedragsholder(boolean foredragsholder) {
        this.foredragsholder = foredragsholder;
    }

    public void setHotel(boolean hotel) {
        this.hotel = hotel;
    }

    public void setUdflugt(boolean udflugt) {
        this.udflugt = udflugt;
    }

    // Arraylist methods connected to Deltager, aka Tilmeldinger

    public ArrayList<Deltager> getDeltagers() {
        return deltagers;
    }

    public void addDeltager (Deltager deltager){
        if(!deltagers.contains(deltager)){
            addDeltager(deltager);
        }
    }

    public void removeDeltager (Deltager deltager){
        if (deltagers.contains(deltager)){
            removeDeltager(deltager);
        }
    }

    // Arralist methods connected to Hotels

    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public void addHotel (Hotel hotel){
        if (!hotels.contains(hotel)){
            addHotel(hotel);
        }
    }

    public void removeHotel (Hotel hotel){
        if (hotels.contains(hotel)){
            removeHotel(hotel);
        }
    }

    public int samletSum (Hotel hotel){
        int sum = 0;
        sum += hotel.getPriser();
        return sum;
    }
}
