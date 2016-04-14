package in.co.appworks;

public class ScoreCalculator {

	private static final int ADJUST_ROLL_INDEX_FOR_STRIKE = 1;
	private static final int MAX_FRAMES = 10;
	private static final int ALL_PINS = 10;
	int[] rolls;
	

	public void load(int[] rolls) {
		this.rolls = rolls;
	}

	public int calculate() {
		int score = 0;
		for (int rollIndex = 0, frame = 0; frame < MAX_FRAMES; rollIndex += 2, frame++) {
			int thisFrame = getFrameScore(rollIndex);

			score += thisFrame;

			if (isStrike(rollIndex)) {
				score += getStrikeBonus(rollIndex);
				rollIndex -= ADJUST_ROLL_INDEX_FOR_STRIKE;
			} else if (isSpare(rollIndex)) {
				score += getSpareBonus(rollIndex);
			}
		}
		return score;
	}

	private int getSpareBonus(int rollIndex) {
		return rolls[rollIndex + 2];
	}

	private int getStrikeBonus(int rollIndex) {
		return rolls[rollIndex + 1] + getSpareBonus(rollIndex);
	}

	private int getFrameScore(int rollIndex) {
		return isStrike(rollIndex) ? rolls[rollIndex] : rolls[rollIndex]
				+ rolls[rollIndex + 1];
	}

	private boolean isStrike(int rollIndex) {
		return rolls[rollIndex] == ALL_PINS;
	}

	private boolean isSpare(int rollIndex) {
		return (rolls[rollIndex] + rolls[rollIndex + 1]) == ALL_PINS;
	}

}
