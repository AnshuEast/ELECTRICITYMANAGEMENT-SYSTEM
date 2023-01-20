package Electricty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateUserInformation extends JFrame implements ActionListener {
    JButton cancel,update;
    JTextField tfaddress,tfcity,tfphone,tfemail,tfstate;
    JLabel name,meterno;
    String meter;
    public updateUserInformation(String meter) {
        this.meter = meter;
        setBounds(300,150,1050,450);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel heading  = new JLabel("UPDATE CUSTOMER  INFORMATION");
        heading.setBounds(110,0,400,30);
        heading.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(heading);

        JLabel lblname;
        lblname = new JLabel("Name");
        lblname.setBounds(30,50,100,25);
        add(lblname);


        name = new JLabel("");
        name.setBounds(230,50,200,20);
        add(name);


        JLabel lblmeterno;
        lblmeterno = new JLabel("Meter Number");
        lblmeterno.setBounds(30,90,100,25);
        add(lblmeterno);


        meterno = new JLabel("");
        meterno.setBounds(230,90,200,20);
        add(meterno);

        JLabel lbladdress;
        lbladdress = new JLabel("Address");
        lbladdress.setBounds(30,130,100,25);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(300,130,200,20);
        add(tfaddress);


        JLabel lblcity;
        lblcity = new JLabel("City");
        lblcity.setBounds(30,170,100,25);
        add(lblcity);


        tfcity = new JTextField();
        tfcity.setBounds(300,170,200,20);
        add(tfcity);

        JLabel lblstate;
        lblstate = new JLabel("State");
        lblstate.setBounds(30,210,100,25);
        add(lblstate);


        tfstate = new JTextField();
        tfstate.setBounds(300,210,200,20);
        add(tfstate);

        JLabel lblemail;
        lblemail = new JLabel("Email-ID");
        lblemail.setBounds(30,250,100,25);
        add(lblemail);


        tfemail = new JTextField();
        tfemail.setBounds(300,250,200,20);
        add(tfemail);

        JLabel lblphone;
        lblphone = new JLabel("Phone Number");
        lblphone.setBounds(30,290,100,25);
        add(lblphone);


        tfphone = new JTextField();
        tfphone.setBounds(300,290,200,20);
        add(tfphone);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meter+"'");
            while (rs.next())
            {
                name.setText(rs.getString("name"));
                tfaddress.setText(rs.getString("address"));
                tfcity.setText(rs.getString("city"));
                tfstate.setText(rs.getString("state"));
                tfemail.setText(rs.getString("email"));
                tfphone.setText(rs.getString("phone"));
                meterno.setText(rs.getString("meter_no"));
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(230,350,100,25);
        cancel.addActionListener(this);
        add(cancel);

        update = new JButton("Update");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setBounds(70,350,100,25);
        update.addActionListener(this);
        add(update);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550,50,400,300);
        add(image);
        setVisible(true);
    }

    public static void main(String[] args) {
        new updateUserInformation("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == update)
        {
            String address = tfaddress.getText();
            String city = tfcity.getText();
            String state = tfstate.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();

            try{
                conn c = new conn();
                c.s.executeUpdate("update customer set address = '"+address+"',city = '"+city+"',state = '"+state+"' , email = '"+email+"', phone = '"+phone+"' where meter_no = '"+meter+"'");
                JOptionPane.showMessageDialog(null,"user information updated successfully");
                setVisible(false);
            }catch (Exception e1)
            {
                e1.printStackTrace();
            }
        }
        else {
            setVisible(false);
        }
    }
}
