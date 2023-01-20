package Electricty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;


public class Depositdetails extends JFrame implements ActionListener {
    Choice meter_number,month;
    JTable table;
    JButton search,print;
    public Depositdetails() {
        super("Deposit Details");




        setSize(700,700);
        setLocation(400,100);
        setLayout(null);
        getContentPane().setBackground(Color.white);



        JLabel lbl_meter_number = new JLabel("Search By Meter Number");
        lbl_meter_number.setBounds(20,20,150,20);
        add(lbl_meter_number);

        meter_number =  new Choice();
        meter_number.setBounds(180,20,150,20);
        add(meter_number);


        try{
            conn c =new conn();
           ResultSet rs = c.s.executeQuery("select * from customer");
           while(rs.next())
           {
               meter_number.add(rs.getString("meter_no"));
           }


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel lbl_month = new JLabel("Search by Month");
        lbl_month.setBounds(400,20,100,20);
        add(lbl_month);

        month =  new Choice();
        month.setBounds(520,20,100,20);
        month.add("january");
        month.add("february");
        month.add("march");month.add("april");
        month.add("may");month.add("june");month.add("july");month.add("august");
        month.add("september");month.add("october");
        month.add("november");month.add("december");
        add(month);

        table = new JTable();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from bill");
            // dbutil is class whoose method take rs as object
            table.setModel(DbUtils.resultSetToTableModel(rs));


        }
        catch (Exception ae)
        {
            ae.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,100,700,600);
        add(sp);


        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds( 120,70,80,20);
        print.addActionListener(this);
        add(print);


        setVisible(true);
    }

    public static void main(String[] args) {
     new Depositdetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==search)
        {
            String query = "select * from bill where meter_no = '"+meter_number.getSelectedItem()+"' and month = '"+month.getSelectedItem()+"'";
            try {
                conn c =new conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }

    }
}
