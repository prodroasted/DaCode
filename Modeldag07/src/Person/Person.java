package Person;

import java.time.LocalDate;
import java.time.Year;

/**
 * Write a description of class Person here.
 *
 * @author (Margrethe Dybdahl)
 * @version (16 / 09 / 2020)
 */
public class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private int dayOfBirth; // 1..31
    private int monthOfBirth; // 1..12
    private int yearOfBirth; // 1900..2010
    private String nomiddlename;

    /**
     * Constructor for objects of class Person
     */

    public Person(String firstName, String middleName, String lastName,
                  int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public Person(String firstName, String lastName,
                  int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.middleName = "";
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void printPerson() {
        System.out.println(firstName + " " + middleName + " " + lastName + " "
                + dayOfBirth + "." + monthOfBirth + "." + yearOfBirth);

    }

    public String getInit() {
        if (middleName.isEmpty()) {
            return "" + firstName.substring(0, 2) + lastName.charAt(0);
        }
        return "" + firstName.charAt(0) + middleName.charAt(0)
                + lastName.charAt(0);
    }

    public String getUserName() {

        if (middleName.isEmpty()) {
            return firstName.substring(0,2).toUpperCase() + (firstName.length()-lastName.length()) + lastName.substring( lastName.length() - 2);
        }

        String tekst1 = firstName.substring(0, 2).toUpperCase();
        String tekst2 = middleName.length() + "";
        String tekst3 = lastName.substring(lastName.length() - 2);

        return tekst1 + tekst2 + tekst3;

    }

    public int age(int dayToDay, int monthToDay, int yearToDay) {
        int age = yearToDay - yearOfBirth;
        if (dayToDay > 20 || monthOfBirth > 9) {
            return age - 1;
        } else {
            return age;
        }
    }

        // TODO make the code work

        public Boolean leapYear ( int year){
            boolean leapyear = false;
            if (year % 400 == 0) {
                leapyear = true;
            } else if (year % 4 == 0 && year % 100 != 0) {
                leapyear = true;
            } else {
                leapyear = false;
            }
            return leapyear;
        }
}