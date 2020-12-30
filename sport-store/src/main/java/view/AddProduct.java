package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;

public class AddProduct extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCode;
	private JTextField textFieldName;
	private JTable table;
	private JTextField textFieldQuantity;
	private JTextField textFieldPrice;
	private JComboBox comboBoxCategory;
	private JComboBox comboBoxSize ;
	private JComboBox comboBoxColor;
	private JComboBox comboBoxBranch;
	private JButton ButtonAdd;
	private JButton ButtonRemove;
	private JButton ButtonSave;
	private JButton ButtonCancel;
	private PanelProduct panelProduct;
	private JTextArea textArea;

	public AddProduct() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 659, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Category");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(48, 54, 70, 15);
		contentPane.add(lblNewLabel);
		
		comboBoxCategory = new JComboBox();
		comboBoxCategory.setBounds(136, 49, 120, 24);
		contentPane.add(comboBoxCategory);
		
		JLabel lblNewLabel_1 = new JLabel("Code");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(48, 111, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		textFieldCode = new JTextField();
		textFieldCode.setBounds(136, 109, 120, 19);
		contentPane.add(textFieldCode);
		textFieldCode.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(296, 216, 70, 15);
		contentPane.add(lblNewLabel_2);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(136, 163, 120, 19);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Size");
		lblNewLabel_3.setBounds(311, 54, 70, 15);
		contentPane.add(lblNewLabel_3);
		
		comboBoxSize = new JComboBox();
		comboBoxSize.setBounds(406, 49, 157, 24);
		contentPane.add(comboBoxSize);
		
		JLabel lblNewLabel_4 = new JLabel("Color");
		lblNewLabel_4.setBounds(311, 111, 70, 15);
		contentPane.add(lblNewLabel_4);
		
		comboBoxColor = new JComboBox();
		comboBoxColor.setBounds(401, 106, 162, 24);
		contentPane.add(comboBoxColor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(158, 253, 317, 109);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Size", "Color", "Quantity"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_5 = new JLabel("Quantity");
		lblNewLabel_5.setBounds(311, 165, 70, 15);
		contentPane.add(lblNewLabel_5);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setBounds(399, 163, 157, 19);
		contentPane.add(textFieldQuantity);
		textFieldQuantity.setColumns(10);
		
		ButtonAdd = new JButton("Add");
		ButtonAdd.setBounds(499, 253, 117, 25);
		contentPane.add(ButtonAdd);
		
		ButtonRemove = new JButton("Remove");
		ButtonRemove.setBounds(499, 302, 117, 25);
		contentPane.add(ButtonRemove);
		
		ButtonSave = new JButton("Save");
		ButtonSave.setBounds(176, 397, 117, 25);
		contentPane.add(ButtonSave);
		
		ButtonCancel = new JButton("Cancel");
		ButtonCancel.setBounds(338, 397, 117, 25);
		contentPane.add(ButtonCancel);
		
		JLabel lblNewLabel_6 = new JLabel("Branch");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(48, 216, 70, 15);
		contentPane.add(lblNewLabel_6);
		
		comboBoxBranch = new JComboBox();
		comboBoxBranch.setBounds(136, 211, 120, 24);
		contentPane.add(comboBoxBranch);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(401, 214, 154, 19);
		contentPane.add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Name");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(48, 165, 70, 15);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(31, 243, 109, 15);
		contentPane.add(lblDescription);
		
		textArea = new JTextArea();
		textArea.setBounds(12, 271, 136, 142);
		contentPane.add(textArea);
	}
	public PanelProduct getPanelProduct() {
		return panelProduct;
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

	public JTable getTable() {
		return table;
	}

	public JTextField getTextFieldQuantity() {
		return textFieldQuantity;
	}

	public JTextField getTextFieldPrice() {
		return textFieldPrice;
	}

	public JComboBox getComboBoxCategory() {
		return comboBoxCategory;
	}

	public JComboBox getComboBoxSize() {
		return comboBoxSize;
	}

	public JComboBox getComboBoxColor() {
		return comboBoxColor;
	}

	public JComboBox getComboBoxBranch() {
		return comboBoxBranch;
	}

	public JButton getButtonAdd() {
		return ButtonAdd;
	}

	public JButton getButtonRemove() {
		return ButtonRemove;
	}

	public JButton getButtonSave() {
		return ButtonSave;
	}

	public JTextArea getTextDes() {
		return textArea;
	}
	public JButton getButtonCancel() {
		return ButtonCancel;
	}
}
