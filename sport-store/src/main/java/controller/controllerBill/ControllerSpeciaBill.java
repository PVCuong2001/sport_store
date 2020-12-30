package controller.controllerBill;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import service.BillServiceImpl;
import view.PanelBill;
import view.ViewSpecialBill;

public class ControllerSpeciaBill {
	private BillServiceImpl billServiceImpl;
	private PanelBill panelBill;
	private Object [][] data1, data2;
	public ControllerSpeciaBill(PanelBill panelBill, BillServiceImpl billServiceImpl) {
		// TODO Auto-generated constructor stub
		this.panelBill = panelBill;
		this.billServiceImpl = billServiceImpl;
		ButtonSpecialBill();
	}
	private void ButtonSpecialBill() {
		panelBill.getButtonSpecialBill().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ViewSpecialBill viewSpecialBill = new ViewSpecialBill();
				viewSpecialBill.setVisible(true);
				
				data1 = billServiceImpl.findprintedbill();
				String[] column = {"Code Bill", "Quantity Clothes", "Value Bill"};
				DefaultTableModel model1 = (DefaultTableModel) viewSpecialBill.getTable().getModel();
				model1.setDataVector(data1, column);
				data2 = billServiceImpl.getprintedlist();
				DefaultTableModel model2 = (DefaultTableModel) viewSpecialBill.getTableStart().getModel();
				model2.setDataVector(data2, column);
				ButtonComplete(viewSpecialBill);
				ButtonCancel(viewSpecialBill); 
			}
		});
	}
	private void ButtonComplete(ViewSpecialBill viewSpecialBill ) {
		viewSpecialBill.getButtonComplete().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				billServiceImpl.completeprintedbill();
				viewSpecialBill.dispose();
			}
		});
	}
	private void ButtonCancel(ViewSpecialBill viewSpecialBill ) {
		viewSpecialBill.getButtonCancel().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				viewSpecialBill.dispose();
			}
		});
	}
}
