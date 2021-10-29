package opgave2.child.child;

/**
 * Write a description of class Barn here.
 */
public class Child {
	private int age;
	private boolean boy; // true if the child is a boy

	public Child(int age, boolean boy) {
		this.age = age;
		this.boy = boy;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBoy() {
		return boy;
	}

	public void setBoy(boolean boy) {
		this.boy = boy;
	}

	public String institution() {
		String result = "";
		if (age == 0) {
			result = "Home";
		} else if (age >= 1) {
			result = "Nusery";
		} else if (age >= 3) {
			result = "Kindergarden";
		} else if (age >= 5) {
			result = "School";
		} else {
			result = "out of school";
		}
		return result;
	}

}
