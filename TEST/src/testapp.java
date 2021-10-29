import java.util.ArrayList;
import java.util.Arrays;

public class testapp {
    //Opgave 1.1
    public static void main(String[] args) {
        ArrayList<String> list;
        list = new ArrayList<>();

        list.add("Pax");
        list.add("Fido");
        list.add("Molly");
        list.add("Pluto");
        list.add("Juno");
        //Opgave 1.2
        System.out.println(list);
        //Opgave 1.3
        System.out.println("******************");
        list.set(2, "King");
        System.out.println(list);
        //Opgave 1.4
        System.out.println("******************");
        list.remove(0);
        System.out.println(list);
        //Opgave 1.5
        System.out.println("******************");
        list.add(3,"Trine");
        System.out.println(list);
        //Opgave 1.6
        System.out.println("******************");
        list.add(0, "Bella");
        System.out.println(list);
        //Opgave 1.7
        System.out.println("******************");
        System.out.println("På nuværende tidspunkt er der " + list.size() + " Elementer i listen");
        //Opgave 1.8
        System.out.println("******************");

        for(int i = 0; i < list.size(); i++){
            {

            }
        }
        //Opgave 1.9
        System.out.println("******************");
        for (int i = 0; i < list.size(); i++){

        }

        //Opgave 1.10

    }
}
