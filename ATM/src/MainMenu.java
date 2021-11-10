import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import java.awt.Panel;

@SuppressWarnings({ "serial", "unused" })
public class MainMenu extends JFrame {

	 private JPanel contentPane;
	 int x=0,y=0;

	 MainMenu frame;
	 JLabel accnum;
	 static int myaccnum = 0;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu(myaccnum);
					frame.setVisible(true);
						
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	public void MainMenu(int sayi1) {
	myaccnum=sayi1;
	}	
	
	
	public MainMenu(int column1) throws SQLException {	
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 470);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x=e.getX();
			     y=e.getY();
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(e.getXOnScreen()-x,e.getYOnScreen()-y);
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		myaccnum=column1;
		
		
		JButton depositBtn = new JButton("Deposit");
		depositBtn.setBounds(279, 192, 98, 32);
		depositBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Deposit(myaccnum).setVisible(true);
				
			}
		});
		depositBtn.setBackground(Color.WHITE);
		contentPane.add(depositBtn);
		
		JButton fastcash = new JButton("FastCash");
		fastcash.setBounds(279, 241, 98, 32);
		fastcash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new FastCash(myaccnum).setVisible(true);
				
			}
		});
		fastcash.setBackground(Color.WHITE);
		contentPane.add(fastcash);
		
		JButton btnChangePin = new JButton("Change Pin");
		btnChangePin.setBounds(279, 297, 98, 32);
		btnChangePin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ChangePin(myaccnum).setVisible(true);
				
			}
		});
		btnChangePin.setBackground(Color.WHITE);
		contentPane.add(btnChangePin);
		
		JButton fastcash_1_1 = new JButton("Withdraw");
		fastcash_1_1.setBounds(400, 241, 98, 32);
		fastcash_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Withdraw(myaccnum).setVisible(true);	
			}
			
		});
		fastcash_1_1.setBackground(Color.WHITE);
		contentPane.add(fastcash_1_1);
		
		JButton fastcash_1_2 = new JButton("Mini Statment");
		fastcash_1_2.setBounds(400, 297, 98, 32);
		fastcash_1_2.setBackground(Color.WHITE);
		contentPane.add(fastcash_1_2);
		
		JButton fastcash_1_3 = new JButton("Balance");
		fastcash_1_3.setBounds(400, 192, 98, 32);
		fastcash_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Balances(myaccnum).setVisible(true);
				
				
			}
		});
		fastcash_1_3.setBackground(Color.WHITE);
		contentPane.add(fastcash_1_3);
		
		JLabel lblNewLabel_2 = new JLabel("Account Number :");
		lblNewLabel_2.setBounds(322, 70, 116, 52);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Log Out");
		lblNewLabel_4.setBounds(354, 424, 61, 19);
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new Auth().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_4);
		
		accnum = new JLabel("New label");
		accnum.setBounds(448, 91, 50, 13);
		contentPane.add(accnum);
		setLocationRelativeTo(null);
		
		
		
		
		
		Panel panel = new Panel();
		panel.setBackground(new Color(255, 127, 80));
		panel.setBounds(0, 0, 760, 64);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AC BANK");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(338, 13, 83, 18);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select Your Transaction");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(294, 41, 172, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("X");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(1);
				
				}
		});
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(739, 10, 21, 13);
		panel.add(lblNewLabel_3);
		
		
		accnum.setText(""+myaccnum);
	

	}

	

	

}
