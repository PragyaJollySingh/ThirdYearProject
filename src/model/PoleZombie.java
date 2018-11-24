package model;

/***
 * A class for the Pole Zombie, that is able to jump over a plant infront oof it once
 * @author Noor
 *
 */
public class PoleZombie extends Zombie {

	private int health; 
	private int attackDamage = 20;
	private boolean atPlant;
	private boolean attacking;
	private Spot currentSpot; 
	private Board gameBoard;
	private boolean alive;
	private boolean jumped; //variable to check if the zombie has already jumped
	public  String turnDescriptionZombie = "";
	
	public PoleZombie(int health, Spot currentSpot, Board gameBoard) { 
		super(health, currentSpot, gameBoard);	
		this.alive = true;
		this.jumped = false;
	}
	
	public void setJumped(boolean jumped) {
		this.jumped = jumped;
	}
	
	public boolean getJumped() {
		return jumped;
	}
	
}
