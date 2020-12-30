package controller.controllerProduct;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import mix.Myexception;
import model.Branch;
import model.BranchCategory;
import model.Category;
import model.Checkstockproperty;
import model.Color;
import model.ProductInfo;
import model.Size;
import model.UploadProductComponent;
import service.ProductServiceImpl;
import view.AddProduct;
import view.PanelProduct;

public class ControllerAddProduct {
	private ProductServiceImpl productService;
	private PanelProduct panelProduct;
	private List<Checkstockproperty> Checkstolist = new ArrayList<Checkstockproperty>();
	private UploadProductComponent uploadProductComponent;
	private int flagsize;
	public ControllerAddProduct(PanelProduct p1) {
		panelProduct = p1;
		productService = new ProductServiceImpl();
		ActionButtonAdd(panelProduct);
		uploadProductComponent=productService.uploadproduct();
	}
	
	private void ActionButtonAdd(PanelProduct panelProduct) {
		panelProduct.getButtonAddData().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddProduct addProduct = new AddProduct();
				addProduct.setVisible(true);
				addProduct.getComboBoxCategory().addItem("");
				List<Category> data_cate = uploadProductComponent.getCategory();
				for(Category c : data_cate) {
					addProduct.getComboBoxCategory().addItem(c.getName());
				}
				addProduct.getComboBoxBranch().addItem("");
				List<Branch> data_bra = uploadProductComponent.getBranch();
				for(Branch c : data_bra) {
					addProduct.getComboBoxBranch().addItem(c.getName());
				}
				addProduct.getComboBoxColor().addItem("");
				List<Color> data_color = uploadProductComponent.getColor();
				for(Color c : data_color) {
					addProduct.getComboBoxColor().addItem(c.getName());
				}

				ActionComboBoxCategory(addProduct);
				ActionButtonRemove(addProduct);
				ActionButtonAdd(addProduct);
				ActionButtonSave(addProduct);
				ActionButtonCancel(addProduct);
			}
		});
	}
	
	private void ActionButtonCancel(AddProduct addProduct) {
		addProduct.getButtonCancel().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				productService.getcheckstolist().clear();
				addProduct.dispose();
			}
		});
	}
	
	private void ActionButtonSave(AddProduct addProduct) {
		
		addProduct.getButtonSave().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductInfo productInfo = new ProductInfo();
				productInfo.setName(addProduct.getTextFieldName().getText());
				productInfo.setCode(addProduct.getTextFieldCode().getText());
				productInfo.setDescription(addProduct.getTextDes().getText());
				productInfo.setCurrentPrice(Integer.parseInt(addProduct.getTextFieldPrice().getText()));
				Branch branch = new  Branch();
				int indexbra=addProduct.getComboBoxBranch().getSelectedIndex()-1;
				branch.setId(uploadProductComponent.getBranch().get(indexbra).getId());
				Category category = new Category();
				int indexcate=addProduct.getComboBoxCategory().getSelectedIndex()-1;
				category.setId(uploadProductComponent.getCategory().get(indexcate).getId());
				BranchCategory branchCategory = new BranchCategory();
				branchCategory.setBranch(branch);
				branchCategory.setCategory(category);
				productInfo.setBranchCategory(branchCategory);
				try {
					productService.saveproduct(productInfo);
					productService.getcheckstolist().clear();
					addProduct.dispose();
					JOptionPane.showMessageDialog(panelProduct ,"Successfully saved!");
				} catch (Myexception e1) {
					JOptionPane.showMessageDialog(panelProduct,e1,"Alert",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
	
	private void ActionComboBoxCategory(AddProduct addProduct) {
		addProduct.getComboBoxCategory().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productService.getcheckstolist().clear();
				addProduct.getComboBoxSize().removeAllItems();
				((DefaultTableModel)addProduct.getTable().getModel()).setRowCount(0);
				int index=addProduct.getComboBoxCategory().getSelectedIndex()-1;
				if(uploadProductComponent.getCategory().get(index).getGroupsize()==0 ){
					flagsize=0;
					List<Size> data_size_char = uploadProductComponent.getSizechar();
					addProduct.getComboBoxSize().addItem("");
					for(Size c : data_size_char) {
						addProduct.getComboBoxSize().addItem(c.getName());		    
					}
					
				
				}else if(uploadProductComponent.getCategory().get(index).getGroupsize()==1 ){
					flagsize=1;
					List<Size> data_size_number = uploadProductComponent.getSizenum();
					addProduct.getComboBoxSize().addItem("");
					for(Size c : data_size_number) {
						addProduct.getComboBoxSize().addItem(c.getName());
					}
					
				}
		}});
	}
	
	private void ActionButtonRemove(AddProduct addProduct) {
		addProduct.getButtonRemove().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DefaultTableModel model = (DefaultTableModel) addProduct.getTable().getModel();
				if(addProduct.getTable().getSelectedRow() != -1) {
					model.removeRow(addProduct.getTable().getSelectedRow());
					productService.deletestockproperty(addProduct.getTable().getSelectedRow()+1);
				}
			}
		});
	}
	
	private void ActionButtonAdd(AddProduct addProduct) {
		addProduct.getButtonAdd().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String a = (String) addProduct.getComboBoxSize().getSelectedItem();
				String b = (String) addProduct.getComboBoxColor().getSelectedItem();
				String c = (String) addProduct.getTextFieldQuantity().getText();
				
				Checkstockproperty checksto = new Checkstockproperty();
				int indexcolor=addProduct.getComboBoxColor().getSelectedIndex()-1;
				int indexsize=addProduct.getComboBoxSize().getSelectedIndex()-1;
				checksto.setIdStockColor(uploadProductComponent.getColor().get(indexcolor).getId());
				if(flagsize==0) {
					checksto.setIdStockSize(uploadProductComponent.getSizechar().get(indexsize).getId());
				}else if(flagsize==1) {
					checksto.setIdStockSize(uploadProductComponent.getSizenum().get(indexsize).getId());
				}
				checksto.setStockQty(Integer.parseInt(addProduct.getTextFieldQuantity().getText()));
				try {
					productService.addstockproperty(checksto);
					String data1[] = {a,b,c};
					DefaultTableModel model1 = (DefaultTableModel) addProduct.getTable().getModel();
					model1.addRow(data1);
					 autoResizeColumn (addProduct.getTable());
					addProduct.getTextFieldQuantity().setText("");
				} catch (Myexception e1) {
					JOptionPane.showMessageDialog(addProduct, e1);
				}
				
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