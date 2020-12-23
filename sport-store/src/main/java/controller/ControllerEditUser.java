package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.User;
import service.UserServiceImpl;
import validate.Myexception;
import view.EditUser;
import view.PanelUser;

public class ControllerEditUser {
    private PanelUser panelUser;
    private UserServiceImpl userServiceImpl;
    private User user;
    public ControllerEditUser(PanelUser panelUser, UserServiceImpl userServiceImpl) {
        // TODO Auto-generated constructor stub
        this.panelUser = panelUser;
        this.userServiceImpl = userServiceImpl;
        user=new User();
        ActionButtonEdit();
        
    }
    private void ActionButtonEdit() {
    	panelUser.getButtonEditUser().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
		        
		        try {
					user = (User) userServiceImpl.getuserlist().get(panelUser.getTableUser().getSelectedRow()).clone();
					 EditUser editUser = new EditUser();
				        editUser.setVisible(true);

				        editUser.getTextFieldCode().setText(user.getCode());
				        editUser.getTextFieldPassword().setText(user.getPassword());
				        editUser.getTextFieldGmail().setText(user.getGmail());
				        editUser.getTextFieldPhone().setText(user.getPhone());
				        editUser.getTextFieldName().setText(user.getName());
				        if(user.getGender().equals("Male")) {
				        	editUser.getRadioMale().setSelected(true);
				        }
				        else {
				        	editUser.getRadioFemale().setSelected(true);
				        }
				        if(user.getIsAdmin()==1) {
				        	editUser.getRadioAdmin().setSelected(true);
				        }
				        else {
				        	editUser.getRadioStaff().setSelected(true);
				        	
				        }
				        ActionButtonSave(editUser);
				        ActionButtonCancel(editUser);
				        ActionButtonRadioAdmin(editUser);
				        ActionButtonRadioGender( editUser);
		        } catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       
			}
		});
        
    }
    private void ActionButtonSave(EditUser editUser) {
    	editUser.getButtonSave().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				user.setCode(editUser.getTextFieldCode().getText());
				user.setName(editUser.getTextFieldName().getText());
				user.setPhone(editUser.getTextFieldPhone().getText());
				user.setPassword(editUser.getTextFieldPassword().getText());
				user.setGmail(editUser.getTextFieldGmail().getText());
				if(editUser.getRadioMale().isSelected()) {
                    user.setGender("Male");
                }
                else {
                    user.setGender("Female");
                }
                if(editUser.getRadioAdmin().isSelected()) {
                	user.setIsAdmin(1);
                }
                else {
                	user.setIsAdmin(0);
                }
				try {
					userServiceImpl.edituser(user, panelUser.getTableUser().getSelectedRow());
					editUser.dispose();
				} catch (Myexception e) {
					JOptionPane.showMessageDialog(panelUser, e,"Alert",JOptionPane.WARNING_MESSAGE);
				} 
				
			}
		});
    }
    private void ActionButtonCancel(EditUser editUser) {
    	editUser.getButtonCancel().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				editUser.dispose();
			}
		});
    }
    private void ActionButtonRadioAdmin(EditUser editUser) {
    	editUser.getRadioAdmin().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(editUser.getRadioAdmin().isSelected()) {
					editUser.getRadioStaff().setSelected(false);
				}
				
			}
		});
    	editUser.getRadioStaff().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(editUser.getRadioStaff().isSelected()) {
					editUser.getRadioAdmin().setSelected(false);
				}
				
			}
		});
    }
    private void ActionButtonRadioGender(EditUser editUser) {
    	 editUser.getRadioFemale().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(editUser.getRadioFemale().isSelected()) {
					editUser.getRadioMale().setSelected(false);
				}
				
			}
		});
    	 editUser.getRadioMale().addActionListener(new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent arg0) {
 				// TODO Auto-generated method stub
 				if(editUser.getRadioMale().isSelected()) {
 					editUser.getRadioFemale().setSelected(false);
 				}
 					
 			}
 		});
    }
}



