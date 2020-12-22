package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class EditUser extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldCode;
    private JTextField textFieldName;
    private JTextField textFieldPassword;
    private JTextField textFieldPhone;
    private JTextField textFieldGmail;
    private JButton ButtonSave;
    private JButton ButtonCancel;
    private JRadioButton radioFemale;
    private JRadioButton radioMale;
    private JRadioButton RadioAdmin;
    private JRadioButton RadioStaff;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EditUser frame = new EditUser();
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
    public EditUser() {
        setTitle("Edit user");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 590, 431);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Code");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(58, 33, 46, 14);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Name");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(58, 85, 46, 14);
        contentPane.add(lblNewLabel_1);
        
        textFieldCode = new JTextField();
        textFieldCode.setEditable(false);
        textFieldCode.setBounds(116, 30, 125, 20);
        contentPane.add(textFieldCode);
        textFieldCode.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Password");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(58, 130, 46, 14);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Phone");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(58, 181, 46, 14);
        contentPane.add(lblNewLabel_3);
        
        textFieldName = new JTextField();
        textFieldName.setBounds(116, 82, 125, 20);
        contentPane.add(textFieldName);
        textFieldName.setColumns(10);
        
        textFieldPassword = new JTextField();
        textFieldPassword.setBounds(116, 127, 125, 20);
        contentPane.add(textFieldPassword);
        textFieldPassword.setColumns(10);
        
        textFieldPhone = new JTextField();
        textFieldPhone.setBounds(116, 178, 125, 20);
        contentPane.add(textFieldPhone);
        textFieldPhone.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Gmail");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setBounds(324, 33, 46, 14);
        contentPane.add(lblNewLabel_4);
        
        textFieldGmail = new JTextField();
        textFieldGmail.setBounds(390, 30, 138, 20);
        contentPane.add(textFieldGmail);
        textFieldGmail.setColumns(10);
        
        JLabel lblNewLabel_5 = new JLabel("Gender");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(324, 85, 46, 14);
        contentPane.add(lblNewLabel_5);
        
        radioMale = new JRadioButton("Male");
        radioMale.setBounds(390, 81, 57, 23);
        contentPane.add(radioMale);
        
        radioFemale = new JRadioButton("Female");
        radioFemale.setBounds(454, 81, 63, 23);
        contentPane.add(radioFemale);
        
        JLabel lblNewLabel_6 = new JLabel("Role");
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setBounds(324, 130, 46, 14);
        contentPane.add(lblNewLabel_6);
        
        ButtonSave = new JButton("Save");
        ButtonSave.setBounds(152, 323, 89, 23);
        contentPane.add(ButtonSave);
        
        ButtonCancel = new JButton("Cancel");    
        ButtonCancel.setBounds(315, 323, 89, 23);
        contentPane.add(ButtonCancel);
        
        RadioAdmin = new JRadioButton("Admin");
        RadioAdmin.setBounds(398, 126, 149, 23);
        contentPane.add(RadioAdmin);
        
        RadioStaff = new JRadioButton("Staff");
        RadioStaff.setBounds(398, 177, 149, 23);
        contentPane.add(RadioStaff);
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

    public JRadioButton getRadioFemale() {
        return radioFemale;
    }

    public JRadioButton getRadioMale() {
        return radioMale;
    }

	public JRadioButton getRadioAdmin() {
		return RadioAdmin;
	}

	public JRadioButton getRadioStaff() {
		return RadioStaff;
	}
    
}



