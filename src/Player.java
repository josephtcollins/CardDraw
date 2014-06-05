// Player class, used to keep names and points
// Joe Collins
public class Player {
	
		  protected String name;
		  protected int score;    

		  public Player(String name, int score) {
		    this.name = name;
		    this.score = score;
		  }

		  public String getName() {
		    return name;
		  }
		  
		  public int getScore() {
		    return score;
		  }
		  
		  public void setScore(int score) {
			  this.score = score;
		  }

		  public String toString() {
		    return (score + ": " + name);
		  }

	}
	