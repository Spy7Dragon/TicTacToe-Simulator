import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class BoardForm {
	static JButton btnTopLeft;
	static JButton btnTopCenter;
	static JButton btnTopRight;
	static JButton btnMiddleLeft;
	static JButton btnMiddleCenter;
	static JButton btnMiddleRight;
	static JButton btnBottomLeft;
	static JButton btnBottomCenter;
	static JButton btnBottomRight;
	static JButton btnRestart;
	static JLabel label;
	static boolean playerTurn = true;
	
	private JFrame frmTicTacToe;
	Board theBoard = new Board();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoardForm window = new BoardForm();
					window.frmTicTacToe.setVisible(true);
					//makes the player or computer turn random
					int turn = (int) Math.round( Math.random() * 1);
					if (turn == 0)
					{
						playerTurn = false;
						window.stopAndCheck();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BoardForm() {
		initialize();
	}

	/*
	 * stops the user to check for winner and allow the computer to make a move
	 */
	public void stopAndCheck()
	{
		char check = theBoard.checkForWinner(); //variable to check for a winner
		if (check == '\0' && !playerTurn){ //if there isn't a winner and it's the computers turn the do computer's move
				label.setText("The computer is taking its turn");
				Node thePicked = theBoard.computerMove();
				label.setText("The computer has picked " + thePicked.getX() + "," + thePicked.getY());
				theBoard.setElement('X',thePicked.getX(),thePicked.getY());
				//label.setText("The board has changed");
				setXButton(thePicked.getX(), thePicked.getY());
				//label.setText(theBoard.toString());
				check = theBoard.checkForWinner();
		}
		else if(check == 'N') //if the board is full then the board is a tie
		{
			label.setText("Tie");
			btnRestart.setEnabled(true);
		}
		else //else there is a winner
		{
			//set label for winner
			label.setText(theBoard.checkForWinner() + " is the winner!");
			//set restart button to true
			btnRestart.setEnabled(true);
		}
		if (check == '\0') //if check still nullstring after computer turn then it is player's turn
		{
			playerTurn = true;
		}
		else if (!btnRestart.isEnabled()) //else check if the computer won in the last spot
		{
			stopAndCheck();
		}
	}
	
	/*
	 * sets the letter X to the value of the button the computer choose
	 */
	public static void setXButton(int x, int y)
	{
		if (x == 0 && y == 0)
		{
			btnTopLeft.setText("X");	
		}
		if (x == 0 && y == 1)
		{
			btnTopCenter.setText("X");	
		}
		if (x == 0 && y == 2)
		{
			btnTopRight.setText("X");	
		}
		if (x == 1 && y == 0)
		{
			btnMiddleLeft.setText("X");	
		}
		if (x == 1 && y == 1)
		{
			btnMiddleCenter.setText("X");	
		}
		if (x == 1 && y == 2)
		{
			btnMiddleRight.setText("X");	
		}
		if (x == 2 && y == 0)
		{
			btnBottomLeft.setText("X");	
		}
		if (x == 2 && y == 1)
		{
			btnBottomCenter.setText("X");	
		}
		if (x == 2 && y == 2)
		{
			btnBottomRight.setText("X");	
		}	
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTicTacToe = new JFrame();
		frmTicTacToe.setTitle("Tic Tac Toe Simulator");
		frmTicTacToe.setBounds(100, 100, 423, 452);
		frmTicTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTicTacToe.getContentPane().setLayout(null);
		
		btnTopLeft = new JButton("");
		btnTopLeft.setFont(new Font("Times New Roman", Font.BOLD, 75));
		btnTopLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (theBoard.setElement('O',0,0) && playerTurn == true){
					btnTopLeft.setText("O");	
					playerTurn = false;
					stopAndCheck();
				}
			}
		});
		btnTopLeft.setBounds(10, 11, 123, 111);
		frmTicTacToe.getContentPane().add(btnTopLeft);
		
		btnTopCenter = new JButton("");
		btnTopCenter.setFont(new Font("Times New Roman", Font.BOLD, 75));
		btnTopCenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (theBoard.setElement('O',0,1) && playerTurn == true){
					btnTopCenter.setText("O");	
					playerTurn = false;
					stopAndCheck();
				}
			}
		});
		btnTopCenter.setBounds(143, 11, 123, 111);
		frmTicTacToe.getContentPane().add(btnTopCenter);
		
		btnTopRight = new JButton("");
		btnTopRight.setFont(new Font("Times New Roman", Font.BOLD, 75));
		btnTopRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (theBoard.setElement('O',0,2) && playerTurn == true){
					btnTopRight.setText("O");
					playerTurn = false;
					stopAndCheck();
				}
			}
		});
		btnTopRight.setBounds(276, 11, 123, 111);
		frmTicTacToe.getContentPane().add(btnTopRight);
		
		btnMiddleLeft = new JButton("");
		btnMiddleLeft.setFont(new Font("Times New Roman", Font.BOLD, 75));
		btnMiddleLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (theBoard.setElement('O',1,0) && playerTurn == true){
					btnMiddleLeft.setText("O");	
					playerTurn = false;
					stopAndCheck();
				}
			}
		});
		btnMiddleLeft.setBounds(10, 133, 123, 111);
		frmTicTacToe.getContentPane().add(btnMiddleLeft);
		
		btnMiddleCenter = new JButton("");
		btnMiddleCenter.setFont(new Font("Times New Roman", Font.BOLD, 75));
		btnMiddleCenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (theBoard.setElement('O',1,1) && playerTurn == true){
					btnMiddleCenter.setText("O");
					playerTurn = false;
					stopAndCheck();
				}
			}
		});
		btnMiddleCenter.setBounds(143, 133, 123, 111);
		frmTicTacToe.getContentPane().add(btnMiddleCenter);
		
		btnMiddleRight = new JButton("");
		btnMiddleRight.setFont(new Font("Times New Roman", Font.BOLD, 75));
		btnMiddleRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (theBoard.setElement('O',1,2) && playerTurn == true){
					btnMiddleRight.setText("O");
					playerTurn = false;
					stopAndCheck();
				}
			}
		});
		btnMiddleRight.setBounds(276, 133, 123, 111);
		frmTicTacToe.getContentPane().add(btnMiddleRight);
		
		btnBottomLeft = new JButton("");
		btnBottomLeft.setFont(new Font("Times New Roman", Font.BOLD, 75));
		btnBottomLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (theBoard.setElement('O',2,0) && playerTurn == true){
					btnBottomLeft.setText("O");	
					playerTurn = false;
					stopAndCheck();
				}
			}
		});
		btnBottomLeft.setBounds(10, 255, 123, 111);
		frmTicTacToe.getContentPane().add(btnBottomLeft);
		
		btnBottomCenter = new JButton("");
		btnBottomCenter.setFont(new Font("Times New Roman", Font.BOLD, 75));
		btnBottomCenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (theBoard.setElement('O',2,1) && playerTurn == true){
					btnBottomCenter.setText("O");
					playerTurn = false;
					stopAndCheck();
				}
			}
		});
		btnBottomCenter.setBounds(143, 255, 123, 111);
		frmTicTacToe.getContentPane().add(btnBottomCenter);
		
		btnBottomRight = new JButton("");
		btnBottomRight.setFont(new Font("Times New Roman", Font.BOLD, 75));
		btnBottomRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (theBoard.setElement('O',2,2) && playerTurn == true){
					btnBottomRight.setText("O");
					playerTurn = false;
					stopAndCheck();
				}
			}
		});
		btnBottomRight.setBounds(276, 255, 123, 111);
		frmTicTacToe.getContentPane().add(btnBottomRight);
		
		btnRestart = new JButton("Restart");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] args = new String[2];
				frmTicTacToe.dispose();
				playerTurn = true;
				main(args);
			}
		});
		btnRestart.setEnabled(false);
		btnRestart.setBounds(10, 377, 89, 23);
		frmTicTacToe.getContentPane().add(btnRestart);
		
		label = new JLabel("");
		label.setBounds(109, 381, 290, 23);
		frmTicTacToe.getContentPane().add(label);	
		
	}
	
}
