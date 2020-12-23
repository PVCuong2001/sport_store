package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;

public class PanelUser extends JPanel {
    private JTextField textFieldName;
    private JTable tableUser;
    private JButton ButtonDeleteUser;
    private JButton ButtonEditUser;
    private JButton ButtonAddUser;
    private JScrollPane scrollPaneUser;
    private JButton ButtonFind;
    private JButton ButtonRefresh;
    /**
     * Create the panel.
     */
    public PanelUser() {
        setLayout(null);
        
        ButtonDeleteUser = new JButton("Delete");
        ButtonDeleteUser.setBounds(63, 112, 89, 23);
        add(ButtonDeleteUser);
        
        ButtonEditUser = new JButton("Edit");
        ButtonEditUser.setBounds(63, 186, 89, 23);
        add(ButtonEditUser);
        
        ButtonAddUser = new JButton("Add");
        ButtonAddUser.setBounds(63, 258, 89, 23);
        add(ButtonAddUser);
        
        scrollPaneUser = new JScrollPane();
        scrollPaneUser.setBounds(206, 100, 620, 288);
        add(scrollPaneUser);
        
        tableUser = new JTable();
        scrollPaneUser.setViewportView(tableUser);
        
        JLabel LabelTableUser = new JLabel("Table User");
        LabelTableUser.setFont(new Font("Tahoma", Font.BOLD, 15));
        LabelTableUser.setHorizontalAlignment(SwingConstants.CENTER);
        LabelTableUser.setBounds(454, 38, 142, 33);
        add(LabelTableUser);
        
        JLabel LabelFindUser = new JLabel("Search");
        LabelFindUser.setHorizontalAlignment(SwingConstants.CENTER);
        LabelFindUser.setBounds(841, 98, 72, 20);
        add(LabelFindUser);
        
        textFieldName = new JTextField();
        textFieldName.setBounds(931, 96, 175, 20);
        add(textFieldName);
        textFieldName.setColumns(10);
        
        ButtonFind = new JButton("Find");
        ButtonFind.setBounds(970, 140, 89, 23);
        add(ButtonFind);
        
        ButtonRefresh = new JButton("Refresh");
        ButtonRefresh.setBounds(63, 319, 89, 23);
        add(ButtonRefresh);

    }
    public JTextField getTextFieldName() {
        return textFieldName;
    }
    public JTable getTableUser() {
        return tableUser;
    }
    public JButton getButtonDeleteUser() {
        return ButtonDeleteUser;
    }
    public JButton getButtonEditUser() {
        return ButtonEditUser;
    }
    public JButton getButtonAddUser() {
        return ButtonAddUser;
    }
    public JScrollPane getScrollPaneUser() {
        return scrollPaneUser;
    }
    public JButton getButtonFind() {
        return ButtonFind;
    }
    public JButton getButtonRefresh() {
        return ButtonRefresh;
    }

}



