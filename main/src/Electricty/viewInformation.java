package Electricty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class viewInformation extends JFrame implements ActionListener {
    JButton cancel;
    String meter;
    public viewInformation(String meter) {
        this.meter = meter;
        setBounds(350,150,850,650);
        getContentPane().setBackground(Color.white);
        setLayout(null);


        JLabel heading  = new JLabel("VIEW CUSTOMER INFORMATION");
        heading.setBounds(250,0,500,40);
        heading.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(heading);

        JLabel lblname;
        lblname = new JLabel("Name");
        lblname.setBounds(70,80,100,20);
        add(lblname);

        JLabel name;
        name = new JLabel("");
        name.setBounds(250,80,100,20);
        add(name);


        JLabel lblmeterno;
        lblmeterno = new JLabel("Meter Number");
        lblmeterno.setBounds(70,140,100,20);
        add(lblmeterno);

        JLabel meterno;
        meterno = new JLabel("");
        meterno.setBounds(250,140,100,20);
        add(meterno);

        JLabel lbladdress;
        lbladdress = new JLabel("Address");
        lbladdress.setBounds(70,200,100,20);
        add(lbladdress);

        JLabel address;
        address = new JLabel("");
        address.setBounds(250,200,100,20);
        add(address);

        JLabel lblcity;
        lblcity = new JLabel("City");
        lblcity.setBounds(70,260,100,20);
        add(lblcity);

        JLabel city;
        city = new JLabel("");
        city.setBounds(250,260,100,20);
        add(city);

        JLabel lblstate;
        lblstate = new JLabel("State");
        lblstate.setBounds(500,80,100,20);
        add(lblstate);

        JLabel state;
        state = new JLabel("");
        state.setBounds(650,80,100,20);
        add(state);

        JLabel lblemail;
        lblemail = new JLabel("Email-ID");
        lblemail.setBounds(500,140,100,20);
        add(lblemail);

        JLabel email;
        email = new JLabel("");
        email.setBounds(650,140,100,20);
        add(email);

        JLabel lblphone;
        lblphone = new JLabel("Phone Number");
        lblphone.setBounds(500,200,100,20);
        add(lblphone);

        JLabel phone;
        phone = new JLabel("");
        phone.setBounds(650,200,100,20);
        add(phone);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meter+"'");
            while (rs.next())
            {
                name.setText(rs.getString("name"));
                address.setText(rs.getString("address"));
                city.setText(rs.getString("city"));
                state.setText(rs.getString("state"));
                email.setText(rs.getString("email"));
                phone.setText(rs.getString("phone"));
                meterno.setText(rs.getString("meter_no"));
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(350,340,100,25);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20,350,600,300);
        add(image);

        setVisible(true);

    }

    public static void main(String[] args) {
        new viewInformation("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(cancel))
        {
            setVisible(false);
        }
    }
}
