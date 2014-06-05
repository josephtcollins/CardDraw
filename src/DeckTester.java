public class DeckTester {

	public static void main(String[] args) {
		
		Deck deck = new Deck();
		System.out.println(deck);
		
		System.out.println("---------------------");
				
		deck.shuffle();
		
		System.out.println(deck);
		
		System.out.println("---------------------");

		for (int i=0; i<53; i++){
			System.out.println(deck.dealCard());
		}
	
		System.out.println("\n" + deck.dealCard());
		
		System.out.println(deck.cardsLeft());
		
		deck = new Deck();
		System.out.println(deck);
		deck.shuffle();
		System.out.println(deck);


	}

}
