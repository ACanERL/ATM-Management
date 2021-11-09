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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FastCash extends JFrame {

	private JPanel contentPane;
	JLabel balancelbl;
	
	int accnum;
	Connection conn;
	 Statement stm1;
	 PreparedStatement pst1;
	 ResultSet rst1;
	 int balance;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FastCash frame = new FastCash();
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
	public FastCash(int myaccnum) {
		accnum=myaccnum;
		getBalance();
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 522);
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
		panel.setBounds(0, 0, 574, 73);
		contentPane.add(panel);
		
		JLabel lblAtmManagementSystem = new JLabel("ATM MANAGEMENT SYSTEM");
		lblAtmManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAtmManagementSystem.setBounds(156, 22, 262, 13);
		panel.add(lblAtmManagementSystem);
		
		JLabel lblFastcash = new JLabel("FastCash");
		lblFastcash.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFastcash.setBounds(241, 94, 91, 22);
		contentPane.add(lblFastcash);
		
		JLabel lblAmounts = new JLabel("Your Balance:");
		lblAmounts.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAmounts.setBounds(241, 151, 111, 22);
		contentPane.add(lblAmounts);
		
		balancelbl = new JLabel();
		balancelbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		balancelbl.setBounds(241, 171, 82, 22);
		contentPane.add(balancelbl);
		
		balancelbl.setText(""+balance);
		
		
		JButton btn100 = new JButton("100 $");
		btn100.setBackground(Color.WHITE);
		btn100.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn100.setBounds(134, 207, 85, 21);
		contentPane.add(btn100);
		
		
		btn100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(balance<100) {
					JOptionPane.showMessageDialog(null, "No Enough Balance");
				}
				else {
					String sql="Update accounttable set Balance=? where AccNumber=?";
				
					try {
						conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdb","root","12345678");
						pst1 = conn.prepareStatement(sql);
						pst1.setInt(1,balance-100);
						pst1.setInt(2,accnum);
						if(pst1.executeUpdate()==1) {
							JOptionPane.showMessageDialog(null, "Balanced Updated");
							
						}else {
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
			}
		});
		
		
		
		JButton btn200 = new JButton("200 $");
		btn200.setBackground(Color.WHITE);
		btn200.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn200.setBounds(134, 257, 85, 21);
		contentPane.add(btn200);
		btn200.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(balance<200) {
					JOptionPane.showMessageDialog(null, "No Enough Balance");
				}
				else {
					String sql="Update accounttable set Balance=? where AccNumber=?";
				
					try {
						conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdb","root","12345678");
						pst1 = conn.prepareStatement(sql);
						pst1.setInt(1,balance-200);
						pst1.setInt(2,accnum);
						if(pst1.executeUpdate()==1) {
							JOptionPane.showMessageDialog(null, "Balanced Updated");
							
						}else {
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
			}
		});
		
		JButton btn500 = new JButton("500 $");
		btn500.setBackground(Color.WHITE);
		btn500.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn500.setBounds(134, 307, 85, 21);
		contentPane.add(btn500);
		
		
		btn500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(balance<500) {
					JOptionPane.showMessageDialog(null, "No Enough Balance");
				}
				else {
					String sql="Update accounttable set Balance=? where AccNumber=?";
				
					try {
						conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdb","root","12345678");
						pst1 = conn.prepareStatement(sql);
						pst1.setInt(1,balance-500);
						pst1.setInt(2,accnum);
						if(pst1.executeUpdate()==1) {
							JOptionPane.showMessageDialog(null, "Balanced Updated");
							
						}else {
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
			}
		});
		
		JButton btn1000 = new JButton("1000 $");
		btn1000.setBackground(Color.WHITE);
		btn1000.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn1000.setBounds(354, 207, 85, 21);
		contentPane.add(btn1000);
		
		btn1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(balance<1000) {
					JOptionPane.showMessageDialog(null, "No Enough Balance");
				}
				else {
					String sql="Update accounttable set Balance=? where AccNumber=?";
				
					try {
						conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdb","root","12345678");
						pst1 = conn.prepareStatement(sql);
						pst1.setInt(1,balance-1000);
						pst1.setInt(2,accnum);
						if(pst1.executeUpdate()==1) {
							JOptionPane.showMessageDialog(null, "Balanced Updated");
							
						}else {
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
			}
		});
		
		JButton btn2000 = new JButton("2000 $");
		btn2000.setBackground(Color.WHITE);
		btn2000.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn2000.setBounds(354, 257, 85, 21);
		contentPane.add(btn2000);
		btn2000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(balance<2000) {
					JOptionPane.showMessageDialog(null, "No Enough Balance");
				}
				else {
					String sql="Update accounttable set Balance=? where AccNumber=?";
				
					try {
						conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdb","root","12345678");
						pst1 = conn.prepareStatement(sql);
						pst1.setInt(1,balance-2000);
						pst1.setInt(2,accnum);
						if(pst1.executeUpdate()==1) {
							JOptionPane.showMessageDialog(null, "Balanced Updated");
							
						}else {
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
			}
		});
		
		JButton btn5000 = new JButton("5000 $");
		btn5000.setBackground(Color.WHITE);
		btn5000.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn5000.setBounds(354, 307, 85, 21);
		contentPane.add(btn5000);
		
		btn5000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(balance<5000) {
					JOptionPane.showMessageDialog(null, "No Enough Balance");
				}
				else {
					String sql="Update accounttable set Balance=? where AccNumber=?";
				
					try {
						conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdb","root","12345678");
						pst1 = conn.prepareStatement(sql);
						pst1.setInt(1,balance-5000);
						pst1.setInt(2,accnum);
						if(pst1.executeUpdate()==1) {
							JOptionPane.showMessageDialog(null, "Balanced Updated");
							
						}else {
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
			}
		});
		
		
		
		
		
		
		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new MainMenu(myaccnum).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(236, 431, 101, 21);
		contentPane.add(btnBack);
	}

	public FastCash() {
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
