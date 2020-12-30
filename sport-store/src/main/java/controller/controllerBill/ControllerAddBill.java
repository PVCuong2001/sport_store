package controller.controllerBill;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.management.InstanceNotFoundException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import mix.Myexception;
import model.Stock;
import service.BillServiceImpl;
import view.AddBill;
import view.PanelBill;

public class ControllerAddBill {
    private PanelBill panelBill;
    private BillServiceImpl billServiceImpl;
    private boolean check;
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
                ActionButtonRadio( addBill) ;
                ActionButtonAdd(addBill);
                ActionButtonSave(addBill);
    			ActionButtonCancel(addBill);
    			ActionButtonRemove( addBill) ;
            }
        });
    }
    public void ActionButtonRadio(AddBill addBill) {
        addBill.getRadioButtonSpecial().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
            	check=true;
                addBill.getButtonFind().setEnabled(true);
                addBill.getRadioButtonNone().setEnabled(false);
                ActionButtonFind(addBill);
            }
        });
        addBill.getRadioButtonNone().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
            	check=false;
                addBill.getButtonFind().setEnabled(true);
                addBill.getRadioButtonSpecial().setEnabled(false);
                ActionButtonFind(addBill);
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
					billServiceImpl.savebill(codebill, description,check);
					billServiceImpl.getstocks().clear();
					addBill.dispose();
				} catch (Myexception e) {
					JOptionPane.showMessageDialog(panelBill, e);
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
					JOptionPane.showMessageDialog(panelBill, e);
				}
			}
		});
    	
    }
    public void ActionButtonRemove(AddBill addBill) {
    	addBill.getButtonRemove().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultTableModel model = (DefaultTableModel) addBill.getTable().getModel();
				int index=addBill.getTable().getSelectedRow() ;
				if(index!= -1) {
						billServiceImpl.removeproduct(index);
						model.removeRow(index);	
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
				billServiceImpl.getbilldetails().clear();
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
                	((DefaultComboBoxModel)addBill.getComboBoxSizeColor().getModel()).removeAllElements();
					List<Stock>stocks=billServiceImpl.checkprocode(code,check);
					addBill.getComboBoxSizeColor().addItem("");
		                for(Stock value :stocks) {
		                	addBill.getComboBoxSizeColor().addItem(value.getColor().getName()+"-"+value.getSize().getName());
		                }
				} catch (Myexception e1) {
					JOptionPane.showMessageDialog(panelBill, e1);
				}
               
            }
        });
    }
}
