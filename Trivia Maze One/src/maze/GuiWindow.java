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

public class GuiWindow {

	private JFrame frame;
	private Maze maze;
	private mapPanel map;

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
		maze = new Maze();
		frame = new JFrame();
		frame.setBounds(100, 100, 630, 405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow][][][][][][][][][][][][][][][][]", "[grow][][][][][][][][][]"));
		
		mapPanel map = new mapPanel();		                                             //------------- swap these 2 for edititng
		map.readMap(maze.getSizeCol(),maze.getSizeRow(),maze.visit(),maze.getPlayer());  //
//		map = new JPanel();                                                              // for this one
		map.setBackground(Color.GRAY);
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
					JOptionPane.showMessageDialog(frame, "Congragulations you won!!!");//you win pannel
				
				if(!maze.isWinnable())
					JOptionPane.showMessageDialog(frame, "You Lose!!!");//-not working
			}
		});
		frame.getContentPane().add(btnUp, "cell 16 6,grow");
		
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
					JOptionPane.showMessageDialog(frame, "Congragulations you won!!!");//you win pannel
				
				if(!maze.isWinnable())
					JOptionPane.showMessageDialog(frame, "You Lose!!!");//-not working
			}
		});
		frame.getContentPane().add(btnNewButton, "cell 16 7,grow");
		
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
					JOptionPane.showMessageDialog(frame, "Congragulations you won!!!");//you win pannel
				
				if(!maze.isWinnable())
					JOptionPane.showMessageDialog(frame, "You Lose!!!");//-not working
			}
		});
		frame.getContentPane().add(btnNewButton_1, "cell 16 8,grow");
		
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
					JOptionPane.showMessageDialog(frame, "Congragulations you won!!!");//you win pannel
				
				if(!maze.isWinnable())
					JOptionPane.showMessageDialog(frame, "You Lose!!!");//-not working
			}
		});
		frame.getContentPane().add(btnNewButton_2, "cell 16 9,grow");
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("file");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewGame = new JMenuItem("new game");
		mntmNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  //-------------------------make a new game
			{
				String [] p = new String[3];
				maze = new Maze();
				frame.getContentPane().remove(map);
				map.readMap(maze.getSizeCol(),maze.getSizeRow(),maze.visit(),maze.getPlayer());
				frame.getContentPane().add(map, "cell 0 0 16 10,grow");
				frame.repaint();
			}
		});
		mnFile.add(mntmNewGame);
		
		JMenuItem mntmSaveGame = new JMenuItem("save game");
		mntmSaveGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//-------------------------save game
			}
		});
		mnFile.add(mntmSaveGame);
		
		JMenuItem mntmLoadGame = new JMenuItem("load game");
		mntmLoadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //----------------------load game
			}
		});
		mnFile.add(mntmLoadGame);
		
		JMenuItem mntmQuit = new JMenuItem("quit");
		mntmQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //-------------------quit
			}
		});
		mnFile.add(mntmQuit);
		
		JMenu mnEdit = new JMenu("edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmDatabase = new JMenuItem("database");
		mntmDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //--------------------edit database
			}
		});
		mnEdit.add(mntmDatabase);
		
		JMenu mnHelp = new JMenu("help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("about");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //--------------------about
			}
		});
		mnHelp.add(mntmAbout);
	}
}
