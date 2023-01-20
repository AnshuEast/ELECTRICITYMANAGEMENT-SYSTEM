package Electricty;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class customerdetails extends  JFrame implements ActionListener {
    Choice meter_number,month;
    JTable table;
    JButton search,print;
    public customerdetails() {
        super("Customer Details");

            setSize(1200,650);
            setLocation(200,150);
            table = new JTable();
            try{
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("select * from customer");
                // dbutil is class whose method take rs as object
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception ae)
            {
                ae.printStackTrace();
            }

            JScrollPane sp = new JScrollPane(table);
            add(sp);


            print = new JButton("Print");
            print.addActionListener(this);
            add(print,"South");

            setVisible(true);
    }

    public static void main(String[] args) {
        new customerdetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            try {
                table.print();
            }catch (Exception ex) {
                ex.printStackTrace();
            }
    }
}
