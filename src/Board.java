
public class Board {

	/*
	 * keeps track of the board Elements
	 */
	private char[][] boardElements;
	
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
		if (getElement(0,0) == getElement(0,1) && getElement(0,1) == getElement(0,2)){
			return getElement(0,0);
		}
		if (getElement(1,0) == getElement(1,1) && getElement(1,1) == getElement(1,2)){
			return getElement(0,0);
		}
		if (getElement(2,0) == getElement(2,1) && getElement(2,1) == getElement(2,2)){
			return getElement(0,0);
		}
		if (getElement(0,0) == getElement(1,0) && getElement(1,0) == getElement(2,0)){
			return getElement(0,0);
		}
		if (getElement(0,1) == getElement(1,1) && getElement(1,1) == getElement(2,1)){
			return getElement(0,0);
		}
		if (getElement(0,2) == getElement(1,2) && getElement(1,2) == getElement(2,2)){
			return getElement(0,0);
		}
		if (getElement(0,0) == getElement(1,1) && getElement(1,1) == getElement(2,2)){
			return getElement(0,0);
		}
		if (getElement(2,0) == getElement(1,1) && getElement(1,1) == getElement(0,2)){
			return getElement(0,0);
		}	
		return '\0';
	}
	
	public void computerMove()
	{
		
	}
}
