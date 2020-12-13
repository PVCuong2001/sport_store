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

public class ViewBill extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel BillCode;
	private JLabel UserCode ;
	private JLabel UserName ;
	private JLabel Createdate; 
	private JLabel Desc; 
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 785, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ldBillCode = new JLabel("Bill Code");
		ldBillCode.setBounds(12, 12, 70, 15);
		contentPane.add(ldBillCode);
		
		JLabel ldUserCode = new JLabel("UserCode");
		ldUserCode.setBounds(274, 12, 70, 15);
		contentPane.add(ldUserCode);
		
		JLabel IdUserName = new JLabel("UserName");
		IdUserName.setBounds(530, 12, 70, 15);
		contentPane.add(IdUserName);
		
		JLabel ldCreatedate = new JLabel("CreateDate");
		ldCreatedate.setBounds(12, 39, 70, 15);
		contentPane.add(ldCreatedate);
		
		JLabel ldDescription = new JLabel("Description");
		ldDescription.setBounds(298, 39, 70, 15);
		contentPane.add(ldDescription);
		
		 BillCode = new JLabel("New label");
		BillCode.setBounds(94, 12, 143, 15);
		contentPane.add(BillCode);
		
		 UserCode = new JLabel("New label");
		UserCode.setBounds(356, 12, 70, 15);
		contentPane.add(UserCode);
		
		 UserName = new JLabel("New label");
		UserName.setBounds(656, 12, 70, 15);
		contentPane.add(UserName);
		
		 Createdate = new JLabel("New label");
		Createdate.setBounds(131, 39, 70, 15);
		contentPane.add(Createdate);
		
		 Desc = new JLabel("New label");
		Desc.setBounds(426, 39, 284, 15);
		contentPane.add(Desc);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(115, 161, 467, 80);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"#", "New column", "ProductName", "Color", "Size", "Price", "Quantity", "TotalPrice"
			}
		));
		scrollPane.setViewportView(table);
	}
	public JTable getTable()
	{
		return table;
	}
	public JPanel getContentPane() {
		return contentPane;
	}

	public JLabel getBillCode() {
		return BillCode;
	}

	public JLabel getUserCode() {
		return UserCode;
	}

	public JLabel getUserName() {
		return UserName;
	}

	public JLabel getCreatedate() {
		return Createdate;
	}

	public JLabel getDesc() {
		return Desc;
	}
}
