package Electricty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Project extends JFrame implements ActionListener {
    String atype,meter;
    public Project(String atype,String meter) {
        this.atype = atype;
        this.meter = meter;
        // it is used to create the frame with full window size.
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,850 ,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);


        // Menu-bar creating
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        // Menu-item will be present in the menu
        JMenu master = new JMenu("Master");
        master.setForeground(Color.blue);

        //menu-item will be added to menu

        // NEW CUSTOMER
        JMenuItem newcustomer = new JMenuItem("newcustomer");
        newcustomer.setFont(new Font("monospaced",Font.PLAIN,12));
        newcustomer.setBackground(Color.white);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1 = icon1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(image1));

        // now here mnemonics will be set here
        newcustomer.setMnemonic('D');
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        newcustomer.addActionListener(this);
        master.add(newcustomer);

        // CUSTOMER-DETAILS
        JMenuItem customerdetails = new JMenuItem("customerdetails");
        customerdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        customerdetails.setBackground(Color.white);
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2 = icon2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(image2));

        customerdetails.setMnemonic('M');
        customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        customerdetails.addActionListener(this);
        master.add(customerdetails);


        // DEPOSIT-DETAILS

        JMenuItem depositdetails = new JMenuItem("depositdetails");
        depositdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        depositdetails.setBackground(Color.white);
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image3 = icon3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        depositdetails.setIcon(new ImageIcon(image3));
        depositdetails.setMnemonic('N');
        depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        depositdetails.addActionListener(this);
        master.add(depositdetails);

        // CALCULATE THE BILL OF THE USER
        JMenuItem calculatebill = new JMenuItem("calculate_bill");
        calculatebill.setFont(new Font("monospaced",Font.PLAIN,12));
        calculatebill.setBackground(Color.white);
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image4 = icon4.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculatebill.setIcon(new ImageIcon(image4));
        calculatebill.setMnemonic('B');
        calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        calculatebill.addActionListener(this);
        master.add(calculatebill);




                // SECOND MENU
        JMenu information = new JMenu("Information");
        information.setForeground(Color.red);


        // MENU-ITEM OF INFORMATION MENU
        // updateInformation

        JMenuItem updateInformation = new JMenuItem("UpdateInformation");
        updateInformation.setFont(new Font("monospaced",Font.PLAIN,12));
        updateInformation.setBackground(Color.white);
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image5 = icon5.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        updateInformation.setIcon(new ImageIcon(image5));
        updateInformation.setMnemonic('U');
        updateInformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
        updateInformation.addActionListener(this);
        information.add(updateInformation);

        //ViewInformation

        JMenuItem viewInformation = new JMenuItem("ViewInformation");
        viewInformation.setFont(new Font("monospaced",Font.PLAIN,12));
        viewInformation.setBackground(Color.white);
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image6 = icon6.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        viewInformation.setIcon(new ImageIcon(image6));
        viewInformation.setMnemonic('V');
        viewInformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        viewInformation.addActionListener(this);
        information.add(viewInformation);

        // Third-Menu

        JMenu user = new JMenu("User");
        user.setForeground(Color.blue);



        // PAY-BILL

        JMenuItem paybill = new JMenuItem("Paybill");
        paybill.setFont(new Font("monospaced",Font.PLAIN,12));
        paybill.setBackground(Color.white);
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image7 = icon7.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(image7));
        paybill.setMnemonic('L');
        paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        paybill.addActionListener(this);
        user.add(paybill);

        // BILL-DETAILS

        JMenuItem billdetails = new JMenuItem("BILL-DETAILS");
        billdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        billdetails.setBackground(Color.white);
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon8.png"));
        Image image8 = icon8.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(image8));
        billdetails.setMnemonic('I');
        billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        billdetails.addActionListener(this);
        user.add(billdetails);

        // FOURTH-MENU
        JMenu report = new JMenu("Report");
        report.setForeground(Color.red);


        // Generate-Bill

        JMenuItem GenerateBill = new JMenuItem("Generate-Bill");
        GenerateBill.setFont(new Font("monospaced",Font.PLAIN,12));
        GenerateBill.setBackground(Color.white);
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image9 = icon9.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        GenerateBill.setIcon(new ImageIcon(image9));
        GenerateBill.setMnemonic('G');
        GenerateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        GenerateBill.addActionListener(this);
        report.add(GenerateBill);

        // FOURTH-MENU
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.blue);


        // NOTE-PAD

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced",Font.PLAIN,12));
        notepad.setBackground(Color.white);
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image10= icon10.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(image10));
        notepad.setMnemonic('N');
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        notepad.addActionListener(this);
        utility.add(notepad);

        // CALCULATOR

        JMenuItem calculator = new JMenuItem("CALCULATOR");
        calculator.setFont(new Font("monospaced",Font.PLAIN,12));
        calculator.setBackground(Color.white);
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image11= icon11.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(image11));
        calculator.setMnemonic('C');
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        calculator.addActionListener(this);
        utility.add(calculator);

        // MENU - EXIT

        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.red);


        // CLOSE

        JMenuItem Mexit = new JMenuItem("EXIT");
        Mexit .setFont(new Font("monospaced",Font.PLAIN,12));
        Mexit .setBackground(Color.white);
        ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image12= icon12.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        Mexit .setIcon(new ImageIcon(image12));
        Mexit .setMnemonic('W');
        Mexit .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        Mexit.addActionListener(this);
        exit.add(Mexit );

        if(atype.equals("Admin")) {
            mb.add(master);
        }
        else {
            mb.add(user);
            mb.add(information);
            mb.add(report);


        }
        mb.add(utility);
        mb.add(exit);


        setLayout(new FlowLayout());
        setVisible(true);
    }

    public static void main(String[] args) {
        new Project("","");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        if(msg.equals("newcustomer"))
        {
            new NewCustomer();
            
        } else if (msg.equals("customerdetails")) {
            new customerdetails();
        } else if (msg.equals("depositdetails")) {
            new Depositdetails();
        } else if (msg.equals("calculate_bill")) {
            new caculatebill();
        } else if (msg.equals("ViewInformation")) {
            new viewInformation(meter);
        }else if(msg.equals("UpdateInformation"))
        {
            new updateUserInformation(meter);
        }
        else if(msg.equals("BILL-DETAILS"))
        {
            new billDetails(meter);
        }
        else if (msg.equals("Notepad")){

            try
            {
               Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception ey)
            {
                ey.printStackTrace();
            }

        }
        else if (msg.equals("CALCULATOR")){

            try
            {
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception ey)
            {
                ey.printStackTrace();
            }
        } else if (msg.equals("EXIT")) {
            setVisible(false);
            new login();
        } else if (msg.equals("Paybill")) {
            new PayBill(meter);
        } else if (msg.equals("Generate-Bill")) {
            new Generatebill(meter);
        }
    }
}
