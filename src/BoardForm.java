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

	private JFrame frame;
	static Board theBoard = new Board();
	/**
	 * @wbp.nonvisual location=27,479
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		btnDisableboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (theBoard.checkForWinner() == '\0'){
					if (frame.isEnabled()){
						frame.disable();
						theBoard.computerMove();
						btnDisableboard.doClick();
					}
					else
					{
						frame.enable();
					}
				}
				else
				{
					//set label for winner
					//set restart button to true
				}
			}
		});
		frame = new JFrame();
		frame.setBounds(100, 100, 423, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JButton btnTopLeft = new JButton("");
		btnTopLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (theBoard.setElement('O',0,0)){
					btnTopLeft.setText("O");	
					btnDisableboard.doClick();
				}
			}
		});
		btnTopLeft.setBounds(10, 11, 123, 111);
		frame.getContentPane().add(btnTopLeft);
		
		final JButton btnTopCenter = new JButton("");
		btnTopCenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (theBoard.setElement('O',0,1)){
					btnTopCenter.setText("O");	
					btnDisableboard.doClick();
				}
			}
		});
		btnTopCenter.setBounds(143, 11, 123, 111);
		frame.getContentPane().add(btnTopCenter);
		
		final JButton btnTopRight = new JButton("");
		btnTopRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (theBoard.setElement('O',0,2)){
					btnTopRight.setText("O");
					btnDisableboard.doClick();
				}
			}
		});
		btnTopRight.setBounds(276, 11, 123, 111);
		frame.getContentPane().add(btnTopRight);
		
		final JButton btnMiddleLeft = new JButton("");
		btnMiddleLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (theBoard.setElement('O',1,0)){
					btnMiddleLeft.setText("O");	
					btnDisableboard.doClick();
				}
			}
		});
		btnMiddleLeft.setBounds(10, 133, 123, 111);
		frame.getContentPane().add(btnMiddleLeft);
		
		final JButton btnMiddleMiddle = new JButton("");
		btnMiddleMiddle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (theBoard.setElement('O',1,1)){
					btnMiddleMiddle.setText("O");
					btnDisableboard.doClick();
				}
			}
		});
		btnMiddleMiddle.setBounds(143, 133, 123, 111);
		frame.getContentPane().add(btnMiddleMiddle);
		
		final JButton btnMiddleRight = new JButton("");
		btnMiddleRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (theBoard.setElement('O',1,2)){
					btnMiddleRight.setText("O");
					btnDisableboard.doClick();
				}
			}
		});
		btnMiddleRight.setBounds(276, 133, 123, 111);
		frame.getContentPane().add(btnMiddleRight);
		
		final JButton btnBottomLeft = new JButton("");
		btnBottomLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (theBoard.setElement('O',2,0)){
					btnBottomLeft.setText("O");	
					btnDisableboard.doClick();
				}
			}
		});
		btnBottomLeft.setBounds(10, 255, 123, 111);
		frame.getContentPane().add(btnBottomLeft);
		
		final JButton btnBottomCenter = new JButton("");
		btnBottomCenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (theBoard.setElement('O',2,1)){
					btnBottomCenter.setText("O");
					btnDisableboard.doClick();
				}
			}
		});
		btnBottomCenter.setBounds(143, 255, 123, 111);
		frame.getContentPane().add(btnBottomCenter);
		
		final JButton btnBottomRight = new JButton("");
		btnBottomRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (theBoard.setElement('O',2,2)){
					btnBottomRight.setText("O");	
					btnDisableboard.doClick();
				}
			}
		});
		btnBottomRight.setBounds(276, 255, 123, 111);
		frame.getContentPane().add(btnBottomRight);
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.setEnabled(false);
		btnRestart.setBounds(10, 377, 89, 23);
		frame.getContentPane().add(btnRestart);
		
		JLabel label = new JLabel("");
		label.setBounds(109, 381, 290, 19);
		frame.getContentPane().add(label);	
		
	}
	
}
