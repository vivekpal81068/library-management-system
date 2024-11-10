import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.*;

public class bookInformation {
    public String bkno = "";
    public String bkna = "";
    public String aut = "";
    public String publ = "";
    public String pri = "";

    public void m1() {
        JFrame frame = new JFrame();
        frame.setBounds(30, 50, 400, 400);
        Font f = new Font("", Font.BOLD, 20);
        System.out.println(bkna + bkno);
        method me = new method();
        JLabel h1 = me.getLabel(frame, "Book Information", 150, 20, 180, 30);
        h1.setFont(f);
        me.getLabel(frame, "Book No", 50, 70, 100, 30);
        me.getLabel(frame, "Book Name", 50, 110, 100, 30);
        me.getLabel(frame, "Author", 50, 150, 100, 30);
        me.getLabel(frame, "Publisher", 50, 190, 100, 30);
        me.getLabel(frame, "Price", 50, 230, 100, 30);
        JTextField bookno = me.getText(frame, 190, 70, 150, 30);
        JTextField bkname = me.getText(frame, 190, 110, 150, 30);
        JTextField author = me.getText(frame, 190, 150, 150, 30);
        JTextField publi = me.getText(frame, 190, 190, 150, 30);
        JTextField price = me.getText(frame, 190, 230, 150, 30);
        bookno.setText(bkno);
        bkname.setText(bkna);
        author.setText(aut);
        publi.setText(publ);
        price.setText(pri);
        JButton by = me.getButton(frame, "BUY", 150, 300, 100, 30);
        by.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                upurchasedetail pd = new upurchasedetail();
                frame.dispose();
            }
        });
        Container c=frame.getContentPane();
        c.setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new bookInformation();
    }

}
