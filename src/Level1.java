
public class Level1 
{
	
	
	
	public static void  main(String[] args) 
	{
		Player player = new Player(300);
		Board board = new Board(15, 5, player);
		System.out.println("Level 1: Begin");
		Wave wave1 = new Wave(3, board);
		wave1.setNumberOfZombies(3);
		while(player.isAlive() && wave1.isOngoing()) 
		{
			new Turn(player, board, wave1);
		}
		
		if(!player.isAlive()) 
		{
			System.out.println("GAME OVER");
			System.exit(0);
		}
		
		if(!wave1.isOngoing()) 
		{
			System.out.println("You have successfully killed all zombies! You win! \n");
			System.exit(0);
		}
		
		
	}

}
