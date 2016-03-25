package in.co.appworks;

public class Game {

	private int score;

	public void roll(int rollScore) {
		score = score + rollScore;
	}

	public int getScore() {
		return score;
	}

}
