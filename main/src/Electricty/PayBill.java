package Electricty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class PayBill extends JFrame implements ActionListener {
    Choice month;
    String meter;
    JButton pay,back;
    public PayBill(String meter) {
        this.meter=meter;
        setLayout(null);
        setBounds(300,150,900,600);

        JLabel heading  = new JLabel("PayBill");
        heading.setFont(new Font("Tahoma",Font.BOLD,24));
        heading.setBounds(120,5,400,30);
        add(heading);

        JLabel lblmeterno = new JLabel("Meter Number");
        lblmeterno.setBounds(35,80,200,20);
        add(lblmeterno);

        JLabel meterno = new JLabel();
        meterno.setBounds(300,80,200,20);
        add(meterno);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35,140,200,20);
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(300,140,200,20);
        add(labelname);

        JLabel lblmonth = new JLabel("Month");
        lblmonth.setBounds(35,200,200,20);
        add(lblmonth);

        month =  new Choice();
        month.setBounds(300,200,200,20);
        month.add("january");
        month.add("february");
        month.add("march");month.add("april");
        month.add("may");month.add("june");month.add("july");month.add("august");
        month.add("september");month.add("october");
        month.add("november");month.add("december");
        add(month);


        JLabel lblunits = new JLabel("Units");
        lblunits.setBounds(35,260,200,20);
        add(lblunits);

        JLabel labelunits = new JLabel();
        labelunits.setBounds(300,260,200,20);
        add(labelunits);


        JLabel lbltotalbill= new JLabel("TotalBiLL");
        lbltotalbill.setBounds(35,320,200,20);
        add(lbltotalbill);

        JLabel labeltotalbill = new JLabel();
        labeltotalbill.setBounds(300,320,200,20);
        add(labeltotalbill);

        JLabel lblstatus= new JLabel("Status");
        lblstatus.setBounds(35,380,200,20);
        add(lblstatus);

        JLabel labelstatus = new JLabel();
        labelstatus.setBounds(300,380,200,20);
        labelstatus.setForeground(Color.red);
        add(labelstatus);


        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("Select * from customer where meter_no='"+meter+"'");
            while(rs.next())
            {
                meterno.setText(meter);
                labelname.setText(rs.getString("name"));
            }

             rs = c.s.executeQuery("Select * from bill where meter_no='"+meter+"' AND month = '"+month.getSelectedItem()+"'");
            while(rs.next())
            {
                labelunits.setText(rs.getString("Units"));
                labeltotalbill.setText(rs.getString("totalbill"));
                labelstatus.setText(rs.getString("status"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        month.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("Select * from bill where meter_no='"+meter+"' AND month = '"+month.getSelectedItem()+"'");
                    while(rs.next())
                    {
                        labelunits.setText(rs.getString("Units"));
                        labeltotalbill.setText(rs.getString("totalbill"));
                        labelstatus.setText(rs.getString("status"));
                    }
                }
                catch (Exception re)
                {
                    re.printStackTrace();
                }
            }
        });

        pay  = new JButton("Pay");
        pay.setBackground(Color.black);
        pay.setForeground(Color.WHITE);
        pay.setBounds(100,460,100,25);
        pay.addActionListener(this);
        add(pay);

        back  = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setBounds(230,460,100,25);
        back.addActionListener(this);
        add(back);



        getContentPane().setBackground(Color.white);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,120,600,300);
        add(image);


        setVisible(true);
    }

    public static void main(String[] args) {
        new PayBill("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==pay)
        {
            try
            {
                conn c = new conn();
                c.s.executeUpdate("update bill set status = 'paid' where meter_no = '"+meter+"' AND month ='"+month.getSelectedItem()+"'");
                setVisible(false);
                new paytm(meter);
            }catch (Exception et)
            {
                et.printStackTrace();
            }

        }else
        {
            setVisible(false);
        }

    }
}
