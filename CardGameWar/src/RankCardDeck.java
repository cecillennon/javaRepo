
import java.util.*;

public class RankCardDeck {
	
	private static final int numCards = 52;
	
	protected int[] carddeck = new int [numCards];
	protected int curCardPos = 0;  //position of next card to be dealt
	
	protected Random rand = new Random();  //to generate random numbers
	
	public RankCardDeck(){
		for(int i = 0; i < numCards; i++)
			carddeck[i] = i / 4;  //there are 4 cards of each rank
	}
	
	public void shuffle(){
		//randomizes order of the cards in the deck and resets
		//the position of the current card to 0
		
		int randLoc;  //random location in card deck
		int temp;  //for swap of cards
		for(int i = (numCards - 1); i > 0; i--){
			randLoc = rand.nextInt(i);  //random integer between 0 and i-1
			temp = carddeck[randLoc];
			carddeck[randLoc] = carddeck[i];
			carddeck[i] = temp;
		}
		curCardPos = 0;
	}
	
	public boolean hasMoreCards(){
		//return true id there are still cards left to be dealt
		//otherwise returns false
		return(curCardPos != numCards);
	}
	
	public int nextCard(){
		//precondition curCardPos != numCards
		//
		//models is a card being dealt by returning an integer representing
		
		curCardPos = curCardPos + 1;
		return(carddeck[curCardPos - 1]);
	}

}
