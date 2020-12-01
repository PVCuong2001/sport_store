package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import service.ProductService;
import view.Login;
import view.MainView;
public class ControllerMainView {
	
	private MainView mainview;

	
	
	public ControllerMainView(MainView m )
	{
		mainview = m;
		ActionButtonNhanVien();
		ActionButtonMatHang();
		ActionButtonHoaDon();
		ActionButtonLogOut();
		ActionButtonInfor();
		ActionPanelMatHang();
	}
	private void ActionButtonNhanVien() {
		mainview.getButtonNhanVien().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainview.getLayeredPane().removeAll();
				mainview.getLayeredPane().add(mainview.getpanelUser());
				mainview.getLayeredPane().repaint();
				mainview.getLayeredPane().revalidate();
			}
		});
	}
	private void ActionButtonMatHang() {
		mainview.getButtonMatHang().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainview.getLayeredPane().removeAll();
				mainview.getLayeredPane().add(mainview.getPanelProduct());
				mainview.getLayeredPane().repaint();
				mainview.getLayeredPane().revalidate();
			}
		});
	}
	private void ActionButtonHoaDon() {
		mainview.getButtonHoaDon().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainview.getLayeredPane().removeAll();
				mainview.getLayeredPane().add(mainview.getpanelBill());
				mainview.getLayeredPane().repaint();
				mainview.getLayeredPane().revalidate();
			}
		});
	}
	private void ActionButtonLogOut() {
		mainview.getButtonLogOut().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(mainview.getButtonLogOut(), "Are you sure?");
                // JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
                    mainview.dispose();
                    Login obj = new Login();
                    obj.setVisible(true);
                }
			}
		});
	}
	private void ActionButtonInfor() {
		mainview.getButtonInforUser().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainview.getLayeredPane().removeAll();
				mainview.getLayeredPane().add(mainview.getPanelInformationUser());
				mainview.getLayeredPane().repaint();
				mainview.getLayeredPane().revalidate();
			}
		});
	}
	private void ActionPanelMatHang() {
		ControllerPagination controllerPagination = new ControllerPagination(mainview.getPanelProduct());
	//	ControllerDeleteMatHang controllerDeleteMatHang = new ControllerDeleteMatHang(mainview.getPanelProduct());
		ControllerAddProduct controllerAddProduct = new ControllerAddProduct(mainview.getPanelProduct() );
	}
}