import java.util.Scanner;

public class WarGameApp {
	
	public static void main(String[] args){
		
		Scanner conIn = new Scanner(System.in);
		WarGame game;
		
		int numGames;  //number of games to simulate
		int maxNumBattles;  //max number battles allowed per game
		
		int numDiscont = 0;  //number of discontinued games
		int numCompleted = 0;  //number of completed games
		int totBattles = 0;  //number of total battles in completed games
		
		System.out.println("How many games o you want to play? ");
		numGames = conIn.nextInt();
		
		System.out.println("What is the max number of battles per game? ");
		maxNumBattles = conIn.nextInt();
		
		game = new WarGame(maxNumBattles);
		
		for(int i = 0; i < numGames; i++){
			if(game.play()){
				numCompleted = numCompleted + 1;
				totBattles = totBattles + game.getNumBattles();
			}
			else
				numDiscont = numDiscont + 1;
			}
		
		//output results
		System.out.println("Number of Games simulated: " + numGames);
		System.out.println("Number of Discontinued Games: " + numDiscont);
		System.out.println("Number of Completed Games: " + numCompleted);
		System.out.println();
		
		if(numCompleted > 0){
			System.out.println("In the completed games");
			System.out.println(" Total Number of Battles " +totBattles);
			System.out.println(" Average Number of Battles " + totBattles / numCompleted);
		}
		
		System.out.println("\nProgram completed.");
		
		}
		
	}
	



