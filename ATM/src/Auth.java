import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

@SuppressWarnings({ "serial", "unused" })
public class Auth extends JFrame {

	private JPanel contentPane;
    int x=0,y=0;
    private JTextField acc_number;
    private JPasswordField pin_code;
    String acc_num;
    
    Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rst=null;
	java.sql.Statement stm;
	public ResultSet getRst() throws SQLException {
		rst.getInt(1);
		return rst;
	}

	public void setRst(ResultSet rst) {
		this.rst = rst;
	}


	
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Auth frame = new Auth();
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
	public Auth() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 424);
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 127, 80));
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(95, 158, 160)));
		panel.setBounds(0, 0, 519, 73);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAtmManagementSystem = new JLabel("ATM MANAGEMENT SYSTEM");
		lblAtmManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAtmManagementSystem.setBounds(128, 22, 262, 13);
		panel.add(lblAtmManagementSystem);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(1);
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(496, 10, 23, 13);
		panel.add(lblNewLabel);
		
		JLabel lblLogn = new JLabel("LOGIN");
		lblLogn.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLogn.setBounds(226, 103, 67, 13);
		contentPane.add(lblLogn);
		
		JLabel lblAccNum = new JLabel("ACC NUM");
		lblAccNum.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAccNum.setBounds(59, 198, 87, 13);
		contentPane.add(lblAccNum);
		
		JLabel lblPnCode = new JLabel("PIN CODE");
		lblPnCode.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPnCode.setBounds(59, 245, 101, 13);
		contentPane.add(lblPnCode);
		
		acc_number = new JTextField();
		acc_number.setBounds(174, 195, 215, 19);
		contentPane.add(acc_number);
		acc_number.setColumns(10);
		
		pin_code = new JPasswordField();
		pin_code.setBounds(174, 240, 215, 19);
		contentPane.add(pin_code);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if(acc_number.getText().isEmpty() || pin_code.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Account Number or Pin Code Empty.");
				}
				else {
				
				String sql="select*from accounttable where AccNumber='"+acc_number.getText()+"' and Pin="+pin_code.getText()+"";
				
				try {
					 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdb","root","12345678");
					 stm=conn.createStatement();
					 rst=stm.executeQuery(sql);
					 
					 if(rst.next()) {
						 int column1=rst.getInt(1);
						 new MainMenu(column1).setVisible(true);
						
						 dispose();
						 }
				
					 else {
						 JOptionPane.showMessageDialog(null, "Wrong Account Information.");
					 }
					
					 
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			  }
				
			}
		});
		loginbtn.setBackground(Color.WHITE);
		loginbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		loginbtn.setBounds(304, 294, 85, 21);
		contentPane.add(loginbtn);
		
		JButton signupbtn = new JButton("Sign Up");
		signupbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SignUp signUp=new SignUp();
				signUp.setVisible(true);
			}
		});
		signupbtn.setBackground(Color.WHITE);
		signupbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		signupbtn.setBounds(304, 325, 85, 21);
		contentPane.add(signupbtn);
		
		JCheckBox checkbox = new JCheckBox("Show");
		checkbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkbox.isSelected()) {
					 pin_code.setEchoChar((char)0);
				}else {
					pin_code.setEchoChar('*');
				}
			}
		});
		checkbox.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkbox.setBackground(Color.WHITE);
		checkbox.setBounds(405, 239, 93, 21);
		contentPane.add(checkbox);
		setLocationRelativeTo(null);
		
		
		
		
	}
}
