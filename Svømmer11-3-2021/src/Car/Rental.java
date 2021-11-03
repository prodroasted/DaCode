package Car;

public class Rental {
    private int number;
    private int days;
    private String date;

    public Rental (int number, int days, String date) {
        this.number = number;
        this.days = days;
        this.date = date;


    }

    public void setDays (int days) {
        this.days = days;
    }

    public int getDays () {
        return days;
    }


}
