package model;

import java.util.ArrayList;
import java.util.Random;

public class Wave {
	private int numberZombies;
	private Board gameBoard;
	private boolean ongoing;
	private String turnDescriptionWave = "";
	private ArrayList<Zombie> zombies;
	private ArrayList<ExplosiveZombie> explosiveZombies;
	private ArrayList<BucketZombie> bucketZombies;

	public Wave(int normal, int bucket, int explosive, Board gameBoard) {
		this.ongoing = true;
		this.numberZombies = normal + bucket + explosive;
		zombies = new ArrayList<Zombie>();
		explosiveZombies = new ArrayList<ExplosiveZombie>();
		bucketZombies = new ArrayList<BucketZombie>();

		ArrayList<Integer> placeableSpotIds = new ArrayList<Integer>();
		placeableSpotIds.add(9);
		placeableSpotIds.add(19);
		placeableSpotIds.add(29);
		placeableSpotIds.add(39);
		placeableSpotIds.add(49);

		//our levels will consist of at minimum 2 zombies and will progress as follows
		//Level 1 = 2 normal zombies
		//Level 2 = 2 normal zombies and an explosive zombie
		//Level 3 = 2 normal zombies, an explosive zombie and a bucket zombie
		//From here on, only normal zombies will be added
		while(normal > 0) {
			Random rand = new Random();
			int random = rand.nextInt(5);

			// Makes normal zombies
			Zombie newZombie = new Zombie(100, gameBoard.spotAt(placeableSpotIds.get(random)), gameBoard);
			int Id = placeableSpotIds.get(random);
			Spot placedSpot = gameBoard.spotAt(Id);
			if ((newZombie != null) && (placedSpot != null)) {
				placedSpot.addSpotZombie(newZombie);
				placedSpot.setHasZombie(true);
				zombies.add(newZombie);
				normal --;
				turnDescriptionWave += "Zombie has been place at spotId: " + String.valueOf(placedSpot.getSpotId())
						+ "\n";
				System.out.println("Zombie has been placed at spotId: " + String.valueOf(placedSpot.getSpotId()));
			}
		}
		
		//make explosive zombies
		while(explosive > 0) {
			Random rand = new Random();
			int random = rand.nextInt(5);
			
			ExplosiveZombie newExplosiveZombie = new ExplosiveZombie(100, gameBoard.spotAt(placeableSpotIds.get(random)), gameBoard);
			Spot placedSpot = gameBoard.spotAt(placeableSpotIds.get(random));
			if ((newExplosiveZombie != null) && (placedSpot != null)) {
				placedSpot.addExplosiveZombie(newExplosiveZombie);
				placedSpot.setHasEZombie(true);
				explosiveZombies.add(newExplosiveZombie);
				explosive --;
				turnDescriptionWave += "Explosive Zombie has been place at spotId: "
						+ String.valueOf(placedSpot.getSpotId()) + "\n";
				System.out.println(
						"Explosive Zombie has been placed at spotId: " + String.valueOf(placedSpot.getSpotId()));
			}
		}
		// Make bucket zombies
		while(bucket > 0) {
			Random rand = new Random();
			int random = rand.nextInt(5);
			
			BucketZombie newBucketZombie = new BucketZombie(250, gameBoard.spotAt(placeableSpotIds.get(random)), gameBoard);
			Spot placedSpot = gameBoard.spotAt(placeableSpotIds.get(random));
			if ((newBucketZombie != null) && (placedSpot != null)) {
				placedSpot.addBucketZombie(newBucketZombie);
				placedSpot.setHasBZombie(true);
				bucketZombies.add(newBucketZombie);
				bucket --;
				turnDescriptionWave += "Bucket Zombie has been place at spotId: "
						+ String.valueOf(placedSpot.getSpotId()) + "\n";
				System.out.println(
						"Bucket Zombie has been placed at spotId: " + String.valueOf(placedSpot.getSpotId()));
			}
		}
	}

	public String getTurnDescriptionWave() {
		return turnDescriptionWave;
	}

	public int getNumberOfZombies() {
		return numberZombies;
	}

	public void setNumberOfZombies(int numberOfZombies) {
		this.numberZombies = numberOfZombies;
	}

	public Board getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(Board gameBoard) {
		this.gameBoard = gameBoard;
	}

	public boolean isOngoing() {
		return ongoing;
	}

	public void setOngoing(boolean ongoing) {
		this.ongoing = ongoing;
	}

	public ArrayList<Zombie> getZombies() {
		return zombies;
	}

	public void setZombies(ArrayList<Zombie> zombies) {
		this.zombies = zombies;
	}
	
	public void setExplosiveZombies(ArrayList<ExplosiveZombie> zombies) {
		this.explosiveZombies = zombies;
	}
	
	public ArrayList<ExplosiveZombie> getExplosiveZombies() {
		return explosiveZombies;
	}
	
	public void setBucketZombies(ArrayList<BucketZombie> zombies) {
		this.bucketZombies = bucketZombies;
	}
	
	public ArrayList<BucketZombie> getBucketZombies() {
		return bucketZombies;
	}
}
