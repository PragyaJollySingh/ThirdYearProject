/**
 * @author johanwesteinde
 * Test class for testing BucketZombie's methods (other than setters and getters)
 */

package tests;

import junit.framework.TestCase;

import model.*;

public class BucketZombieTest extends TestCase {

	private Player player;
	private Board board;
	private Wave wave;
//	private Spot spot;
	private BucketZombie zombie;
//	private Zombie bucketZombie;
	private int currentSpotId;
	
	
	protected void setUp() {
		//set zombie to be at spot x=0, y=9
		player = new Player(200);
		board = new Board(player);
		wave = new Wave(3, board);
//		spot = new Spot(9, 9, 0, false);
//		zombie = new BucketZombie(100, spot, board);
	}
	
	protected void tearDown() {
		player = null;
		board = null;
		wave = null;
		zombie = null;
	}
	
	/*
	 * Test moving the zombie one spot when no other zombies on the board
	 */
	public void testMoveZombie() {
		//
		for(int i = 0; i < wave.getZombies().size(); i++) {
			if(wave.getZombies().get(i) instanceof BucketZombie) {
				zombie = (BucketZombie) wave.getZombies().get(i);
				currentSpotId = zombie.getCurrentSpot().getSpotId();
			}
		}
		
		zombie.moveZombie();
		assertEquals(currentSpotId - 1, zombie.getCurrentSpot().getSpotId());
		
	}
	/**
	public void testMoveZombieWithNoDamage() {
		int startSpotId = zombie.getCurrentSpot().getSpotId();

		//move the zombie and make sure its current spot gets updated correctly
		zombie.moveZombie();
		assertEquals(zombie.getCurrentSpot().getSpotId(), startSpotId - 1);
		
		zombie.moveZombie();
		assertEquals(zombie.getCurrentSpot().getSpotId(), startSpotId - 2);
		
		//set zombie spot back to xcord = 9
		Spot startSpot = new Spot(startSpotId, Board.xSize - 1, zombie.getCurrentSpot().getyCord(), false);
		zombie.setCurrentSpot(startSpot);
	}
	
	public void testMoveZombieWithDamage() {
		int spotId = zombie.getCurrentSpot().getSpotId();
		int yspot = zombie.getCurrentSpot().getyCord();
		
		//plant a peashooter in the same row as the zombie
		Spot psSpot = new Spot(yspot*board.getxSize(), 0, yspot, false);
		PeaShooter ps = new PeaShooter(0, yspot, 50, psSpot, board, wave);
		
		//move zombie and attack with peashooter (zombie doesn't die)
		zombie.moveZombie();
		assertEquals(zombie.getCurrentSpot().getSpotId(), spotId - 1);
		ps.attackZombie();
		assertEquals(50, zombie.getHealth());
		
		//move zombie and attack with peashooter (zombie dies)
		zombie.moveZombie();
		assertEquals(zombie.getCurrentSpot().getSpotId(), spotId - 2);
		ps.attackZombie();
		assertEquals(0, zombie.getHealth());
		assertFalse(zombie.isAlive());
	}
	
	**/
}
