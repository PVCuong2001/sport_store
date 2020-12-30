package controller.controllerInfoUser;

import service.UserService;
import service.UserServiceImpl;
import view.PanelInfoUser;

public class ControllerPanelInfoUser {
	private PanelInfoUser panelInfoUser;
	private UserServiceImpl userServiceImpl;
	public ControllerPanelInfoUser(PanelInfoUser panelInfoUser, UserServiceImpl userServiceImpl) {
		// TODO Auto-generated constructor stub
		this.panelInfoUser = panelInfoUser;
		this.userServiceImpl = userServiceImpl;
		
		this.panelInfoUser.getTextFieldName().setText(userServiceImpl.storeuser.getName());
		this.panelInfoUser.getTextFieldCode().setText(userServiceImpl.storeuser.getCode());
		this.panelInfoUser.getTextFieldPassword().setText(userServiceImpl.storeuser.getPassword());
		if(userServiceImpl.storeuser.getGender().equals("Male")) {
			this.panelInfoUser.getTextFieldGender().setText("Male");
		}
		else{
			this.panelInfoUser.getTextFieldGender().setText("Female");
		}
		this.panelInfoUser.getTextFieldPhone().setText(userServiceImpl.storeuser.getPhone());
		this.panelInfoUser.getTextFieldGmail().setText(userServiceImpl.storeuser.getGmail());
		if(userServiceImpl.storeuser.getIsAdmin() == 1) {
			this.panelInfoUser.getTextFieldRole().setText("Admin");
		}
		else {
			this.panelInfoUser.getTextFieldRole().setText("Staff");
		}
	}
}
