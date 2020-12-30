package controller.controllerProduct;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import mix.Myexception;
import model.Checkstockproperty;
import model.Color;
import model.ProductInfo;
import model.Size;
import model.UploadProductComponent;
import service.ProductServiceImpl;
import view.EditProduct;
import view.PanelProduct;

public class ControllerEditProduct {
	private ProductServiceImpl productService;
	private PanelProduct panelProduct;
	private UploadProductComponent uploadProductComponent;
	private int flagsize;
	private ProductInfo productInf;
	public ControllerEditProduct( PanelProduct panelProduct ,ProductServiceImpl productService) {
		this.panelProduct = panelProduct;
		this.productService = productService;
		uploadProductComponent=productService.uploadproduct();
		ActionButtonEdit();
	}
	public void ActionButtonEdit() {
        panelProduct.getButtonEdit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
            	int index=panelProduct.getTable().getSelectedRow();
                try {
					productInf=(ProductInfo) productService.getprolist().get(index).clone();
					Object[][] data = productService.showdetail(panelProduct.getTable().getSelectedRow());
	                EditProduct editProduct = new EditProduct();
	                editProduct.setVisible(true);
	                editProduct.getTextFieldBranch().setText(productInf.getBranchCategory().getBranch().getName());
	                   editProduct.getTextFieldCategory().setText(productInf.getBranchCategory().getCategory().getName());
	                   editProduct.getTextFieldCode().setText(productInf.getCode());
	                   editProduct.getTextAreaDes().setText(productInf.getDescription());
	                   editProduct.getTextFieldName().setText(productInf.getName());
	                   editProduct.getTextFieldPrice().setText(String.valueOf(productInf.getCurrentPrice()));
	                   String[] col = {"Color","Size","Quantity"};
	                   DefaultTableModel mod = (DefaultTableModel) editProduct.getTable().getModel();
	                   mod.setDataVector(data, col);
	                   List<Size> data_size =null;
	                   if(productInf.getBranchCategory().getCategory().getGroupsize()==0)
	                   {
	                       data_size = uploadProductComponent.getSizechar();
	                       flagsize=0;
	                   }
	                   else  if(productInf.getBranchCategory().getCategory().getGroupsize()==1) {
	                       data_size =uploadProductComponent.getSizenum();
	                       flagsize=1;
	                   }
	                   editProduct.getComboBoxSize().addItem("");
	                   for(Size d : data_size) {
	                       editProduct.getComboBoxSize().addItem(d.getName());
	                   }
	                   List<Color> data_color = uploadProductComponent.getColor();
	                   editProduct.getComboBoxColor().addItem("");
	                   for( Color c : data_color) {
	                       editProduct.getComboBoxColor().addItem(c.getName());
	                   }
	                   autoResizeColumn (editProduct.getTable());
	                   ActionButtonAdd(editProduct);
	                   ActionButtonRemove(editProduct);
	                   ActionButtonSave(editProduct);
	                   ActionButtonCancel( editProduct);
				} catch (CloneNotSupportedException e1) {
					e1.printStackTrace();
				}               
               }});
    }
    public void ActionButtonAdd(EditProduct editProduct) {
        editProduct.getButtonAdd().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String size = (String) editProduct.getComboBoxSize().getSelectedItem();
                String color = (String) editProduct.getComboBoxColor().getSelectedItem();
                String quantity = (String) editProduct.getTextFieldQuantity().getText();
                
            	Checkstockproperty checksto = new Checkstockproperty();
				int indexcolor=editProduct.getComboBoxColor().getSelectedIndex()-1;
				int indexsize=editProduct.getComboBoxSize().getSelectedIndex()-1;
				if(flagsize==0) checksto.setIdStockSize(uploadProductComponent.getSizechar().get(indexsize).getId());
				else checksto.setIdStockSize(uploadProductComponent.getSizenum().get(indexsize).getId());
				checksto.setIdStockColor(uploadProductComponent.getColor().get(indexcolor).getId());
				checksto.setStockQty(Integer.parseInt(editProduct.getTextFieldQuantity().getText()));
				
				try {
					productService.addstockproperty(checksto);
					String data1[] = {color,size,quantity};
					DefaultTableModel model1 = (DefaultTableModel) editProduct.getTable().getModel();
					model1.addRow(data1);
					editProduct.getTextFieldQuantity().setText("");
				} catch (Myexception e1) {
					JOptionPane.showMessageDialog(editProduct,e1);
				}
				
            }
        });
    }
    public void ActionButtonRemove(EditProduct editProduct) {
    	editProduct.getButtonRemove().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DefaultTableModel model = (DefaultTableModel) editProduct.getTable().getModel();
				if(editProduct.getTable().getSelectedRow() != -1) {
					productService.deletestockproperty(editProduct.getTable().getSelectedRow());
					model.removeRow(editProduct.getTable().getSelectedRow());
					
			}
		}});
    }
    public void ActionButtonSave(EditProduct editProduct) {
    	editProduct.getButtonSave().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String name=editProduct.getTextFieldName().getText();
				String des=editProduct.getTextAreaDes().getText();
				long price=Long.parseLong(editProduct.getTextFieldPrice().getText());
				productInf.setName(name);
				productInf.setDescription(des);
				productInf.setCurrentPrice(price);
				try {
					productService.editproduct(productInf);
					productService.getcheckstolist().clear();
					productService.getstolist().clear();
					editProduct.dispose();
				} catch (Myexception e) {
					System.out.println("Toang");
				}
			}
		});
    }
    public void ActionButtonCancel(EditProduct editProduct) {
    	editProduct.getButtonCancel().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				productService.getcheckstolist().clear();
				productService.getstolist().clear();
				editProduct.dispose();
			}
		});
    }
    private void autoResizeColumn(JTable jTable1) {
        JTableHeader header = jTable1.getTableHeader();
        int rowCount = jTable1.getRowCount();

        final Enumeration columns = jTable1.getColumnModel().getColumns();
        while (columns.hasMoreElements()) {
            TableColumn column = (TableColumn) columns.nextElement();
            int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
            int width = (int) jTable1.getTableHeader().getDefaultRenderer()
                    .getTableCellRendererComponent(jTable1, column.getIdentifier(), false, false, -1, col).getPreferredSize().getWidth();

            for (int row = 0; row < rowCount; row++) {
                int preferedWidth = (int) jTable1.getCellRenderer(row, col).getTableCellRendererComponent(jTable1,
                        jTable1.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
                width = Math.max(width, preferedWidth);
            }
            header.setResizingColumn(column); // this line is very important
            column.setWidth(width + jTable1.getIntercellSpacing().width);
        }
    }

}
