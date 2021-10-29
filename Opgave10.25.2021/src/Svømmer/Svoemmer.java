package Svømmer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;

public class Svoemmer {
    private String navn;
    private String klub;
    private LocalDate foedselsdag;
    private ArrayList<Double> tider;

    public Svoemmer(String navn, String klub, LocalDate foedselsdag){
        this.navn = navn;
        this.klub = klub;
        LocalDate foesldag = LocalDate.of(1998, 11, 13);
        ArrayList<Double> tider = new ArrayList<>();
    }

    public void udskrivtider(){}

    public String getNavn() {
        return navn;
    }

    public LocalDate getFoedselsdag() {
        return foedselsdag;
    }

    public String getKlub() {
        return klub;
    }
}
