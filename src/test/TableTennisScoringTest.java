package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import main.TableTennisScoring;

class TableTennisScoringTest {

	@Test
	void testStartPlay() {
		fail("Not yet implemented");
	}

	@Test
	void testCheckWhoWins() {
		fail("Not yet implemented");
	}

	@Test
	void testTossForEven() {
		
		boolean res = TableTennisScoring.toss(4444);
		assertEquals(res, true);
	}
	
	@Test
	void testTossForOdd() {
		boolean res = TableTennisScoring.toss(5555);
		assertEquals(res, false);
	}

}
