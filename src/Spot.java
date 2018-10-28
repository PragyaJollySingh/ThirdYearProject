import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Spot 
{
	private int spotId;
	private int xCoord;
	private int yCoord;
	private boolean filled;
	private boolean hasSunflower;
	private boolean hasPea;
	private boolean hasZombie;
	private Sunflower spotSunflower;
	private PeaShooter spotPeaShooter;
	private CopyOnWriteArrayList<Zombie> spotZombies;
	
	public Spot(int spotId, int xCoord, int yCoord, boolean filled) 
	{
		this.spotId = spotId;
		this.xCoord = xCoord;
		this.yCoord = yCoord; 
		this.filled = filled; 
		this.hasSunflower = false;
		this.hasPea = false;
		this.spotPeaShooter = null;
		this.spotSunflower = null;
		spotZombies = new CopyOnWriteArrayList<Zombie>();
	}
	/**Checks to see if the spot has a sunflower
	 * @return a boolean that returns if the spot has a flower 
	 */
	
	public boolean isHasSunflower() {
		return hasSunflower;
	}
	/** Sets the spot to have a sunflower 
	 * @param a boolean value set for the sunflower's position
	 */
	public void setHasSunflower(boolean hasSunflower) {
		this.hasSunflower = hasSunflower;
	}
	
	/** Checks to see if there is a peaplant in that particular spot 
	 * @return a boolean value if the spot has a peaplant at that spot
	 */

	public boolean isHasPea() {
		return hasPea;
	}
	/** Sets the spot to have a peaplant
	 * @param a boolean value that indicates it the peaplant is at that spot
	 * @return void
	 */

	public void setHasPea(boolean hasPea) {
		this.hasPea = hasPea;
	}
	/** Gets the sunflower spot on the bored 
	 * @return a  type spotSunflower 
	 */

	public Sunflower getSpotSunflower() {
		return spotSunflower;
	}
	/** Sets the sunflower to a particular place on the bored
	 * @para type Sunflower a spot where it would like the sunflower to be
	 * @return void
	 */

	public void setSpotSunflower(Sunflower spotSunflower) {
		this.spotSunflower = spotSunflower;
	}
	
	/** Gets the peashooters spot
	 * @return type PeaShooter (spot)
	 */

	public PeaShooter getSpotPeaShooter() {
		return spotPeaShooter;
	}
	/** set the spot for the peashooter
	 * @param type PeaShooter which is a spot for a peashooter
	 * @return void
	 */

	public void setSpotPeaShooter(PeaShooter spotPeaShooter) {
		this.spotPeaShooter = spotPeaShooter;
	}
	/**
	 * Sets the x coordinerate 
	 * @param type int that is an x coordinate
	 * @return void
	 */

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}
	/** Get the x coordinate 
	 * @return int type that is an x coordinate
	 */

	public int getxCoord() 
	{
		return xCoord;
	}
	
	/** Get the y coordinate 
	 * @return an int type that is the y coordinate
	 */
	
	public int getyCoord() 
	{
		return yCoord;
	}
	/** Sets the y coordinate 
	 * @param an int y coordinate 
	 * @return void
	 */
	
	public void setyCoord(int yCoord) 
	{
		this.yCoord = yCoord;
	}
	/** Checks if the spot is actually filled with something in it 
	 * @return a boolean value that indicates if something is in that spot
	 */
	
	public boolean isFilled() 
	{
		return filled;
	}
	/** Set the spot to be filled 
	 * @param a boolean type that indicates if the spot is filled or not 
	 * @return void
	 */
	
	public void setFilled(boolean filled)
	{
		this.filled = filled;
	}
	/** Adds a zombibe to the spot 
	 * @param a zombie that is of type Zombie
	 * @return void
	 */
	
	public void addSpotZombie(Zombie zombie) 
	{
		spotZombies.add(zombie);
	}
	/** Gets the first Zombie
	 * @return a Zombie 
	 */
	
	public Zombie getFirstZombie() 
	{
		return spotZombies.get(0);
	}
	/** Empty the spot so that there is no zombie at a particular spot
	 * @return boolean that checks if that spot is empty
	 */
	
	public boolean hasNoZombies() 
	{
		return spotZombies.isEmpty();
	}
	/** Kills the first Zombie by removing it from the spot 
	 * @return void
	 */
	
	public void killFirstZombie() 
	{
		spotZombies.remove(0);
	}
	/** To represent that a zombie is eatting a plant 
	 * @return void
	 */
	
	public void zombieEatsPlant() 
	{
		this.filled = false;
		if(this.hasSunflower) 
		{
			this.spotSunflower = null;
			this.hasSunflower  = false;
		}
		else 
		{
			this.spotPeaShooter = null;
			this.hasPea = false;
		}
	}
	
	/** Gets the spot ID 
	 * @return int that is the spot ID
	 */

	public int getSpotId() {
		return spotId;
	}
	/** You set the spot Id 
	 * @param a type int thats is the spot Id
	 * @return void
	 */

	public void setSpotId(int spotId) {
		this.spotId = spotId;
	}
	/** Checks to see if a zombie is at a spot
	 * @return type boolean representing if a spot has a zombie
	 */

	public boolean isHasZombie() {
		return hasZombie;
	}
	/** Sets a spot to have a zombie 
	 * @parm a boolean type representing if a spot has a zombie
	 * @return void
	 */

	public void setHasZombie(boolean hasZombie) {
		this.hasZombie = hasZombie;
	}
	/**Get a spot Zombie 
	 * @return spotZombie
	 */

	public CopyOnWriteArrayList<Zombie> getSpotZombies() {
		return spotZombies;
	}
	/** Sets a spot on Zombie 
	 * @param CopyOnWriteArrayList<Zombie>  a spot zombie
	 */

	public void setSpotZombies(CopyOnWriteArrayList<Zombie> spotZombies) 
	{
		this.spotZombies = spotZombies;
	}
	
	
}
