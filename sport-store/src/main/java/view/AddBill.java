package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class AddBill extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JButton ButtonSave;
    private JButton ButtonAdd;
    private JButton ButtonCancel;
    private JTextArea textAreaDescription;
    private JScrollPane scrollPane;
    private JTextField textFieldCodeProduct;
    private JLabel LabelBillCode;
    private JTextField textFieldCodeBill;
    private JLabel LabelDanhsach;
    private JLabel LabelColorSize;
    private JComboBox comboBoxSizeColor;
    private JLabel LabelQuantity;
    private JTextField textFieldQuantity;
    private JButton ButtonFind;

    public AddBill() {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 872, 445);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel LabelCode = new JLabel("Code");
        LabelCode.setHorizontalAlignment(SwingConstants.CENTER);
        LabelCode.setBounds(10, 46, 70, 15);
        contentPane.add(LabelCode);
        
        JLabel LabelDescription = new JLabel("Description");
        LabelDescription.setHorizontalAlignment(SwingConstants.CENTER);
        LabelDescription.setBounds(10, 89, 70, 15);
        contentPane.add(LabelDescription);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(221, 184, 379, 151);
        contentPane.add(scrollPane);
        
        table = new JTable();
       table.setModel(new DefaultTableModel(
               new Object[][] {
               },
               new String[] {
                   "Code", "Color - Size", "Quantity"
               }
     ));
        scrollPane.setViewportView(table);
        
        ButtonSave = new JButton("Save");
        ButtonSave.setBounds(263, 358, 89, 23);
        contentPane.add(ButtonSave);
        
        ButtonCancel = new JButton("Cancel");
        ButtonCancel.setBounds(414, 358, 89, 23);
        contentPane.add(ButtonCancel);
        
        textAreaDescription = new JTextArea();
        textAreaDescription.setBounds(115, 84, 127, 61);
        contentPane.add(textAreaDescription);
        
        ButtonAdd = new JButton("ADD");
        ButtonAdd.setBounds(637, 65, 89, 23);
        contentPane.add(ButtonAdd);
        
        textFieldCodeProduct = new JTextField();
        textFieldCodeProduct.setBounds(115, 43, 127, 20);
        contentPane.add(textFieldCodeProduct);
        textFieldCodeProduct.setColumns(10);
        
        LabelBillCode = new JLabel("Bill Code");
        LabelBillCode.setHorizontalAlignment(SwingConstants.CENTER);
        LabelBillCode.setBounds(10, 246, 46, 14);
        contentPane.add(LabelBillCode);
        
        textFieldCodeBill = new JTextField();
        textFieldCodeBill.setBounds(66, 246, 103, 20);
        contentPane.add(textFieldCodeBill);
        textFieldCodeBill.setColumns(10);
        
        LabelDanhsach = new JLabel("Danh s\u00E1ch m\u1EB7t h\u00E0ng");
        LabelDanhsach.setHorizontalAlignment(SwingConstants.CENTER);
        LabelDanhsach.setBounds(294, 159, 224, 14);
        contentPane.add(LabelDanhsach);
        
        LabelColorSize = new JLabel("Color - Size");
        LabelColorSize.setHorizontalAlignment(SwingConstants.CENTER);
        LabelColorSize.setBounds(376, 46, 70, 14);
        contentPane.add(LabelColorSize);
        
        comboBoxSizeColor = new JComboBox();
        comboBoxSizeColor.setBounds(473, 42, 127, 22);
        contentPane.add(comboBoxSizeColor);
        
        LabelQuantity = new JLabel("Quantity");
        LabelQuantity.setHorizontalAlignment(SwingConstants.CENTER);
        LabelQuantity.setBounds(376, 89, 70, 14);
        contentPane.add(LabelQuantity);
        
        textFieldQuantity = new JTextField();
        textFieldQuantity.setBounds(473, 86, 127, 20);
        contentPane.add(textFieldQuantity);
        textFieldQuantity.setColumns(10);
        
        ButtonFind = new JButton("Find");
        ButtonFind.setBounds(263, 42, 57, 23);
        contentPane.add(ButtonFind);
    }

    public JPanel getContentPane() {
        return contentPane;
    }

    public JTable getTable() {
        return table;
    }

    public JButton getButtonSave() {
        return ButtonSave;
    }

    public JButton getButtonAdd() {
        return ButtonAdd;
    }

    public JButton getButtonCancel() {
        return ButtonCancel;
    }

    public JTextArea getTextAreaDescription() {
        return textAreaDescription;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JTextField getTextFieldCodeProduct() {
        return textFieldCodeProduct;
    }

    public JLabel getLabelBillCode() {
        return LabelBillCode;
    }

    public JTextField getTextFieldCodeBill() {
        return textFieldCodeBill;
    }

    public JLabel getLblNewLabel() {
        return LabelDanhsach;
    }

    public JLabel getLabelColorSize() {
        return LabelColorSize;
    }

    public JComboBox getComboBoxSizeColor() {
        return comboBoxSizeColor;
    }

    public JLabel getLblNewLabel_2() {
        return LabelQuantity;
    }

    public JTextField getTextFieldQuantity() {
        return textFieldQuantity;
    }

    public JButton getButtonFind() {
        return ButtonFind;
    }
    
    
}




