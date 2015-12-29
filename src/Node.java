
/*
 * keeps track of inputted x and y and the count for node array
 */
public class Node {
	
	private int x;
	private int y;
	private int count = 0;
	
	public Node(int theX, int theY)
	{
		x = theX;
		y = theY;
	}
	
	public Node()
	{
		x = 0;
		y = 0;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public void incrementCount()
	{
		count++;
	}
	
	/**
	 * checks if the node is a corner
	 * @param checkNode
	 * @return
	 */
	public boolean isCorner()
	{
		boolean corner = false;
		if (this.getX()%2 == 0 && this.getY()%2 == 0)
		{
			corner = true;
		}
		return corner;
	}
	
	public String toString()
	{
		return getX() + "," + getY();
	}
	
}
