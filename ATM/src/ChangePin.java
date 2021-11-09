import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ChangePin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	int accnum;
	
	JLabel lblNewPin;
	JLabel lblConfirmPin;
	Connection conn;
	 Statement stm1;
	 PreparedStatement pst;
	 ResultSet rst1;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePin frame = new ChangePin();
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
	public ChangePin(int myaccnum) {
		
		accnum=myaccnum;
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 405);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(95, 158, 160)));
		panel.setBackground(new Color(255, 127, 80));
		panel.setBounds(0, 0, 500, 73);
		contentPane.add(panel);
		
		JLabel lblAtmManagementSystem = new JLabel("ATM MANAGEMENT SYSTEM");
		lblAtmManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAtmManagementSystem.setBounds(119, 22, 262, 13);
		panel.add(lblAtmManagementSystem);
		
		JLabel lblChangePin = new JLabel("Change Pin");
		lblChangePin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChangePin.setBounds(192, 98, 115, 22);
		contentPane.add(lblChangePin);
		
		lblNewPin = new JLabel("New Pin :");
		lblNewPin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewPin.setBounds(74, 184, 82, 22);
		contentPane.add(lblNewPin);
		
	    lblConfirmPin = new JLabel("Confirm Pin :");
		lblConfirmPin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConfirmPin.setBounds(74, 230, 105, 22);
		contentPane.add(lblConfirmPin);
		
		textField = new JTextField();
		textField.setBounds(192, 188, 145, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(192, 234, 145, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				try {
					new MainMenu(accnum).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(236, 321, 101, 21);
		contentPane.add(btnBack);
		
		JButton btnNewButton = new JButton("Complete");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(236, 290, 101, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					if(textField.getText().isEmpty()||textField_1.getText().isEmpty()) {
						 JOptionPane.showMessageDialog(null, "Enter Pin");
					}
					if(!textField.getText().equals(textField_1.getText())) {
						JOptionPane.showMessageDialog(null, "Not Match Pin and Confrim Pin");
					}
					else {
						String sql="Update accounttable set Pin=? where AccNumber=?";
						try {
							conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdb","root","12345678");
							pst = conn.prepareStatement(sql);
							pst.setInt(1,Integer.valueOf(textField.getText()));
							pst.setInt(2,accnum);
							if(pst.executeUpdate()==1) {
								JOptionPane.showMessageDialog(null, "Pin Updated");
								
							}else {
								
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
			
			}
		});
		
	}

	public ChangePin() {
		// TODO Auto-generated constructor stub
	}
	

}
