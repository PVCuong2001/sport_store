package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.management.InstanceNotFoundException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import config.Injector;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;
import service.ProductServiceImpl;
import service.UserServiceImpl;
import validate.Myexception;
import view.Login;
import view.MainView;

public class ControllerLogin {
	public static User storeuser=null;
	private UserDAOImpl userDAOImpl;
	private Login login;
	private ProductServiceImpl productService;
	private JFrame f;
	@SuppressWarnings("unchecked")
	public ControllerLogin(Login l) throws InstanceNotFoundException {
		login = l;
		userDAOImpl=new UserDAOImpl(User.class);
		f=new JFrame();
	}
	
	public void ActionButtonLogin() {
		login.getButtonLogin().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code=login.getTextFieldCode().getText();
				String password=login.getTextFieldPassword().getText();
				UserServiceImpl userService=new UserServiceImpl();
				try {
					userService.checkuser(code, password);
					MainView frame=new MainView();
					frame.setVisible(true);
					ControllerMainView controllerMainView=new ControllerMainView(frame);
					login.dispose();
				}catch (Myexception e1) {
					JOptionPane.showMessageDialog(f, e1,"Alert",JOptionPane.WARNING_MESSAGE);
					login.getTextFieldCode().setText("");
					login.getTextFieldPassword().setText("");
				}
				
			}
		});
	}
	public void ActionButtonReset() {
		login.getButtonReset().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.getTextFieldCode().setText("");
				login.getTextFieldPassword().setText("");
			}
		});
	}
}
