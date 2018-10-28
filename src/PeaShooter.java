import java.util.ArrayList;

public class PeaShooter extends Plant
{
	private int xCoordinate;
	private int yCoordinate;
	private int attackDamage;
	private Spot spotPlaced;
	private Board gameBoard;
	private Wave wave;
	
	public PeaShooter( int xCoordinate, int yCorodinate, int attackDamage, Spot spotPlaced, Board gameBoard, Wave wave) 
	{
		super(100, 100);
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.attackDamage = attackDamage;
		this.spotPlaced = spotPlaced;
		this.gameBoard = gameBoard;
		this.wave = wave;
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public Spot getSpotPlaced() {
		return spotPlaced;
	}

	public void setSpotPlaced(Spot spotPlaced) {
		this.spotPlaced = spotPlaced;
	}

	public void attackZombie() 
	{
		ArrayList<Spot> attackableZombieSpotsInRow = new ArrayList<Spot>();
		for(Spot s : gameBoard.getGrid()) 
		{
			if(s.getyCoord() == this.yCoordinate && (s.getxCoord() >= this.xCoordinate)) 
			{
				if(s.isHasZombie()) 
				{
					attackableZombieSpotsInRow.add(s);
				}
			}
		}
		
		Spot closestSpot = null;
		
		for(Spot zSpot : attackableZombieSpotsInRow) 
		{
			closestSpot = attackableZombieSpotsInRow.get(0);
			if(zSpot.getxCoord() < closestSpot.getxCoord()) 
			{
				closestSpot = zSpot;
			}
		}
		
		if(!closestSpot.hasNoZombies()) 
		{
			Zombie zombieToAttack = closestSpot.getFirstZombie();
			zombieToAttack.setHealth(zombieToAttack.getHealth() - this.attackDamage);
			System.out.print("Zombie attacked at spot x: " + Integer.toString(closestSpot.getxCoord()) + 
					  " y: " + Integer.toString(closestSpot.getyCoord()) + "\n");
			System.out.print("Zombie's current health is: " + Integer.toString(zombieToAttack.getHealth()) + "!\n");
			
			
			if(zombieToAttack.getHealth() <= 0) 
			{
				zombieToAttack.setAlive(false);
				closestSpot.getSpotZombies().remove(0);
				wave.setNumberOfZombies(wave.getNumberOfZombies() - 1);
				System.out.print("Zombie killed at spot x: " + Integer.toString(closestSpot.getxCoord()) + 
													  " y: " + Integer.toString(closestSpot.getyCoord()) + "\n");
				System.out.print("Currently " + Integer.toString(wave.getNumberOfZombies()) + " zombies remaining in this wave.\n");
			}
		}
	}

	public Board getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(Board gameBoard) {
		this.gameBoard = gameBoard;
	}

	public Wave getWave() {
		return wave;
	}

	public void setWave(Wave wave) {
		this.wave = wave;
	}
	
	
}
