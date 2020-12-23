package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class ViewSpecialBill extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JButton ButtonComplete;
    private JButton ButtonCancel;
    private JTable tableStart;

    public ViewSpecialBill() {
        setTitle("Completed Bill");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 890, 481);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        ButtonComplete = new JButton("Complete");
        ButtonComplete.setBounds(285, 375, 121, 23);
        contentPane.add(ButtonComplete);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(456, 105, 381, 193);
        contentPane.add(scrollPane);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                "Bill Code", "Quantity Clothes", "Value Bill"
            }
        ));
        scrollPane.setViewportView(table);
        
        JLabel lblNewLabel = new JLabel("Selected Bill");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(541, 59, 199, 35);
        contentPane.add(lblNewLabel);
        
        ButtonCancel = new JButton("Cancel");
        ButtonCancel.setBounds(456, 375, 121, 23);
        contentPane.add(ButtonCancel);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(58, 105, 348, 193);
        contentPane.add(scrollPane_1);
        
        tableStart = new JTable();
        tableStart.setModel(new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                "Bill Code", "Quantity Clothes", "Value Bill"
            }
        ));
        scrollPane_1.setViewportView(tableStart);
        
        JLabel lblNewLabel_1 = new JLabel("Bills");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(117, 59, 216, 35);
        contentPane.add(lblNewLabel_1);
    }

    public JPanel getContentPane() {
        return contentPane;
    }

    public JTable getTable() {
        return table;
    }

    public JTable getTableStart() {
        return tableStart;
    }
    
    public JButton getButtonComplete() {
        return ButtonComplete;
    }

    public JButton getButtonCancel() {
        return ButtonCancel;
    }
}




