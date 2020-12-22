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

    public ViewSpecialBill() {
        setTitle("Completed Bill");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 643, 438);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        ButtonComplete = new JButton("Complete");
        ButtonComplete.setBounds(147, 333, 121, 23);
        contentPane.add(ButtonComplete);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(123, 107, 381, 193);
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
        lblNewLabel.setBounds(207, 48, 199, 35);
        contentPane.add(lblNewLabel);
        
        ButtonCancel = new JButton("Cancel");
        ButtonCancel.setBounds(348, 333, 121, 23);
        contentPane.add(ButtonCancel);
    }

    public JPanel getContentPane() {
        return contentPane;
    }

    public JTable getTable() {
        return table;
    }

    public JButton getButtonComplete() {
        return ButtonComplete;
    }

    public JButton getButtonCancel() {
        return ButtonCancel;
    }
}


