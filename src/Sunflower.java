
public class Sunflower extends Plant
{
	int xCordinate;
	int yCordinate;
	private Player player;
	
	public Sunflower(int xCordinate, int yCordinate, Player player) 
	{
		super(100, 50);
		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate;
		this.player = player;
	}
	
	public void addSunToPlayer() 
	{
		player.addSun();
		System.out.println("Sunflower gave the player 10 sun! \n");
		System.out.println("Player's current sun balance is: " + Integer.toString(player.getSunAmount()) + "!\n");
	}
}
