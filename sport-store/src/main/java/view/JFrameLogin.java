package view;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import config.Injector;
import config.Serializable_user;
import controller.LoginController;
import model.User;
import service.UserService;

import java.awt.Color;


public class JFrameLogin extends JFrame {
	static final Logger log=Logger.getLogger(UserService.class.getName());
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCode;
	private JPasswordField textFieldPassword;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameLogin frame = new JFrameLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrameLogin() {
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
		ImageLogin.setIcon(new ImageIcon("D:\\\u1EA2NH\\iconlogin.jpg"));
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
		
		JButton buttonLogin = new JButton("LOGIN");
		buttonLogin.setBackground(new Color(176, 224, 230));
		buttonLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					String code=textFieldCode.getText();
					String password=textFieldPassword.getText();
					if(!code.isEmpty()&&!password.isEmpty()) {
						LoginController loginController=new LoginController();
						List<User>users=loginController.finduser("code",code);
						if(users.size()!=0 && users.get(0).getPassword().equals(password)) {
							loginController.storeuser=users.get(0);
							dispose();//close login page
							MainView mainview = new MainView();
							mainview.show();
						}
						else {
							JOptionPane.showInputDialog(this, "Code or password is wrong!");
							textFieldPassword.setText("");
							textFieldCode.setText("");
						}
					}else {
						JOptionPane.showInputDialog(this, "Please enter code and password");
						textFieldPassword.setText("");
						textFieldCode.setText("");
					}
					
				}catch(Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		buttonLogin.setBounds(369, 161, 89, 42);
		contentPane.add(buttonLogin);
		
		JButton buttonReset = new JButton("RESET");
		buttonReset.setBackground(new Color(176, 224, 230));
		buttonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldPassword.setText("");
				textFieldCode.setText("");
			}
		});
		buttonReset.setBounds(369, 228, 89, 37);
		contentPane.add(buttonReset);
	}
}