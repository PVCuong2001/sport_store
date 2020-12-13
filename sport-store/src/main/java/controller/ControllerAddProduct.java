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
import model.ProductInfo;
import service.ProductService;
import validate.Myexception;
import view.AddProduct;
import view.PanelProduct;

public class ControllerAddProduct {
	private ProductService productService;
	private PanelProduct panelProduct;
	private JFrame f;
	private List<Checkstockproperty> Checkstolist = new ArrayList<Checkstockproperty>();
	
	public ControllerAddProduct(PanelProduct p1) {
		panelProduct = p1;
		productService = new ProductService();
		ActionButtonAdd(panelProduct);
		f= new  JFrame();
	}
	
	private void ActionButtonAdd(PanelProduct panelProduct) {
		panelProduct.getButtonAddData().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddProduct addProduct = new AddProduct(productService);
				addProduct.setVisible(true);
				ActionComboBoxProduct(addProduct);
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
				category.setId(addProduct.getComboBoxProduct().getSelectedIndex());
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
	
	private void ActionComboBoxProduct(AddProduct addProduct) {
		addProduct.getComboBoxProduct().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct.getContentPane().add(addProduct.getLayeredPane());
				if(addProduct.getComboBoxProduct().getSelectedIndex()>=1 && addProduct.getComboBoxProduct().getSelectedIndex()<=7) {
					addProduct.getLayeredPane().removeAll();
					addProduct.getLayeredPane().add(addProduct.getPanel());
					addProduct.getLayeredPane().repaint();
					addProduct.getLayeredPane().revalidate();
					DefaultTableModel model1 = (DefaultTableModel) addProduct.getTable().getModel();
					model1.setRowCount(0);
				}
				else if(addProduct.getComboBoxProduct().getSelectedIndex()>7){
					addProduct.getLayeredPane().removeAll();
					addProduct.getLayeredPane().add(addProduct.getPanel_1());
					addProduct.getLayeredPane().repaint();
					addProduct.getLayeredPane().revalidate();
					DefaultTableModel model2 = (DefaultTableModel) addProduct.getTable_1().getModel();
					model2.setRowCount(0);
				}
				else if(addProduct.getComboBoxProduct().getSelectedIndex()==0){
					addProduct.getLayeredPane().removeAll();
					addProduct.getLayeredPane().add(addProduct.getPanel_2());
					addProduct.getLayeredPane().repaint();
					addProduct.getLayeredPane().revalidate();
				}
			}
		});
	}
	
	private void ActionButtonRemove(AddProduct addProduct) {
		addProduct.getButtonRemove().addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent ae) {
	        	DefaultTableModel model1 = (DefaultTableModel) addProduct.getTable().getModel();
	            if(addProduct.getTable().getSelectedRow() != -1) {
	               model1.removeRow(addProduct.getTable().getSelectedRow());
	               productService.deletestockproperty(addProduct.getTable().getSelectedRow()+1);
	            }
	         }
	      });
		addProduct.getButtonRemove1().addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent ae) {
	        	DefaultTableModel model2 = (DefaultTableModel) addProduct.getTable_1().getModel();
	            if(addProduct.getTable_1().getSelectedRow() != -1) {
	               model2.removeRow(addProduct.getTable_1().getSelectedRow());
	               productService.deletestockproperty(addProduct.getTable().getSelectedRow()+1);
	            }
	         }
	      });
	}
	
	private void ActionButtonAdd(AddProduct addProduct) {
		addProduct.getButtonAdd().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String a1 = (String) addProduct.getComboBoxSize().getSelectedItem();
				String b1 = (String) addProduct.getComboBoxColor().getSelectedItem();
				String c1 = (String) addProduct.getTextFieldQuantity().getText();
				
				Checkstockproperty checksto = new Checkstockproperty();
				checksto.setIdStockColor(addProduct.getComboBoxSize().getSelectedIndex());
				checksto.setIdStockSize(addProduct.getComboBoxColor().getSelectedIndex());
				checksto.setStockQty(Integer.parseInt(addProduct.getTextFieldQuantity().getText()));
				try {
					productService.addstockproperty(checksto);
					String data1[] = {a1,b1,c1};
					DefaultTableModel model1 = (DefaultTableModel) addProduct.getTable().getModel();
					model1.addRow(data1);
					addProduct.getTextFieldQuantity().setText("");
				} catch (Myexception e1) {
					JOptionPane.showMessageDialog(f, e1);
				}
				
				
				
			}
		});
		addProduct.getButtonAdd1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a2 = (String) addProduct.getcomboBoxSize1().getSelectedItem();
				String b2 = (String) addProduct.getcomboBoxColor1().getSelectedItem();
				String c2 = (String) addProduct.gettextFieldQuantity1().getText();
				
				Checkstockproperty checksto = new Checkstockproperty();
				checksto.setIdStockColor(addProduct.getcomboBoxSize1().getSelectedIndex());
				checksto.setIdStockSize(addProduct.getcomboBoxColor1().getSelectedIndex());
				checksto.setStockQty(Integer.parseInt(addProduct.gettextFieldQuantity1().getText()));
				try {
					productService.addstockproperty(checksto);
					String data2[] = {a2,b2,c2};
					DefaultTableModel model2 = (DefaultTableModel) addProduct.getTable_1().getModel();
					model2.addRow(data2);
					addProduct.gettextFieldQuantity1().setText("");
				} catch (Myexception e1) {
					JOptionPane.showMessageDialog(f, e1);
				}
				
				
			}
		});
	}
}