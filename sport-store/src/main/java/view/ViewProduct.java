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

public class ViewProduct extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldCode;
	private JTextField textFieldBranch;
	private JTextField textFieldName;
	private JTextField textFieldCate;
	private JTextField textFieldPrice;
	private JTextField textFieldDes;
	private JButton ButtonCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewProduct frame = new ViewProduct();
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
	public ViewProduct() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Code");
		lblNewLabel.setBounds(12, 12, 70, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(12, 39, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Branch");
		lblNewLabel_2.setBounds(202, 12, 70, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Category");
		lblNewLabel_3.setBounds(212, 30, 70, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Price");
		lblNewLabel_4.setBounds(289, 62, 70, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Description");
		lblNewLabel_5.setBounds(22, 80, 144, 15);
		contentPane.add(lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(99, 106, 260, 96);
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
		
		textFieldCode = new JTextField();
		textFieldCode.setBounds(70, 10, 114, 19);
		contentPane.add(textFieldCode);
		textFieldCode.setColumns(10);
		
		textFieldBranch = new JTextField();
		textFieldBranch.setBounds(259, 0, 114, 19);
		contentPane.add(textFieldBranch);
		textFieldBranch.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(70, 28, 114, 19);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldCate = new JTextField();
		textFieldCate.setBounds(300, 28, 114, 19);
		contentPane.add(textFieldCate);
		textFieldCate.setColumns(10);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(336, 60, 114, 19);
		contentPane.add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
		textFieldDes = new JTextField();
		textFieldDes.setBounds(133, 78, 114, 19);
		contentPane.add(textFieldDes);
		textFieldDes.setColumns(10);
		
		ButtonCancel = new JButton("Cancel");
		ButtonCancel.setBounds(156, 226, 117, 25);
		contentPane.add(ButtonCancel);
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

	public JTextField getTextFieldDes() {
		return textFieldDes;
	}
	
	public JButton getButtonCancel() {
		return ButtonCancel;
	}
}
