
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


	public int getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}
}
