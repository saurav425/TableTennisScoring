package main;
import java.util.Random;

public class TableTennisScoring {

	public static boolean isRule10Active = false;
	
	public static void main(String[] args) {
		
		
		boolean isPlayer1 = false;
	
		//use toss to start match
		//true if player
		isPlayer1 = toss(generateRandomNum());
		
		String winner = startPlay(isPlayer1);
		
		System.out.println("Congratulations !! Player :"+winner+" you have done it.");

	}
	
	/**
	 * Driver function to start match and keep playing
	 * 
	 * @param isPlayer1 
	 * @return winner name
	 */
	public static String startPlay(boolean isPlayer1) {
		
		int scoreP1=0 , scoreP2=0;
		boolean isRule10Active = false;
		int countOfServe = 0;
		String winner = null;
		
		// Break only when winner is decided
				while (true) {
					
					if(isPlayer1) {
						countOfServe++;
					}
					else {
						countOfServe++;
					}
					
					if(generateRandomNum()%2==0)
						scoreP1++;
					else
						scoreP2++;
					
					System.out.println("Current Score of P1 : "+scoreP1);
					System.out.println("Current Score of P2 : "+scoreP2);
					
					if(countOfServe == 2) {
						isPlayer1 = isPlayer1 == true ? false : true;
						countOfServe = 0;
					}
						
					
					if(scoreP1 > 10 || scoreP2 >10) {
						isRule10Active = isRule10Active(scoreP1, scoreP2);
						winner = checkWhoWins(scoreP1,scoreP2,isRule10Active) ;
					}
					
					if(winner != null)
						break;	
				}
				return winner;
				
	}

	/**
	 * Function useful when tie is there at score 10 or 20
	 * 
	 * @param scoreP1
	 * @param scoreP2
	 * @param isRule10Active
	 * @return true if difference of 2 is required for winning
	 */
	public static boolean isRule10Active(int scoreP1, int scoreP2) {
		if((scoreP1==10 && scoreP2==10) || (isRule10Active && scoreP1 < 20 && scoreP2 < 20)) {
			isRule10Active = true;
			return isRule10Active;
		}		
		else if(scoreP1 == 20 && scoreP2 == 20) {
			isRule10Active = false;
			return isRule10Active;
		}
		return false;
	}

	/**
	 * logic to decide who wins the match as per scoring rules
	 * 
	 * @param scoreP1 
	 * @param scoreP2
	 * @param isRule10Active
	 * @return
	 */
	public static String checkWhoWins(int scoreP1, int scoreP2,boolean isRule10Active) {
		String winner = null;
			
		if (scoreP1 > 10 || scoreP2 > 10) {
			if (isRule10Active) {
				if (Math.abs(scoreP2 - scoreP1) >= 2) {
					winner = (scoreP2 > scoreP1 ? "P2" : "P1");
				}
			} else if (Math.abs(scoreP2 - scoreP1) >= 1) {
				winner = (scoreP2 > scoreP1 ? "P2" : "P1");
			} 
		}
		return winner;
	}

	//Util function to generate Random integers
	private static int generateRandomNum() {
		Random rand = new Random();
		return rand.nextInt();
	}
	
	// Method for toss so as to decide which player starts serving first
	public static boolean toss(int randNum) {
		return (randNum % 2 == 0 ? true :false);
	}

	
}
