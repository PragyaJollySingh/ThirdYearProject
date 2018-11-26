package model;

public class Plant 
{
	private int health; 
	private int cost; 
	private boolean alive;
	
	// This is the general plant class as no matter what kind of plant you always have to keep track of the health and cost
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


	public boolean isAlive() {
		return alive;
	}


	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
}
