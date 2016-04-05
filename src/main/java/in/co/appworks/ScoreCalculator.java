package in.co.appworks;

public class ScoreCalculator {

	int[] rolls;

	public void load(int[] rolls) {
		this.rolls = rolls;
	}

	public int calculate() {
		int score = 0;

		for (int i = 0; i < rolls.length; i++) {  
			score += rolls[i];
		}
		return score;
	}

}
