import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class userInformation {
    public userInformation() {
        JFrame frame = new JFrame("Add Books");
        frame.setBounds(30, 50, 400, 500);

        Font f = new Font("", Font.BOLD, 17);
        method me = new method();
        JLabel l1 = me.getLabel(frame, "BOOKS", 152, 20, 150, 30);
        l1.setFont(f);
        JButton btn1 = me.getButton(frame, "Add Books", 135, 80, 140, 40);
        btn1.setBackground(Color.GRAY);
        JButton btn2 = me.getButton(frame, "view Books", 135, 150, 140, 40);
        btn2.setBackground(Color.GRAY);
        JButton btn3 = me.getButton(frame, "Purchase Books", 135, 220, 140, 40);
        btn3.setBackground(Color.GRAY);
        JButton btn4 = me.getButton(frame, "Return Books", 135, 290, 140, 40);
        btn4.setBackground(Color.GRAY);
        JButton btn5 = me.getButton(frame, "-*-Exit-*-", 135, 350, 140, 40);
        btn5.setBackground(Color.GRAY);
        JButton back = me.getButton(frame, "<<Back", 135, 410, 140, 40);
        back.setBackground(Color.GRAY);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new userLogin();
                frame.dispose();
            }
        });
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usAddBook usa = new usAddBook();
                frame.dispose();
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unewBook un = new unewBook();
                frame.dispose();
            }

        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                purchase pur = new purchase();
                frame.dispose();
            }

        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookretur bkr = new bookretur();
                frame.dispose();
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                userLogin ulo = new userLogin();
                frame.dispose();
            }
        });
        Container c=frame.getContentPane();
        c.setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new userInformation();
    }

}
