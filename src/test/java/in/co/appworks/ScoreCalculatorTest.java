package in.co.appworks;

import static org.junit.Assert.*;

import org.junit.Test;

import cucumber.api.java.Before;

public class ScoreCalculatorTest {

	@Test
	public void testThatAGameWithAll1PinsScores20() throws Exception {
		int totalScore = calculateScore(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1 });

		assertEquals(20, totalScore);

	}

	@Test
	public void testThatAGameWithAll2PinsScores40() throws Exception {
		int totalScore = calculateScore(new int[] { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
				2, 2, 2, 2, 2, 2, 2 });

		assertEquals(40, totalScore);
	}
	
	@Test
	public void testThatAGameWith1SpareReturnCorrectScore() throws Exception {
		int totalScore = calculateScore(new int[] { 5,5, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
				2, 2, 2, 2, 2, 2, 2 });

		assertEquals(48, totalScore);
	}
	
	@Test
	public void testThatAGameWith2SparesReturnCorrectScore() throws Exception {
		int totalScore = calculateScore(new int[] { 6,4, 8, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
				2, 2, 2, 2, 2, 2, 2 });

		assertEquals(62, totalScore);
	}
	
	@Test
	public void testThatAGameWith1StrikeReturnCorrectScore() throws Exception {
		int totalScore = calculateScore(new int[] { 10, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
				2, 2, 2, 2, 2, 2, 2 });

		assertEquals(50, totalScore);
	}
	

	private int calculateScore(int[] rolls) {
		ScoreCalculator scoreCalculator = new ScoreCalculator();

		scoreCalculator.load(rolls);

		int totalScore = scoreCalculator.calculate();
		return totalScore;
	}
}
