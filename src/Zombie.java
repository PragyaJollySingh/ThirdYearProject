
public class Zombie extends Actor
{
	int health; 
	int attackDamage;
	boolean atPlant;
	boolean attacking;
	Spot currentSpot; 
	Board gameBoard;
	boolean alive;
	
	public Zombie(int health, int attackDamage, Spot currentSpot, Board gameBoard)
	{
		
		this.health = health;
		this.attackDamage = attackDamage;
		this.atPlant = false;
		this.attacking = false;
		this.currentSpot = currentSpot;
		this.gameBoard = gameBoard;
		this.alive = true;
	}
	/** To see if the Zombie is attacking
	 * @return boolean to show that a zombie is attacking
	 */
	public boolean isAttacking() {
		return attacking;
	}
	
	/** Setting the Zombie to attack 
	 * @param a type boolean to represent if an attack is occuring
	 * @return void
	 */

	public void setAttacking(boolean attacking) {
		this.attacking = attacking;
	}
	/**Gets the current spot of the Zombie 
	 * @return tyep Spot that represents the spot of the zombie
	 */

	public Spot getCurrentSpot() {
		return currentSpot;
	}
	/** Set the current spot for the zombie
	 * @param type spot that is the current location of the Zombie
	 * @return void
	 */

	public void setCurrentSpot(Spot currentSpot) {
		this.currentSpot = currentSpot;
	}
	/**Gets the game board 
	 * @return type Board that is the game board
	 */

	public Board getGameBoard() {
		return gameBoard;
	}
	/** Set the game board 
	 * @param type board that is the current board game 
	 * @return void
	 */

	public void setGameBoard(Board gameBoard) {
		this.gameBoard = gameBoard;
	}
	/**Moves the Zombie on the board, and attacks if there is something in the next spot to it
	 * and or moves the zombie up the bored
	 * @void
	 */
	
	public void move() 
	{
		if(!currentSpot.isFilled()) 
		{
			int futureX = currentSpot.getxCoord() - 1;
			if(futureX == 0) 
			{
				gameBoard.getPlayer().die();
				System.out.println("Zombie has eaten your brains: GAME OVER\n");
				System.exit(0);
			}
			
			
			
			currentSpot.getSpotZombies().remove(0);
			currentSpot.setHasZombie(false);
			
			gameBoard.spotAt(futureX, currentSpot.getyCoord()).addSpotZombie(this);
			gameBoard.spotAt(futureX, currentSpot.getyCoord()).setHasZombie(true);
			
			this.currentSpot = gameBoard.spotAt(futureX, currentSpot.getyCoord());
			System.out.print("A Zombie has moved to spot x: " + Integer.toString(futureX) + 
													   " y: " + Integer.toString(currentSpot.getyCoord()) + "\n");
		}
		else 
		{
			this.attacking = true;
			if(currentSpot.isHasSunflower()) 
			{
				int currentHealth = currentSpot.getSpotSunflower().getHealth();
				currentSpot.getSpotSunflower().setHealth(currentHealth - attackDamage);
				System.out.println("A Zombie has attacked Sunflower at x: " + Integer.toString(currentSpot.getxCoord()) + 
						   " y: " + Integer.toString(currentSpot.getyCoord()) + "\n");
				System.out.println("Sunflower Current Health: " + Integer.toString(currentSpot.getSpotSunflower().getHealth()) + "\n");
				
				if(currentSpot.getSpotSunflower().getHealth() <= 0) 
				{
					currentSpot.getSpotSunflower().setAlive(false);
					currentSpot.setHasSunflower(false);
					currentSpot.setFilled(false);
					System.out.println("A Zombie has killed Sunflower at x: " + Integer.toString(currentSpot.getxCoord()) + 
																	   " y: " + Integer.toString(currentSpot.getyCoord()) + "\n");
				}
			}
			else 
			{
				int currentHealth = currentSpot.getSpotPeaShooter().getHealth();
				currentSpot.getSpotPeaShooter().setHealth(currentHealth - attackDamage); 
				System.out.println("A Zombie has attacked PeaShooter at x: " + Integer.toString(currentSpot.getxCoord()) + 
						   " y: " + Integer.toString(currentSpot.getyCoord()) + "\n");
				System.out.println("PeaShooter Current Health: " + Integer.toString(currentSpot.getSpotPeaShooter().getHealth()) + "\n");
				
				
				if(currentSpot.getSpotPeaShooter().getHealth() <= 0) 
				{
					currentSpot.getSpotPeaShooter().setAlive(false);
					currentSpot.setSpotPeaShooter(null);
					currentSpot.setHasPea(false);
					System.out.println("A Zombie has killed a PeaShooter at x: " + Integer.toString(currentSpot.getxCoord()) + 
							   " y: " + Integer.toString(currentSpot.getyCoord()) + "\n");
				}
			}
		}
	
	}
	/** Gets the health of the zombie
	 * @return int type that gets the value of the health of a zombie
	 */
	
	public int getHealth() 
	{
		return health;
	}
	/** Sets the health
	 * @param type int that is the health 
	 * @return void
	 */

	public void setHealth(int health) {
		this.health = health;
	}
	/**Checks if the Zombie is at a spot that has a plant on it 
	 * @return a boolen value to indicate if there is plant there
	 */
	
	public boolean isAtPlant() 
	{
		return atPlant;
	}
	/** Set a zombie at a place where there is a plant there
	 * @param a boolean that indicates if a zombie is at the same place as a plant
	 * @return void
	 */

	public void setAtPlant(boolean atPlant) {
		this.atPlant = atPlant;
	}
	
	
}
