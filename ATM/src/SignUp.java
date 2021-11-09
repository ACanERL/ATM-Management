import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	private JPanel contentPane;
    int x=0,y=0;
    private JTextField acc_number;
    private JTextField name;
    private JTextField surname;
    private JTextField pin;
    private JTextField phone;
    private JTextField email;
    private JTextArea address;
    SignUp frame;
    
    Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rst=null;
	Statement›nfo stm=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 530);
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
		panel.setBounds(0, 0, 892, 91);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAtmManagementSystem = new JLabel("ATM MANAGEMENT SYSTEM");
		lblAtmManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAtmManagementSystem.setBounds(315, 22, 262, 13);
		panel.add(lblAtmManagementSystem);
		
		JLabel lblSignUpForm = new JLabel("Sign Up Form");
		lblSignUpForm.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSignUpForm.setBounds(384, 56, 124, 25);
		panel.add(lblSignUpForm);
		
		JLabel lblNewLabel = new JLabel("Acc Number");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(71, 165, 83, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName.setBounds(71, 200, 83, 13);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("SurName");
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSurname.setBounds(71, 235, 83, 13);
		contentPane.add(lblSurname);
		
		JLabel lblAd = new JLabel("Address");
		lblAd.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAd.setBounds(71, 270, 83, 13);
		contentPane.add(lblAd);
		
		JLabel lblPin = new JLabel("Pin");
		lblPin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPin.setBounds(537, 165, 83, 13);
		contentPane.add(lblPin);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPhone.setBounds(537, 200, 83, 13);
		contentPane.add(lblPhone);
		
		JLabel mail = new JLabel("Mail");
		mail.setFont(new Font("Tahoma", Font.BOLD, 13));
		mail.setBounds(537, 235, 83, 13);
		contentPane.add(mail);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDate.setBounds(537, 270, 83, 13);
		contentPane.add(lblDate);
		
		acc_number = new JTextField();
		acc_number.setBounds(165, 163, 176, 19);
		contentPane.add(acc_number);
		acc_number.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(165, 198, 176, 19);
		contentPane.add(name);
		
		surname = new JTextField();
		surname.setColumns(10);
		surname.setBounds(165, 233, 176, 19);
		contentPane.add(surname);
		
		pin = new JTextField();
		pin.setColumns(10);
		pin.setBounds(595, 163, 176, 19);
		contentPane.add(pin);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(595, 198, 176, 19);
		contentPane.add(phone);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(595, 233, 176, 19);
		contentPane.add(email);
		
		JDateChooser date = new JDateChooser();
		date.setBounds(595, 270, 176, 19);
		contentPane.add(date);
		
		JTextArea address = new JTextArea();
		address.setBackground(SystemColor.menu);
		address.setBounds(164, 270, 177, 73);
		contentPane.add(address);
		
	
		
		
		JButton complete = new JButton("Complete");
		complete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			if(acc_number.getText().isEmpty() || name.getText().isEmpty() ||surname.getText().isEmpty()||pin.getText().isEmpty()) {
				JOptionPane.showMessageDialog(frame, "Missing Information!",
			               "", JOptionPane.ERROR_MESSAGE);
			}
			else {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
	    		    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdb","root","12345678");
	    		    PreparedStatement add=conn.prepareStatement("insert into accounttable values(?,?,?,?,?,?,?,?,?)");
	    		    
	    		    add.setInt(1,Integer.valueOf(acc_number.getText()));
	    		    add.setString(2, name.getText());
	    		    add.setString(3, surname.getText());
	    		    add.setString(4,date.getDate().toString());
	    		    add.setString(5,phone.getText());
	    		    add.setString(6, address.getText());
		            add.setString(7, email.getText());
		            add.setInt(8, 0);
		            add.setInt(9,Integer.valueOf(pin.getText()));
		            int row=add.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Success! Account has been created");
		            conn.close();
		            clear();
	    		    
				}catch(Exception ex) {
					   JOptionPane.showMessageDialog(null,ex);
				}
			}
				
			}
		});
		complete.setFont(new Font("Tahoma", Font.BOLD, 13));
		complete.setBackground(Color.WHITE);
		complete.setBounds(686, 485, 101, 21);
		contentPane.add(complete);
		
		JButton singup = new JButton("Back");
		singup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Auth auth=new Auth();
				auth.setVisible(true);
			}
		});
		singup.setFont(new Font("Tahoma", Font.BOLD, 13));
		singup.setBackground(Color.WHITE);
		singup.setBounds(686, 454, 101, 21);
		contentPane.add(singup);
		setLocationRelativeTo(null);
		
		
	
	}
	
	private void clear() {
		acc_number.setText("");
		pin.setText("");
		surname.setText("");
		name.setText("");
		email.setText("");
		phone.setText("");
		address.setText("");	
	}
}
