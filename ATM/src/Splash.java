import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

public class Splash extends JFrame {

	private JPanel contentPane;
	int posx=0,posy=0;
	 JProgressBar progressBar;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splash frame = new Splash();
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
	public Splash() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 535);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(UIManager.getBorder("TextPane.border"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(e.getXOnScreen()-posx,e.getYOnScreen()-posy);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				posx=e.getX();
			      posy=e.getY();
			}
		});
		panel.setBackground(new Color(255, 127, 80));
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 140, 0)));
		panel.setBounds(0, 0, 459, 535);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AC BANK");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(175, 186, 109, 64);
		panel.add(lblNewLabel);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("C:\\Users\\Caner\\Desktop\\bank.png"));
		logo.setBounds(169, 60, 120, 116);
		panel.add(logo);
		
		
 		
	    ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\Caner\\eclipse-workspace\\ATM\\image\\bank.png").getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH));
	    logo.setIcon(imageIcon);
	    
	    progressBar = new JProgressBar();
	    progressBar.setBounds(104, 315, 250, 31);
	    panel.add(progressBar);
	    
	    Splash a=new Splash();
    	a.setVisible(true);
	    
	    try {

	    		for(int i=0;i<=100;i++) {
	    		Thread.sleep(100);
	    		a.progressBar.setValue(i);
	    	}
	    }catch(Exception e) {
	    	
	    }
	    new Auth().setVisible(true);
	    dispose();
	}
}
