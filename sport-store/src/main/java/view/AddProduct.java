package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;

import model.Branch;
import model.Category;
import model.Color;
import model.Size;
import service.ProductService;

public class AddProduct extends JFrame {
	
	private ProductService productservice;
	
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldCode;
	private JTextField textFieldPrice;
	private JTextField textFieldQuantity;
	private JTextField textFieldQuantity1;
	private JTable table;
	private JTable table_1;
	private JButton ButtonAdd;
	private JButton ButtonAdd1;
	private JButton ButtonRemove;
	private JButton ButtonRemove1;
	private JButton ButtonSave;
	private JButton ButtonCancel;
	private JComboBox comboBoxProduct;
	private JComboBox comboBoxBranch;
	private JComboBox comboBoxSize;
	private JComboBox comboBoxSize1;
	private JComboBox comboBoxColor;
	private JComboBox comboBoxColor1;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JLayeredPane layeredPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductService p = new ProductService();
					AddProduct frame = new AddProduct(p);
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
	public AddProduct(ProductService p) {
		
		productservice = p;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 620, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelProduct = new JLabel("Product");
		LabelProduct.setHorizontalAlignment(SwingConstants.CENTER);
		LabelProduct.setBounds(33, 35, 46, 14);
		contentPane.add(LabelProduct);
		
		comboBoxProduct = new JComboBox();
		comboBoxProduct.setBounds(89, 31, 117, 22);
		List<Category> datacategory = productservice.uploadproduct().getCategory();
		comboBoxProduct.addItem("");
	 	for(Category c : datacategory) {
	 		comboBoxProduct.addItem(c.getName());
		}
		contentPane.add(comboBoxProduct);
		
		JLabel LabelName = new JLabel("Name");
		LabelName.setHorizontalAlignment(SwingConstants.CENTER);
		LabelName.setBounds(33, 76, 46, 14);
		contentPane.add(LabelName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(92, 73, 114, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel LabelCode = new JLabel("Code");
		LabelCode.setHorizontalAlignment(SwingConstants.CENTER);
		LabelCode.setBounds(33, 116, 46, 14);
		contentPane.add(LabelCode);
		
		textFieldCode = new JTextField();
		textFieldCode.setBounds(92, 113, 114, 20);
		contentPane.add(textFieldCode);
		textFieldCode.setColumns(10);
		
		JLabel LabelBranch = new JLabel("Branch");
		LabelBranch.setHorizontalAlignment(SwingConstants.CENTER);
		LabelBranch.setBounds(33, 151, 46, 14);
		contentPane.add(LabelBranch);
		
		comboBoxBranch = new JComboBox();
		comboBoxBranch.setBounds(89, 144, 117, 22);
		comboBoxBranch.addItem("");
		List<Branch> databranch = productservice.uploadproduct().getBranch();
		for(Branch c : databranch) {
			comboBoxBranch.addItem(c.getName());
		}
		contentPane.add(comboBoxBranch);
		
		JLabel LabelPrice = new JLabel("Price");
		LabelPrice.setHorizontalAlignment(SwingConstants.CENTER);
		LabelPrice.setBounds(33, 191, 46, 14);
		contentPane.add(LabelPrice);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(92, 188, 114, 20);
		contentPane.add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(273, 22, 307, 338);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		layeredPane.add(panel, "name_924549323925600");
		panel.setLayout(null);
		
		JLabel LabelSize = new JLabel("Size");
		LabelSize.setHorizontalAlignment(SwingConstants.CENTER);
		LabelSize.setBounds(33, 25, 46, 14);
		panel.add(LabelSize);
		
		comboBoxSize = new JComboBox();
		comboBoxSize.setBounds(89, 25, 54, 22);
		comboBoxSize.addItem("");
		List<Size> datasize = productservice.uploadproduct().getSizechar();
		for(Size c : datasize) {
			comboBoxSize.addItem(c.getName());
		}
		panel.add(comboBoxSize);
		
		ButtonSave = new JButton("Save");
		ButtonSave.setBounds(179, 340, 89, 23);
		contentPane.add(ButtonSave);
		
		ButtonCancel = new JButton("Cancel");
		ButtonCancel.setBounds(319, 340, 89, 23);
		contentPane.add(ButtonCancel);
		
		JLabel LabelColor = new JLabel("Color");
		LabelColor.setBounds(177, 25, 46, 14);
		panel.add(LabelColor);
		
		comboBoxColor = new JComboBox();
		comboBoxColor.setBounds(212, 25, 85, 22);
		comboBoxColor.addItem("");
		List<Color> datacolor = productservice.uploadproduct().getColor();
		for(Color c : datacolor) {
			comboBoxColor.addItem(c.getName());
		}
		panel.add(comboBoxColor);
		
		JLabel LabelQuantity = new JLabel("Quantity");
		LabelQuantity.setBounds(67, 87, 76, 14);
		panel.add(LabelQuantity);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setBounds(162, 84, 86, 20);
		panel.add(textFieldQuantity);
		textFieldQuantity.setColumns(10);
		
		ButtonAdd = new JButton("Add");
		ButtonAdd.setBounds(33, 141, 89, 23);
		panel.add(ButtonAdd);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 210, 184, 81);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Size", "Color", "Quantity"
			}
		));
		scrollPane.setViewportView(table);
		
		ButtonRemove = new JButton("Remove");
		ButtonRemove.setBounds(162, 141, 89, 23);
		panel.add(ButtonRemove);
		
		panel_1 = new JPanel();
		layeredPane.add(panel_1, "name_924567161242900");
		panel_1.setLayout(null);
		
		comboBoxColor1 = new JComboBox();
		comboBoxColor1.setBounds(212, 25, 85, 22);
		comboBoxColor1.addItem("");
		List<Color> datacolor2 = productservice.uploadproduct().getColor();
		for(Color c : datacolor2) {
			comboBoxColor1.addItem(c.getName());
		}
		panel_1.add(comboBoxColor1);
		
		JLabel LabelColor2 = new JLabel("Color");
		LabelColor2.setBounds(177, 25, 46, 14);
		panel_1.add(LabelColor2);
		
		JLabel LabelSize2 = new JLabel("Size");
		LabelSize2.setHorizontalAlignment(SwingConstants.CENTER);
		LabelSize2.setBounds(33, 25, 46, 14);
		panel_1.add(LabelSize2);
		
		comboBoxSize1 = new JComboBox();
		comboBoxSize1.setBounds(89, 25, 54, 22);
		comboBoxSize1.addItem("");
		List<Size> datasize2 = productservice.uploadproduct().getSizenum();
		for(Size c : datasize2) {
			comboBoxSize1.addItem(c.getName());
		}
		panel_1.add(comboBoxSize1);
		
		JLabel LabelQuantity2 = new JLabel("Quantity");
		LabelQuantity2.setBounds(67, 87, 76, 14);
		panel_1.add(LabelQuantity2);
		
		textFieldQuantity1 = new JTextField();
		textFieldQuantity1.setBounds(162, 84, 86, 20);
		panel_1.add(textFieldQuantity1);
		textFieldQuantity1.setColumns(10);
		
		ButtonAdd1 = new JButton("Add");
		ButtonAdd1.setBounds(33, 141, 89, 23);
		panel_1.add(ButtonAdd1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(67, 210, 184, 81);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Size", "Color", "Quantity"
			}
		));
		panel_2 = new JPanel();
		scrollPane_1.setViewportView(table_1);
		
		ButtonRemove1 = new JButton("Remove");
		ButtonRemove1.setBounds(162, 141, 89, 23);
		panel_1.add(ButtonRemove1);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTextFieldName() {
		return textFieldName;
	}

	public JTextField getTextFieldCode() {
		return textFieldCode;
	}

	public JTextField getTextFieldPrice() {
		return textFieldPrice;
	}

	public JTextField getTextFieldQuantity() {
		return textFieldQuantity;
	}

	public JTextField gettextFieldQuantity1() {
		return textFieldQuantity1;
	}

	public JTable getTable() {
		return table;
	}

	public JTable getTable_1() {
		return table_1;
	}

	public JButton getButtonAdd() {
		return ButtonAdd;
	}

	public JButton getButtonAdd1() {
		return ButtonAdd1;
	}

	public JButton getButtonRemove() {
		return ButtonRemove;
	}

	public JButton getButtonRemove1() {
		return ButtonRemove1;
	}

	public JComboBox getComboBoxProduct() {
		return comboBoxProduct;
	}

	public JComboBox getComboBoxBranch() {
		return comboBoxBranch;
	}

	public JComboBox getComboBoxSize() {
		return comboBoxSize;
	}

	public JComboBox getcomboBoxSize1() {
		return comboBoxSize1;
	}

	public JComboBox getComboBoxColor() {
		return comboBoxColor;
	}

	public JComboBox getcomboBoxColor1() {
		return comboBoxColor1;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JScrollPane getScrollPane_1() {
		return scrollPane_1;
	}

	public JLayeredPane getLayeredPane() {
		return layeredPane;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	public JPanel getPanel_2() {
		return panel_2;
	}

	public JButton getButtonSave() {
		return ButtonSave;
	}

	public JButton getButtonCancel() {
		return ButtonCancel;
	}

}