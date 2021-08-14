package defaultPackage;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class App {
    private JPanel panel1;
    private JTextField number;
    private JComboBox savingsType;
    private JTable table1;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JTable table2;
    private JTextField name;
    private JTextField deposit;
    private JTextField years;
    DefaultTableModel model1;
    DefaultTableModel model2;

    String[] columnNames1 = {"Number",
            "Name",
            "Deposit",
            "Years",
            "Type of Savings"};

    String[] columnNames2 = {"Year",
            "Starting",
            "Interest",
            "Ending Value"};

    public static void main(String[] args){
        JFrame frame = new JFrame("Compound Interest");
        frame.setContentPane(new App().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public App(){
        savingsType.addItem("Savings-Regular");
        savingsType.addItem("Savings-Deluxe");

        model1 = new DefaultTableModel(null,columnNames1);
        table1.setModel(model1);

        model2 = new DefaultTableModel(null,columnNames2);
        table2.setModel(model2);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model1.addRow(new Object[]{number.getText(), name.getText(), deposit.getText(), years.getText(), savingsType.getSelectedItem()});
                showMessageDialog(null, "Record Added");
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessageDialog(null, "Record Edited");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model1.removeRow(table1.getSelectedRow());
                showMessageDialog(null, "Record Deleted");
            }
        });
    }
}
