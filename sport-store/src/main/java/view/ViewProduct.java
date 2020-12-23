package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ViewProduct extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField textFieldCode;
    private JTextField textFieldBranch;
    private JTextField textFieldName;
    private JTextField textFieldCate;
    private JTextField textFieldPrice;
    private JButton ButtonCancel;
    private JTextArea textAreaDes;
    
    public ViewProduct() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 558, 420);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Code");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(22, 12, 60, 15);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Name");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(22, 43, 60, 15);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Branch");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(301, 12, 70, 15);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Category");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(301, 43, 70, 15);
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Price");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setBounds(301, 80, 70, 15);
        contentPane.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Description");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(22, 80, 114, 15);
        contentPane.add(lblNewLabel_5);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(59, 191, 403, 113);
        contentPane.add(scrollPane);
        
        table = new JTable();
        table.setEnabled(false);
        table.setRowSelectionAllowed(false);
        table.setModel(new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                "Size", "Color", "Quantity"
            }
        ));
        scrollPane.setViewportView(table);
        
        textFieldCode = new JTextField();
        textFieldCode.setEditable(false);
        textFieldCode.setBounds(102, 9, 114, 19);
        contentPane.add(textFieldCode);
        textFieldCode.setColumns(10);
        
        textFieldBranch = new JTextField();
        textFieldBranch.setEditable(false);
        textFieldBranch.setBounds(381, 9, 114, 19);
        contentPane.add(textFieldBranch);
        textFieldBranch.setColumns(10);
        
        textFieldName = new JTextField();
        textFieldName.setEditable(false);
        textFieldName.setBounds(102, 40, 158, 19);
        contentPane.add(textFieldName);
        textFieldName.setColumns(10);
        
        textFieldCate = new JTextField();
        textFieldCate.setEditable(false);
        textFieldCate.setBounds(381, 40, 114, 19);
        contentPane.add(textFieldCate);
        textFieldCate.setColumns(10);
        
        textFieldPrice = new JTextField();
        textFieldPrice.setEditable(false);
        textFieldPrice.setBounds(381, 77, 114, 19);
        contentPane.add(textFieldPrice);
        textFieldPrice.setColumns(10);
        
        ButtonCancel = new JButton("Cancel");
        ButtonCancel.setBounds(202, 333, 117, 25);
        contentPane.add(ButtonCancel);
        
        textAreaDes = new JTextArea();
        textAreaDes.setEditable(false);
        textAreaDes.setBounds(138, 80, 122, 56);
        contentPane.add(textAreaDes);
        
        JLabel lblNewLabel_6 = new JLabel("Product Detail");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setBounds(184, 147, 148, 33);
        contentPane.add(lblNewLabel_6);
    }

    public JPanel getContentPane() {
        return contentPane;
    }

    public JTable getTable() {
        return table;
    }

    public JTextField getTextFieldCode() {
        return textFieldCode;
    }

    public JTextField getTextFieldBranch() {
        return textFieldBranch;
    }

    public JTextField getTextFieldName() {
        return textFieldName;
    }

    public JTextField getTextFieldCate() {
        return textFieldCate;
    }

    public JTextField getTextFieldPrice() {
        return textFieldPrice;
    }

    public JTextArea getTextFieldDes() {
        return textAreaDes;
    }
    
    public JButton getButtonCancel() {
        return ButtonCancel;
    }
}



