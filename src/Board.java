import java.util.ArrayList;

public class Board {

	/*
	 * keeps track of the board Elements
	 */
	private char[][] boardElements;
	ArrayList<Node[]> winConditions = new ArrayList<Node[]>(); 
	
	
	public Board()
	{
		boardElements = new char[3][3];
		
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				boardElements[i][j] = ' ';
			}
		}
		Node[] topRow = {new Node(0,0), new Node(0,1), new Node(0,2)};
		winConditions.add(topRow);
		Node[] middleRow = {new Node(1,0), new Node(1,1), new Node(1,2)};
		winConditions.add(middleRow);
		Node[] bottomRow = {new Node(2,0), new Node(2,1), new Node(2,2)};
		winConditions.add(bottomRow);
		Node[] leftColumn = {new Node(0,0), new Node(1,0), new Node(2,0)};
		winConditions.add(leftColumn);
		Node[] middleColumn = {new Node(0,1), new Node(1,1), new Node(2,1)};
		winConditions.add(middleColumn);
		Node[] rightColumn = {new Node(0,2), new Node(1,2), new Node(2,2)};
		winConditions.add(rightColumn);
		Node[] downSlope = {new Node(0,0), new Node(1,1), new Node(2,2)};
		winConditions.add(downSlope);
		Node[] upSlope = {new Node(2,0), new Node(1,1), new Node(0,2)};
		winConditions.add(upSlope);		
	}
	
	public char getElement(int x, int y)
	{
		if (x >= 0 && x < 3 && y >=0 && y < 3){
			return boardElements[x][y];
		}
		else
		{
			return ' ';
		}
	}
	
	public boolean setElement(char element, int x, int y)
	{
		if (x >= 0 && x < 3 && y >=0 && y < 3 && getElement(x,y) == ' ')
		{
			boardElements[x][y] = element;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public char checkForWinner()
	{
		boolean elementsLeft = false;
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (getElement(i,j) == ' ')
				{
					elementsLeft= true;
				}
			}
		}
		if (!elementsLeft)
		{
			return 'N';
		}
		if (getElement(0,0) != ' ' && getElement(0,0) == getElement(0,1) && getElement(0,1) == getElement(0,2)){
			return getElement(0,0);
		}
		if (getElement(1,0) != ' ' && getElement(1,0) == getElement(1,1) && getElement(1,1) == getElement(1,2)){
			return getElement(1,0);
		}
		if (getElement(2,0) != ' ' && getElement(2,0) == getElement(2,1) && getElement(2,1) == getElement(2,2)){
			return getElement(2,0);
		}
		if (getElement(0,0) != ' ' && getElement(0,0) == getElement(1,0) && getElement(1,0) == getElement(2,0)){
			return getElement(0,0);
		}
		if (getElement(0,1) != ' ' && getElement(0,1) == getElement(1,1) && getElement(1,1) == getElement(2,1)){
			return getElement(0,1);
		}
		if (getElement(0,2) != ' ' && getElement(0,2) == getElement(1,2) && getElement(1,2) == getElement(2,2)){
			return getElement(0,2);
		}
		if (getElement(0,0) != ' ' && getElement(0,0) == getElement(1,1) && getElement(1,1) == getElement(2,2)){
			return getElement(0,0);
		}
		if (getElement(2,0) != ' ' && getElement(2,0) == getElement(1,1) && getElement(1,1) == getElement(0,2)){
			return getElement(2,0);
		}	
		return '\0';
	}
	
	public Node computerMove()
	{
		//check for O on board
		NodeArray blocks = new NodeArray();
		
		Node emptyOne = new Node();
		Node emptyTwo = new Node();
		boolean found = false;
		Node picked = new Node();
		int current = 0;
		Node[] temp = new Node[3];
		//check for computer win conditions
		
		for (int i = 0; i < 8 && !found; i++)
		{
			current = 0;
			temp = winConditions.get(i);
			System.out.println("The win condition being evaluated is ");
			for (int r = 0; r < temp.length; r++){
				System.out.print(temp[r] + " ");
			}
			System.out.println();
			
			emptyOne = null;
			for (int j = 0; j < 3; j++)
			{
				int x = temp[j].getX();
				int y = temp[j].getY();
				if (getElement(x,y) == 'X')
				{
					current++;
				}
				else
				{
					if (emptyOne == null){
						emptyOne = temp[j];
					}
				}	
			}
			if (current == 2 && getElement(emptyOne.getX(), emptyOne.getY()) == ' ')
			{
				picked = emptyOne;
				found = true;
			}
		}
		
		// check for human player win conditions
		for (int i = 0; i < 8 && !found; i++)
		{
			current = 0;
			temp = winConditions.get(i);
			System.out.print("The win condition being evaluated is ");
			for (int r = 0; r < temp.length; r++){
				System.out.print(temp[r] + " ");
			}
			System.out.println();
			
			emptyOne = null;
			emptyTwo = null;
			for (int j = 0; j < 3; j++)
			{ 
				int x = temp[j].getX();
				int y = temp[j].getY();
				if (getElement(x,y) == 'O')
				{
					current++;
				}
				else
				{
					if (emptyOne == null){
						emptyOne = temp[j];
					}
					else
					{
						emptyTwo = temp[j];
					}	
				}
			}
			if (current == 2 && getElement(emptyOne.getX(), emptyOne.getY()) == ' ')
			{
				picked = emptyOne;
				found = true;
			}
			else if (current == 1)
			{
				if (getElement(1,1) == ' ')
				{
					picked = new Node(1,1);
					found = true;
				}
				else 
				{
					if (emptyOne != null)
					{
						System.out.println(emptyOne + " is added to blocks");
						blocks.add(emptyOne);
						System.out.println(blocks.toString());
					}
					if (emptyTwo != null)
					{
						System.out.println(emptyTwo + " is added to blocks");
						blocks.add(emptyTwo);
						System.out.println(blocks.toString());
					}
				}
			}
		}
		
		while (!found){
			picked = blocks.returnHighCollision();
			if (getElement(picked.getX(), picked.getY()) != ' ')
			{
				blocks.delete(picked);
			}
			else
			{
				found = true;
			}
		}
		
		System.out.println(blocks.toString());
		return picked;
	}
	
	public String toString()
	{
		String board = "The board looks like \n" + getElement(0,0) + getElement(0,1) + getElement(0,2) + "\r\n"
	+ getElement(1,0) + getElement(1,1) + getElement (1,2) + "\r\n" 
				+ getElement(2,0) + getElement(2,1) + getElement(2,2);
		return board;	
	}
}
