package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import main.TableTennisScoring;

class TableTennisScoringTest {

	@Test
	void testStartPlay() {
		//Assure that winner is always there
		String winner = TableTennisScoring.startPlay(true);
		assertNotEquals(winner,null);
		
	}

	@Test
	void testCheckWhoWins() {
		
		boolean isRule10Active = TableTennisScoring.isRule10Active(5, 6);
		//No one has won case
		String winner = TableTennisScoring.checkWhoWins(5, 6, isRule10Active);
		assertEquals(winner, null);
		
		//case when tie at 10
		isRule10Active = TableTennisScoring.isRule10Active(10, 10);
		winner = TableTennisScoring.checkWhoWins(10,11, isRule10Active);
		assertEquals(winner, null);
		
		isRule10Active = TableTennisScoring.isRule10Active(10, 12);
		winner = TableTennisScoring.checkWhoWins(10, 12, isRule10Active);
		assertEquals(winner, "P2");
		
			
		isRule10Active = TableTennisScoring.isRule10Active(17, 18);
		winner = TableTennisScoring.checkWhoWins(17, 18, isRule10Active);
		assertEquals(winner, null);
		
		isRule10Active = TableTennisScoring.isRule10Active(19, 17);
		winner = TableTennisScoring.checkWhoWins(19, 17, isRule10Active);
		assertEquals(winner, "P1");
		
		//tie at 20
		isRule10Active = TableTennisScoring.isRule10Active(21, 20);
		winner = TableTennisScoring.checkWhoWins(21,20, isRule10Active);
		assertEquals(winner, "P1");
		
		//No tie is there
		isRule10Active = TableTennisScoring.isRule10Active(11, 9);
		winner =TableTennisScoring.checkWhoWins(11, 9, isRule10Active);
		assertEquals(winner, "P1");
		
		isRule10Active = TableTennisScoring.isRule10Active(9, 11);
		winner = TableTennisScoring.checkWhoWins(9, 11, isRule10Active);
		assertEquals(winner, "P2");
		
	}

	@Test
	void testTossForEven() {
		
		boolean res = TableTennisScoring.toss(4444);
		assertEquals(res, true);
		res = TableTennisScoring.toss(5555);
		assertEquals(res, false);
		
	}
	
	@Test
	void testRule10Active() {
		boolean isRule10Active = TableTennisScoring.isRule10Active(10, 0);
		assertEquals(false,isRule10Active);
		
		isRule10Active = TableTennisScoring.isRule10Active(0, 10);
		assertEquals(false,isRule10Active);
		
		isRule10Active = TableTennisScoring.isRule10Active(10, 10);
		assertEquals(true,isRule10Active);
		
		isRule10Active = TableTennisScoring.isRule10Active(12, 11);
		assertEquals(true,isRule10Active);
		
		isRule10Active = TableTennisScoring.isRule10Active(20, 20);
		assertEquals(false,isRule10Active);
		
		isRule10Active = TableTennisScoring.isRule10Active(21, 20);
		assertEquals(false,isRule10Active);
		
		isRule10Active = TableTennisScoring.isRule10Active(20, 21);
		assertEquals(false,isRule10Active);	
		
	}
	
	

}
