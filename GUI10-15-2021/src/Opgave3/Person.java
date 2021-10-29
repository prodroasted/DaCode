package Opgave3;

public class Person {
	private String firstName;
	private String titel;
	private boolean senior;


	public Person(String titel, String firstName, boolean senior) {
		this.firstName = firstName;
		this.titel = titel;
		this.senior = senior;
	}


	public String getFirstName() {
		return firstName;
	}

	public String getTitel() {
		return titel;
	}


	@Override
	public String toString() {
		String s = titel + " " + firstName;
		if (senior) s = s + " (Senior)";
		return  s;
	}

}
