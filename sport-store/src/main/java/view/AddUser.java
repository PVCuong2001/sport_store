package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JRadioButtonMenuItem;

public class AddUser extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldCode;
    private JTextField textFieldName;
    private JTextField textFieldPassword;
    private JTextField textFieldPhone;
    private JTextField textFieldGmail;
    private JButton ButtonSave;
    private JButton ButtonCancel;
    private JRadioButton radioButtonMale;
    private JRadioButton radioButtonFemale;
    private JRadioButton radioAdmin;
    private JRadioButton radioStaff;
    
    
    public AddUser() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 527, 414);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Code");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(34, 34, 46, 14);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Name");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(34, 96, 46, 14);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Password");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(12, 154, 89, 14);
        contentPane.add(lblNewLabel_2);
        
        textFieldCode = new JTextField();
        textFieldCode.setBounds(98, 31, 133, 20);
        contentPane.add(textFieldCode);
        textFieldCode.setColumns(10);
        
        textFieldName = new JTextField();
        textFieldName.setBounds(98, 93, 133, 20);
        contentPane.add(textFieldName);
        textFieldName.setColumns(10);
        
        textFieldPassword = new JTextField();
        textFieldPassword.setBounds(98, 151, 133, 20);
        contentPane.add(textFieldPassword);
        textFieldPassword.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Phone");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(34, 208, 46, 14);
        contentPane.add(lblNewLabel_3);
        
        textFieldPhone = new JTextField();
        textFieldPhone.setBounds(98, 205, 133, 20);
        contentPane.add(textFieldPhone);
        textFieldPhone.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Gmail");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setBounds(257, 34, 46, 14);
        contentPane.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Gender");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(249, 96, 65, 14);
        contentPane.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Role");
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setBounds(257, 154, 46, 14);
        contentPane.add(lblNewLabel_6);
        
        textFieldGmail = new JTextField();
        textFieldGmail.setBounds(313, 31, 172, 20);
        contentPane.add(textFieldGmail);
        textFieldGmail.setColumns(10);
        
        radioButtonMale = new JRadioButton("Male");
        radioButtonMale.setBounds(309, 92, 69, 23);
        contentPane.add(radioButtonMale);
        
        radioButtonFemale = new JRadioButton("Female");
        radioButtonFemale.setBounds(382, 92, 84, 23);
        contentPane.add(radioButtonFemale);
        
        ButtonSave = new JButton("Save");
        ButtonSave.setBounds(143, 309, 89, 23);
        contentPane.add(ButtonSave);
        
        ButtonCancel = new JButton("Cancel");
        ButtonCancel.setBounds(270, 309, 89, 23);
        contentPane.add(ButtonCancel);
        
        radioAdmin = new JRadioButton("Admin");
        radioAdmin.setBounds(317, 145, 149, 23);
        contentPane.add(radioAdmin);
        
        radioStaff = new JRadioButton("Staff");
        radioStaff.setBounds(317, 182, 149, 23);
        contentPane.add(radioStaff);
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

    public JTextField getTextFieldPassword() {
        return textFieldPassword;
    }

    public JTextField getTextFieldPhone() {
        return textFieldPhone;
    }

    public JTextField getTextFieldGmail() {
        return textFieldGmail;
    }

    public JButton getButtonSave() {
        return ButtonSave;
    }

    public JButton getButtonCancel() {
        return ButtonCancel;
    }

    public JRadioButton getRadioButtonMale() {
        return radioButtonMale;
    }

    public JRadioButton getRadioButtonFemale() {
        return radioButtonFemale;
    }

	public JRadioButton getRadioAdmin() {
		return radioAdmin;
	}

	public JRadioButton getRadioStaff() {
		return radioStaff;
	}
    
}


