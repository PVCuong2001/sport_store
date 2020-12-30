package controller.controllerProduct;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mix.Myexception;
import service.ProductServiceImpl;
import view.PanelProduct;

public class ControllerDelProduct {
	private PanelProduct panelProduct;
	private ProductServiceImpl productService;
	public ControllerDelProduct(PanelProduct panelProduct,ProductServiceImpl productService){
		this.panelProduct = panelProduct;
		this.productService=productService;
		ActionButtonDelete();
	}
	public void ActionButtonDelete() {
		panelProduct.getButtonDelete().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int a=JOptionPane.showConfirmDialog(panelProduct,"Are you sure?");
				if(a==JOptionPane.YES_OPTION) {
					try {
						productService.deleteproduct(panelProduct.getTable().getSelectedRow());
					} catch (Myexception e) {
						JOptionPane.showMessageDialog(panelProduct, e);
					}
				}
			}
		});
	}
}
