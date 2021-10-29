import java.util.Scanner;

public class Pig {

    private Die player1;
    private Die player2;
    private boolean finished;
    private Scanner scan;
    private int scorelimit;
    private int player1score;
    private int player2score;
    private int player;

    public Pig(int scorelimit) {
        player1 = new Die();
        player2 = new Die();
        scan = new Scanner(System.in);
        this.scorelimit = scorelimit;

    }

    public void welcomeToGame() {
        System.out.println("Welcome To Pig, Would you like to partake in some dice rolling?");
        System.out.println("\n");
        System.out.println("If so, type Yes to start and No to exit the game");
        if (scan.nextLine().equalsIgnoreCase("Yes")) {
            finished = false;
        } else {
            System.out.println("So you´re backing out of the game, that´s a shame");
            finished = true;
        }
    }

    public void gameover() {
        finished = true;
        System.out.println("Congratulations you´ve won the game");
        System.out.println("Player " + player + "Has reached over " + scorelimit + " Points!");
        System.out.println("\n");
        System.out.println("Type ´Restart´ to play again!");
        if (scan.nextLine().equalsIgnoreCase("restart")) ;
        finished = false;
        gamestart();
    }

    public void gamestart() {
        welcomeToGame();
        int temporaryScore1 = 0;
        int temporaryScore2 = 0;

        System.out.println("Player1 Starts, get ready!");
        player = 1;

        while (!finished) {
            if (player == 1) {
                System.out.println("Player 1 Type ´roll´ to begin and ´stop´ to end the turn");
                String answer = scan.nextLine();
                if (answer.equalsIgnoreCase("roll")) {
                    player1.roll();
                    if (player1.getFaceValue() != 1) {
                        System.out.println("current Roll: " + player1.getFaceValue());
                        temporaryScore1 += player1.getFaceValue();
                        System.out.println("temporary score: " + temporaryScore1);
                        if (temporaryScore1 + player1score >= this.scorelimit) {
                            gameover();
                        }
                    } else {
                        temporaryScore1 = 0;
                        player = 2;
                    }
                } else if (answer.equalsIgnoreCase("Stop")) {
                    player1score += temporaryScore1;
                    System.out.println("Player 1 ended with: " + player1score);
                    temporaryScore1 = 0;
                    player = 2;
                }
            }
                if (player == 2) {
                    System.out.println("Player 2 Type ´roll´ to begin and ´stop´ to end the turn");
                    String answer = scan.nextLine();
                    if (answer.equalsIgnoreCase("roll")) {
                        player2.roll();
                        if (player2.getFaceValue() != 1) {
                            System.out.println("Current roll: " + player2.getFaceValue());
                            temporaryScore2 += player2.getFaceValue();
                            System.out.println("Temporary Score: " + temporaryScore2);
                            if (temporaryScore2 + player2score >= this.scorelimit) {
                                gameover();
                            }
                        } else {
                            temporaryScore2 = 0;
                            player = 1;
                        }
                    } else if (answer.equalsIgnoreCase("Stop")) {
                        player2score += temporaryScore2;
                        System.out.println("Player 2 ended with " + player2score);
                        temporaryScore2 = 0;
                        player = 1;

                    }

                }
            }
        }
    }