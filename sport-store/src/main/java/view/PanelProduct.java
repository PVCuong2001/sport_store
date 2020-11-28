package view;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelProduct extends JPanel {
	private JComboBox comboBoxSort;
	private JComboBox comboBoxPage;
	private JLabel LabelTotalData;
	private JLabel LabelPage;
	private JLabel LabelSortOption;
	private JTable table;
	private JLabel LabelExample;
	private JScrollPane scrollPane;
	private JButton ButtonAddData;
	private JButton ButtonDelete;
	public PanelProduct() {
		setLayout(null);
		
		LabelSortOption = new JLabel("Sort Option");
		LabelSortOption.setBounds(10, 32, 68, 14);
		LabelSortOption.setFont(new Font("Tahoma", Font.BOLD, 11));
		LabelSortOption.setHorizontalAlignment(SwingConstants.CENTER);
		add(LabelSortOption);
		
		LabelPage = new JLabel("Page");
		LabelPage.setBounds(10, 69, 68, 14);
		LabelPage.setFont(new Font("Tahoma", Font.BOLD, 11));
		LabelPage.setHorizontalAlignment(SwingConstants.CENTER);
		add(LabelPage);
		
		comboBoxSort = new JComboBox();
		comboBoxSort.setModel(new DefaultComboBoxModel(new String[] {"sort by code asc", "sort by code dsc", "sort by name asc", "sort by name dsc", "sort by price asc", "sort by price dsc", "sort by category asc", "sort by category dsc"}));
		comboBoxSort.setBounds(88, 28, 125, 22);
		add(comboBoxSort);
		
		comboBoxPage = new JComboBox();
		comboBoxPage.setBounds(88, 65, 125, 22);
		add(comboBoxPage);
		
	
		
		LabelTotalData = new JLabel("TotalData");
		LabelTotalData.setHorizontalAlignment(SwingConstants.CENTER);
		LabelTotalData.setBounds(811, 327, 145, 22);
		LabelTotalData.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(LabelTotalData);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(270, 68, 723, 248);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel LabelBangMatHang = new JLabel("B\u1EA2NG M\u1EB6T H\u00C0NG");
		LabelBangMatHang.setHorizontalAlignment(SwingConstants.CENTER);
		LabelBangMatHang.setFont(new Font("Tahoma", Font.BOLD, 17));
		LabelBangMatHang.setBounds(523, 15, 201, 43);
		add(LabelBangMatHang);
		
		ButtonAddData = new JButton("ADD");
		ButtonAddData.setBounds(67, 149, 89, 23);
		add(ButtonAddData);
		
		ButtonDelete = new JButton("DELETE");
		ButtonDelete.setBounds(67, 208, 89, 23);
		add(ButtonDelete);
		
		LabelExample = new JLabel("New label");
		LabelExample.setBounds(27, 305, 186, 36);
		add(LabelExample);

	}
//	public JScrollPane getScrollPane() {
//		return scrollPane;
//	}
	public JComboBox getComboBoxSort() {
		return comboBoxSort;
	}
	public JComboBox getComboBoxPage() {
		return comboBoxPage;
	}
	public JLabel getLabelTotalData() {
		return LabelTotalData;
	}
	public JLabel getLabelPage() {
		return LabelPage;
	}
	public JLabel getLabelSortOption() {
		return LabelSortOption;
	}
	public JTable getTable() {
		return table;
	}
	public JButton getButtonAddData() {
		return ButtonAddData;
	}
	public JButton getButtonDelete() {
		return ButtonDelete;
	}
	public JLabel getLabelExample() {
		return LabelExample;
	}
}
