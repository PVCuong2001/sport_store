package controller;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import model.ProductInfo;
import service.ProductService;
import validate.Myexception;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Enumeration;

import view.PanelProduct;
import view.ViewProduct;

public class ControllerPagination {
	
	int page;
	int rowCountPerPage = 15;
	int totalPage;
	long totalData;
	
	private PanelProduct panelProduct;
	private ProductService productService;
	private JFrame f;
	public ControllerPagination(PanelProduct m) {
		panelProduct = m;
		f=new JFrame();
		productService = new ProductService();
		initComponents();
		panelProduct.getComboBoxPage().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				initPaginations();
			}
		});
		panelProduct.getComboBoxSort().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				initPaginations();
			}
		});

		initPaginations();
		ActionButtonDelete();
		ActionButtonRefresh();
		ActionButtonView();
		
	}
	private void initPaginations() {
		totalData = productService.totaldata();
		int b = (int) panelProduct.getComboBoxPage().getSelectedItem();
		panelProduct.getLabelPage().setText("Page "+b+" for "+totalPage);
		panelProduct.getLabelTotalData().setText("Total Data "+totalData);
		int a = (int) panelProduct.getComboBoxPage().getSelectedItem();
		int c =  panelProduct.getComboBoxSort().getSelectedIndex();
		Object[][] data = productService.showproduct(a, 4, c);
		String[] col = {"#","NAME","CODE","PRICE","CATEGORY","CREATEDATE","UPDATEDATE","DESCRIPTION","STATUS"};
		DefaultTableModel model = (DefaultTableModel) panelProduct.getTable().getModel();
		model.setDataVector(data, col);
		autoResizeColumn(panelProduct.getTable());
		//////
		int f = panelProduct.getTable().getSelectedRow();
		System.out.println(f);
	}
	private void initComponents() {
		panelProduct.getComboBoxPage().removeAllItems();		
		Integer[] datapage=productService.listpage();
		totalPage =datapage.length;
		DefaultComboBoxModel mod = new DefaultComboBoxModel(datapage);
		panelProduct.getComboBoxPage().setModel(mod);
	}
	public void ActionButtonView()
	{
		panelProduct.getButtonView().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ProductInfo productInfo=productService.getprolist().get(panelProduct.getTable().getSelectedRow());
				Object[][] data = productService.showdetail(panelProduct.getTable().getSelectedRow());
				ViewProduct viewProduct=new ViewProduct();
				viewProduct.setVisible(true);
				viewProduct.getTextFieldBranch().setText(productInfo.getBranchCategory().getBranch().getName());
				viewProduct.getTextFieldCate().setText(productInfo.getBranchCategory().getCategory().getName());
				viewProduct.getTextFieldCode().setText(productInfo.getCode());
				viewProduct.getTextFieldDes().setText(productInfo.getDescription());
				viewProduct.getTextFieldName().setText(productInfo.getName());
				viewProduct.getTextFieldPrice().setText(String.valueOf(productInfo.getCurrentPrice()));
				String[] col = {"Color","Size","Quantity"};
				DefaultTableModel model = (DefaultTableModel) viewProduct.getTable().getModel();
				model.setDataVector(data, col);
			}
		});
	}
	public void ActionButtonRefresh(){
		System.out.println(1);
		panelProduct.getButtonRefreshData().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(2);
//				panelProduct.getComboBoxPage().removeAllItems();
				Integer[] datapage=productService.listpage();
				totalPage =datapage.length;
				DefaultComboBoxModel mod = new DefaultComboBoxModel(datapage);
				panelProduct.getComboBoxPage().setModel(mod);
				totalData = productService.totaldata();
				panelProduct.getLabelPage().setText("Page "+1+" for "+totalPage);
				panelProduct.getLabelTotalData().setText("Total Data "+totalData);
				panelProduct.getComboBoxPage().setSelectedIndex(0);
				panelProduct.getComboBoxSort().setSelectedIndex(0);
				System.out.println(4);
				Object[][] data = productService.showproduct(1, 4, 1);
				System.out.println(3);
				String[] col = {"#","NAME","CODE","PRICE","CATEGORY","CREATEDATE","UPDATEDATE","DESCRIPTION","STATUS"};
				DefaultTableModel model = (DefaultTableModel) panelProduct.getTable().getModel();
				model.setDataVector(data, col);
				autoResizeColumn(panelProduct.getTable());
			}
		});
	}
	public void ActionButtonDelete()
	{
		panelProduct.getButtonDelete().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int a=JOptionPane.showConfirmDialog(panelProduct.getButtonDelete(),"Are you sure?");
				if(a==JOptionPane.YES_OPTION) {
					try {
						productService.deleteproduct(panelProduct.getTable().getSelectedRow());
					} catch (Myexception e) {
						JOptionPane.showMessageDialog(f, e);
					}
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
