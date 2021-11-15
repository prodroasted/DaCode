package application.model;

import java.time.LocalDate;

public class Konference {
    private String navn, lokation;
    private LocalDate startdato, slutdato;

    public Konference (String navn, String lokation, LocalDate startdato, LocalDate slutdato){
        this.navn = navn;
        this.lokation = lokation;
        this.startdato = startdato;
        this.slutdato = slutdato;
    }

    // Getter's and setter's

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getLokation() {
        return lokation;
    }

    public void setLokation(String lokation) {
        this.lokation = lokation;
    }

    public LocalDate getStartdato() {
        return startdato;
    }

    public void setStartdato(LocalDate startdato) {
        this.startdato = startdato;
    }

    public LocalDate getSlutdato() {
        return slutdato;
    }

    public void setSlutdato(LocalDate slutdato) {
        this.slutdato = slutdato;
    }
}
