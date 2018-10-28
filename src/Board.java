import java.util.ArrayList;

public class Board 
{
	private int xSize;
	private int ySize;
	private ArrayList<Spot> grid;
	private Player player;
	
	public Board(int xSize, int ySize, Player player) 
	{
		this.player = player;
		this.xSize = xSize;
		this.ySize = ySize;
		int count = 0;
		
		grid = new ArrayList<Spot>();
		for(int i = 0; i < xSize; i++) 
		{
			for(int j = 0; j < ySize; j++) 
			{
				Spot s = new Spot(count, i, j, false);
				grid.add(s);
				count++;
			}
		}
	}
/**Gets the player
 * @return type Player which is a player
 */

	public Player getPlayer() {
		return player;
	}
/**Sets a player
 * @param a player of type Player
 * @return void
 */
	public void setPlayer(Player player) {
		this.player = player;
	}
/** Gets the x axis size
 * @return type int which is the horizontal size of the board
 */

	public int getxSize() 
	{
		return xSize;
	}
/** Gets the vertical size 
 * @return a type int that is vertical size of the board
 */

	
	public int getySize() 
	{
		return ySize;
	}
	
/** Placing a spot 
 * @param int values of x and y coordinate 
 * @return a Spot of a particular x and y value
 */
	public Spot spotAt(int x, int y) 
	{
		for(Spot s : this.getGrid()) 
		{
			if(s.getxCoord() == x) 
			{
				if(s.getyCoord() == y) 
				{
					return s; 
				}
			}
		}
		return null;
	}
	

/** Gets teh grid 
 * @return an ArrayList of spots that is the grid
 */
	public ArrayList<Spot> getGrid() {
		return grid;
	}
/** Sets the grid 
 * @param an ArrayList of spots that is a grid
 * @return void
 */
	public void setGrid(ArrayList<Spot> grid) {
		this.grid = grid;
	}
/** Sets the horizontal grid size 
 * @param type int that is the horizontal grid size
 * @return void
 */

	public void setxSize(int xSize) {
		this.xSize = xSize;
	}
/**sets the vertical grid size 
 * @param type int that is the vertical grid size 
 * @return void
 */
	public void setySize(int ySize) {
		this.ySize = ySize;
	}
}
