package view;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.EventQueue;


public class Login extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCode;
	private JPasswordField textFieldPassword;
	private JButton buttonLogin;
	private JButton buttonReset;
	

	public Login() {
		setBackground(new Color(95, 158, 160));
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("C\u1EECA H\u00C0NG C\u01AF\u1EDCNG L\u1EE2I");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 368);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ImageLogin = new JLabel("");
		ImageLogin.setIcon(new ImageIcon("/home/cuong/git/java/iconlogin.jpg"));
		ImageLogin.setBounds(22, 39, 225, 225);
		contentPane.add(ImageLogin);
		
		JLabel lableCode = new JLabel("CODE");
		lableCode.setFont(new Font("Tahoma", Font.BOLD, 14));
		lableCode.setBounds(280, 39, 46, 14);
		contentPane.add(lableCode);
		
		JLabel labelPassword = new JLabel("PASSWORD");
		labelPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelPassword.setBounds(257, 80, 92, 14);
		contentPane.add(labelPassword);
		
		textFieldCode = new JTextField();
		textFieldCode.setBounds(359, 36, 121, 29);
		contentPane.add(textFieldCode);
		textFieldCode.setColumns(10);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(359, 77, 121, 29);
		contentPane.add(textFieldPassword);
		
		buttonLogin = new JButton("LOGIN");
		buttonLogin.setBackground(new Color(176, 224, 230));
		buttonLogin.setBounds(369, 161, 89, 42);
		contentPane.add(buttonLogin);
		
		buttonReset = new JButton("RESET");
		buttonReset.setBackground(new Color(176, 224, 230));
		buttonReset.setBounds(369, 228, 89, 37);
		contentPane.add(buttonReset);
	}
	public JTextField getTextFieldCode() {
		return textFieldCode;
	}
	public JPasswordField getTextFieldPassword() {
		return textFieldPassword;
	}
	public JButton getButtonLogin() {
		return buttonLogin;
	}
	public JButton getButtonReset() {
		return buttonReset;
	}
}
