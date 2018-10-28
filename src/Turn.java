import java.util.Scanner;
public class Turn 
{
	private Player player;
	private Board board;
	private Wave wave;
	
	
	public Turn(Player player, Board board, Wave wave) 
	{
		this.player = player;
		this.board = board; 
		this.wave = wave;
		
		askToPlant();
		
	}
	/**Checks the bored at the end to see that the user has done, keeps the player updated
	 * regarding how many zombies are on the bore dand how many have been defeated
	 * @return void
	 */
	
	public void finishTurn() 
	{

		for(Spot s : board.getGrid()) 
		{
			if(s.isHasSunflower()) 
			{
				s.getSpotSunflower().addSunToPlayer();
			}
		}
		
		for(Spot s : board.getGrid()) 
		{
			if(s.isHasZombie()) 
			{
				if(s.getSpotZombies() != null) 
				{
					for(Zombie z : s.getSpotZombies()) 
					{
					
						z.move();
					}
				}
			}
		}
		
		for(Spot s : board.getGrid()) 
		{
			if(s.isHasPea()) 
			{
				s.getSpotPeaShooter().attackZombie();
				
			}
		}
		
		System.out.println(Integer.toString(wave.getNumberOfZombies()) + " Zombies remain!\n");
		if(wave.getNumberOfZombies() == 0) 
		{
			System.out.println("Congrats you have defeated this wave of zombies!\nYou Win!\n");
			wave.setOngoing(false);
		}
	}
	/** Asks the user if they would like to plant a plant or keep the points and plant at another turn
	 * @return void
	 */
	
	public void askToPlant() 
	{
		System.out.print("It is your turn: press P to place a new plant or N for the next turn\n");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		if(input.equalsIgnoreCase("P")) 
		{
			askWhichPlant();
		}
		else if(input.equalsIgnoreCase("N")) 
		{
			finishTurn();
		}
		else 
		{
			System.out.println("Invalid Command! \n");
			askToPlant();
		}
	}
	/**Asks the player what plant they would like to plant on the bored, and does the math 
	 * to make sure that the player has sufficant coins to pay for that plant
	 */
	
	public void askWhichPlant() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("What type of plant? Press S for Sunflower or Press P for Pea Shooter\n");
		String whichPlant = sc.next();
		if(whichPlant.equalsIgnoreCase("S")) 
		{
			if(player.getSunAmount() >= 50) 
			{
				askForXCoordinate(true);
			}
			else 
			{
				System.out.println("Insufficient Sun Balance!\n");
				askWhichPlant();
			}
		}
		else if (whichPlant.equalsIgnoreCase("P")) 
		{
			
			if(player.getSunAmount() >= 100) 
			{
				askForXCoordinate(false);
			}
			else 
			{
				System.out.println("Insufficient Sun Balance!\n");
				askWhichPlant();
			}
		}
		else 
		{
			askWhichPlant();
		}
	}
	/**Asks the player where they would like to plant the sunflower, and checks to see if it is a valid 
	 * spot, if it is not then it will let the user know with an error message 
	 * @param a boolean that represent if there is a sunFlower at that spot
	 */
	
	
	public void askForXCoordinate(boolean isSunflower) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an X coordinate: \n");
		String xCoord = sc.next();
		int xCoordinate = Integer.parseInt(xCoord);
		if(xCoordinate > -1 && xCoordinate < board.getxSize()) 
		{
			askForYCoordinate(xCoordinate, isSunflower);
		}
		else 
		{
			System.out.println("Invalid X Coordinate! Please try again. \n");
			askForXCoordinate(isSunflower);
		}
	}
	/** Asks the player for the y corrdinate, checks if it is a valid positions and is not filled,
	 * and if it is not filled will place a sunflower/peaplants there. it will let you know of the sucessful 
	 * plantation. If the spot is filled an error message will be displayed 
	 * @return void
	 */
	
	public void askForYCoordinate(int xCoordinate, boolean isSunflower) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Y coordinate: \n");
		String yCoord = sc.next();
		int yCoordinate = Integer.parseInt(yCoord);
		if(isSunflower) 
		{
			if(!board.spotAt(xCoordinate, yCoordinate).isFilled()) 
			{
				board.spotAt(xCoordinate, yCoordinate).setSpotSunflower(new Sunflower(xCoordinate, yCoordinate, player));
				board.spotAt(xCoordinate, yCoordinate).setFilled(true);
				board.spotAt(xCoordinate, yCoordinate).setHasSunflower(true);
				player.setSunAmount(player.getSunAmount() - 50);
				System.out.println("Sunflower placed at coordinates x: " + Integer.toString(xCoordinate) +
																  " y: " + Integer.toString(yCoordinate) + " \n");
				System.out.println("Player current sun balance is: " + Integer.toString(player.getSunAmount()) + "!\n");
				finishTurn();
			}
			else  
			{
				System.out.print("Spot is filled choose new Y Coord: \n");
				askForYCoordinate(xCoordinate, isSunflower);
			}
			
		}
		else 
		{
			if(!board.spotAt(xCoordinate, yCoordinate).isFilled()) 
			{
				board.spotAt(xCoordinate, yCoordinate).setSpotPeaShooter(new PeaShooter(xCoordinate, yCoordinate, 20, 
																	board.spotAt(xCoordinate, yCoordinate), board, wave));
				board.spotAt(xCoordinate, yCoordinate).setFilled(true);
				board.spotAt(xCoordinate, yCoordinate).setHasPea(true);
				player.setSunAmount(player.getSunAmount() - 100);
				System.out.println("Player current sun balance is: " + Integer.toString(player.getSunAmount()) + "!\n");
				System.out.println("PeaShooter placed at coordinates x: " + Integer.toString(xCoordinate) +
						  " y: " + Integer.toString(yCoordinate) + " \n");
				finishTurn();
			}
			else  
			{
				System.out.print("Spot is filled choose new Y Coord: \n");
				askForYCoordinate(xCoordinate, isSunflower);
			}
			
		}
		
	}
	
}
