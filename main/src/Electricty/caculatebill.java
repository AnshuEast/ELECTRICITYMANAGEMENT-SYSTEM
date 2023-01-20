package Electricty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class caculatebill extends JFrame implements ActionListener {
    JTextField tfname,tfunit;
    JLabel  lb_name,label_address;
    JButton submit,cancel;
    Choice meternumber,cmonth;
    public caculatebill()  {

        setSize(700,500);
        setLocation(400,150);


        // here we create the panel for  partition

        JPanel p  = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(172,216,230));
        add(p);

        // Calculate Electricity Bill

        JLabel heading  = new JLabel("Calculate Electricity Bill");
        heading.setBounds(100,25,400,25);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        p.add(heading);


        JLabel lbl_meter  = new JLabel("Meter Number");
        lbl_meter.setBounds(100,80,100,20);
        p.add(lbl_meter);

        meternumber = new Choice();
        try
        {
           conn c = new conn();
           ResultSet rs =c.s.executeQuery("select * from customer");
           while(rs.next())
           {
               meternumber.add(rs.getString("Meter_no"));
           }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        meternumber.setBounds(240,80,200,20);
        p.add(meternumber);

        // NAME

        JLabel meter_name = new JLabel("Name");
        meter_name.setBounds(100,120,100,20);
        p.add(meter_name);

        // HERE we are making label in front label

        lb_name = new JLabel("");
        lb_name.setBounds(240,120,100,20);
        p.add(lb_name);

        //ADDRESS
        // DYNAMIC ADDRESS WITH RESPECT TO THE METER NUMBER

        JLabel lbl_address  = new JLabel("Address");
        lbl_address.setBounds(100,160,100,20);
        p.add(lbl_address);

        label_address = new JLabel();
        label_address.setBounds(240,160,200,20);
        p.add(label_address);
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meternumber.getSelectedItem()+"'");
            while(rs.next())
            {
                lb_name.setText(rs.getString("name"));
                label_address.setText(rs.getString("address"));
            }
        }catch (Exception ei)
        {
            ei.printStackTrace();
        }

        meternumber.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meternumber.getSelectedItem()+"'");
                    while(rs.next())
                    {
                        lb_name.setText(rs.getString("name"));
                        label_address.setText(rs.getString("address"));
                    }
                }catch (Exception ea)
                {
                    ea.printStackTrace();
                }

            }
        });

        //UNITS

        JLabel lbl_unit  = new JLabel("Units Consumed");
        lbl_unit.setBounds(100,200,100,20);
        p.add(lbl_unit);
        //TEXT-FIELD
        tfunit = new JTextField();
        tfunit.setBounds(240,200,200,20);
        p.add(tfunit);

        //MONTH

        JLabel lbl_month  = new JLabel("Month");
        lbl_month.setBounds(100,240,100,20);
        p.add(lbl_month);

        cmonth = new Choice();
        cmonth.setBounds(240,240,200,20);
        cmonth.add("january");
        cmonth.add("february");
        cmonth.add("march");cmonth.add("april");
        cmonth.add("may");cmonth.add("june");cmonth.add("july");cmonth.add("august");
        cmonth.add("september");cmonth.add("october");
        cmonth.add("november");cmonth.add("december");
        p.add(cmonth);



        submit = new JButton("Submit");
        submit.setBounds(120,390,100,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        p.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(250,390,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        p.add(cancel);


        // here we are setting up border-layout explicitly
        setLayout(new BorderLayout());
        add(p,"Center");


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hi-con2.jpg "));
        Image i2 = i1.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image,"West");

        getContentPane().setBackground(Color.white);


        setVisible(true);



    }
    public static void main(String[] args) {
        new  caculatebill();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==submit)
        {
            String meter = meternumber.getSelectedItem();
            String units = tfunit.getText();
            String months = cmonth.getSelectedItem();

            int total_bill =  0;
            int Unit_cons = Integer.parseInt(units);

            String query = "select * from tax";


            try{
                conn c =new conn();
                ResultSet rs = c.s.executeQuery(query);

                while(rs.next())
                {
                    total_bill +=  Unit_cons * Integer.parseInt(rs.getString("cost_per_unit"));
                    total_bill += Integer.parseInt(rs.getString("meter_rent"));
                    total_bill += Integer.parseInt(rs.getString("service_charge"));
                    total_bill += Integer.parseInt(rs.getString("service_tax"));
                    total_bill += Integer.parseInt(rs.getString("swacch_bharat_cess"));
                    total_bill += Integer.parseInt(rs.getString("fixed_tax"));
                }

            }catch (Exception se)
            {
                se.printStackTrace();
            }
            String query2 = "insert into bill values('"+meter+"','"+months+"','"+units+"','"+total_bill+"','Not paid')";
            try{
                conn c = new conn();
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"customer bill updated successfully");
                setVisible(false);
            }
            catch (Exception eo)
            {
                eo.printStackTrace();
            }
        }
        else {
            setVisible(false);
        }

    }

}
