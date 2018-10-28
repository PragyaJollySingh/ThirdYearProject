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


	public int getNumberOfZombies() 
	{
		return numberOfZombies;
	}


	public void setNumberOfZombies(int numberOfZombies) 
	{
		this.numberOfZombies = numberOfZombies;
	}


	public Board getGameBoard() {
		return gameBoard;
	}


	public void setGameBoard(Board gameBoard)
	{
		this.gameBoard = gameBoard;
	}


	public boolean isOngoing()
	{
		return ongoing;
	}


	public void setOngoing(boolean ongoing)
	{
		this.ongoing = ongoing;
	}
	
	
}
