import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font; 
import javax.swing.*;
import java.awt.GridLayout;
import javax.swing.table.DefaultTableModel;
@SuppressWarnings("unused")
public class Statement›nfo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7144989836016598128L;
	private JPanel contentPane;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statement›nfo frame = new Statement›nfo();
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
	@SuppressWarnings("serial")
	public Statement›nfo() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		

		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 127, 80));
		panel.setBounds(0, 0, 892, 91);
		contentPane.add(panel);
		
		JLabel lblAtmManagementSystem = new JLabel("ATM MANAGEMENT SYSTEM");
		lblAtmManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAtmManagementSystem.setBounds(315, 22, 262, 13);
		panel.add(lblAtmManagementSystem);
		
		JLabel lblStatement = new JLabel("Statement");
		lblStatement.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStatement.setBounds(392, 56, 108, 25);
		panel.add(lblStatement);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 130, 870, 396);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);

		
		
        
	
	}
}
