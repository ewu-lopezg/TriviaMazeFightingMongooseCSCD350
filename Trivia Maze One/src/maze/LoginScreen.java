package maze;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LoginScreen extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	private JTextField reenterTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginScreen dialog = new LoginScreen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginScreen() {
		setBounds(100, 100, 441, 242);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(12, 75, 95, 30);
		contentPanel.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(12, 106, 71, 16);
		contentPanel.add(passwordLabel);
		
		JLabel reenterLabel = new JLabel("Re-enter:");
		reenterLabel.setBounds(12, 133, 56, 16);
		contentPanel.add(reenterLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(78, 79, 331, 22);
		contentPanel.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(78, 103, 331, 22);
		contentPanel.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		reenterTextField = new JTextField();
		reenterTextField.setBounds(78, 130, 331, 22);
		contentPanel.add(reenterTextField);
		reenterTextField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						LoginScreen.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
