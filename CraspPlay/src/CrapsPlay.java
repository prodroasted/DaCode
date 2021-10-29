import java.util.Scanner;

public class CrapsPlay {

    private Die Die1;
    private Die Die2;
    private int Rolls;
    private boolean Won;
    private int sum;
    Scanner Scan;
    private int savesum;


    public CrapsPlay() {
        Die1 = new Die();
        Die2 = new Die();
        Scan = new Scanner(System.in);
        sum = Die1.getFaceValue() + Die2.getFaceValue();
    }

    public CrapsPlay(int sides) {
        Die1 = new Die(sides);
        Die2 = new Die(sides);
    }

    public void WelcomeToTheGame() {
        System.out.println("Would you like to begin the game? YES/NO");
        if (Scan.nextLine().equalsIgnoreCase("Yes"));
        TakeTurn();
        Won = false;
    }

    public void GameOver() {
        if (Won == true) {
            System.out.println("Grats you´ve magically won Crasps");
        } else {
            System.out.println("You´ve lost one of the easiest games... Hah");
        }
        System.out.println("Type ´RESTART´ to try again");
        Scan.nextLine().equalsIgnoreCase("Restart");
        startGame();
    }

    public void startGame() {
        WelcomeToTheGame();
    }

    public void TakeTurn() {
        System.out.println("Throw Dice: YES/NO");
        if (Scan.nextLine().equalsIgnoreCase("Yes"));
        Die1.roll();
        Die2.roll();

        System.out.println(sum);

        if (sum == 7 || sum == 11) {
            GameOver();
        } else if (sum == 2 || sum == 3 || sum == 12) {
            Won = false;
            GameOver();
        } else if (sum == savesum) {
            TakeExtraTurn();
        }
    }

    public void TakeExtraTurn() {

        System.out.println("Throw the dice? YES/NO");
        if (Scan.nextLine().equalsIgnoreCase("Yes"))
            Die1.roll();
        Die2.roll();
        sum = Die1.getFaceValue() + Die2.getFaceValue();
        System.out.println("You need to hit: " + savesum);
        System.out.println("Current Hit: " + sum);
        System.out.println("\n");
        if (sum == 7) ;
        Won = false;
        GameOver();
    }
}