//-------------------------------------------------------------
// Card.java            			 by Joe Collins                   
// Card class, to be used by Deck to make a deck of cards
//-------------------------------------------------------------

public class Card {
		
	protected int num;
	protected int suit;
	protected String numname;
	protected String suitcolor;
	  
		public Card(int newnum, int newsuit) {
			num = newnum;
			suit = newsuit;
		}

		public int getSuit() {
			return suit;
		}
	  
		public int getNum() {
			return num;
		}
	  
		public String toString() {
			String numname = "";
			String suitcolor = "";
		  	
			switch (suit) {
				case 1:
					suitcolor = "Spades";
					break;
				case 2:
					suitcolor = "Hearts";
					break;
				case 3:
					suitcolor = "Diamonds";
					break;
				case 4:
					suitcolor = "Clubs";
					break;
			}
			
			switch (num) {
				case 1:
					numname = "Penalty Card";
					break;
				case 11:
					numname = "Jack";
					break;
				case 12:
					numname = "Queen";
					break;
				case 13:
					numname = "King";
					break;
				case 14:
					numname = "Ace";
					break;
				default:
					numname = Integer.toString(num);
					break;
			}
		if (num == 1)
			return (numname);
		else
			return (numname + " of " + suitcolor);
		
	}
}
