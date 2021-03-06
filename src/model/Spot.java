package model;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Spot 
{
	private int spotId;
	private int xCord;
	private int yCord;
	private boolean filled;
	private boolean hasSunflower;
	private boolean hasPea;
	private boolean hasZombie;
	private Sunflower spotSunflower;
	private PeaShooter spotPeaShooter;
	private CopyOnWriteArrayList<Zombie> spotZombies;
	
	public Spot(int spotId, int xCord, int yCord, boolean filled) 
	{
		this.spotId = spotId;
		this.xCord = xCord;
		this.yCord = yCord; 
		this.filled = filled; 
		this.hasSunflower = false;
		this.hasPea = false;
		this.spotPeaShooter = null;
		this.spotSunflower = null;
		spotZombies = new CopyOnWriteArrayList<Zombie>();
	}
	
	public boolean isHasSunflower() {
		return hasSunflower;
	}

	public void setHasSunflower(boolean hasSunflower) {
		this.hasSunflower = hasSunflower;
	}

	public boolean isHasPea() {
		return hasPea;
	}

	public void setHasPea(boolean hasPea) {
		this.hasPea = hasPea;
	}

	public Sunflower getSpotSunflower() {
		return spotSunflower;
	}

	public void setSpotSunflower(Sunflower spotSunflower) {
		this.spotSunflower = spotSunflower;
	}

	public PeaShooter getSpotPeaShooter() {
		return spotPeaShooter;
	}

	public void setSpotPeaShooter(PeaShooter spotPeaShooter) {
		this.spotPeaShooter = spotPeaShooter;
		System.out.println("Spot sunflower placed at spotID: " + Integer.toString(spotId));
	}

	public void setxCord(int xCord) {
		this.xCord = xCord;
	}

	public int getxCord() 
	{
		return xCord;
	}
	
	
	public int getyCord() 
	{
		return yCord;
	}
	
	public void setyCord(int yCord) 
	{
		this.yCord = yCord;
	}
	
	public boolean isFilled() 
	{
		return filled;
	}
	
	public void setFilled(boolean filled)
	{
		this.filled = filled;
	}
	
	public void addSpotZombie(Zombie zombie) 
	{
		spotZombies.add(zombie);
	}
	
	public Zombie getFirstZombie() 
	{
		return spotZombies.get(0);
	}
	
	public boolean hasNoZombies() 
	{
		return spotZombies.isEmpty();
	}
	
	public void killFirstZombie() 
	{
		spotZombies.remove(0);
	}
	
	public void zombieEatsPlant() 
	{
		this.filled = false;
		if(this.hasSunflower) 
		{
			this.spotSunflower = null;
			this.hasSunflower  = false;
		}
		else 
		{
			this.spotPeaShooter = null;
			this.hasPea = false;
		}
	}

	public int getSpotId() {
		return spotId;
	}

	public void setSpotId(int spotId) {
		this.spotId = spotId;
	}

	public boolean isHasZombie() {
		return hasZombie;
	}

	public void setHasZombie(boolean hasZombie) {
		this.hasZombie = hasZombie;
	}

	public CopyOnWriteArrayList<Zombie> getSpotZombies() {
		return spotZombies;
	}

	public void setSpotZombies(CopyOnWriteArrayList<Zombie> spotZombies) 
	{
		this.spotZombies = spotZombies;
	}
	
	public String toString() 
	{
		return "Spot ID: " + Integer.toString(spotId) + "\n" +
				"X Cordinate: " + Integer.toString(xCord) + "\n" +
				"Y Cordinate: " + Integer.toString(yCord) + "\n" +
				"Is Filled: " + String.valueOf(filled)+ "\n" +
				"Has a PeaShooter: " + String.valueOf(hasPea)+ "\n" +
				"Has a Sunflower: " + String.valueOf(hasSunflower)+ "\n" +
				"Has at least one Zombie: " + String.valueOf(hasZombie)+ "\n" +
				"Number of Zombies: " + Integer.toString(spotZombies.size());
		
	}
	
	
}