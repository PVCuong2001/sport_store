package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.InstanceNotFoundException;
import javax.swing.JOptionPane;

import model.User;
import service.BillServiceImpl;
import service.ProductServiceImpl;
import service.UserServiceImpl;
import view.Login;
import view.MainView;
public class ControllerMainView {
	
	private MainView mainview;
	private ProductServiceImpl productServiceImpl;
	private BillServiceImpl billServiceImpl;
	private UserServiceImpl userServiceImpl;
	
	
	public ControllerMainView(MainView m )
	{
		mainview = m;
		productServiceImpl=new ProductServiceImpl();
		billServiceImpl=new BillServiceImpl();
		userServiceImpl=new UserServiceImpl();
		if(userServiceImpl.storeuser.getIsAdmin()==0) {
			mainview.getPanelProduct().getButtonAddData().setVisible(false);
            mainview.getPanelProduct().getButtonDelete().setVisible(false);
            mainview.getPanelProduct().getButtonEdit().setVisible(false);
            mainview.getPanelProduct().getButtonRefreshData().setVisible(false);
            mainview.getButtonNhanVien().setVisible(false);
		}else if(userServiceImpl.storeuser.getIsAdmin()==1){
			mainview.getLayeredPane().add(mainview.getpanelUser());
			ActionButtonNhanVien();
			ActionPanelUser();
		}
		ActionButtonInfor();
		ActionButtonMatHang();	
		ActionButtonHoaDon();
		ActionButtonLogOut();
		ActionPanelMatHang();
		ActionPanelBill();
	}
	public void ActionButtonNhanVien() {
		mainview.getButtonNhanVien().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainview.getLayeredPane().removeAll();
				mainview.getLayeredPane().add(mainview.getpanelUser());
				mainview.getLayeredPane().repaint();
				mainview.getLayeredPane().revalidate();
			}
		});
	}
	public void ActionButtonMatHang() {
		mainview.getButtonMatHang().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainview.getLayeredPane().removeAll();
				mainview.getLayeredPane().add(mainview.getPanelProduct());
				mainview.getLayeredPane().repaint();
				mainview.getLayeredPane().revalidate();
			}
		});
	}
	public void ActionButtonHoaDon() {
		mainview.getButtonHoaDon().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainview.getLayeredPane().removeAll();
				mainview.getLayeredPane().add(mainview.getpanelBill());
				mainview.getLayeredPane().repaint();
				mainview.getLayeredPane().revalidate();
			}
		});
	}
	public void ActionButtonLogOut() {
		mainview.getButtonLogOut().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(mainview, "Are you sure?");
                // JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
                    mainview.dispose();
                    Login obj = new Login();
                    obj.setVisible(true);
                    userServiceImpl.storeuser=null;
                    ControllerLogin c;
					try {
						c = new ControllerLogin(obj);
						c.ActionButtonLogin();
						c.ActionButtonReset();
					} catch (InstanceNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
                }
			}
		});
	}
	public void ActionButtonInfor() {
		mainview.getButtonInforUser().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainview.getLayeredPane().removeAll();
				mainview.getLayeredPane().add(mainview.getPanelInformationUser());
				mainview.getLayeredPane().repaint();
				mainview.getLayeredPane().revalidate();
			}
		});
	}
	public void ActionPanelUser() {
		ControllerRefreshPanelUser controllerRefreshPanelUser = new ControllerRefreshPanelUser(mainview.getpanelUser(), userServiceImpl);
		ControllerEditUser controllerEditUser = new ControllerEditUser(mainview.getpanelUser(), userServiceImpl);
		ControllerUser controllerUser=new ControllerUser(mainview.getpanelUser(), userServiceImpl);
		ControllerAddUser controllerAddUser=new ControllerAddUser(mainview.getpanelUser(), userServiceImpl);
		ControllerDelUser controllerDelUser=new ControllerDelUser(mainview.getpanelUser(), userServiceImpl);
	}
	public void ActionPanelBill() {
		ControllerSpeciaBill controllerSpeciaBill = new ControllerSpeciaBill(mainview.getpanelBill(), billServiceImpl);
		ControllerBill controllerBill = new ControllerBill(mainview.getpanelBill(),billServiceImpl);
		ControllerAddBill controllerAddBill=new ControllerAddBill(mainview.getpanelBill(),billServiceImpl);
	}
	public void ActionPanelMatHang() {
		ControllerEditProduct controllerEditProduct = new ControllerEditProduct(mainview.getPanelProduct(),productServiceImpl);
		ControllerPagination controllerPagination = new ControllerPagination(mainview.getPanelProduct(),productServiceImpl);
		ControllerDelProduct controllerDelProduct=new ControllerDelProduct(mainview.getPanelProduct(),productServiceImpl);
		ControllerAddProduct controllerAddProduct = new ControllerAddProduct(mainview.getPanelProduct() );
	}
}