package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.management.InstanceNotFoundException;
import javax.swing.JOptionPane;

import config.Injector;
import dao.UserDAO;
import model.User;
import service.ProductService;
import service.UserService;
import view.Login;
import view.MainView;

public class ControllerLogin {
	public static User storeuser=null;
	private UserDAO<User> userDAO;
	private Login login;
	private ProductService productService;
	@SuppressWarnings("unchecked")
	public ControllerLogin(Login l) throws InstanceNotFoundException {
		login = l;
		userDAO = (UserDAO<User>) Injector.getInstance("UserDAOImpl");
	}
	
	public void ActionButtonLogin() {
		login.getButtonLogin().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code=login.getTextFieldCode().getText();
				String password=login.getTextFieldPassword().getText();
				UserService userService=new UserService();
				int check =userService.checkuser(code, password);
				if(check==1000) {
					MainView frame=new MainView();
					frame.setVisible(true);
					ControllerMainView controllerMainView=new ControllerMainView(frame);
					login.dispose();
				}else if(check==1001) {
					JOptionPane.showInputDialog(this, "Please enter code and password");
					login.getTextFieldCode().setText("");
					login.getTextFieldPassword().setText("");
				}else if(check==1002) {
					JOptionPane.showInputDialog(this,"Code or password is wrong!");
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
