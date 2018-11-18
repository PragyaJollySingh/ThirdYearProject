/**
 * @author johanwesteinde
 * Test class for testing Wave's methods (other than setters and getters)
 */

package model;

import junit.framework.TestCase;

public class WaveTest extends TestCase {

	private Player player;
	private Board board;
	private Wave wave;
	private Zombie zombie;
	
	
	protected void setUp() {
		//create a new 5X10 board and create a new wave with one zombie
		player = new Player(200);
		board = new Board(player);
		wave = new Wave(1, board);
		zombie = wave.getZombies().get(0);
	}
	
	protected void tearDown() {
		player = null;
		board = null;
		wave = null;
		zombie = null;
	}
	
	public void testZombiesList() {
		//ensure that the correct zombie was added to the wave
		assertEquals(1, wave.getNumberOfZombies());
		assertEquals(zombie, wave.getZombies().get(0));
	}
	
	//testing of killing a zombie and its effects on the wave are done in the PeaShooter test class
}
