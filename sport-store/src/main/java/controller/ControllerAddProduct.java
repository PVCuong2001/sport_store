package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Branch;
import model.BranchCategory;
import model.Category;
import model.Checkstockproperty;
import model.Color;
import model.ProductInfo;
import model.Size;
import model.UploadProductComponent;
import service.ProductServiceImpl;
import validate.Myexception;
import view.AddProduct;
import view.PanelProduct;

public class ControllerAddProduct {
	private ProductServiceImpl productService;
	private PanelProduct panelProduct;
	private JFrame f;
	private List<Checkstockproperty> Checkstolist = new ArrayList<Checkstockproperty>();
	private UploadProductComponent uploadProductComponent;
	private int flagsize;
	public ControllerAddProduct(PanelProduct p1) {
		panelProduct = p1;
		productService = new ProductServiceImpl();
		ActionButtonAdd(panelProduct);
		f= new  JFrame();
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
				productInfo.setDescription("none");
				productInfo.setCurrentPrice(Integer.parseInt(addProduct.getTextFieldPrice().getText()));
				productInfo.setImgUrl("none");
				Branch branch = new  Branch();
				branch.setId(addProduct.getComboBoxBranch().getSelectedIndex());
				Category category = new Category();
				category.setId(addProduct.getComboBoxCategory().getSelectedIndex());
				BranchCategory branchCategory = new BranchCategory();
				branchCategory.setBranch(branch);
				branchCategory.setCategory(category);
				productInfo.setBranchCategory(branchCategory);
				try {
					productService.saveproduct(productInfo);
					productService.getcheckstolist().clear();
					addProduct.dispose();
					JOptionPane.showMessageDialog(f,"Successfully saved!");
				} catch (Myexception e1) {
					JOptionPane.showMessageDialog(f,e1,"Alert",JOptionPane.WARNING_MESSAGE);
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
				int index=addProduct.getComboBoxCategory().getSelectedIndex();
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
				int indexcolor=addProduct.getComboBoxColor().getSelectedIndex();
				int indexsize=addProduct.getComboBoxSize().getSelectedIndex();
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
					addProduct.getTextFieldQuantity().setText("");
				} catch (Myexception e1) {
					JOptionPane.showMessageDialog(f, e1);
				}
				
			}
		});
	}
}