package Electricty;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class signup extends JFrame implements ActionListener {
    JButton back,create;
    Choice accountType;
    JTextField meter,username,name,psword;
    public signup() {
        setBounds(450,140,700,400);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(30,30,650,300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(172,216,230),2),"Create-Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(172,216,230)));
        panel.setBackground(Color.white);
        panel.setLayout(null);
        panel.setForeground(new Color(34,139,34));
        add(panel);



        JLabel heading  = new JLabel("Create Account As");
        heading.setBounds(100,50,140,20);
        heading.setForeground(Color.gray);
        heading.setFont(new Font("Thoma",Font.BOLD,14));
        panel.add(heading);

        accountType = new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(250,50,150,20);
        //accountType.addFocusListener();
        panel.add(accountType);

        JLabel lblmeterno  = new JLabel("MeterNumber");
        lblmeterno.setBounds(100,90,140,20);
        lblmeterno.setForeground(Color.gray);
        lblmeterno.setFont(new Font("Thoma",Font.BOLD,14));
        lblmeterno.setVisible(false);
        panel.add(lblmeterno);

        meter = new JTextField();
        meter.setBounds(249,90,140,20);
        meter.setVisible(false);
        panel.add(meter);

        JLabel lblusername  = new JLabel("UserName");
        lblusername .setBounds(100,130,140,20);
        lblusername .setForeground(Color.gray);
        lblusername .setFont(new Font("Thoma",Font.BOLD,14));
        panel.add(lblusername );

        username = new JTextField();
        username.setBounds(249,130,140,20);
        panel.add(username);


        JLabel lblname  = new JLabel("Name");
        lblname .setBounds(100,170,140,20);
        lblname .setForeground(Color.gray);
        lblname .setFont(new Font("Thoma",Font.BOLD,14));
        panel.add(lblname );

        name = new JTextField();
        name.setBounds(249,170,140,20);
        panel.add(name);

        meter.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }
            @Override
            public void focusLost(FocusEvent e) {
                try {
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from login where meter_no = '"+meter.getText()+"'");
                    while (rs.next())
                    {
                        name.setText(rs.getString("name"));
                    }
                }catch(Exception ae)
                {
                    ae.printStackTrace();
                }
            }
        });

        JLabel lblpassword  = new JLabel("Password");
        lblpassword .setBounds(100,210,140,20);
        lblpassword .setForeground(Color.gray);
        lblpassword .setFont(new Font("Thoma",Font.BOLD,14));
        panel.add(lblpassword);

        psword = new JTextField();
        psword.setBounds(249,210,140,20);
        panel.add(psword);

        accountType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String user = accountType.getSelectedItem();
                if(user.equals("Customer"))
                {
                    lblmeterno.setVisible(true);
                    meter.setVisible(true);
                    name.setEditable(false);
                }
                else {
                    lblmeterno.setVisible(false);
                    meter.setVisible(false);
                    name.setEditable(true);
                }
            }
        });


        create = new JButton("Create");
        create.setBackground(Color.black);
        create.setForeground(Color.white);
        create.setBounds(140,260,100,25);
        create.addActionListener(this);
        panel.add(create);

         back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(280,260,100,25);
        back.addActionListener(this);
        panel.add(back);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(410,30,250,250);
        panel.add(image);




        setVisible(true);
    }

    public static void main(String[] args) {
     new signup();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back)
        {
            setVisible(false);
            new login();
        }
        else if(e.getSource()==create)
        {
            String atype = accountType.getSelectedItem();
            String susername = username.getText();
            String sname = name.getText();
            String spassword = psword.getText();
            String smeter = meter.getText();




            // hit for mysql because the chances of exception is more
            try
            {
                conn c = new conn();
                String query =null;
                if(atype.equals("Admin")) {
                   query= "insert into login values('" + smeter + "', '" + susername + "', '" + sname + "', '" + spassword + "', '" + atype + "')";
                } else {
                    query = "update login set username = '"+susername+"',password = '"+spassword+"',user = '"+atype+"' where meter_no = '"+smeter+"' ";
                }
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Account Created successfully");
                // if the account created successfully then we close that frame
                setVisible(false);
                new login();
            }catch(Exception ae)
            {
                ae.printStackTrace();
            }
        }
    }
}
