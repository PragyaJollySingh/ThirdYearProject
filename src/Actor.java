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
	
	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}
	
	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
}
