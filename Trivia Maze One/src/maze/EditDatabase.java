package maze;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EditDatabase extends JFrame {

	private JPanel contentPane;
	private JPanel add; 
	private JPanel delete; 
	private JPanel AdminMain; 
	private JTable table;
	private static Database database = new Database();
	CardLayout cl = new CardLayout(0,0);
	private static Connection connection = null;
	ResultSet rs = null; 
	PreparedStatement pst = null; 
	private JTextField questionTextField;
	private JTextField answerTextField;
	private JTextField poss1TextField;
	private JTextField poss2TextField;
	private JTextField poss3TextField;
	private JTextField idTextField;
	private JCheckBox chckbxMultipleChoice;
	private JCheckBox chckbxTruefalse;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditDatabase frame = new EditDatabase();
					frame.setVisible(true);
					connection = database.dbConnection();
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
	}
	private void UpdateTable()
	{
		
	}
	/**
	 * Create the frame.
	 */
	public EditDatabase() {
		//connection = database.dbConnection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(cl); 	//cardlayout
		contentPane.setVisible(true);
		
		AdminMain = new JPanel();
		contentPane.add(AdminMain, "name_25921842956592");
		AdminMain.setLayout(null);
		AdminMain.setVisible(false);  
		
		cl.show(contentPane, "name_26062747484153");
		
		JLabel lblTables = new JLabel("Tables: ");
		lblTables.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTables.setBounds(104, 52, 69, 16);
		AdminMain.add(lblTables);
		
		JRadioButton rdbtnUsers = new JRadioButton("Users");
		rdbtnUsers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnUsers.setBounds(196, 48, 95, 25);
		AdminMain.add(rdbtnUsers);
		
		JRadioButton rdbtnQuestions = new JRadioButton("Questions");
		rdbtnQuestions.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnQuestions.setBounds(295, 48, 123, 25);
		AdminMain.add(rdbtnQuestions);
		
		JButton AddBtn = new JButton("ADD");
		AddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(contentPane, "name_25930192889649");
			}
		});
		AddBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		AddBtn.setBounds(75, 110, 158, 68);
		AdminMain.add(AddBtn);
		
		JButton updateBtn = new JButton("UPDATE");
		updateBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		updateBtn.setBounds(286, 110, 158, 68);
		AdminMain.add(updateBtn);
		
		JButton deleteBtn = new JButton("DELETE");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(contentPane, "name_26062747484153");
				
			}
		});
		deleteBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		deleteBtn.setBounds(191, 203, 150, 68);
		AdminMain.add(deleteBtn);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBounds(447, 306, 99, 25);
		AdminMain.add(btnNewButton);
		
		add = new JPanel();
		contentPane.add(add, "name_25930192889649");
		add.setLayout(null);
		add.setVisible(false);
		
		JLabel lblTables_1 = new JLabel("Tables");
		lblTables_1.setBounds(12, 13, 56, 16);
		add.add(lblTables_1);
		
		JLabel lblQuestion = new JLabel("Question : ");
		lblQuestion.setBounds(12, 79, 93, 32);
		add.add(lblQuestion);
		
		questionTextField = new JTextField();
		questionTextField.setEnabled(false);
		questionTextField.setBounds(76, 84, 470, 22);
		add.add(questionTextField);
		questionTextField.setColumns(10);
		
		JLabel lblAnswer = new JLabel("Answer : ");
		lblAnswer.setBounds(12, 124, 56, 16);
		add.add(lblAnswer);
		
		answerTextField = new JTextField();
		answerTextField.setEnabled(false);
		answerTextField.setBounds(76, 119, 470, 22);
		add.add(answerTextField);
		answerTextField.setColumns(10);
		
		JLabel lblPossible = new JLabel("A :");
		lblPossible.setBounds(46, 153, 22, 16);
		add.add(lblPossible);
		
		poss1TextField = new JTextField();
		poss1TextField.setEnabled(false);
		poss1TextField.setBounds(76, 154, 470, 22);
		add.add(poss1TextField);
		poss1TextField.setColumns(10);
		
		JLabel lblB = new JLabel("B : ");
		lblB.setBounds(46, 182, 22, 16);
		add.add(lblB);
		
		JLabel lblC = new JLabel("C : ");
		lblC.setBounds(46, 211, 22, 16);
		add.add(lblC);
		
		poss2TextField = new JTextField();
		poss2TextField.setEnabled(false);
		poss2TextField.setBounds(76, 179, 470, 22);
		add.add(poss2TextField);
		poss2TextField.setColumns(10);
		
		poss3TextField = new JTextField();
		poss3TextField.setEnabled(false);
		poss3TextField.setBounds(76, 208, 470, 22);
		add.add(poss3TextField);
		poss3TextField.setColumns(10);
		
		JLabel statusText = new JLabel("");
		statusText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		statusText.setForeground(Color.RED);
		statusText.setBounds(12, 240, 534, 58);
		add.add(statusText);
		
		chckbxMultipleChoice = new JCheckBox("Multiple Choice ");
		chckbxMultipleChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxMultipleChoice.isSelected())
				{
					questionTextField.setEnabled(true);
					answerTextField.setEnabled(true);
					poss1TextField.setEnabled(true);
					poss2TextField.setEnabled(true);
					poss3TextField.setEnabled(true);
					statusText.setText("Multiple selected");
					chckbxTruefalse.setSelected(false);
				}
			}
		});
		chckbxMultipleChoice.setBounds(70, 23, 115, 50);
		add.add(chckbxMultipleChoice);
		
		chckbxTruefalse = new JCheckBox("True/False");
		chckbxTruefalse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxTruefalse.isSelected())
				{
					questionTextField.setEnabled(true);
					answerTextField.setEnabled(true);
					poss1TextField.setEnabled(true);
					poss2TextField.setEnabled(true);
					statusText.setText("True false selected");
					chckbxMultipleChoice.setSelected(false);
				}
			}
		});
		chckbxTruefalse.setBounds(204, 23, 200, 50);
		add.add(chckbxTruefalse);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxMultipleChoice.isSelected())//if multiple choice 
				{
					if(!(questionTextField.getText().compareTo("") == 0) && 
							!(answerTextField.getText().compareTo("") == 0) &&
							!(poss1TextField.getText().compareTo("") == 0) &&
							!(poss2TextField.getText().compareTo("") == 0) &&
							!(poss3TextField.getText().compareTo("") == 0))
					{
						JOptionPane.showMessageDialog(null, "Great all completed");
						cl.show(contentPane, "name_25921842956592");
					}
					else{
						JOptionPane.showMessageDialog(null,"Please make sure all fields are filled out");
					}
				}
				else if(chckbxTruefalse.isSelected())//if true / false
				{
					if(!(questionTextField.getText().compareTo("") == 0) && 
							!(answerTextField.getText().compareTo("") == 0) &&
							!(poss1TextField.getText().compareTo("") == 0) &&
							!(poss2TextField.getText().compareTo("") == 0))
					{
						JOptionPane.showMessageDialog(null, "Great all completed");
						cl.show(contentPane, "name_25921842956592");
					}
					else{
						JOptionPane.showMessageDialog(null,"Please make sure all fields are filled out");
					}
				}
				else{
					
				}
			}
		});
		btnSubmit.setBounds(447, 306, 99, 25);
		add.add(btnSubmit);
		
		delete = new JPanel();
		contentPane.add(delete, "name_26062747484153");
		delete.setLayout(null);
		delete.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 534, 193);
		delete.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setVisible(true); 
		
		JButton refreshBtn = new JButton("Refresh");
		refreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Database database = new Database();
				try{
					String query = "SELECT * FROM USER";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));		
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		refreshBtn.setBounds(12, 212, 99, 25);
		delete.add(refreshBtn);
		
		JLabel lblId = new JLabel("ID # : ");
		lblId.setBounds(256, 272, 43, 16);
		delete.add(lblId);
		
		idTextField = new JTextField();
		idTextField.setBounds(298, 269, 55, 22);
		delete.add(idTextField);
		idTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Please enter the ID Number of the row you wish to delete. ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(111, 219, 372, 34);
		delete.add(lblNewLabel);
		
		JPanel blah = new JPanel();
		contentPane.add(blah, "name_7660034415643");
		blah.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(65, 164, 56, 16);
		blah.add(lblNewLabel_1);
	}
}
