package Opgave1;

public class Bankkonto {
    private double balance;
    private int accountid;
    private static int id = 1000;


    /**
     *
     * @param initialBalace
     */
    public Bankkonto(double initialBalace){
        balance = initialBalace;

        Bankkonto.id++;
        accountid = Bankkonto.id;
    }

    /**
     * Amount skal være størrer end 0.
     * @param amount
     */
    public void deposit(double amount) {
        balance += amount;
    }

    public int getId(){
        return id;
    }

    /**
     *Amount skal være størrer end 0.
     * @param amount
     */
    public void withdraw(double amount){
        balance -= amount;
    }

    /**
     *
     * @return
     */
    public double getBalance(){
        return balance;
    }
}
