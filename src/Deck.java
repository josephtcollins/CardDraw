//----------------------------------------------------
//  Deck.java						by Joe Collins
//  Deck
//----------------------------------------------------

import java.util.Random;

public class Deck implements DeckofCardsInterface{

	private final int NumCards = 56;
	private int cardsLeft; 
	private Card[] deck = new Card[NumCards]; 
	private Random rand = new Random();
	
	public Deck () { // builds deck
		
		cardsLeft = NumCards-1;
		Card tempCard;
		int count = 0;
		
		for (int i=1; i<=4; i++) {
			for (int j=1; j<=14; j++) {
				tempCard = new Card(j,i);
				deck[count] = tempCard;
				count++;
			}
		}
	}
	
	public void shuffle() {
		int to;
		int from; // exchanges two cards many times, a method of shuffling
		
		for (int i=0; i<1000; i++) { // does this action 1000 times for max randomness 
			to = rand.nextInt(NumCards);
			from = rand.nextInt(NumCards);
			switchCards (to,from); // exchanges the cards
		}
	}
	
	public void switchCards (int to, int from) { //  used for shuffle method
		
		Card toCard = deck[to];
		Card fromCard = deck[from];
		
		deck[to] = fromCard;
		deck[from] = toCard;
	}

	public int cardsLeft() {
		
		return cardsLeft+1;
	}

	public Card dealCard() {
		Card returnCard = null;
		
		if (cardsLeft >= 0){
			returnCard = deck[cardsLeft];
			cardsLeft --; //  returns top card if deck has cards left
		}
		else{
			cardsLeft = NumCards-1;
			shuffle();
			returnCard = deck[cardsLeft];
			cardsLeft --; //  sets deck up again, shuffles, and returns new top card
		}
		return returnCard;
	}
	
	public String toString(){
		String returnString = "";
		
		for (int i = 0; i < NumCards;i++ ){ //  String for entire deck
			returnString += deck[i].toString() + "\n";
		}
		
		return returnString;
	}
	
}
