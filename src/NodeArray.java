import java.util.ArrayList;

public class NodeArray {

	ArrayList<Node> structure = new ArrayList<Node>();

	public NodeArray()
	{
		
	}
	
	public void add(Node toAdd)
	{
		for (int i = 0; i < structure.size(); i++)
		{
			if(toAdd.getX() == structure.get(i).getX() && toAdd.getX() == structure.get(i).getX())
			{
				structure.get(i).incrementCount();
			}
			else
			{
				structure.add(toAdd);
				structure.get(structure.size()-1).incrementCount();
			}
		}
	}
	
	public Node returnHighCollision()
	{
		Node toReturn = new Node();
		for (int i = 0; i < structure.size(); i++)
		{
			if (structure.get(i).getCount() > toReturn.getCount())
			{
				toReturn = structure.get(i);
			}
		}
		return toReturn;
	}
	
	public String toString()
	{
		String array = new String();
		array = "The blocks are ";
		for (int i = 0; i < structure.size(); i++)
		{
			array += structure.get(i).getX() + "," + structure.get(i).getY() + " ";
		}
		return array;
	}
}
