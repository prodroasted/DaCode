package Hjælp;

/**
 * This class models one pair of dices.
 *
 */
public class PairOfDices {
	/**
	 * Constructor for objects of class PairOfDices
	 */
	// TODO: put the constructor here!
	public PairOfDices() {
		die1 = new Die();
		die2 = new Die();
	}

	public PairOfDices(int sides) {
		die1 = new Die(sides);
		die2 = new Die(sides);
	}

	public int SumOfDices() {
		return die1.getFaceValue() + die2.getFaceValue();
	}

	public void resetPairOfDice() {
		rolls = 0;
		six = 0;
		five = 0;
		one = 0;
		same = 0;
		biggestroll = 0;

	}

	/**
	 * The first die in the pair.
	 */
	private Die die1;
	/**
	 * The second die in the pair.
	 */
	private Die die2;

	private int rolls;
	private int six;
	private int five;
	private int one;
	private int same;
	private int biggestroll = 0;


	public int getBiggestRoll() {
		return biggestroll;
	}

	public int getRolls() {
		return rolls;
	}

	public int getSix() {
		return six;
	}

	public int getFive(){
		return five;
	}

	public int getOne(){
		return one;
	}

	public int getSame(){
		return same;
	}

	public void RollBothDices() {
		die1.roll();
		die2.roll();
		rolls++;

		if (die1.getFaceValue() == 6) {
			six++;
		} else if (die1.getFaceValue() == 5) {
			five++;
		} else if (die1.getFaceValue() == 1) {
			one++;
		}

		if (die2.getFaceValue() == 6) {
			six++;
		} else if (die2.getFaceValue() == 5) {
			five++;
		} else if (die2.getFaceValue() == 1) {
			one++;
		}

		if (die1.getFaceValue() == die2.getFaceValue()) {
			same++;
		}
		if (SumOfDices() >= biggestroll) {
			biggestroll = SumOfDices();
		}

	}
	public void PlayPairOfDice(){

	}
}