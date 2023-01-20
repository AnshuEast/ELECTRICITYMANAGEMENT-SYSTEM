package Electricty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame  implements ActionListener{
    JButton login,signup,cancel;
    JTextField username,pass;
    Choice loggin;
    public login() {
        // In the constructor super will be the first statement of constructor
        super("Login Page");
        // to get the frame access
        getContentPane().setBackground(Color.white);
        setLayout(null);
        // using the J-label we can write anything on the frame
        // by using the set-bounds we can create our own layout
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(300, 20, 100, 20);
        add(lblusername);
        // here we are creating the input field using the JTextField
        username = new JTextField();
        username.setBounds(400, 20, 150, 20);
        add(username);


        JLabel lblpass = new JLabel("Password");
        lblpass.setBounds(300, 60, 100, 20);
        add(lblpass);
        // TEXT-FIELD FOR PASSWORD
        pass = new JTextField();
        pass.setBounds(400, 60, 150, 20);
        add(pass);


        JLabel log = new JLabel("Login in as");
        log.setBounds(300, 100, 100, 20);
        add(log);
        // DROP-DOWN
        loggin = new Choice();
        loggin.add("Admin");
        loggin.add("Customer");
        loggin.setBounds(400, 100, 150, 20);
        add(loggin);


        // To create the Button of the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2 = i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        login = new JButton("Login", new ImageIcon(i2));
        login.setBounds(320, 160, 100, 20);
        login.addActionListener(this);
        add(login);


        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i4 = i3.getImage().getScaledInstance(8, 8, Image.SCALE_DEFAULT);
        cancel = new JButton("Cancel", new ImageIcon(i4));
        cancel.setBounds(430, 160, 100, 20);
        cancel.addActionListener(this);
        add(cancel);


        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i6 = i5.getImage().getScaledInstance(8, 8, Image.SCALE_DEFAULT);
        signup = new JButton("Signup", new ImageIcon(i6));
        signup.setBounds(370, 200, 120, 20);
        signup.addActionListener(this);
        add(signup);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image = new JLabel(i9);
        image.setBounds(0, 0, 250, 250);
        add(image);

        setSize(640, 300);
        setLocation(400, 200);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login)
        {
            String susername = username.getText();
            String spassword = pass.getText();
            String user = loggin.getSelectedItem();

            try {
                conn c = new conn();
                String query = "Select * from login where username= '"+susername+"' and password = '"+spassword+"' and user = '"+user+"'";
                ResultSet rs =c.s.executeQuery(query); // execute-query() returns object of result set;
                if(rs.next())
                {
                    String meter = rs.getString("meter_no");
                    setVisible(false);
                    new Project(user,meter);
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                    username.setText("");
                    pass.setText("");
                }


            }catch (Exception a)
            {
                a.printStackTrace();
            }

        } else if (e.getSource()==cancel) {
            setVisible(false);
        } else if (e.getSource()== signup) {
            setVisible(false);
            new signup();
        }
    }
    public static void main(String[] args) {
        new login();
    }
}
