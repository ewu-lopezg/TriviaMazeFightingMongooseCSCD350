package maze;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import java.awt.Font;

public class about extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					about frame = new about();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public about() {
		setResizable(false);
		setFont(new Font("Dialog", Font.PLAIN, 10));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 506, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrObjectiveaPlayer = new JTextArea();
		txtrObjectiveaPlayer.setLineWrap(true);
		txtrObjectiveaPlayer.setEditable(false);
		txtrObjectiveaPlayer.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtrObjectiveaPlayer.setText("objective:\r\n\t-a player wins if they can move thier character(blue circle) to the exit(green circle)\r\n\t- a player loses if they are no longer able to reach the exit\r\n\t-walls and locked doors(red highlited) are not passable were open doors(green higlighted) are\r\n\t-a player opens a closed door by answering a question correctly, if they anwer wrong or try to exit the quetion that door will lock.\r\n\t-a player can save thier progress to a new or existing user under file -> save\r\n\t-a player can load from an existing user under file->load\r\n\t");
		txtrObjectiveaPlayer.setBounds(0, 0, 500, 211);
		contentPane.add(txtrObjectiveaPlayer);
	}
}
