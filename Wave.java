import java.util.ArrayList;
import java.util.Random;

public class Wave 
{
	private int numberOfZombies;
	private Board gameBoard;
	private boolean ongoing;
	
	
	public Wave(int numberOfZombies, Board gameBoard)
	{
		 this.ongoing = true;
		 ArrayList<Spot> placeableSpots = new ArrayList<Spot>();
		 for(Spot s : gameBoard.getGrid()) 
		 {
			 if(s.getxCoord() == 14) 
			 {
				 placeableSpots.add(s);
			 }
		 }
		 for(int i = 0; i < numberOfZombies; i++) 
		 {
			 Random rand = new Random();
			 int random = rand.nextInt(5);
			 Zombie newZombie = new Zombie(100, 10, placeableSpots.get(random) , gameBoard);
			 Spot placedSpot = gameBoard.spotAt(14, newZombie.getCurrentSpot().getyCoord());
			 placedSpot.addSpotZombie(newZombie);
			 placedSpot.setHasZombie(true);
			 System.out.println("Zombie has been placed at spot x: " + Integer.toString(placedSpot.getxCoord()) + 
					 										  " y: " + Integer.toString(placedSpot.getyCoord()));
		 }
	}

/** Gets the number of Zombies on the bored 
 * @return an int type that represents the number of zombies on the board
 */
	public int getNumberOfZombies() 
	{
		return numberOfZombies;
	}

/** Sets the number of Zombies on the board
 * @param an int value that represents the number of zombies 
 * @return void
 */
	public void setNumberOfZombies(int numberOfZombies) 
	{
		this.numberOfZombies = numberOfZombies;
	}
	
/** Gets the game board
 * @return type board that is the current game board
 */

	public Board getGameBoard() {
		return gameBoard;
	}
/** Sets the game board 
 * @param type Board that is the game baord 
 * @return void
 */


	public void setGameBoard(Board gameBoard)
	{
		this.gameBoard = gameBoard;
	}
/** Checks if the wave of zombies is still going on 
 * @return a boolean value to show if the wave is still going on
 */

	public boolean isOngoing()
	{
		return ongoing;
	}

/** Sets the wave to ongoing 
 * @param a boolean that indicates if there is wave that is going on
 * @return void
 */
	public void setOngoing(boolean ongoing)
	{
		this.ongoing = ongoing;
	}
	
	
}
