package Electricty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Generatebill extends JFrame implements ActionListener {
    String meter;
    JButton bill;
    Choice cmonth;
    JTextArea area;
    public Generatebill(String meter) {
        this.meter = meter;
        setSize(500,800);
        setLocation(550,50);

        setLayout(new BorderLayout());

        JPanel panel  = new JPanel();

        JLabel heading = new JLabel("Generate Bill");
        JLabel meternumber = new JLabel();

        cmonth = new Choice();
        cmonth.add("january");
        cmonth.add("february");
        cmonth.add("march");cmonth.add("april");
        cmonth.add("may");cmonth.add("june");cmonth.add("july");cmonth.add("august");
        cmonth.add("september");cmonth.add("october");
        cmonth.add("november");cmonth.add("december");


        area = new JTextArea(50,15);
        area.setText("\n\n\t----------Click on the-------------\n\t Generate Bill Button to get \n\t the bill of selected month");
        area.setFont(new Font("Senserif",Font.ITALIC,18));
        JScrollPane pane = new JScrollPane(area);
        bill = new JButton("Generate Bill");
        bill.addActionListener(this);

        panel.add(heading);
        panel.add(meternumber);
        panel.add(cmonth);
        add(panel, "North");
        add(pane,"Center");
        add(bill,"South");
        setVisible(true);
    }

    public static void main(String[] args) {
            new Generatebill("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try
        {
            conn c = new conn();
            String month = cmonth.getSelectedItem();
            area.setText("\t Andani Power Limited\n  Electricity Bill Generated for the month of "+month+",2022\n\n\n");

            ResultSet rs = c.s.executeQuery("select * from customer where meter_no ='"+meter+"'");
            if(rs.next())
            {
                area.append("\n    Customer Name:" + rs.getString("name"));
                area.append("\n    Meter number:" + rs.getString("meter_no"));
                area.append("\n    Address:" + rs.getString("address"));
                area.append("\n    City:" + rs.getString("city"));
                area.append("\n    State:" + rs.getString("state"));
                area.append("\n    E-Mail:" + rs.getString("email"));
                area.append("\n    Mobile No:" + rs.getString("phone"));
                area.append("\n-----------------------------------------------------");
                area.append("\n");
            }

             rs = c.s.executeQuery("select * from meter_info where meter_no ='"+meter+"'");
            if(rs.next())
            {
                area.append("\n    Meter Location:" + rs.getString("meter_location"));
                area.append("\n    Meter Type:" + rs.getString("meter_type"));
                area.append("\n    Phase Code:" + rs.getString("phase_code"));
                area.append("\n    BillType:" + rs.getString("bill_type"));
                area.append("\n    Days:" + rs.getString("days"));
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }
}
