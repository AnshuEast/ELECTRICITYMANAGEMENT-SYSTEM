package Electricty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Meterinfo extends JFrame implements ActionListener {
    JTextField tfname,  tfaddress, tfcity, tfState, tfemail, tfphone;
    JLabel lblmeter;
    JButton Submit;
    Choice meterlocation,metertype,phasecode,bill_type;
    String meternumber;

    public Meterinfo(String meter) {
        this.meternumber = meter;
        setSize(700, 500);
        setLocation(400, 200);


        // here we create the panel for  partition

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(172, 216, 230));
        add(p);


        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(180, 10, 200, 20);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(heading);


        JLabel lblmeter = new JLabel("Meter Number");
        lblmeter.setBounds(100, 80, 100, 20);
        p.add(lblmeter);

        JLabel lblmetern0 = new JLabel(meternumber);
        lblmetern0.setBounds(240, 80, 100, 20);
        p.add(lblmetern0);

        // here the label has been created
        JLabel meter_loc = new JLabel("Meter Location");
        meter_loc.setBounds(100, 120, 100, 20);
        p.add(meter_loc);

        // here the choice has been created in-front of the meter_loc label;
        meterlocation = new Choice();
        meterlocation.add("OUTSIDE");
        meterlocation.add("INSIDE");
        meterlocation.setBounds(240, 120, 200, 20);

        p.add(meterlocation);

        //TYPE OF THE METER
        JLabel meter_type = new JLabel("Meter Type");
        meter_type.setBounds(100, 160, 100, 20);
        p.add(meter_type);

        metertype = new Choice();
        metertype.add("Electric Meter");
        metertype.add("Solar Meter");
        metertype.add("Smart Meter");
        metertype.setBounds(240, 160, 200, 20);
        p.add(metertype);



        //PHASE_CODE

        JLabel phase_Code = new JLabel("PhaseCode");
        phase_Code.setBounds(100, 200, 100, 20);
        p.add(phase_Code);

        phasecode = new Choice();
        phasecode.add("011");
        phasecode.add("022");
        phasecode.add("033");
        phasecode.add("044");
        phasecode.add("055");
        phasecode.add("066");
        phasecode.add("077"); phasecode.add("088"); phasecode.add("099");
        phasecode.setBounds(240, 200, 200, 20);
        p.add(phasecode);


        // BILL

        JLabel bill_meter = new JLabel("Bill Type");
        bill_meter.setBounds(100, 240, 100, 20);
        p.add(bill_meter);

        bill_type = new Choice();
        bill_type.add("Normal");
        bill_type.add("Industrial");
        bill_type.setBounds(240, 240, 200, 20);
        p.add(bill_type);



        // DAY

        JLabel day = new JLabel("Days");
        day.setBounds(100, 280, 100, 20);
        p.add(day);

        JLabel lbl = new JLabel("30 Days");
        lbl.setBounds(240, 280, 100, 20);
        p.add(lbl);

        JLabel note= new JLabel("* Note");
        note.setBounds(100, 320, 100, 20);
        p.add(note);

        JLabel Default = new JLabel("By Default Bill is calculated for 30 days only");
        Default.setBounds(240, 320, 300, 20);
        p.add(Default);






        Submit = new JButton("submit");
        Submit.setBounds(120, 390, 100, 25);
        Submit.setBackground(Color.black);
        Submit.setForeground(Color.white);
        Submit.addActionListener(this);
        p.add(Submit);




        // here we are setting up border-layout explicitly
        setLayout(new BorderLayout());
        add(p, "Center");


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hi-con1.jpg "));
        Image i2 = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image, "West");

        getContentPane().setBackground(Color.white);


        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Submit) {
            String meter = meternumber;
            String location = meterlocation.getSelectedItem();
            String Type= metertype.getSelectedItem();
            String code = phasecode.getSelectedItem();
            String BillType = bill_type.getSelectedItem();
            String days = "30";


            String query1 = "insert into meter_info values('" + meter + "','" + location + "','" + Type + "','" + code + "','" + BillType + "','" + days + "')";


            try {
                conn c = new conn();
                c.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, "Meter details added successfully");
                setVisible(false);
            } catch (Exception se) {
                se.printStackTrace();
            }
        }
        else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Meterinfo("");
    }
}


