package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.management.InstanceNotFoundException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import model.Stock;
import service.BillServiceImpl;
import validate.Myexception;
import view.AddBill;
import view.PanelBill;

public class ControllerAddBill {
    private PanelBill panelBill;
    private BillServiceImpl billServiceImpl;
    public ControllerAddBill(PanelBill p1,BillServiceImpl billServiceImpl) {
    	panelBill = p1;
    	this.billServiceImpl = billServiceImpl;
			ActionButtonAddBill(panelBill);
    }
    public void ActionButtonAddBill(PanelBill panelBill)
    {
    	panelBill.getButtonAddBill().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                AddBill addBill = new AddBill();
                addBill.setVisible(true);
                ActionButtonFind(addBill);
                ActionButtonAdd(addBill);
                ActionButtonSave(addBill);
    			ActionButtonCancel(addBill);
            }
        });
    }
    public void ActionButtonSave(AddBill addBill) {
    	addBill.getButtonSave().addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String codebill = addBill.getTextFieldCodeBill().getText();
				String description = addBill.getTextAreaDescription().getText();
				try {
					billServiceImpl.savebill(codebill, description, 1);
					addBill.dispose();
				} catch (Myexception e) {
					System.out.println(e);
				}
			}
		});
    }
 
    public void ActionButtonAdd(AddBill addBill) {
    	addBill.getButtonAdd().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					billServiceImpl.addproduct(addBill.getComboBoxSizeColor().getSelectedIndex()-1,Integer.parseInt(addBill.getTextFieldQuantity().getText()));
					String code = addBill.getTextFieldCodeProduct().getText();
					String color_size = (String)addBill.getComboBoxSizeColor().getSelectedItem();
					String quantity = addBill.getTextFieldQuantity().getText();
					String data[] = {code,color_size,quantity};
					DefaultTableModel model=(DefaultTableModel)addBill.getTable().getModel();
					model.addRow(data);
					addBill.getTextFieldCodeProduct().setText("");
					addBill.getTextFieldQuantity().setText("");
					((DefaultComboBoxModel)addBill.getComboBoxSizeColor().getModel()).removeAllElements();		    
				} catch (Myexception e) {
					
				}
			}
		});
    	
    }
    
    public void ActionButtonCancel(AddBill addBill) {
		addBill.getButtonCancel().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				billServiceImpl.getstocks().clear();
				addBill.dispose();
			}
		});
	}
    
    public void ActionButtonFind(AddBill addBill)
    {
        addBill.getButtonFind().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String code = addBill.getTextFieldCodeProduct().getText();
                try {
					List<Stock>stocks=billServiceImpl.checkprocode(code);
					addBill.getComboBoxSizeColor().addItem("");
		                for(Stock value :stocks) {
		                	addBill.getComboBoxSizeColor().addItem(value.getColor().getName()+"-"+value.getSize().getName());
		                }
				} catch (Myexception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
               
            }
        });
    }
}
