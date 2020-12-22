package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


import model.User;
import service.UserService;
import validate.Myexception;
import view.AddUser;
import view.PanelUser;

public class ControllerAddUser {
    private PanelUser panelUser;
    private UserService userService;
    public ControllerAddUser(PanelUser panelUser, UserService userService) {
        this.panelUser = panelUser;
        this.userService = userService;
        ActionButtonAddUser();
    }
    private void ActionButtonAddUser() {
        panelUser.getButtonAddUser().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                AddUser addUser = new AddUser();
                addUser.setVisible(true);
                ActionButtonRadio(addUser);
                ActionButtonRadioRole(addUser);
                ActionButtonSave(addUser);
                ActionButtonCancel(addUser);
            }
        });
    }
    private void ActionButtonSave(AddUser addUser) {
        addUser.getButtonSave().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int warn = JOptionPane.showConfirmDialog(addUser, "Are you sure?");
                if(warn == JOptionPane.YES_NO_OPTION) {
                    User user = new User();
                    user.setName(addUser.getTextFieldName().getText());
                    user.setCode(addUser.getTextFieldCode().getText());
                    if(addUser.getRadioButtonMale().isSelected()) {
                        user.setGender("Male");
                    }
                    else {
                        user.setGender("Female");
                    }
                    if(addUser.getRadioAdmin().isSelected()) {
                    	user.setIsAdmin(1);
                    }
                    else {
                    	user.setIsAdmin(0);
                    }
                    user.setGmail(addUser.getTextFieldGmail().getText());
                    user.setPhone(addUser.getTextFieldPhone().getText());   
                    user.setPassword(addUser.getTextFieldPassword().getText());
                    try {
						userService.adduser(user);
						addUser.dispose();
					} catch (Myexception e1) {
						JOptionPane.showMessageDialog(panelUser, e1,"Alert",JOptionPane.WARNING_MESSAGE);
					}
                }
            }
        });
    }
    private void ActionButtonCancel(AddUser addUser) {
        addUser.getButtonCancel().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                addUser.dispose();
            }
        });
    }
    private void ActionButtonRadio(AddUser addUser) {
        addUser.getRadioButtonFemale().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(addUser.getRadioButtonFemale().isSelected()) {
                    addUser.getRadioButtonMale().setSelected(false);
                }
            }
        });
        addUser.getRadioButtonMale().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(addUser.getRadioButtonMale().isSelected()) {
                    addUser.getRadioButtonFemale().setSelected(false);
                }
            }
        });
    }
    private void ActionButtonRadioRole(AddUser addUser) {
    	addUser.getRadioAdmin().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(addUser.getRadioAdmin().isSelected()) {
					addUser.getRadioStaff().setSelected(false);
				}
			}
		});
    	addUser.getRadioStaff().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(addUser.getRadioStaff().isSelected()) {
					addUser.getRadioAdmin().setSelected(false);
				}
			}
		});
    }
}



