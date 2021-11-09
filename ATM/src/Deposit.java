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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings({ "serial", "unused" })
public class Deposit extends JFrame {

	private JPanel contentPane;
	int x=0,y=0;
	private JTextField textField;
	 Connection conn=null;
	 Statement stm;
	 PreparedStatement pst=null,pst1=null;
	 ResultSet rst1=null,rst=null;
	 int myacc;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit frame = new Deposit();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param myaccnum 
	 */
	public Deposit(int myaccnum) {
		myacc=myaccnum;
		getBalance();
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 405);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
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
		
		JLabel lblDeposit = new JLabel("Deposit");
		lblDeposit.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDeposit.setBounds(212, 99, 76, 22);
		contentPane.add(lblDeposit);
		
		JLabel lblNewLabel = new JLabel("Amount :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(93, 185, 82, 22);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(178, 189, 144, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Complete");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(219, 242, 103, 21);
		contentPane.add(btnNewButton);
		
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			if(textField.getText().isEmpty() || textField.getText().equals(0)) {
				JOptionPane.showMessageDialog(null, "Enter Valid Amount");
			}else {
				String sql="Update accounttable set Balance=? where AccNumber=?";
				try {
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdb","root","12345678");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					pst = conn.prepareStatement(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					pst.setInt(1,oldbalance+Integer.valueOf(textField.getText()));
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					pst.setInt(2,myaccnum);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					if(pst.executeUpdate()==1) {
						JOptionPane.showMessageDialog(null, "Balanced Updated");
						setVisible(false);
						new MainMenu(myaccnum).setVisible(true);
					}else {
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
		});
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Back");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				try {
					new MainMenu(myaccnum).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(435, 366, 55, 29);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 127, 80));
		panel_1.setBounds(0, 398, 500, 7);
		contentPane.add(panel_1);
	}

	public Deposit() {
		// TODO Auto-generated constructor stub
	}
	int oldbalance;
	
	private void getBalance() {
		
		String sql="select*from accounttable where AccNumber='"+myacc+"'";
		
		try {
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdb","root","12345678");
			 java.sql.Statement stm=conn.createStatement();
			 rst1=stm.executeQuery(sql);
			 
			 if(rst1.next()) {
				 setVisible(false);
				 oldbalance=rst1.getInt(8);
				
				// dispose();
				 }
		
			 else {
				 JOptionPane.showMessageDialog(null, "Wrong Account Information.");
			 }
			
			 
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
}
