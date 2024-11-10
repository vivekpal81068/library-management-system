import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;

public class login1 {
    public void m1() {
        JFrame frame = new JFrame("First page ");
        frame.setBounds(30, 50, 400, 400);

        Font f = new Font("", Font.BOLD, 25);
        method me = new method();
        JLabel l = me.getLabel(frame, "Shree Krishna Library", 35, 20, 300, 30);
        l.setFont(f);
        l.setBackground(Color.RED);
        JButton button1 = new JButton("Admin Login");
        button1.setBackground(Color.CYAN);
        JButton button2 = new JButton("User Login");
        button2.setBackground(Color.CYAN);
        button1.setBounds(110, 85, 135, 65);
        button2.setBounds(110, 160, 135, 65);
        frame.add(button2);
        frame.add(button1);
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                adminlo adl = new adminlo();
                frame.dispose();
            }

        });

        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                userLogin l = new userLogin();
                frame.dispose();
            }
        });
        JLabel img = new JLabel(new ImageIcon("MyProject/imges/li.png"));
        img.setBounds(0, 0, 380, 400);
        frame.add(img);
        Container c=frame.getContentPane();
        c.setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        login1 log = new login1();
        log.m1();
    }
}
