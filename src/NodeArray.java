import java.util.ArrayList;

public class NodeArray {

	private ArrayList<Node> structure = new ArrayList<Node>();

	public NodeArray()
	{
		
	}
	
	public void add(Node toAdd)
	{
		boolean add = true;
		for (int i = 0; i < structure.size(); i++)
		{
			if(toAdd.getX() == structure.get(i).getX() && toAdd.getY() == structure.get(i).getY())
			{
				System.out.println(toAdd.toString() + " is equal to " + structure.get(i).toString());
				structure.get(i).incrementCount();
				add = false;
				System.out.println("Collision occurred");
			}
		}
		if (add)
		{
			structure.add(toAdd);
			structure.get(structure.size()-1).incrementCount();
		}
	}
	
	public Node returnHighCollision()
	{
		Node toReturn = structure.get(0);
		for (int i = 0; i < structure.size(); i++)
		{
			if (structure.get(i).getCount() > 1)
			{
				toReturn = structure.get(i);
			}
			else if (isCorner(structure.get(i)) && toReturn.getCount() == structure.get(i).getCount())
			{
				toReturn = structure.get(i);
			}
		}
		return toReturn;
	}
	
	public void delete(Node toDelete)
	{
		if (structure.contains(toDelete)){
			structure.remove(toDelete);
		}
	}
	
	public boolean isCorner(Node checkNode)
	{
		boolean corner = false;
		if (checkNode.getX()%2 == 0 && checkNode.getY()%2 == 0)
		{
			corner = true;
		}
		return corner;
	}
	public String toString()
	{
		String array = new String();
		array = "There are " + structure.size() + " blocks ";
		for (int i = 0; i < structure.size(); i++)
		{
			array += structure.get(i).toString() + " ";
		}
		return array;
	}
}
