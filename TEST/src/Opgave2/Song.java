package Opgave2;

public class Song {
    private String titel;
    private String artist;
    private int bpm;

    public Song (String artist, String titel, int bpm){
     this.titel = titel;
     this.artist = artist;
     this.bpm = bpm;

    }

    public String getTitel(){
        return titel;
    }

    public String getArtist(){
        return artist;
    }

    public int getBpm(){
        return bpm;
    }

    public void printSong(){
        System.out.println("*****************");
        System.out.println("Titel " + titel);
        System.out.println("Kunstner " + artist);
        System.out.println("Hastighed " + bpm);
        System.out.println("*****************");
    }

}
