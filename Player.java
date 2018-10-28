
public class Player 
{
	private int sunAmount; 
	private boolean alive;
	
	public Player(int startingAmount) 
	{
		this.sunAmount = startingAmount;
		this.alive = true;
	}
	/** Sets the player to dead, by setting alive to false 
	 * @return a boolean value of false
	 */
	
	public void die() 
	{
		this.alive = false;
	}
	/** Adds ten to the sunAmount 
	 * @return void
	 */
	
	public void addSun()
	{
		sunAmount += 10; 
	}
	/** Retrieves the sun amount
	 * @return an int value of the sunAmount
	 */

	public int getSunAmount() {
		return sunAmount;
	}
	/**
	 * Sets the sun amount 
	 * @param int value of the desire set sun amount
	 * @return void
	 */

	public void setSunAmount(int sunAmount) {
		this.sunAmount = sunAmount;
	}
	/** Checks if the player is alive 
	 * @return boolean value that indicates with true/false if the player is alive
	 */

	public boolean isAlive() {
		return alive;
	}
	
	/** Sets the player to alive 
	 * @param a boolean value indicating if the player is alive or not 
	 * @return void
	 */

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
}
