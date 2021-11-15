package application.model;

enum Areal{STANDARD, VIP, BØRNE, TURNERING}

public class Omraade {
    private Areal areal;

    public Omraade(Areal areal){
        this.areal = areal;
    }
}
