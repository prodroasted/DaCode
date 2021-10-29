package Hjælp;

import java.util.Scanner;

public class PlayPairOfDice {
    private Scanner scan;
    private PairOfDices terninger;
    private boolean finished;


    public PlayPairOfDice() {
        terninger = new PairOfDices();
        scan = new Scanner(System.in);
    }

    public void startGame() {
        welcomeToGame();

        System.out.println("Do you want to begin? type START GAME");
        if (scan.nextLine().equalsIgnoreCase("START GAME"))
            finished = false;

        while (!finished) {
            System.out.println("Throw Dice: YES/NO");
            String answer = scan.nextLine();
            if (answer.equalsIgnoreCase("no"))
            {
                gameOver();
            }
        else if (answer.equalsIgnoreCase("yes")) {
                taketurn();
            } else {
                System.out.println("GIVE A VALID ANSWER!");
            }
        }

    }

    private void welcomeToGame() {
        System.out.println("Welcome to Our brand NEW addicting Dice Game");
    }

    public void gameOver(){
        System.out.println("GAME OVER!");
        System.out.println("RESETTING!..");
        System.out.println("Type EXIT TO LEAVE GAME");
        terninger.resetPairOfDice();
        finished = true;
        startGame();
    }

    private void taketurn(){
        terninger.RollBothDices();
        System.out.println("ROLLS " + terninger.getRolls());
        System.out.println("ONE " + terninger.getOne());
        System.out.println("FIVE " + terninger.getFive());
        System.out.println("SIX " + terninger.getSix());
        System.out.println("SAME " + terninger.getSame());
        System.out.println("BIGGEST ROLE " + terninger.getBiggestRoll());
        System.out.println("\n");
        System.out.println("SUM OF DICE " + terninger.SumOfDices());
    }

}