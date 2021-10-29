package Person;

public class PersonApp {

    public static void main(String[] args) {
        Person p = new Person("Bent", "Janus", "Christensen", 27, 12, 1995);
        p.printPerson();
        System.out.println("Initialer: " + p.getInit());
        System.out.println("Username: " + p.getUserName());

        System.out.println("Age: " + p.age(20, 9, 2021)); // p's age today
        int year = 2021;
        System.out.println("Er " + year + " skudår: " + p.leapYear(year));

        Person p1 = new Person("kate", "Thomson", 15, 11, 1998);
        p1.printPerson();
        System.out.println("Initialer: " + p1.getInit());
        System.out.println("Username: " + p1.getUserName());

    }

}
