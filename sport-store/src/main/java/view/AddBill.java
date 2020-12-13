package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class AddBill extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBill frame = new AddBill();
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
	public AddBill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(12, 12, 70, 15);
		contentPane.add(lblCode);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(104, 12, 70, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(12, 39, 70, 15);
		contentPane.add(lblDescription);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(114, 39, 195, 15);
		contentPane.add(lblNewLabel_1);
	}
}
