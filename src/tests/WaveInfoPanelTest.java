package tests;

import javax.swing.JTextArea;

import junit.framework.TestCase;
import view.*;

public class WaveInfoPanelTest extends TestCase {

	private WaveInfoPanel panel;

	/***
	 * Creates a new panel at the start of the testing
	 */
	protected void setUp() {
		panel = new WaveInfoPanel();
	}

	/***
	 * Tears down or destroys the panel at the end of testing
	 */
	protected void tearDown() {
		panel = null;
	}

	/***
	 * Test that every getter function with WaveInfoPanel.java does not return a
	 * null value Every value is meant to be pre-set to a value that can be changed
	 * by the user upon initial creation of the panel
	 */
	public void testNotNull() {
		assertNotNull(panel.getNzAmount());
		assertNotNull(panel.getBzAmount());
		assertNotNull(panel.getEzAmount());
	}

	/***
	 * Test the function setEzAmount()
	 */
	public void testEzSet() {
		JTextArea test = new JTextArea("2");
		panel.setEzAmount(test);
		assertEquals(2, panel.getEzAmount());
	}

	/***
	 * Test the function setNzAmount()
	 */
	public void testNzSet() {
		JTextArea test = new JTextArea("2");
		panel.setNzAmount(test);
		assertEquals(2, panel.getNzAmount());
	}

	/***
	 * Test the function setBzAmount()
	 */
	public void testBzSet() {
		JTextArea test = new JTextArea("2");
		panel.setBzAmount(test);
		assertEquals(2, panel.getBzAmount());
	}
}
