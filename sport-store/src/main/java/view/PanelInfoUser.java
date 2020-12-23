package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelInfoUser extends JPanel {
    private JTextField textFieldName;
    private JTextField textFieldGender;
    private JTextField textFieldPhone;
    private JTextField textFieldAddress;
    private JTextField textFieldCode;
    private JTextField textFieldGmail;
    private JTextField textFieldPassword;
    private JTextField textFieldRole;

    /**
     * Create the panel.
     */
    public PanelInfoUser() {
        setLayout(null);
        
        JLabel LabelName = new JLabel("Name");
        LabelName.setHorizontalAlignment(SwingConstants.CENTER);
        LabelName.setBounds(225, 43, 46, 14);
        add(LabelName);
        
        JLabel LabelSDT = new JLabel("Phone");
        LabelSDT.setHorizontalAlignment(SwingConstants.CENTER);
        LabelSDT.setBounds(225, 179, 46, 14);
        add(LabelSDT);
        
        JLabel LabelAddress = new JLabel("Address");
        LabelAddress.setHorizontalAlignment(SwingConstants.CENTER);
        LabelAddress.setBounds(225, 251, 46, 14);
        add(LabelAddress);
        
        JLabel LabelGender = new JLabel("Gender");
        LabelGender.setHorizontalAlignment(SwingConstants.CENTER);
        LabelGender.setBounds(225, 109, 46, 14);
        add(LabelGender);
        
        textFieldName = new JTextField();
        textFieldName.setEditable(false);
        textFieldName.setBounds(281, 40, 163, 20);
        add(textFieldName);
        textFieldName.setColumns(10);
        
        textFieldGender = new JTextField();
        textFieldGender.setEditable(false);
        textFieldGender.setBounds(281, 103, 53, 20);
        add(textFieldGender);
        textFieldGender.setColumns(10);
        
        textFieldPhone = new JTextField();
        textFieldPhone.setEditable(false);
        textFieldPhone.setBounds(281, 176, 163, 20);
        add(textFieldPhone);
        textFieldPhone.setColumns(10);
        
        textFieldAddress = new JTextField();
        textFieldAddress.setEditable(false);
        textFieldAddress.setBounds(281, 248, 163, 20);
        add(textFieldAddress);
        textFieldAddress.setColumns(10);
        
        JLabel LabelCode = new JLabel("Code");
        LabelCode.setHorizontalAlignment(SwingConstants.CENTER);
        LabelCode.setBounds(493, 43, 46, 14);
        add(LabelCode);
        
        textFieldCode = new JTextField();
        textFieldCode.setEditable(false);
        textFieldCode.setBounds(562, 40, 163, 20);
        add(textFieldCode);
        textFieldCode.setColumns(10);
        
        JLabel LabelGmail = new JLabel("Gmail");
        LabelGmail.setHorizontalAlignment(SwingConstants.CENTER);
        LabelGmail.setBounds(493, 106, 46, 14);
        add(LabelGmail);
        
        textFieldGmail = new JTextField();
        textFieldGmail.setEditable(false);
        textFieldGmail.setBounds(562, 103, 163, 20);
        add(textFieldGmail);
        textFieldGmail.setColumns(10);
        
        JLabel LabelPassword = new JLabel("Password");
        LabelPassword.setHorizontalAlignment(SwingConstants.CENTER);
        LabelPassword.setBounds(483, 179, 69, 14);
        add(LabelPassword);
        
        textFieldPassword = new JTextField();
        textFieldPassword.setEditable(false);
        textFieldPassword.setBounds(562, 176, 163, 20);
        add(textFieldPassword);
        textFieldPassword.setColumns(10);
        
        JLabel LabelRole = new JLabel("Role");
        LabelRole.setHorizontalAlignment(SwingConstants.CENTER);
        LabelRole.setBounds(493, 251, 46, 14);
        add(LabelRole);
        
        textFieldRole = new JTextField();
        textFieldRole.setEditable(false);
        textFieldRole.setBounds(562, 248, 163, 20);
        add(textFieldRole);
        textFieldRole.setColumns(10);

    }

    public JTextField getTextFieldName() {
        return textFieldName;
    }

    public JTextField getTextFieldGender() {
        return textFieldGender;
    }

    public JTextField getTextFieldPhone() {
        return textFieldPhone;
    }

    public JTextField getTextFieldAddress() {
        return textFieldAddress;
    }

    public JTextField getTextFieldCode() {
        return textFieldCode;
    }

    public JTextField getTextFieldGmail() {
        return textFieldGmail;
    }

    public JTextField getTextFieldPassword() {
        return textFieldPassword;
    }

    public JTextField getTextFieldRole() {
        return textFieldRole;
    }
    
}



