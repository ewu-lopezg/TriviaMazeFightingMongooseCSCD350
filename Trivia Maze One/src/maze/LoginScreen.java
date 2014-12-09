package maze;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;


public class LoginScreen extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField usernameTextField;
	JLabel reenterLabel;
	private static Database database = new Database();
	GuiWindow main;
	private JPasswordField passwordField2;
	JPasswordField reenterPasswordTextField;

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
		
		reenterLabel = new JLabel("Re-enter:");
		reenterLabel.setBounds(12, 133, 56, 16);
		contentPanel.add(reenterLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(78, 79, 331, 22);
		contentPanel.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(78, 106, 331, 22);
		contentPanel.add(passwordField2);
		
		reenterPasswordTextField = new JPasswordField();
		reenterPasswordTextField.setEnabled(false);
		reenterPasswordTextField.setBounds(77, 134, 333, 22);
		contentPanel.add(reenterPasswordTextField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String[] container = new String[4];
						String password =new String(passwordField2.getPassword());
						String reenterPassword = new String(reenterPasswordTextField.getPassword());
						
						if(!reenterPasswordTextField.isEnabled())//Returned Users
						{
							if(database.checkLogginCredentials(usernameTextField.getText(), password))
							{
								//lJOptionPane.showMessageDialog(null,"Congrats you logged in");
								
								container = database.getLoadedMap(usernameTextField.getText());
								main.currentPlayerInfo = container; //--------------------Sets the arraylist with all saved questions 
								LoginScreen.this.dispose();
							}
							else{
								JOptionPane.showMessageDialog(null, "Username does not match, Please try again");
								usernameTextField.setText("");
							}
						}
						else //New users
						{
							if((usernameTextField.getText().compareTo("") == 0) || (password.compareTo("") == 0))//if either username or pw empty.
							{
								JOptionPane.showMessageDialog(null, "Please make sure there is a USERNAME and PASSWORD");
							}
							else if(password.compareTo(reenterPassword) == 0)//Check if passwords match
							{//if there is a username and pw
								container[1] = usernameTextField.getText(); 
								container[2] = password; 
								container[3] = "0";
								if(database.insertToUserTable(container))//will throw error in database side if username already exist.								
								{
									LoginScreen.this.dispose();
								}
								passwordField2.setText("");
								reenterPasswordTextField.setText("");
							}
							else{
								JOptionPane.showMessageDialog(null,"passwords do not match, please try again");
								passwordField2.setText("");
								reenterPasswordTextField.setText("");
							}
						}
					}
				});
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
