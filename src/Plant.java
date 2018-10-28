public class Plant extends Actor
{
	int health; 
	int cost; 
	boolean alive;
	private int xCordinate;
	private int yCordinate;
	
	
	public Plant(int health, int cost) 
	{
		this.health = health;
		this.cost = cost;
		this.alive = true;
	}

	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getxCordinate() {
		return xCordinate;
	}

	public void setxCordinate(int xCordinate) {
		this.xCordinate = xCordinate;
	}

	public int getyCordinate() {
		return yCordinate;
	}

	public void setyCordinate(int yCordinate) {
		this.yCordinate = yCordinate;
	}
	
}
