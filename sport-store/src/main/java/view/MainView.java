package view;

import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.UIManager;
import javax.swing.JTable;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;

public class MainView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private PanelUser panelUser;
	private PanelProduct panelProduct;
	private PanelBill panelBill;
	private PanelInfoUser panelInformationUser;
	private JButton ButtonNhanVien;
	private JButton ButtonMatHang;
	private JButton ButtonInforUser;
	private JButton ButtonHoaDon;
	private JButton ButtonLogOut;
	private JTable tableStock;
	private JLabel LabelTotalData;
	private JLabel LabelStatus;
	private JComboBox comboBoxSort;
	private JComboBox comboBoxPage;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainView() {
		setTitle("       C\u1EECA H\u00C0NG B\u00D3NG \u0110\u00C1 C\u01AF\u1EDCNG L\u1EE2I");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1258, 613);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(95, 158, 160)));
		layeredPane.setBounds(29, 104, 1180, 406);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelUser = new PanelUser();
		//layeredPane.add(panelUser, "name_29185430653000");
		panelUser.setLayout(null);
		
		panelProduct = new PanelProduct();
		layeredPane.add(panelProduct, "name_29220497651800");
		
		panelBill = new PanelBill();
		layeredPane.add(panelBill, "name_29254702838100");
		
		JLabel lblNewLabel_2 = new JLabel("Panel Ho\u00E1 \u0111\u01A1n");
		panelBill.add(lblNewLabel_2);
		
		panelInformationUser = new PanelInfoUser();
		layeredPane.add(panelInformationUser, "name_29268846766800");
		
		JLabel lblNewLabel_3 = new JLabel("Panel Th\u00F4ng tin ng\u01B0\u1EDDi d\u00F9ng");
		panelInformationUser.add(lblNewLabel_3);
		
		ButtonInforUser = new JButton("Information User");
		ButtonInforUser.setBackground(UIManager.getColor("Button.shadow"));
		ButtonInforUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		ButtonInforUser.setBounds(672, 29, 168, 43);
		contentPane.add(ButtonInforUser);
		
		ButtonNhanVien = new JButton("Nh\u00E2n vi\u00EAn");
		ButtonNhanVien.setBackground(UIManager.getColor("Button.shadow"));
		ButtonNhanVien.setFont(new Font("Tahoma", Font.BOLD, 15));
		ButtonNhanVien.setBounds(119, 29, 124, 42);
		contentPane.add(ButtonNhanVien);
		
		ButtonMatHang = new JButton("M\u1EB7t h\u00E0ng");
		ButtonMatHang.setBackground(UIManager.getColor("Button.shadow"));
		ButtonMatHang.setFont(new Font("Tahoma", Font.BOLD, 15));
		ButtonMatHang.setBounds(307, 29, 111, 42);
		contentPane.add(ButtonMatHang);
		
		ButtonHoaDon = new JButton("Ho\u00E1 \u0111\u01A1n");
		ButtonHoaDon.setBackground(UIManager.getColor("Button.shadow"));
		ButtonHoaDon.setFont(new Font("Tahoma", Font.BOLD, 15));
		ButtonHoaDon.setBounds(489, 29, 111, 42);
		contentPane.add(ButtonHoaDon);
		
		
		ButtonLogOut = new JButton("LogOut");
		ButtonLogOut.setBackground(UIManager.getColor("Button.shadow"));
		ButtonLogOut.setFont(new Font("Tahoma", Font.BOLD, 15));
		ButtonLogOut.setBounds(901, 29, 89, 42);
		contentPane.add(ButtonLogOut);
		
	}
	public JButton getButtonNhanVien() {
		return ButtonNhanVien;
	}	
	public JButton getButtonMatHang() {
		return ButtonMatHang;
	}
	public JButton getButtonInforUser() {
		return ButtonInforUser;
	}
	public JButton getButtonHoaDon() {
		return ButtonHoaDon;
	}
	public JButton getButtonLogOut() {
		return ButtonLogOut;
	}
	public JLayeredPane getLayeredPane() {
		return layeredPane;
	}
	public PanelUser getpanelUser() {
		return panelUser;
	}
	public  PanelProduct getPanelProduct() {
		return panelProduct;
	}
	public PanelInfoUser getPanelInformationUser() {
		return panelInformationUser;
	}
	public PanelBill getpanelBill() {
		return panelBill;
	}
	public JLabel getLabelTotalData() {
		return LabelTotalData;
	}
	public JLabel getLabelStatus() {
		return LabelStatus;
	}
	public JComboBox getComboBoxSort() {
		return comboBoxSort;
	}
	public JComboBox getComboBoxPage() {
		return comboBoxPage;
	}
	public JTable getTableStock() {
		return tableStock;
	}
}

