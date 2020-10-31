package view;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import config.Serializable_user;
import model.User;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;

public class MainView extends JFrame {

	/**
	 * 
	 */

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public MainView() {
		setTitle("C\u1EECA H\u00C0NG C\u01AF\u1EDCNG L\u1EE2I");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 891, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 875, 489);
		contentPane.add(tabbedPane);
		
		JPanel mathang = new JPanel();
		tabbedPane.addTab("M\u1EB7t h\u00E0ng", null, mathang, null);
		
		JPanel hoadon = new JPanel();
		tabbedPane.addTab("Ho\u00E1 \u0111\u01A1n", null, hoadon, null);
		
		JPanel nhanvien = new JPanel();
		tabbedPane.addTab("Nh\u00E2n vi\u00EAn", null, nhanvien, null);
	}
}