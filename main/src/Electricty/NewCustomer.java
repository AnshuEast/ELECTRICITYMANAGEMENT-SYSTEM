package Electricty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class NewCustomer extends JFrame  implements ActionListener {
    JTextField tfname,tfaddress,tfcity,tfState,tfemail,tfphone;
    JLabel  lblmeter;
    JButton next,cancel;
    public NewCustomer()  {

        setSize(700,500);
        setLocation(400,200);


        // here we create the panel for  partition

        JPanel p  = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(172,216,230));
        add(p);

        // LABEL FOR NEW CUSTOMER

        JLabel heading  = new JLabel("NEW CUSTOMER");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        p.add(heading);


        JLabel lblname  = new JLabel("Customer Name");
        lblname.setBounds(100,80,100,20);
        p.add(lblname);
        //TEXT-FIELD
        tfname = new JTextField();
        tfname.setBounds(240,80,200,20);
        p.add(tfname);

        // METER NUMBER WHICH IS AUTO-GENERATED

        JLabel meterno  = new JLabel("Meter Number");
        meterno.setBounds(100,120,100,20);
        p.add(meterno);

        // HERE we are making label in front label

        lblmeter  = new JLabel("");
        lblmeter.setBounds(240,120,100,20);
        p.add(lblmeter);

        Random ran = new Random();
        Long number = ran.nextLong()%100000;
        lblmeter.setText("" + Math.abs(number));

        //ADDRESS

        JLabel lbladdress  = new JLabel("Address");
        lbladdress.setBounds(100,160,100,20);
        p.add(lbladdress);
        //TEXT-FIELD
        tfaddress = new JTextField();
        tfaddress.setBounds(240,160,200,20);
        p.add(tfaddress);

        //CITY

        JLabel lblcity  = new JLabel("CITY");
        lblcity.setBounds(100,200,100,20);
        p.add(lblcity);
        //TEXT-FIELD
        tfcity = new JTextField();
        tfcity.setBounds(240,200,200,20);
        p.add(tfcity);

        // STATE

        JLabel lblstate  = new JLabel("STATE");
        lblstate.setBounds(100,240,100,20);
        p.add(lblstate);
        //TEXT-FIELD
        tfState = new JTextField();
        tfState.setBounds(240,240,200,20);
        p.add(tfState);

        // EMAIL

        JLabel lblemail  = new JLabel("Email");
        lblemail.setBounds(100,280,100,20);
        p.add(lblemail);
        //TEXT-FIELD
        tfemail = new JTextField();
        tfemail.setBounds(240,280,200,20);
        p.add(tfemail);
        setVisible(true);

        // PHONE NUMBER

        JLabel lblphone  = new JLabel("MobileNumber");
        lblphone.setBounds(100,320,100,20);
        p.add(lblphone);
        //TEXT-FIELD
        tfphone= new JTextField();
        tfphone.setBounds(240,320,200,20);
        p.add(tfphone);

        next = new JButton("Next");
        next.setBounds(120,390,100,25);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        p.add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(250,390,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        p.add(cancel);


        // here we are setting up border-layout explicitly
        setLayout(new BorderLayout());
        add(p,"Center");


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hi-con1.jpg "));
        Image i2 = i1.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image,"West");

        getContentPane().setBackground(Color.white);


        setVisible(true);



    }
    public static void main(String[] args) {
        new  NewCustomer();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==next)
        {
           String name  = tfname.getText();;
           String meter = lblmeter.getText();
           String address = tfaddress.getText();
           String city = tfcity.getText();
           String state = tfState.getText();
           String phone = tfphone.getText();
           String Email = tfemail.getText();




           String query1 = "insert into customer values('"+name+"','"+meter+"','"+address+"','"+city+"','"+state+"','"+Email+"','"+phone+"')";
           String query2 = "insert into login values('"+meter+"','','"+name+"','','')" ;


           try{
               conn c =new conn();
               c.s.executeUpdate(query1);
               c.s.executeUpdate(query2);

               JOptionPane.showMessageDialog(null,"Customer details added successfully");
               setVisible(false);
               // new frame in which we ask about the meter information of customer
               new Meterinfo(meter);
           }catch (Exception se)
           {
               se.printStackTrace();
           }
        }

        else {
            setVisible(false);
        }

    }
}
