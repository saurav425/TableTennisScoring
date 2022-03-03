import java.util.Random;

public class TableTennisScoring {

	public static void main(String[] args) {
		
		int scoreP1=0 , scoreP2=0;
		boolean isPlayer1 = false;
		int countOfServe = 0;
		
		//use toss to start match
		int toss = toss();
		isPlayer1 = (toss == 0 ? true :false);
		boolean isRule10Active = false;
		String winner = null;
		
		// Break only when winner is decided
		while (true) {
			if(isPlayer1) {
				countOfServe++;
				scoreP1+=generateRandomNum()%2==0?1:0;
				
			}
			else {
				countOfServe++;
				scoreP2+=generateRandomNum()%2==1?1:0;
				
			}
			
			System.out.println("Current Score of P1 : "+scoreP1);
			System.out.println("Current Score of P2 : "+scoreP2);
			
			if(countOfServe == 2) {
				isPlayer1 = isPlayer1 == true ? false : true;
				countOfServe = 0;
			}
			
			if(scoreP1==10 && scoreP2==10)
				isRule10Active = true;
			else if(scoreP1 == 20 && scoreP2 == 20)
				isRule10Active = false;
			if(scoreP1 > 10 || scoreP2 >10) {
				winner = checkWhoWins(scoreP1,scoreP2,isRule10Active) ;
			}
			
			if(winner != null)
				break;
				
		}
		
		System.out.println("Congratulations !! Player :"+winner+" you have done it.");

	}
	
	//logic to decide who wins the match as per scoring rules
	private static String checkWhoWins(int scoreP1, int scoreP2,boolean isRule10Active) {
			
		if(isRule10Active) {
				if(Math.abs(scoreP2-scoreP1) >=2 )
					return (scoreP2>scoreP1 ? "P2" : "P1");
			}
		else if(Math.abs(scoreP2-scoreP1) >=1){
			return (scoreP2>scoreP1 ? "P2" : "P1");
		}
		return null;
	}

	//util function to generate Random integers
	public static int generateRandomNum() {
		Random rand = new Random();
		return rand.nextInt();
	}
	
	// Method for toss so as to decide which player starts serving first
	public static int toss() {
		Random rand = new Random();
		return rand.nextInt(2);
	}

	
}
