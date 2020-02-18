
import queues.*;

public class WarGame {
	
	BoundedQueueInterface<Integer> player1;  //player1's hand
	BoundedQueueInterface<Integer> player2;  //player2's hand
	
	int maxNumBattles;  //max number of batles allowed before game is discontinued
	int numBattles;  //number of battles played in current game
	RankCardDeck deck;  //deck of cards
	
	BoundedQueueInterface<Integer> prize;  //cards for current battle
	
	static final int numCards = 52;  //number of cards in deck
	
	public WarGame(int maxNumBattles){
		this.maxNumBattles = maxNumBattles;
		deck = new RankCardDeck();
	}
	
	public int getNumBattles(){
		return numBattles;
	}
	
	public boolean play(){
		//simulates one game. if number of battles played
		//reaches maxNumBattles the game is discontinued
		//returns true if game finishes normally; otherwise false
		//if game is discontinued
		//
		//instantiate player's hands
		player1 = new ArrayBndQueue<Integer>(numCards);
		player2 = new ArrayBndQueue<Integer>(numCards);
		
		//instantiate prize pile
		prize = new ArrayBndQueue<Integer>(numCards);
		
		boolean gameOver = false;  //becomes true when game is over
		boolean gameOK = true;  //becomes false when game is discontinued
		
		//deal original hands
		deck.shuffle();
		while(deck.hasMoreCards()){
			player1.enqueue(deck.nextCard());;
			if(deck.hasMoreCards())
				player2.enqueue(deck.nextCard());
		}
		
		//play game until somebody runs out of cards or
		//reach the maximum number of battles
		numBattles = 0;
		while(!gameOver){
			try{
				numBattles = numBattles + 1;
				battle();
			}
			catch(QueueUnderflowException exceptionVar){
				gameOver = true;
			}
			if(numBattles == maxNumBattles){
				gameOver = true;
				gameOK = false;
			}
		}
		return gameOK;
	}
	
	private void battle(){
		//models a battle between player1 and player2. if battle
		//results in a war. three cards from each player are placed
		//in the prize queue and the battle is continued recursively
		//
		//cards for this battle
		int p1card;
		int p2card;
		
		//get cards from players and place in prize queue
		p1card = player1.dequeue();
		prize.enqueue(p1card);
		p2card = player2.dequeue();
		prize.enqueue(p2card);
		
		//determine and handle result
		if(p1card > p2card)   //player1 wins
			while(!prize.isEmpty())
				player1.enqueue(prize.dequeue());
		else{
			if(p2card > p1card)  //player2 wins
				while(!prize.isEmpty())
					player2.enqueue(prize.dequeue());
			else{
				//it's a war...
				//each player places 3 cards in prize queue
				for(int i = 0; i < 3; i++){
					prize.enqueue(player1.dequeue());
					prize.enqueue(player2.dequeue());
				}
				//now continue the battle to determine who wins
				battle();
				}
			}
			
		}
	}
	


