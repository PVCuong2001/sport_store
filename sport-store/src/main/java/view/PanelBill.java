package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;

public class PanelBill extends JPanel {
	private JButton ButtonDeleteBill;
	private JButton ButtonViewBill;
	private JButton ButtonOkBill;
	private JButton ButtonAddBill;
	private JLabel LabelTotalBill;
	private JScrollPane scrollPaneBill;
	private JLabel LabelStartDate;
	private JTextField textFieldminTotal;
	private JTextField textFieldmaxTotal;
	private JTable tableBill;
	private JDateChooser dateChooserBegin;
	private JDateChooser dateChooserEnd;
	private JButton ButtonSpecial;
	public PanelBill() {
		setLayout(null);
		
		ButtonDeleteBill = new JButton("Delete");
		ButtonDeleteBill.setBounds(67, 94, 125, 23);
		add(ButtonDeleteBill);
		
		ButtonViewBill = new JButton("View");
		ButtonViewBill.setBounds(67, 177, 125, 23);
		add(ButtonViewBill);
		
		scrollPaneBill = new JScrollPane();
		scrollPaneBill.setBounds(270, 68, 723, 248);
		add(scrollPaneBill);
		
		tableBill = new JTable();
		scrollPaneBill.setViewportView(tableBill);
		
		ButtonAddBill = new JButton("Add");
		ButtonAddBill.setBounds(67, 224, 125, 23);
		add(ButtonAddBill);
		
		JLabel LabelTableBill = new JLabel("B\u1EA3ng Bill");
		LabelTableBill.setFont(new Font("Tahoma", Font.BOLD, 20));
		LabelTableBill.setHorizontalAlignment(SwingConstants.CENTER);
		LabelTableBill.setBounds(516, 13, 218, 44);
		add(LabelTableBill);
		
		LabelTotalBill = new JLabel("Total Data");
		LabelTotalBill.setFont(new Font("Tahoma", Font.BOLD, 15));
		LabelTotalBill.setHorizontalAlignment(SwingConstants.CENTER);
		LabelTotalBill.setBounds(811, 327, 145, 22);;
		add(LabelTotalBill);
		
		LabelStartDate = new JLabel("From date");
		LabelStartDate.setHorizontalAlignment(SwingConstants.CENTER);
		LabelStartDate.setBounds(169, 333, 78, 14);
		add(LabelStartDate);
		
		JLabel LabelEndDate = new JLabel("to date");
		LabelEndDate.setHorizontalAlignment(SwingConstants.CENTER);
		LabelEndDate.setBounds(383, 331, 75, 14);
		add(LabelEndDate);
		
		JLabel LabelMaxTotal = new JLabel("Min total");
		LabelMaxTotal.setHorizontalAlignment(SwingConstants.CENTER);
		LabelMaxTotal.setBounds(169, 373, 76, 14);
		add(LabelMaxTotal);
		
		textFieldminTotal = new JTextField();
		textFieldminTotal.setBounds(257, 370, 108, 20);
		add(textFieldminTotal);
		textFieldminTotal.setColumns(10);
		
		JLabel LabelMinTotal = new JLabel("Max total");
		LabelMinTotal.setHorizontalAlignment(SwingConstants.CENTER);
		LabelMinTotal.setBounds(383, 373, 75, 14);
		add(LabelMinTotal);
		
		textFieldmaxTotal = new JTextField();
		textFieldmaxTotal.setBounds(462, 371, 108, 20);
		add(textFieldmaxTotal);
		textFieldmaxTotal.setColumns(10);
		
		ButtonOkBill = new JButton("Ok");
		ButtonOkBill.setBounds(577, 348, 89, 23);
		add(ButtonOkBill);
		
		dateChooserBegin = new JDateChooser();
		dateChooserBegin.setBounds(257, 327, 108, 20);
		add(dateChooserBegin);
		
		dateChooserEnd = new JDateChooser();
		dateChooserEnd.setBounds(462, 328, 108, 20);
		add(dateChooserEnd);
		
		ButtonSpecial = new JButton("Special Bill");
		ButtonSpecial.setBounds(67, 272, 125, 25);
		add(ButtonSpecial);

	}
	public JButton getButtonDeleteBill() {
		return ButtonDeleteBill;
	}
	public JButton getButtonOkBill() {
		return ButtonOkBill;
	}
	public JButton getButtonAddBill() {
		return ButtonAddBill;
	}
	public JLabel getLabelTotalBill() {
		return LabelTotalBill;
	}
	public JScrollPane getScrollPaneBill() {
		return scrollPaneBill;
	}
	public JLabel getLabelStartDate() {
		return LabelStartDate;
	}
	public JTextField getTextFieldMaxTotal() {
		return textFieldmaxTotal;
	}
	public JTextField getTextFieldMinTotal() {
		return textFieldminTotal;
	}
	public JTable getTabelBill() {
		return tableBill;
	}
	public JDateChooser getDateChooserBegin() {
		return dateChooserBegin;
	}
	public JDateChooser getDateChooserEnd() {
		return dateChooserEnd;
	}
	public JButton getButtonView() {
		return ButtonViewBill;
	}
	public JButton getButtonSpecialBill() {
		return ButtonSpecial;
	}
}