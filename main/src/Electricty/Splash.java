package Electricty;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
// whenever you implement the thread  class you have to make the object of that class explicitly
public class Splash extends JFrame implements Runnable {
    Thread t;
    public Splash() {

        // To set image in the splash frame()

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        Image i2 = i1.getImage().getScaledInstance(730,550,Image.SCALE_DEFAULT);
        // we cannot pass the object of image class to the j-label, so we again create the class of Image-icon
        ImageIcon i3 = new ImageIcon(i2);

        // we cannot directly pass the image icon to add component or method
        // by using j-label we can pass the image in it.
        // j-label is the class in the java swing.
        JLabel image = new JLabel(i3);
        add(image);
        setVisible(true);
        // to delay the opening of the splash screen
        int x=1;
        for(int i=3;i<600;i+=4,x=+1) {
            setSize(i+x, i);
            setLocation(700-((i+x)/2), 400-(i/2));
            // here we're using the concept of multi-threading
            try {
                Thread.sleep(2);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        t = new Thread(this);
        t.start(); // start method internally call run method of runnable interface
    }
    // by Implementing this Runnable Interface we can create that 7 seconds delay for the next window
    @Override
    public void run() {
        try
        {
            Thread.sleep(1000);
            // To hide that frame we will mark false set-visible method false;
            setVisible(false);
            // login frame
            new login();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // we cannot instantiate the abstract classes
        // we cannot create the object of abstract classes
        new Splash(); // its anonymous object
    }
}
