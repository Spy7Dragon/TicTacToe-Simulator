
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
	
	public String toString()
	{
		return getX() + "," + getY();
	}
}
