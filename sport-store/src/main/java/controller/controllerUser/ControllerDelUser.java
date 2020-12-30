package controller.controllerUser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import service.UserServiceImpl;
import view.PanelUser;

public class ControllerDelUser {
    private PanelUser panelUser;
    private UserServiceImpl userServiceImpl;
    public ControllerDelUser(PanelUser panelUser, UserServiceImpl userServiceImpl) {
        this.panelUser = panelUser;
        this.userServiceImpl = userServiceImpl;
        ActionButtonDelete();
    }
    private void ActionButtonDelete() {
        panelUser.getButtonDeleteUser().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
            	int a=JOptionPane.showConfirmDialog(panelUser,"Are you sure?");
            	if(a==JOptionPane.YES_OPTION) {
            		userServiceImpl.deleteuser(panelUser.getTableUser().getSelectedRow());
            	}
                    
            }
        });
    }
}



