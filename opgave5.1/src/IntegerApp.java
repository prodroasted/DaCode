import java.util.Scanner;

public class IntegerApp {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Write a Number");
        int tal = scan.nextInt();
        if (tal >0) {
            System.out.println("Positive");}

        else if (tal == 0) {
            System.out.println("Zero");}

        else {
            System.out.println("negative");
        }
        scan.close();

    }

}