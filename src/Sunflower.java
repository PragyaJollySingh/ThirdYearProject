
public class Sunflower extends Plant
{
	int xCoordinate;
	int yCoordinate;
	private Player player;
	
	public Sunflower(int xCoordinate, int yCoordinate, Player player) 
	{
		super(100, 50);
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.player = player;
	}
	/**Adds sun to the bored  and prints out how many sun points the player got due to that addition and the current balance
	**@retuen void
	**/
	public void addSunToPlayer() 
	{
		player.addSun();
		System.out.println("Sunflower gave the player 10 sun! \n");
		System.out.println("Player's current sun balance is: " + Integer.toString(player.getSunAmount()) + "!\n");
	}
}
