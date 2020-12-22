package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import service.UserService;
import service.UserServiceImpl;
import view.PanelUser;

public class ControllerUser {
    private PanelUser panelUser;
    private UserServiceImpl userServiceImpl;
    
    public ControllerUser(PanelUser panelUser,UserServiceImpl userServiceImpl)
    {
        this.panelUser = panelUser;
       this.userServiceImpl=userServiceImpl;
        ShowDataUser();
    }
    public void ShowDataUser( )
    {
        Object[][] data = userServiceImpl.showuser();
        String col[] = {"#","CODE","NAME","PHONE","GMAIL","GENDER","STATUS","ROLE"};
        DefaultTableModel model = (DefaultTableModel) panelUser.getTableUser().getModel();
        model.setDataVector(data, col);
        autoResizeColumn(panelUser.getTableUser());
    }
    private  void autoResizeColumn(JTable table)
    {
        JTableHeader header = table.getTableHeader();
        int rowCount = table.getRowCount();

        final Enumeration columns = table.getColumnModel().getColumns();
        while (columns.hasMoreElements()) {
            TableColumn column = (TableColumn) columns.nextElement();
            int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
            int width = (int) table.getTableHeader().getDefaultRenderer()
                    .getTableCellRendererComponent(table, column.getIdentifier(), false, false, -1, col).getPreferredSize().getWidth();

            for (int row = 0; row < rowCount; row++) {
                int preferedWidth = (int) table.getCellRenderer(row, col).getTableCellRendererComponent(table,
                        table.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
                width = Math.max(width, preferedWidth);
            }
            header.setResizingColumn(column); // this line is very important
            column.setWidth(width + table.getIntercellSpacing().width);
        }
    }
        
}



