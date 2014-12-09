package maze;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import java.awt.GridBagConstraints;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import java.awt.Insets;

import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Canvas;
import java.awt.Color;

/**
 * @author Team: fighting mongoose
 * this is our main class that calls all the others
 */
public class GuiWindow {
	
	JMenuItem mntmQuit;

	private JFrame frame;
	Maze maze = new Maze();
	private mapPanel map;
	private LoginScreen login = new LoginScreen();
	String[] currentPlayerInfo;
	private Database data; 
	private userChoice choice = new userChoice();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
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
		//maze = new Maze();
		frame = new JFrame();
		frame.setBounds(100, 100, 630, 405);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow][][][][][][][][][][][][][][][][]", "[][grow][][][][][][][][][]"));
		
		mapPanel map = new mapPanel();		                                             //------------- swap these 2 for edititng
		map.readMap(maze.getSizeCol(),maze.getSizeRow(),maze.visit(),maze.getPlayer());  //

		frame.getContentPane().add(map, "cell 0 0 16 10,grow");
		
		JButton btnUp = new JButton("up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{ //-------------------up
				maze.moveUp();
				frame.getContentPane().remove(map);
				map.readMap(maze.getSizeCol(),maze.getSizeRow(),maze.visit(),maze.getPlayer());
				frame.getContentPane().add(map, "cell 0 0 16 10,grow");
				frame.repaint();
				
				if(maze.won())
				{
					JOptionPane.showMessageDialog(frame, "Congragulations you won!!!");
					AudioPlayer.play("win.wav");
				}
				
				if(!maze.isWinnable())
				{
					AudioPlayer.play("lose.wav");
					JOptionPane.showMessageDialog(frame, "You Lose!!!");
					
				}
			}
		});
		
		JButton btnQuit = new JButton("quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				mntmQuit.doClick();
			}
		});
		frame.getContentPane().add(btnQuit, "cell 16 0,growx,aligny top");
		frame.getContentPane().add(btnUp, "cell 16 7,grow");
		
		JButton btnNewButton = new JButton("right");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{ //--------------right
				maze.moveRight();
				frame.getContentPane().remove(map);
				map.readMap(maze.getSizeCol(),maze.getSizeRow(),maze.visit(),maze.getPlayer());
				frame.getContentPane().add(map, "cell 0 0 16 10,grow");
				frame.repaint();
				
				if(maze.won())
				{
					JOptionPane.showMessageDialog(frame, "Congragulations you won!!!");
					AudioPlayer.play("win.wav");
				}
				
				if(!maze.isWinnable())
				{
					AudioPlayer.play("lose.wav");
					JOptionPane.showMessageDialog(frame, "You Lose!!!");
				}
			}
		});
		frame.getContentPane().add(btnNewButton, "cell 16 8,grow");
		
		JButton btnNewButton_1 = new JButton("left");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{//-------------------left
				maze.moveLeft();
				frame.getContentPane().remove(map);
				map.readMap(maze.getSizeCol(),maze.getSizeRow(),maze.visit(),maze.getPlayer());
				frame.getContentPane().add(map, "cell 0 0 16 10,grow");
				frame.repaint();
				
				if(maze.won())
				{
					JOptionPane.showMessageDialog(frame, "Congragulations you won!!!");
					AudioPlayer.play("win.wav");
				}
				
				if(!maze.isWinnable())
				{
					AudioPlayer.play("lose.wav");
					JOptionPane.showMessageDialog(frame, "You Lose!!!");
					
				}
			}
		});
		frame.getContentPane().add(btnNewButton_1, "cell 16 9,grow");
		
		JButton btnNewButton_2 = new JButton("down");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{ //-------------------------down
				maze.moveDown();
				frame.getContentPane().remove(map);
				map.readMap(maze.getSizeCol(),maze.getSizeRow(),maze.visit(),maze.getPlayer());
				frame.getContentPane().add(map, "cell 0 0 16 10,grow");
				frame.repaint();
				
				if(maze.won())
				{
					JOptionPane.showMessageDialog(frame, "Congragulations you won!!!");
					AudioPlayer.play("win.wav");
				}
				
				if(!maze.isWinnable())
				{
					AudioPlayer.play("lose.wav");
					JOptionPane.showMessageDialog(frame, "You Lose!!!");
				}
			}
		});
		frame.getContentPane().add(btnNewButton_2, "cell 16 10,grow");
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewGame = new JMenuItem("New Game");
		mntmNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  //-------------------------make a new game
			{				
				String [] p = new String[3];
				maze = new Maze();
				frame.getContentPane().remove(map);
				map.readMap(maze.getSizeCol(),maze.getSizeRow(),maze.visit(),maze.getPlayer());
				frame.getContentPane().add(map, "cell 0 0 16 10,grow");
				frame.repaint();
				login.maze = new Maze();
			}
		});
		mnFile.add(mntmNewGame);
		
		JMenuItem mntmSaveGame = new JMenuItem("Save Game");
		mntmSaveGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{//-------------------------save game
				choice.setVisible(true);
			}
		});
		
		JMenuItem mntmLoadGame = new JMenuItem("Load Game");
		mntmLoadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{ //----------------------load game
//				choice.setVisible(true);
				login = new LoginScreen();
				login.reenterPasswordTextField.setEnabled(false);//////////fix
				login.reenterLabel.setEnabled(false);
				login.setVisible(true);
			}
		});
		mnFile.add(mntmLoadGame);
		mnFile.add(mntmSaveGame);
		
		mntmQuit = new JMenuItem("Quit");
		mntmQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				data.close();
				System.exit(0);//-------------------quit
			}
		});
		mnFile.add(mntmQuit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmDatabase = new JMenuItem("database");
		mntmDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //--------------------edit database
				LoginScreen login = new LoginScreen();
				login.isAdmin = true; 
				login.setVisible(true); 
				
				//EditDatabase editdata = new EditDatabase();
				//editdata.database = data; ///fix
				//editdata.setVisible(true);
			}
		});
		mnEdit.add(mntmDatabase);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("about");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				about msg= new about();//--------------------about
				msg.setVisible(true);
			}
		});
		mnHelp.add(mntmAbout);
	}
}
