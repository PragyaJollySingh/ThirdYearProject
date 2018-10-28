/***
 * 
 * Super-class with attributes that are shared with Plants and Zombies
 */
public class Actor {

	int attackDamage;
	int health;
	boolean alive;

	public Actor() {
		
	}
/** Gets the attack from the damage
 * @return an int type that returns the attack damage
 */
	
	public int getAttackDamage() {
		return attackDamage;
	}
/**Sets the attack damage 
 * @param int value of attack damage 
 * @void
 */

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}
/** Checks if the actor is alive
 * @return a boolean to indicate if the actor is alive
 */
	
	public boolean isAlive() {
		return alive;
	}
/** Sets the actor to alive 
 * @param a boolean to indicate if the actor is alive
 */

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
/** Gets the health 
 * @param an int type that returns the health
 */
	
	public int getHealth() {
		return health;
	}
/** Sets the health 
 * @param an int that has the health value 
 * @return void
 */

	public void setHealth(int health) {
		this.health = health;
	}
}
