package maze;

import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;



public class GuiWindow {

	private JFrame frame;
	private static Maze one;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				one = new Maze();
				try {
					GuiWindow window = new GuiWindow();
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
	public GuiWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 642, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 626, 363);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(null);

		
		final TextField words = new TextField();
		words.setBounds(108, 56, 143, 23);
		layeredPane.add(words);
		
		
		final JTextArea map = new JTextArea();
		map.setBounds(39, 128, 331, 198);
		map.setText(one.mazeString());
		layeredPane.add(map);
		map.setText(one.mazeString());
		
		
		JButton btnUp_1 = new JButton("up");
		btnUp_1.setBounds(515, 194, 89, 23);
		btnUp_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				one.moveUp();//-----------------------------------------------------move up
				words.setText(one.one.getLocation().getX() + ", " + one.one.getLocation().getY());
				map.setText(one.mazeString());
			}
		});
		layeredPane.add(btnUp_1);
		
		JButton btnDown = new JButton("down");
		btnDown.setBounds(515, 228, 89, 23);
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				one.moveDown();//-----------------------------------------------------move down
				words.setText(one.one.getLocation().getX() + ", " + one.one.getLocation().getY());
				map.setText(one.mazeString());
			}
		});
		layeredPane.add(btnDown);
		
		JButton btnLeft = new JButton("left");
		btnLeft.setBounds(515, 262, 89, 23);
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				one.moveLeft();//----------------------------------------------------left
				words.setText(one.one.getLocation().getX() + ", " + one.one.getLocation().getY());
				map.setText(one.mazeString());
			}
		});
		layeredPane.add(btnLeft);
		
		JButton btnRight = new JButton("right");
		btnRight.setBounds(515, 296, 89, 23);
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				one.moveRight();//-------------------------------------------------right
				words.setText(one.one.getLocation().getX() + ", " + one.one.getLocation().getY());
				map.setText(one.mazeString());
			}
		});
		layeredPane.add(btnRight);
	
	}
}

