package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class EditProduct extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldCode;
    private JTextField textFieldName;
    private JTextField textFieldPrice;
    private JTextField textFieldCategory;
    private JTextField textFieldBranch;
    private JTable table;
    private JButton ButtonCancel;
    private JButton ButtonSave;
    private JTextArea textAreaDes;
    private JButton buttonAdd;
    private JButton buttonRemove;
    private JTextField textFieldQuantity;
    private JComboBox comboBoxColor;
    private JComboBox comboBoxSize;

    public EditProduct() {
        
        setBounds(100, 100, 639, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel LabelCode = new JLabel("Code");
        LabelCode.setHorizontalAlignment(SwingConstants.CENTER);
        LabelCode.setBounds(35, 37, 46, 14);
        contentPane.add(LabelCode);
        
        textFieldCode = new JTextField();
        textFieldCode.setEditable(false);
        textFieldCode.setBounds(102, 34, 138, 20);
        contentPane.add(textFieldCode);
        textFieldCode.setColumns(10);
        
        JLabel LabelName = new JLabel("Name");
        LabelName.setHorizontalAlignment(SwingConstants.CENTER);
        LabelName.setBounds(35, 80, 46, 14);
        contentPane.add(LabelName);
        
        textFieldName = new JTextField();
        textFieldName.setEditable(true);
        textFieldName.setBounds(102, 77, 138, 20);
        contentPane.add(textFieldName);
        textFieldName.setColumns(10);
        
        JLabel LabelDes = new JLabel("Description");
        LabelDes.setHorizontalAlignment(SwingConstants.CENTER);
        LabelDes.setBounds(21, 127, 71, 14);
        contentPane.add(LabelDes);
        
        textAreaDes = new JTextArea();
        textAreaDes.setEditable(true);
        textAreaDes.setBounds(102, 122, 138, 63);
        contentPane.add(textAreaDes);
        
        JLabel LabelBranch = new JLabel("Branch");
        LabelBranch.setHorizontalAlignment(SwingConstants.CENTER);
        LabelBranch.setBounds(328, 37, 46, 14);
        contentPane.add(LabelBranch);
        
        JLabel LabelCategory = new JLabel("Category");
        LabelCategory.setHorizontalAlignment(SwingConstants.CENTER);
        LabelCategory.setBounds(315, 80, 71, 14);
        contentPane.add(LabelCategory);
        
        JLabel LabelPrice = new JLabel("Price");
        LabelPrice.setHorizontalAlignment(SwingConstants.CENTER);
        LabelPrice.setBounds(328, 127, 46, 14);
        contentPane.add(LabelPrice);
        
        textFieldPrice = new JTextField();
        textFieldPrice.setBounds(384, 124, 157, 20);
        contentPane.add(textFieldPrice);
        textFieldPrice.setColumns(10);
        
        textFieldCategory = new JTextField();
        textFieldCategory.setEditable(false);
        textFieldCategory.setBounds(384, 77, 157, 20);
        contentPane.add(textFieldCategory);
        textFieldCategory.setColumns(10);
        
        textFieldBranch = new JTextField();
        textFieldBranch.setEditable(false);
        textFieldBranch.setBounds(384, 34, 157, 20);
        contentPane.add(textFieldBranch);
        textFieldBranch.setColumns(10);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(187, 207, 270, 119);
        contentPane.add(scrollPane);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                "Color", "Size", "Quantity"
            }
        ));
        scrollPane.setViewportView(table);
        
        ButtonCancel = new JButton("Cancel");
        ButtonCancel.setBounds(211, 357, 89, 23);
        contentPane.add(ButtonCancel);
        
        ButtonSave = new JButton("Save");
        ButtonSave.setBounds(340, 357, 89, 23);
        contentPane.add(ButtonSave);
        
        buttonAdd = new JButton("Add");
        buttonAdd.setBounds(485, 204, 71, 23);
        contentPane.add(buttonAdd);
        
        buttonRemove = new JButton("Remove");
        buttonRemove.setFont(new Font("Tahoma", Font.PLAIN, 9));
        buttonRemove.setBounds(485, 238, 71, 23);
        contentPane.add(buttonRemove);
        
        JLabel lblNewLabel = new JLabel("Size");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(10, 227, 46, 14);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Color");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(10, 273, 46, 14);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Quantity");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(0, 320, 66, 14);
        contentPane.add(lblNewLabel_2);
        
        comboBoxSize = new JComboBox();
        comboBoxSize.setBounds(66, 223, 111, 22);
        contentPane.add(comboBoxSize);
        
        comboBoxColor = new JComboBox();
        comboBoxColor.setBounds(66, 269, 111, 22);
        contentPane.add(comboBoxColor);
        
        textFieldQuantity = new JTextField();
        textFieldQuantity.setBounds(71, 317, 86, 20);
        contentPane.add(textFieldQuantity);
        textFieldQuantity.setColumns(10);
    }

    public JPanel getContentPane() {
        return contentPane;
    }

    public JTextField getTextFieldCode() {
        return textFieldCode;
    }

    public JTextField getTextFieldName() {
        return textFieldName;
    }

    public JTextField getTextFieldPrice() {
        return textFieldPrice;
    }

    public JTextField getTextFieldCategory() {
        return textFieldCategory;
    }

    public JTextField getTextFieldBranch() {
        return textFieldBranch;
    }

    public JTable getTable() {
        return table;
    }

    public JButton getButtonCancel() {
        return ButtonCancel;
    }

    public JButton getButtonSave() {
        return ButtonSave;
    }
    
    public JTextArea getTextAreaDes() {
        return textAreaDes;
    }
    
    public JButton getButtonAdd() {
        return buttonAdd;
    }
    
    public JButton getButtonRemove() {
        return buttonRemove;
    }

    public JTextField getTextFieldQuantity() {
        return textFieldQuantity;
    }

    public JComboBox getComboBoxColor() {
        return comboBoxColor;
    }

    public JComboBox getComboBoxSize() {
        return comboBoxSize;
    }
    
}



