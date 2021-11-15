package Enumopg1;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        hund et = new hund("Diezel", true, 2000, Race.BOKSER);
        hund to = new hund("Teffi", false, 500, Race.PUDDEL);
        hund tre = new hund("Pesto", true, 3000, Race.TERRIER);
        hund fire = new hund("Denzo", false, 500, Race.BOKSER);
        hund fem = new hund("Per", false, 300, Race.PUDDEL);

        ArrayList<hund> hunde = new ArrayList<>();
        hunde.add(et);
        hunde.add(to);
        hunde.add(tre);
        hunde.add(fire);
        hunde.add(fem);

        System.out.println(hund.samletPris(hunde, Race.BOKSER));
    }
}
