package Opgave1;

import java.util.ArrayList;

public class ArrayListApp {
    public static void main(String[] args) {

        ArrayList<String> list;
        list = new ArrayList<>();

        list.add("Hans");
        list.add("Viggo");
        list.add("Jens");
        list.add("Børge");
        list.add("Bent");


        int size = list.size();
        System.out.println("Der er " + size + " Elementer i denne liste");

        list.add("ib");
        list.add(2,"jane");
        list.remove(1);

        list.set(0, "Pia");
        list.remove(2);
        list.add(2,"Hansi");

        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for (String s : list) {
            System.out.println(s);
        }

    }
}
