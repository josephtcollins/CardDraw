//-------------------------------------------------
//  DeckofCardsInterface.java        by Joe Collins
//  Interface for Deck class
//-------------------------------------------------

public interface DeckofCardsInterface{
	public void shuffle();
	// shuffles the deck of cards and resets deal
	// to beginning of deck
	
	public int cardsLeft();
	// returns number of undealt cards
	
	public Card dealCard();
	// returns next card
	// if all dealt, shuffles then returns next card
	
	public String toString();
	// returns a string representing entire deck of cards
	
}
