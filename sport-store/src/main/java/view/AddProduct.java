package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;

public class AddProduct extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldCode;
	private JTextField textFieldPrice;
	private JTextField textFieldQuantity;
	private JTable table;
	private JTextField textFieldQuantity2;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProduct frame = new AddProduct();
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
	public AddProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelProduct = new JLabel("Product");
		LabelProduct.setHorizontalAlignment(SwingConstants.CENTER);
		LabelProduct.setBounds(33, 35, 46, 14);
		contentPane.add(LabelProduct);
		
		JComboBox comboBoxProduct = new JComboBox();
		comboBoxProduct.setModel(new DefaultComboBoxModel(new String[] {"", "Gi\u00E0y \u0111\u00E1 b\u00F3ng", "C\u00FAp b\u00F3ng \u0111\u00E1", "B\u1ECDc \u1ED1ng \u0111\u1ED3ng", "Qu\u1EA7n \u00E1o b\u00F3ng \u0111\u00E1", "T\u1EA5t v\u1EDB", "B\u00F3ng", "T\u00FAi \u0111\u1EF1ng ph\u1EE5 ki\u1EC7n", "\u00C1o l\u00F3t b\u00F3ng \u0111\u00E1", "B\u1ECDc khu\u1EF7u tay"}));
		comboBoxProduct.setBounds(89, 31, 117, 22);
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
		
		JComboBox comboBoxBranch = new JComboBox();
		comboBoxBranch.setModel(new DefaultComboBoxModel(new String[] {"", "Nike", "Adidas", "Puma", "Biti's"}));
		comboBoxBranch.setBounds(89, 144, 117, 22);
		contentPane.add(comboBoxBranch);
		
		JLabel LabelPrice = new JLabel("Price");
		LabelPrice.setHorizontalAlignment(SwingConstants.CENTER);
		LabelPrice.setBounds(33, 191, 46, 14);
		contentPane.add(LabelPrice);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(92, 188, 114, 20);
		contentPane.add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(273, 22, 307, 338);
		//contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		layeredPane.add(panel, "name_924549323925600");
		panel.setLayout(null);
		
		JLabel LabelSize = new JLabel("Size");
		LabelSize.setHorizontalAlignment(SwingConstants.CENTER);
		LabelSize.setBounds(33, 25, 46, 14);
		panel.add(LabelSize);
		
		JComboBox comboBoxSize = new JComboBox();
		comboBoxSize.setModel(new DefaultComboBoxModel(new String[] {"", "36", "37", "38", "39", "40", "41", "42", "43", "44"}));
		comboBoxSize.setBounds(89, 25, 54, 22);
		panel.add(comboBoxSize);
		
		JLabel LabelColor = new JLabel("Color");
		LabelColor.setBounds(177, 25, 46, 14);
		panel.add(LabelColor);
		
		JComboBox comboBoxColor = new JComboBox();
		comboBoxColor.setModel(new DefaultComboBoxModel(new String[] {"", "Green", "Red", "Yellow", "Pink", "Black"}));
		comboBoxColor.setBounds(212, 25, 85, 22);
		panel.add(comboBoxColor);
		
		JLabel LabelQuantity = new JLabel("Quantity");
		LabelQuantity.setBounds(67, 87, 76, 14);
		panel.add(LabelQuantity);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setBounds(162, 84, 86, 20);
		panel.add(textFieldQuantity);
		textFieldQuantity.setColumns(10);
		
		JButton ButtonAdd = new JButton("Add");
		ButtonAdd.setBounds(33, 141, 89, 23);
		ButtonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = (String) comboBoxSize.getSelectedItem();
				String b = (String) comboBoxColor.getSelectedItem();
				String c = (String) textFieldQuantity.getText();
				String data[] = {a,b,c};
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(data);
				textFieldQuantity.setText("");
			}
		});
		panel.add(ButtonAdd);
		
		JScrollPane scrollPane = new JScrollPane();
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
		
		JButton ButtonRemove = new JButton("Remove");
		ButtonRemove.setBounds(162, 141, 89, 23);
		panel.add(ButtonRemove);
		ButtonRemove.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent ae) {
	            // check for selected row first
	        	 DefaultTableModel model1 = (DefaultTableModel) table.getModel();
	            if(table.getSelectedRow() != -1) {
	               // remove selected row from the model
	               model1.removeRow(table.getSelectedRow());
	               JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
	            }
	         }
	      });
		
		JPanel panel_1 = new JPanel();
		layeredPane.add(panel_1, "name_924567161242900");
		panel_1.setLayout(null);
		
		JComboBox comboBoxColor2 = new JComboBox();
		comboBoxColor2.setModel(new DefaultComboBoxModel(new String[] {"", "Green", "Black", "Yellow", "Pink"}));
		comboBoxColor2.setBounds(212, 25, 85, 22);
		panel_1.add(comboBoxColor2);
		
		JLabel LabelColor2 = new JLabel("Color");
		LabelColor2.setBounds(177, 25, 46, 14);
		panel_1.add(LabelColor2);
		
		JLabel LabelSize2 = new JLabel("Size");
		LabelSize2.setHorizontalAlignment(SwingConstants.CENTER);
		LabelSize2.setBounds(33, 25, 46, 14);
		panel_1.add(LabelSize2);
		
		JComboBox comboBoxSize2 = new JComboBox();
		comboBoxSize2.setModel(new DefaultComboBoxModel(new String[] {"", "M", "S", "XL", "XXL"}));
		comboBoxSize2.setBounds(89, 25, 54, 22);
		panel_1.add(comboBoxSize2);
		
		JLabel LabelQuantity2 = new JLabel("Quantity");
		LabelQuantity2.setBounds(67, 87, 76, 14);
		panel_1.add(LabelQuantity2);
		
		textFieldQuantity2 = new JTextField();
		textFieldQuantity2.setBounds(162, 84, 86, 20);
		panel_1.add(textFieldQuantity2);
		textFieldQuantity2.setColumns(10);
		
		JButton ButtonAdd2 = new JButton("Add");
		ButtonAdd2.setBounds(33, 141, 89, 23);
		panel_1.add(ButtonAdd2);
		ButtonAdd2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = (String) comboBoxSize2.getSelectedItem();
				String b = (String) comboBoxColor2.getSelectedItem();
				String c = (String) textFieldQuantity2.getText();
				String data2[] = {a,b,c};
				DefaultTableModel model2 = (DefaultTableModel) table.getModel();
				model2.addRow(data2);
				textFieldQuantity2.setText("");
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
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
		JPanel panel_2 = new JPanel();
		scrollPane_1.setViewportView(table_1);
		
		JButton ButtonRemove2 = new JButton("Remove");
		ButtonRemove2.setBounds(162, 141, 89, 23);
		panel_1.add(ButtonRemove2);
		ButtonRemove2.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent ae) {
	            // check for selected row first
	        	 DefaultTableModel model2 = (DefaultTableModel) table_1.getModel();
	            if(table.getSelectedRow() != -1) {
	               // remove selected row from the model
	               model2.removeRow(table_1.getSelectedRow());
	               JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
	            }
	         }
	      });
		comboBoxProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.add(layeredPane);
				if(comboBoxProduct.getSelectedIndex()>=4) {
					layeredPane.removeAll();
					layeredPane.add(panel_1);
					layeredPane.repaint();
					layeredPane.revalidate();
				}
				else if(comboBoxProduct.getSelectedIndex()>=1){
					layeredPane.removeAll();
					layeredPane.add(panel);
					layeredPane.repaint();
					layeredPane.revalidate();
				}
				else {
					layeredPane.removeAll();
					layeredPane.add(panel_2);
					layeredPane.repaint();
					layeredPane.revalidate();
				}
			}
		});
	}
}
