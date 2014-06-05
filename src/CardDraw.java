//----------------------------------------------------------------------
// CardDraw.java										Joseph Collins 
// 3/18/14
// CardDraw Game, for MAXETATECH
//----------------------------------------------------------------------


import java.util.Scanner;
public class CardDraw {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);
		Deck deck = new Deck(); // build the deck
		Player[] Players = new Player[5]; // Array to keep track of players
		Card[] cards = new Card[5]; // Array to keep track of picked cards in round

		int numPeople = 1; int count = 1; 
		int tempnum = 0; int tempsuit = 0;
		int roundsuit = 0; int roundnum = 0;
		int winner = 0;
		int winindex = 0;
		
		String tempname = "";
		boolean won = false; boolean close = false;
		Card roundCard = new Card(1,1);
		
		System.out.println("Welcome to game CARD DRAW, good luck and godspeed. \n");
		
		
		while (numPeople != -1) { // Choosing number of players
			System.out.println("Please enter the number of people playing (2-4).");
			numPeople = scan.nextInt();
			if ((numPeople == 2) || (numPeople == 3) || (numPeople == 4))
				break;
			else
				System.out.print("Choose a valid number.\n");
		}
		
		
		System.out.println("Okay, you're doing great.\nNow what are your names?");
		System.out.println("Please type and press \"enter\" separately to bank names.");
		
		
		for (int i = 0; i<=numPeople; i++) { // Getting and banking names
			tempname = scan.nextLine();
			Players[i] = new Player(tempname, 0);
		}
		
		deck.shuffle();
		System.out.println("Let the game begin.");
		
		System.out.println("Round: " + count);
		
		while (!won || close) {
			close = false; won = false;
			deck = new Deck();
			deck.shuffle(); deck.shuffle();

			for (int j = 1; j<=numPeople; j++) {
				
				System.out.println(Players[j].getName() + "'s turn.");
				System.out.println("Please pick card (type \"pick\")"); // Can type anything 
				
				scan.nextLine();
				roundCard = deck.dealCard();
				cards[j] = roundCard; // store the cards for comparison at end of round
				System.out.println("Card is... ");

				System.out.println(roundCard);

					if (roundCard.getNum() == 1) { // if penalty card is drawn
						Players[j].setScore((Players[j].getScore())-1);
						System.out.println("Penalty Card! Minues ONE POINT.");
					}
					
					
				try {
					Thread.sleep(800); // a slight pause for realism
				}
				catch(InterruptedException ex) {
				    Thread.currentThread().interrupt(); //-------------
				}
				
				
				System.out.println("\n");
			}
			
			tempnum = 0; tempsuit = 5;
			roundnum = 0; winner = 0;
			roundsuit = 5;
			
			for (int k = 1; k<=numPeople; k++) { // Finding who has won the round
				
				tempnum = cards[k].getNum();
				tempsuit = cards[k].getSuit();
				
				if (tempnum > roundnum) {
					roundnum = tempnum; 
					winner = k;
					roundsuit = tempsuit;
				}
				if (tempnum == roundnum) {
					if (tempsuit < roundsuit) {
						winner = k;
						roundsuit = tempsuit;
					}
				}
			}
			
			System.out.println("The WINNER of the round is " 
			+ Players[winner].getName() + ". + 2 points\n");
			Players[winner].setScore(Players[winner].getScore() + 2); // increment score of player by 2
			System.out.println("-----------------------------");
			
			for (int r = 1; r<=numPeople; r++) { // checks to see if anyone has won
				if (Players[r].getScore() >= 21) {
					winindex = r;
					won = true;
				}
				
				System.out.println(Players[r]);
			}
			
			if (won == true) {  
				for (int s = 1; s<=numPeople; s++){
					if ((Players[winindex].getScore() - Players[s].getScore()) < 2) { // within two check
						if (s != winindex)
							close = true;
					}
					else
						winner = winindex;
				}
			}
			
			
		} // ends while loop
		
		System.out.println("\n-------------------------------------");
		System.out.println("THE GAME HAS ENDED");
		System.out.println("The Winner is " + Players[winner].getName()
				+ " with " + Players[winner].getScore() + " points!");
		System.out.println("---------------------------------------\n");
		
		
	}
	
}
