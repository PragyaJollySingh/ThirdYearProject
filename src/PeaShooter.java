import java.util.ArrayList;

public class PeaShooter extends Plant
{
	int xCoordinate;
	int yCoordinate;
	int attackDamage;
	Spot spotPlaced;
	private Board gameBoard;
	private Wave wave;
	
	public PeaShooter( int xCoordinate, int yCoordinate, int attackDamage, Spot spotPlaced, Board gameBoard, Wave wave) 
	{
		super(100, 100);
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.attackDamage = attackDamage;
		this.spotPlaced = spotPlaced;
		this.gameBoard = gameBoard;
		this.wave = wave;
	}
/** Getting the x coordinate
 * @return an int value that represents the x coordinate 
 */

	public int getxCoordinate() {
		return xCoordinate;
	}
/** Sets the x coordinate 
 * @param an int value that is the x coordinate value 
 * @return void
 */
	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
/** Gets the y coordinate 
 * @returns an int value that represent the y coordinate value
 */
	public int getyCoordinate() {
		return yCoordinate;
	}
/** Sets the y coordinate 
 * @param an int value that is the y coordinate
 * @return void
 */

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
/** Gets the spot of the peashooter
 * @return a Spot that is the spot that the peashooter is placed
 */

	public Spot getSpotPlaced() {
		return spotPlaced;
	}
/**Sets the spot placed for the peashooter
 * @param type Spot that the peashooter is placed 
 * @return void
 */

	public void setSpotPlaced(Spot spotPlaced) {
		this.spotPlaced = spotPlaced;
	}
/** The peashooter attacks the zombies, while giving information about the numeber of zombies on the board 
 * and their health
 * @return void 
 */
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
/**Gets the game board 
 * @return A type board that returns the game board
 */
	public Board getGameBoard() {
		return gameBoard;
	}
/** Sets the game board 
 * @param type Board that is the gameboard 
 * @return void
 */

	public void setGameBoard(Board gameBoard) {
		this.gameBoard = gameBoard;
	}
/** Gets the Zombie wave
 * @return a type Wave that is a wave
 */

	public Wave getWave() {
		return wave;
	}
/** Sets the wave 
 * @param a wave of type Wave
 * @return void
 */

	public void setWave(Wave wave) {
		this.wave = wave;
	}
	
	
}
