package controller;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import service.ProductService;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Enumeration;

import view.PanelProduct;

public class ControllerPagination {
	
	int page;
	int rowCountPerPage = 15;
	int totalPage;
	long totalData;
	
	private PanelProduct panelProduct;
	private ProductService productService;
	
	public ControllerPagination(PanelProduct m) {
		panelProduct = m;
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
//		ControllerDeleteMatHang mat = new ControllerDeleteMatHang(panelProduct);
		initPaginations();
	}
	private void initPaginations() {
		totalData = productService.totaldata();
		int b = (int) panelProduct.getComboBoxPage().getSelectedItem();
		panelProduct.getLabelPage().setText("Page "+b+" for "+totalPage);
		panelProduct.getLabelTotalData().setText("Total Data "+totalData);
		int a = (int) panelProduct.getComboBoxPage().getSelectedItem();
		int c =  panelProduct.getComboBoxSort().getSelectedIndex();
		Object[][] data = productService.showproduct(a, 4, c);
		String[] col = {"#","NAME","CODE","PRICE","CATEGORY","SIZE","COLOR","QUANTITY"};
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
