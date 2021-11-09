import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings({ "serial", "unused" })
public class Balances extends JFrame {

	private JPanel contentPane;
	int balance;
	int accnum;
	JLabel Balance;
	JLabel AccountNumber;
	
	 Connection conn;
	 Statement stm1;
	 PreparedStatement pst1;
	 ResultSet rst1;
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Balances frame = new Balances();
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
	public Balances(int myaccnum) {
		accnum=myaccnum;
		getBalance();
		
		
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 405);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccountNumber = new JLabel("Account Number :");
		lblAccountNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAccountNumber.setBounds(65, 142, 146, 22);
		contentPane.add(lblAccountNumber);
		
		JLabel lblBalance = new JLabel("Balance :");
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBalance.setBounds(65, 174, 82, 22);
		contentPane.add(lblBalance);
		
		
		Balance = new JLabel("");
		Balance.setFont(new Font("Tahoma", Font.BOLD, 16));
		Balance.setBounds(150, 174, 82, 22);
		contentPane.add(Balance);
		
		
		AccountNumber = new JLabel("");
		AccountNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
		AccountNumber.setBounds(230, 142, 146, 22);
		contentPane.add(AccountNumber);
		
		
		
		Balance.setText(""+balance);
		AccountNumber.setText(""+accnum);
		
		
		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new MainMenu(accnum).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		lblBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBack.setBounds(436, 373, 54, 22);
		contentPane.add(lblBack);
		
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
		setLocationRelativeTo(null);
	}

	public Balances() {
		// TODO Auto-generated constructor stub
	}
	private void getBalance() {
		
		String sql="select*from accounttable where AccNumber='"+accnum+"'";
		
		try {
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdb","root","12345678");
			 stm1=conn.createStatement();
			 rst1=stm1.executeQuery(sql);
			 
			 if(rst1.next()) {
				 setVisible(false);
				 balance=rst1.getInt(8);
				 
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
