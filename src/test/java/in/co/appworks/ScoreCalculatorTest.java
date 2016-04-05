package in.co.appworks;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreCalculatorTest {

	@Test
	public void testThatAGameWithAll1PinsScores20() throws Exception {
		ScoreCalculator scoreCalculator = new ScoreCalculator();

		scoreCalculator.load(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1 });
		
		int totalScore = scoreCalculator.calculate();
		
		assertEquals(20, totalScore);

	}
	
	@Test
	public void testThatAGameWithAll2PinsScores40() throws Exception {
		ScoreCalculator scoreCalculator = new ScoreCalculator();

		scoreCalculator.load(new int[] { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
				2, 2, 2, 2, 2, 2, 2 });
		
		int totalScore = scoreCalculator.calculate();
		
		assertEquals(40, totalScore);
	}
}
