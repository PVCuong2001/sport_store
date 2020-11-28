package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainView;
import view.AddProduct;
import view.PanelProduct;

public class ControllerAddProduct {
	private PanelProduct panelProduct;
	private MainView mainView;
	public ControllerAddProduct(PanelProduct p, MainView m){
		panelProduct = p;
		mainView = m;
		panelProduct.getButtonAddData().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AddProduct addproduct = new AddProduct();
				
				addproduct.setVisible(true);
				mainView.dispose();
				
			}
		});
	}
}
