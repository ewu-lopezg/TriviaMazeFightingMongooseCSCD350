package maze;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import java.awt.TextArea;
import java.awt.TextField;
import java.io.PrintStream;

import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

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
				words.setText(one.getPlayer().getLocation().getX() + ", " + one.getPlayer().getLocation().getY());
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
				words.setText(one.getPlayer().getLocation().getX() + ", " + one.getPlayer().getLocation().getY());
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
				words.setText(one.getPlayer().getLocation().getX() + ", " + one.getPlayer().getLocation().getY());
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
				words.setText(one.getPlayer().getLocation().getX() + ", " + one.getPlayer().getLocation().getY());
				map.setText(one.mazeString());
			}
		});
		layeredPane.add(btnRight);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 626, 25);
		layeredPane.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//---------Exit Button
				System.exit(0);//-----------------------------Exits out of the home GUI form 
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmDatabase = new JMenuItem("Database");
		mnEdit.add(mntmDatabase);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);

	}
}
