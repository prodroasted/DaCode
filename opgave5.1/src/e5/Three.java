package e5;

import java.awt.desktop.SystemSleepEvent;
import java.util.Scanner;

public class Three {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Write three numbers");
        int tal = scan.nextInt();
        int tal1 = scan.nextInt();
        int tal2 = scan.nextInt();

        if (tal < tal1 && tal1 < tal2) { System.out.println("Increasing"); }

        else if (tal > tal1 && tal1 > tal2) { System.out.println("Decreasing"); }

        else { System.out.println("Neither"); }

    }
}
