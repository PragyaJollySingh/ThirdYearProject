import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Spot 
{
	private int spotId;
	private int xCoord;
	private int yCoord;
	private boolean filled;
	private boolean hasSunflower;
	private boolean hasPea;
	private boolean hasZombie;
	private Sunflower spotSunflower;
	private PeaShooter spotPeaShooter;
	private CopyOnWriteArrayList<Zombie> spotZombies;
	
	public Spot(int spotId, int xCoord, int yCoord, boolean filled) 
	{
		this.spotId = spotId;
		this.xCoord = xCoord;
		this.yCoord = yCoord; 
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
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getxCoord() 
	{
		return xCoord;
	}
	
	
	public int getyCoord() 
	{
		return yCoord;
	}
	
	public void setyCoord(int yCoo
		rd) 
	{
		this.yCoord = yCoord;
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
	
	
}
