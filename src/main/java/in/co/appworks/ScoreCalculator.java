package in.co.appworks;

public class ScoreCalculator {

	int[] rolls;

	public void load(int[] rolls) {
		this.rolls = rolls;
	}

	public int calculate() {
		int score = 0;

		boolean wasSpare = false;
		boolean wasStrike = false;

		for (int i = 0; i < rolls.length; i += 2) {
			int thisFrame = getFrameScore(i);
			
			if (wasStrike) {
				score += thisFrame;
			} else {
				if (wasSpare) {
					score += rolls[i];
				}
			}

			score += thisFrame;

			if (isStrike(rolls[i])) {
				wasStrike = true;
				i -= 1;
				wasSpare = false;
			} else {
				wasStrike = false;
				wasSpare = isSpare(rolls[i], rolls[i + 1]);
			}
		}
		return score;
	}

	private int getFrameScore(int i) {
		return isStrike(rolls[i]) ? rolls[i] : rolls[i]
				+ rolls[i + 1];
	}

	private boolean isStrike(int thisFrame) {
		return thisFrame == 10;
	}

	private boolean isSpare(int rollOne, int rollTwo) {
		return (rollOne + rollTwo) == 10;
	}

}
