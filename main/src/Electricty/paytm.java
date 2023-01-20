package Electricty;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class paytm extends JFrame implements ActionListener {
    String meter;
    JButton back;
    public paytm(String meter) {
        this.meter = meter;
        JEditorPane j = new JEditorPane();// it will return the text area which is editable to restrict the editablity of that text area
        j.setEditable(false);

        try
        {
            j.setPage("https://paytm.com/online-payments");
        }
        catch (Exception e)
        {
            j.setContentType("text/html");
            j.setText("<html> Could not Load <html>");

        }
        // it is used to add scrollbar
        JScrollPane pane = new JScrollPane(j);
        add(pane);


        back = new JButton("Back");
        back.setBounds(640,20,80,30);
        back.addActionListener(this);
        j.add(back);

        setSize(800,600);
        setLocation(400,150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new paytm("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new PayBill(meter);
    }
}
