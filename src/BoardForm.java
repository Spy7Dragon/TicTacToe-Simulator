import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	boolean playerTurn = true;
	
	private JFrame frame;
	Board theBoard = new Board();
	/**
	 * @wbp.nonvisual location=17,539
	 */
	private final JButton btnDisableboard = new JButton("disableBoard");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoardForm window = new BoardForm();
					window.frame.setVisible(true);
					
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

	public void stopAndCheck()
	{
		if (theBoard.checkForWinner() == '\0'){
			if (!playerTurn){
				label.setText("The computer is taking its turn");
				Node thePicked = theBoard.computerMove();
				label.setText("The computer has picked " + thePicked.getX() + "," + thePicked.getY());
				theBoard.setElement('X',thePicked.getX(),thePicked.getY());
				//label.setText("The board has changed");
				setXButton(thePicked.getX(), thePicked.getY());
				//label.setText(theBoard.toString());
				playerTurn = true;
			}
		}
		else
		{
			//set label for winner
			label.setText(theBoard.checkForWinner() + " is the winner!");
			//set restart button to true
			btnRestart.setEnabled(true);
		}
	}
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
		frame = new JFrame();
		frame.setBounds(100, 100, 423, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnTopLeft = new JButton("");
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
		frame.getContentPane().add(btnTopLeft);
		
		btnTopCenter = new JButton("");
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
		frame.getContentPane().add(btnTopCenter);
		
		btnTopRight = new JButton("");
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
		frame.getContentPane().add(btnTopRight);
		
		btnMiddleLeft = new JButton("");
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
		frame.getContentPane().add(btnMiddleLeft);
		
		btnMiddleCenter = new JButton("");
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
		frame.getContentPane().add(btnMiddleCenter);
		
		btnMiddleRight = new JButton("");
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
		frame.getContentPane().add(btnMiddleRight);
		
		btnBottomLeft = new JButton("");
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
		frame.getContentPane().add(btnBottomLeft);
		
		btnBottomCenter = new JButton("");
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
		frame.getContentPane().add(btnBottomCenter);
		
		btnBottomRight = new JButton("");
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
		frame.getContentPane().add(btnBottomRight);
		
		btnRestart = new JButton("Restart");
		btnRestart.setEnabled(false);
		btnRestart.setBounds(10, 377, 89, 23);
		frame.getContentPane().add(btnRestart);
		
		label = new JLabel("");
		label.setBounds(109, 381, 290, 79);
		frame.getContentPane().add(label);	
		
	}
	
}
