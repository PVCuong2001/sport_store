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
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ViewBill extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField textFieldCode;
    private JTextField textFieldCreateDate;
    private JTextField textFieldUserCode;
    private JTextField textFieldUserName;
    private JTextArea textAreaDes;
    private JLabel lblNewLabel;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewBill frame = new ViewBill();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ViewBill() {
        setTitle("Bill Detail");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 785, 454);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel ldBillCode = new JLabel("Bill Code");
        ldBillCode.setBounds(10, 22, 97, 15);
        contentPane.add(ldBillCode);
        
        JLabel ldUserCode = new JLabel("UserCode");
        ldUserCode.setBounds(282, 22, 89, 15);
        contentPane.add(ldUserCode);
        
        JLabel IdUserName = new JLabel("UserName");
        IdUserName.setBounds(512, 22, 98, 15);
        contentPane.add(IdUserName);
        
        JLabel ldCreatedate = new JLabel("CreateDate");
        ldCreatedate.setBounds(9, 71, 98, 15);
        contentPane.add(ldCreatedate);
        
        JLabel ldDescription = new JLabel("Description");
        ldDescription.setBounds(348, 71, 98, 15);
        contentPane.add(ldDescription);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(44, 208, 681, 184);
        contentPane.add(scrollPane);
        
        table = new JTable();
        table.setEnabled(false);
        table.setRowSelectionAllowed(false);
        table.setModel(new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                "#", "New column", "ProductName", "Color", "Size", "Price", "Quantity", "TotalPrice"
            }
        ));
        scrollPane.setViewportView(table);
        
        textFieldCode = new JTextField();
        textFieldCode.setEditable(false);
        textFieldCode.setBounds(145, 20, 119, 20);
        contentPane.add(textFieldCode);
        textFieldCode.setColumns(10);
        
        textFieldCreateDate = new JTextField();
        textFieldCreateDate.setEditable(false);
        textFieldCreateDate.setBounds(114, 69, 176, 20);
        contentPane.add(textFieldCreateDate);
        textFieldCreateDate.setColumns(10);
        
        textFieldUserCode = new JTextField();
        textFieldUserCode.setEditable(false);
        textFieldUserCode.setBounds(375, 20, 119, 20);
        contentPane.add(textFieldUserCode);
        textFieldUserCode.setColumns(10);
        
        textFieldUserName = new JTextField();
        textFieldUserName.setEditable(false);
        textFieldUserName.setBounds(628, 20, 134, 20);
        contentPane.add(textFieldUserName);
        textFieldUserName.setColumns(10);
        
        textAreaDes = new JTextArea();
        textAreaDes.setEditable(false);
        textAreaDes.setBounds(467, 71, 295, 51);
        contentPane.add(textAreaDes);
        
        lblNewLabel = new JLabel("Bill Detail");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(246, 142, 217, 41);
        contentPane.add(lblNewLabel);
    }
    public JTable getTable()
    {
        return table;
    }
    public JPanel getContentPane() {
        return contentPane;
    }

    public JTextField getTextFieldCode() {
        return textFieldCode;
    }

    public JTextField getTextFieldCreateDate() {
        return textFieldCreateDate;
    }

    public JTextField getTextFieldUserCode() {
        return textFieldUserCode;
    }

    public JTextField getTextFieldUserName() {
        return textFieldUserName;
    }

    public JTextArea getTextAreaDes() {
        return textAreaDes;
    }
    

}



