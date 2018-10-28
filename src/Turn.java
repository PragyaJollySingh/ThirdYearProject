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
