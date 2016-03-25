package in.co.appworks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GameTest {

	@Test
	public void testThatScoreWillBeZeroWhenAllBallsGoInGutter()
			throws Exception {
		int rollScore = 0;
		Game game = initializeGameWithConstantRollScore(rollScore);

		assertEquals(0, game.getScore());
	}

	private Game initializeGameWithConstantRollScore(int rollScore) {
		Game game = new Game();
		for (int i = 0; i < 20; i++) {
			game.roll(rollScore);
		}
		return game;
	}

	@Test
	public void testThatScoreWillBe20IfOnePinIsKnockedOutInEachRoll()
			throws Exception {
		int rollScore = 1;
		Game game = initializeGameWithConstantRollScore(rollScore);
		assertEquals(20, game.getScore());
	}

	@Test
	public void testThatScoreWillBe80IfFourPinsAreKnockedOutInEachRoll()
			throws Exception {

		int rollScore = 4;
		Game game = initializeGameWithConstantRollScore(rollScore);
		assertEquals(80, game.getScore());
	}

	@Test
	public void testThatScoreWilleBeSumOfVariableRollScoresWhenRollScoreIsLessThanFive()
			throws Exception {
		int[] rollScoreArray = { 0, 1, 2, 3, 4, 0, 1, 2, 3, 4, 0, 1, 2, 3, 4,
				0, 1, 2, 3, 4 };
		Game game = new Game();
		for (int i = 0; i < rollScoreArray.length; i++) {
			game.roll(rollScoreArray[i]);
		}
		assertEquals(40, game.getScore());
	}

}
