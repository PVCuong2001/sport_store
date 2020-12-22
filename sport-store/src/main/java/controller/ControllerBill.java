package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.List;

import javax.management.InstanceNotFoundException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import service.BillService;
import service.BillServiceImpl;
import validate.Myexception;
import view.PanelBill;
import view.ViewBill;
public class ControllerBill {
	
	private PanelBill panelBill;
	private BillServiceImpl billServiceImpl;
	private JFrame f;
	public ControllerBill(PanelBill p,BillServiceImpl billServiceImpl) {
		this.billServiceImpl = billServiceImpl;
		panelBill = p;
		f=new JFrame();
		ActionButtonOk(); 
		ActionButtonView();
		ActionButtonDelete();
	}
	private void ActionButtonOk() {
		panelBill.getButtonOkBill().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
				String mindate = df1.format(panelBill.getDateChooserBegin().getDate());
				DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
				String maxdate = df2.format(panelBill.getDateChooserEnd().getDate());
				int minTotal = Integer.parseInt(panelBill.getTextFieldMinTotal().getText());
				int maxTotal = Integer.parseInt(panelBill.getTextFieldMaxTotal().getText());
				Object[][] data = billServiceImpl.showbill(minTotal, maxTotal,mindate, maxdate);
				String[] col = {"#","Code","Usercode","Total Quantity","Total Price" ,"Create Date"};
				DefaultTableModel model = (DefaultTableModel) panelBill.getTabelBill().getModel();
				model.setDataVector(data, col);
				autoResizeColumn(panelBill.getTabelBill());
				panelBill.getTextFieldMaxTotal().setText("");
				panelBill.getTextFieldMinTotal().setText("");
			}
		});
	}
	public void ActionButtonDelete()
	{
		panelBill.getButtonDeleteBill().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int a = JOptionPane.showConfirmDialog(panelBill, "Are you sure?");
				if(a==JOptionPane.YES_OPTION)
				{
					try {
						billServiceImpl.deletebill(panelBill.getTabelBill().getSelectedRow());
					} catch (Myexception e) {
						JOptionPane.showMessageDialog(f,e,"Alert",JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
	}
	private void ActionButtonView()
	{
		panelBill.getButtonView().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewBill viewbill = new ViewBill();
				int index=panelBill.getTabelBill().getSelectedRow();
				Object[][] data=billServiceImpl.showbilldetail(index);
				List<Object[]>list=billServiceImpl.getshowbill();
				viewbill.getBillCode().setText(list.get(index)[1].toString());
				viewbill.getUserCode().setText(list.get(index)[9].toString());
				viewbill.getUserName().setText(list.get(index)[8].toString());
				viewbill.getCreatedate().setText(list.get(index)[2].toString());
				viewbill.getDesc().setText(list.get(index)[4].toString());
				String[] col = {"#","ProductCode","ProductName","Color","Size","Quantity","Price","TotalPrice"};
				DefaultTableModel model = (DefaultTableModel) viewbill.getTable().getModel();
				model.setDataVector(data, col);
				viewbill.setVisible(true);
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