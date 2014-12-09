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
	static Database database;
	CardLayout cl = new CardLayout(0,0);
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
	private JLabel warningLable;
	private JRadioButton rdbtnUsers;
	private JRadioButton rdbtnQuestions;
	boolean question = false; 
	static JButton refreshBtn;
	private JTable updateTable;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditDatabase frame = new EditDatabase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
	}
	public void loadTable(String tableName)
	{
		try{
			String query = "SELECT * FROM " + tableName + ";";
			
			pst = database.c.prepareStatement(query);
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));	
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public boolean isUserSelected()
	{
		if(rdbtnUsers.isSelected())
		{
			return true; 
		}
		return false; 
	}
	public boolean isQuestionSelected()
	{
		if(rdbtnQuestions.isSelected())
		{
			return true; 
		}
		return false; 
	}
	
	public void setAdminDefault()
	{
		rdbtnQuestions.setSelected(false);
		rdbtnUsers.setSelected(false); 
	}

	/**
	 * Create the frame.
	 */
	public EditDatabase() {
		setResizable(false);
		
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
		
		rdbtnUsers = new JRadioButton("Users");
		rdbtnUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnQuestions.setSelected(false);
			}
		});
		rdbtnUsers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnUsers.setBounds(196, 48, 95, 25);
		AdminMain.add(rdbtnUsers);
		
		rdbtnQuestions = new JRadioButton("Questions");
		rdbtnQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnUsers.setSelected(false);				
			}
		});
		rdbtnQuestions.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnQuestions.setBounds(295, 48, 123, 25);
		AdminMain.add(rdbtnQuestions);
		
		JButton AddBtn = new JButton("ADD");
		AddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(isQuestionSelected())
				{
					warningLable.setText("Please select a Table");
					questionTextField.setText("");
					answerTextField.setText("");
					poss1TextField.setText("");
					poss2TextField.setText("");
					poss3TextField.setText("");
					chckbxMultipleChoice.setSelected(false);
					chckbxTruefalse.setSelected(false);
					cl.show(contentPane, "name_25930192889649");
				}
				else if(isUserSelected())
				{
					JOptionPane.showMessageDialog(null, "User selected");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please select a table");
				}				
			}
		});
		AddBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		AddBtn.setBounds(75, 110, 158, 68);
		AdminMain.add(AddBtn);
		
		JButton updateBtn = new JButton("UPDATE");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQuestionSelected())
				{
					cl.show(contentPane, "name_25930192889649");
				}
				else if(isUserSelected())
				{
					JOptionPane.showMessageDialog(null, "User selected");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please select a table");
				}				
			}
		});
		updateBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		updateBtn.setBounds(286, 110, 158, 68);
		AdminMain.add(updateBtn);
		
		JButton deleteBtn = new JButton("DELETE");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(isQuestionSelected())
				{
					question = true; 
					cl.show(contentPane, "name_26062747484153");
				}
				else if(isUserSelected())
				{
					question = false; 
					cl.show(contentPane, "name_26062747484153");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please select a table");
				}
			}
		});
		deleteBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		deleteBtn.setBounds(191, 203, 150, 68);
		AdminMain.add(deleteBtn);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//database.close();////////////////////////////////////////////////remove when connect to others 
				EditDatabase.this.dispose();
			}
		});
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
					warningLable.setText("");
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
		chckbxMultipleChoice.setBounds(76, 31, 115, 39);
		add.add(chckbxMultipleChoice);
		
		chckbxTruefalse = new JCheckBox("True/False");
		chckbxTruefalse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxTruefalse.isSelected())
				{
					warningLable.setText("");
					questionTextField.setEnabled(true);
					answerTextField.setEnabled(true);
					poss1TextField.setEnabled(true);
					poss2TextField.setEnabled(true);
					poss3TextField.setEnabled(false);
					statusText.setText("True false selected");
					chckbxMultipleChoice.setSelected(false);
				}
			}
		});
		chckbxTruefalse.setBounds(204, 23, 200, 50);
		add.add(chckbxTruefalse);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			//(QUESTION,ANSWER,POSSIBLE1,POSSIBLE2,POSSIBLE3,TRUEFALSE)
			String[] container = new String[7];
			public void actionPerformed(ActionEvent e) {
				if(chckbxMultipleChoice.isSelected())//if multiple choice 
				{
					if(!(questionTextField.getText().compareTo("") == 0) && 
							!(answerTextField.getText().compareTo("") == 0) &&
							!(poss1TextField.getText().compareTo("") == 0) &&
							!(poss2TextField.getText().compareTo("") == 0) &&
							!(poss3TextField.getText().compareTo("") == 0))
					{
						container[0] = questionTextField.getText();
						container[1] = answerTextField.getText();
						container[2] = poss1TextField.getText();
						container[3] = poss2TextField.getText();
						container[4] = poss3TextField.getText();
						container[5] = "0";
						container[6] = "0";
						if(database.insertToQuestionSTable(container))
						{
							setAdminDefault();
							cl.show(contentPane, "name_25921842956592");
						}
						else{
							statusText.setText("Something went wrong");
						}
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
						container[0] = questionTextField.getText();
						container[1] = answerTextField.getText();
						container[2] = poss1TextField.getText();
						container[3] = poss2TextField.getText(); 
						container[5] = "1";
						container[6] = "0";
						if(database.insertToQuestionSTable(container))
						{
							setAdminDefault();
							cl.show(contentPane, "name_25921842956592");
						}
						else{
							statusText.setText("Something went wrong");
						}
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
		
		warningLable = new JLabel("Please select a Table");
		warningLable.setForeground(Color.RED);
		warningLable.setBounds(80, 5, 213, 32);
		add.add(warningLable);
		
		delete = new JPanel();
		contentPane.add(delete, "name_26062747484153");
		delete.setLayout(null);
		delete.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 534, 242);
		delete.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setVisible(true); 
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
			if(question)	
			{
				loadTable("QUESTIONS");
			}
			else
			{
				loadTable("USER");
			}
			}
		});
		refreshBtn.setBounds(12, 266, 99, 25);
		delete.add(refreshBtn);
		
		JLabel lblId = new JLabel("ID # : ");
		lblId.setBounds(14, 314, 43, 16);
		delete.add(lblId);
		
		idTextField = new JTextField();
		idTextField.setBounds(56, 311, 55, 22);
		delete.add(idTextField);
		idTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Please enter the ID Number of the row you wish to delete. ");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(118, 261, 372, 34);
		delete.add(lblNewLabel);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*if((table.getSelectedRow() < 0))
				{
					JOptionPane.showMessageDialog(null, "Please select a row");
				}*/
				setAdminDefault();
				cl.show(contentPane, "name_25921842956592");
			}
		});
		btnCancel.setBounds(447, 308, 99, 25);
		delete.add(btnCancel);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!(idTextField.getText().compareTo("") == 0))
				{
					JOptionPane.showMessageDialog(null, "good to go");
					if(question)
					{
						if(database.deleteOperation("QUESTIONS", idTextField.getText()))
						{
							idTextField.setText("");
							refreshBtn.doClick();
						}
						else{
							idTextField.setText("");
						}
					}
					else{
						if(database.deleteOperation("USER", idTextField.getText()))
						{
							idTextField.setText("");
							refreshBtn.doClick();
						}
						else
						{
							idTextField.setText("");
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please enter an id number");
				}
			}
		});
		btnDelete.setBounds(128, 310, 99, 25);
		delete.add(btnDelete);
		
		JPanel update = new JPanel();
		contentPane.add(update, "name_7660034415643");
		update.setLayout(null);
		
		JButton btnCancel_1 = new JButton("Cancel");
		btnCancel_1.setBounds(449, 308, 99, 25);
		update.add(btnCancel_1);
		
		updateTable = new JTable();
		updateTable.setBounds(12, 13, 536, 164);
		update.add(updateTable);
	}
}
