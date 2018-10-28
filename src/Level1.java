
public class Level1 
{
	
	
	
	public static void  main(String[] args) 
	{
		Player player = new Player(300);
		Board board = new Board(15, 5, player); //Sets the board
		System.out.println("Level 1: Begin");
		Wave wave1 = new Wave(3, board); // Initializes the zombie wave
		wave1.setNumberOfZombies(3); // Initializes the numbre of zombies
		while(player.isAlive() && wave1.isOngoing()) //The start of the wave begins and the player is still alive
		{
			new Turn(player, board, wave1);
		}
		
		if(!player.isAlive()) // If the player is not alive the game is over
		{
			System.out.println("GAME OVER");
			System.exit(0);
		}
		
		if(!wave1.isOngoing()) // If the player is still alive the game goes on till they win
		{
			System.out.println("You have successfully killed all zombies! You win! \n"); 
			System.exit(0);
		}
		
		
	}

}
