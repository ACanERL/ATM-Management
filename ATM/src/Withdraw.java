import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Withdraw extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	int x=0,y=0;
	private JTextField textField;
	JLabel balance;
	Connection conn;
	Statement stm1;
	PreparedStatement pst1;
	ResultSet rst1;
	int oldbalance;
	int accnumber;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdraw frame = new Withdraw();
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
	public Withdraw(int acc) {
		accnumber=acc;
		getBalance();
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 405);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
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
		lblAtmManagementSystem.setBounds(128, 22, 262, 13);
		panel.add(lblAtmManagementSystem);
		
		JLabel lblWithdraw = new JLabel("Withdraw");
		lblWithdraw.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWithdraw.setBounds(204, 100, 91, 13);
		contentPane.add(lblWithdraw);
		
		JLabel lblNewLabel = new JLabel("Your Balance :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(123, 171, 119, 13);
		contentPane.add(lblNewLabel);
		
		balance = new JLabel("Balance");
		balance.setFont(new Font("Tahoma", Font.BOLD, 14));
		balance.setBounds(252, 171, 94, 13);
		contentPane.add(balance);
	
		balance.setText(""+oldbalance);
		
		
		
		JLabel lblAmount = new JLabel("Amount :");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAmount.setBounds(123, 222, 119, 13);
		contentPane.add(lblAmount);
		
		textField = new JTextField();
		textField.setBounds(222, 218, 154, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Complete");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(210, 308, 110, 26);
		contentPane.add(btnNewButton);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty() || textField.getText().equals(0)) {
					JOptionPane.showMessageDialog(null, "Enter Valid Amount");
				}
				else if(oldbalance<Integer.valueOf(textField.getText()))
				{
					JOptionPane.showMessageDialog(null, "No Enough Balance");
				}
				else {
					String sql="Update accounttable set Balance=? where AccNumber=?";
				
					try {
						conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdb","root","12345678");
						pst1 = conn.prepareStatement(sql);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						pst1 = conn.prepareStatement(sql);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						pst1.setInt(1,oldbalance-Integer.valueOf(textField.getText()));
					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						pst1.setInt(2,accnumber);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						if(pst1.executeUpdate()==1) {
							JOptionPane.showMessageDialog(null, "Balanced Updated");
							setVisible(false);
							new MainMenu(accnumber).setVisible(true);
						}else {
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				}
				
				
			
		});
		
		
		
		
		
		JButton back = new JButton("Back");
		back.setFont(new Font("Tahoma", Font.BOLD, 12));
		back.setBackground(Color.WHITE);
		back.setBounds(210, 338, 110, 26);
		contentPane.add(back);
		
		
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				try {
					new MainMenu(accnumber).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
	}
	
	
	
	
	public Withdraw() {
		// TODO Auto-generated constructor stub
	}


	private void getBalance() {
		String sql="select*from accounttable where AccNumber='"+accnumber+"'";
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdb","root","12345678");
			stm1=conn.createStatement();
			rst1=stm1.executeQuery(sql);
			
			if(rst1.next()) {
				oldbalance=rst1.getInt(8);
			}
			 else {
				// JOptionPane.showMessageDialog(null, "Wrong Account Information.");
			 }
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
		
	
		
	}
}
