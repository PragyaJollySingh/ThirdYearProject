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

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getxSize() 
	{
		return xSize;
	}

	
	public int getySize() 
	{
		return ySize;
	}
	
	
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
	


	public ArrayList<Spot> getGrid() {
		return grid;
	}

	public void setGrid(ArrayList<Spot> grid) {
		this.grid = grid;
	}

	public void setxSize(int xSize) {
		this.xSize = xSize;
	}

	public void setySize(int ySize) {
		this.ySize = ySize;
	}
}
