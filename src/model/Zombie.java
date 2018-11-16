package model;

public class Zombie 
{
	private int health; 
	private int attackDamage;
	private boolean atPlant;
	private boolean attacking;
	private Spot currentSpot; 
	private Board gameBoard;
	private boolean alive;
	public  String turnDescriptionZombie = "";
	
	
	
	public Zombie(int health, int attackDamage, Spot currentSpot, Board gameBoard)
	{
		
		this.health = health;
		this.attackDamage = attackDamage;
		this.atPlant = false;
		this.attacking = false;
		this.currentSpot = currentSpot;
		this.gameBoard = gameBoard;
		this.alive = true;
	}

	public boolean isAttacking() {
		return attacking;
	}

	public void setAttacking(boolean attacking) {
		this.attacking = attacking;
	}

	public Spot getCurrentSpot() {
		return currentSpot;
	}

	public void setCurrentSpot(Spot currentSpot) {
		this.currentSpot = currentSpot;
	}

	public Board getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(Board gameBoard) {
		this.gameBoard = gameBoard;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	/*
	public void move() 
	{
		if(!currentSpot.isFilled()) 
		{
			int futureX = currentSpot.getxCord() - 1;
			if(futureX == 0) 
			{
				gameBoard.getPlayer().die();
				System.out.println("Zombie has eaten your brains: GAME OVER\n");
				System.exit(0);
			}
			
			
			
			currentSpot.getSpotZombies().remove(0);
			currentSpot.setHasZombie(false);
			
			gameBoard.spotAt(futureX, currentSpot.getyCord()).addSpotZombie(this);
			gameBoard.spotAt(futureX, currentSpot.getyCord()).setHasZombie(true);
			
			this.currentSpot = gameBoard.spotAt(futureX, currentSpot.getyCord());
			System.out.print("A Zombie has moved to spot x: " + Integer.toString(futureX) + 
													   " y: " + Integer.toString(currentSpot.getyCord()) + "\n");
		}
		else 
		{
			this.attacking = true;
			if(currentSpot.isHasSunflower()) 
			{
				int currentHealth = currentSpot.getSpotSunflower().getHealth();
				currentSpot.getSpotSunflower().setHealth(currentHealth - attackDamage);
				System.out.println("A Zombie has attacked Sunflower at x: " + Integer.toString(currentSpot.getxCord()) + 
						   " y: " + Integer.toString(currentSpot.getyCord()) + "\n");
				System.out.println("Sunflower Current Health: " + Integer.toString(currentSpot.getSpotSunflower().getHealth()) + "\n");
				
				if(currentSpot.getSpotSunflower().getHealth() <= 0) 
				{
					currentSpot.getSpotSunflower().setAlive(false);
					currentSpot.setHasSunflower(false);
					currentSpot.setFilled(false);
					System.out.println("A Zombie has killed Sunflower at x: " + Integer.toString(currentSpot.getxCord()) + 
																	   " y: " + Integer.toString(currentSpot.getyCord()) + "\n");
				}
			}
			else 
			{
				int currentHealth = currentSpot.getSpotPeaShooter().getHealth();
				currentSpot.getSpotPeaShooter().setHealth(currentHealth - attackDamage); 
				System.out.println("A Zombie has attacked PeaShooter at x: " + Integer.toString(currentSpot.getxCord()) + 
						   " y: " + Integer.toString(currentSpot.getyCord()) + "\n");
				System.out.println("PeaShooter Current Health: " + Integer.toString(currentSpot.getSpotPeaShooter().getHealth()) + "\n");
				
				
				if(currentSpot.getSpotPeaShooter().getHealth() <= 0) 
				{
					currentSpot.getSpotPeaShooter().setAlive(false);
					currentSpot.setSpotPeaShooter(null);
					currentSpot.setHasPea(false);
					System.out.println("A Zombie has killed a PeaShooter at x: " + Integer.toString(currentSpot.getxCord()) + 
							   " y: " + Integer.toString(currentSpot.getyCord()) + "\n");
				}
			}
		}
	
	}
	*/
	
	public void moveZombie() 
	{
		turnDescriptionZombie = "\n";
		if(!currentSpot.isFilled()) 
		{
			int futureSpotId = currentSpot.getSpotId() - 1;
			if((futureSpotId != -1) && (futureSpotId !=  9 ) && (futureSpotId !=  19 ) && (futureSpotId !=  29 )&& (futureSpotId !=  39 ))
			{
				Spot futureSpot = gameBoard.spotAt(futureSpotId);
				currentSpot.getSpotZombies().remove(this);
				futureSpot.addSpotZombie(this);
				futureSpot.setHasZombie(true);
				turnDescriptionZombie += "Zombie moved from SpotId: " + String.valueOf(currentSpot.getSpotId()) + " to SpotID: " + String.valueOf(futureSpotId) + "\n";
				currentSpot = futureSpot;
				 
			}
			else if(futureSpotId == -1 || futureSpotId == 9 || futureSpotId == 19 || futureSpotId == 29 || futureSpotId == 39)
			{
				System.out.println("You lose Zombie ate your brains");
				gameBoard.setGameOver();
				//System.exit(1);
				
			}
			
		}
		else 
		{
			this.attacking = true;
			if(currentSpot.isHasSunflower()) 
			{
				int currentHealth = currentSpot.getSpotSunflower().getHealth();
				turnDescriptionZombie += "Sunflower current health: " + String.valueOf(currentHealth) + "\n" + "Zombie attacks sunfower at SpotId: " 
																	  + String.valueOf(currentSpot.getSpotId()) + "\n";
				currentSpot.getSpotSunflower().setHealth(currentHealth - attackDamage);
				turnDescriptionZombie += "Sunflower lost " + String.valueOf(attackDamage) + " Current health: " + String.valueOf(currentHealth-attackDamage) +"\n";
				
				if(currentSpot.getSpotSunflower().getHealth() <= 0) 
				{
					currentSpot.getSpotSunflower().setAlive(false);
					currentSpot.setHasSunflower(false);
					currentSpot.setFilled(false);
					turnDescriptionZombie += "Zombie killed sunflower at spotId: " + String.valueOf(currentSpot.getSpotId());
					
				}
				
			}
			else if(currentSpot.isHasPea()) 
			{
				int currentHealth = currentSpot.getSpotPeaShooter().getHealth();
				turnDescriptionZombie += "PeaShooter current health: " + String.valueOf(currentHealth) + "\n" + "Zombie attacks sunfower at SpotId: " + String.valueOf(currentSpot);
				currentSpot.getSpotPeaShooter().setHealth(currentHealth - attackDamage);
				turnDescriptionZombie += "PeaShooter lost " + String.valueOf(attackDamage) + " Current health: " + String.valueOf(currentHealth-attackDamage);

				if(currentSpot.getSpotPeaShooter().getHealth() <= 0) 
				{
					currentSpot.getSpotPeaShooter().setAlive(false);
					currentSpot.setHasPea(false);
					currentSpot.setFilled(false);
				}
				
			}
			
			
		}
		
		
	}
	
	
	public  String getTurnDescriptionZombie() 
	{
		return turnDescriptionZombie;
	}

	

	public int getHealth() 
	{
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) 
	{
		this.attackDamage = attackDamage;
	}

	
	public boolean isAtPlant() 
	{
		return atPlant;
	}

	public void setAtPlant(boolean atPlant)
	{
		this.atPlant = atPlant;
	}
	
	
}
