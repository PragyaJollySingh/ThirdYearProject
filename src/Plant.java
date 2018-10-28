
public class Plant extends Actor 
{
	int health; 
	int cost; 
	boolean alive;
	
	
	public Plant(int health, int cost) 
	{
		this.health = health;
		this.cost = cost;
		this.alive = true;
	}

/** Gets the plants health
 * @return int value representing the health of the plant
 */
	public int getHealth() {
		return health;
	}
	
/** Sets the health of the of the plant
 * @param an int value that is the health of the plant
 * @return void
 */

	public void setHealth(int health) {
		this.health = health;
	}
/** Gets the cost 
 * @return an int value that is the cost of the plant
 */

	public int getCost() {
		return cost;
	}
/** Sets the value of the cost of a plant
 * @param an int vaue that is the cost of the plant 
 * @return void
 */

	public void setCost(int cost) {
		this.cost = cost;
	}
}
