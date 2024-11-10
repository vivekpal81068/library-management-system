import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class imfomation {
   
     public imfomation() {    
        JFrame frame = new JFrame("Librarian Information");
        frame.setBounds(30, 50, 500, 500);
        Font f = new Font("", Font.BOLD, 15);
        method me = new method();
        JLabel label = me.getLabel(frame, "Librarian Information", 150, 20, 180, 30);
        label.setFont(f);
        JButton button1 = new JButton("Add Librarian");
        button1.setBounds(150, 80, 150, 40);
        button1.setFont(f);
        button1.setBackground(Color.GREEN);
        frame.add(button1);
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addLib adl = new addLib();
                frame.dispose();
            }

        });

        JButton button2 = new JButton("View Librarian");
        button2.setBounds(150, 150, 150, 40);
        button2.setFont(f);
        button2.setBackground(Color.GREEN);
        frame.add(button2);
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                newLib nl = new newLib();
                frame.dispose();
            }

        });

        JButton deletelib = new JButton("Delete Librarian");
        deletelib.setBounds(150, 220, 150, 40);
        deletelib.setFont(f);
        deletelib.setBackground(Color.GREEN);
        frame.add(deletelib);
        deletelib.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                delete dl = new delete();
                frame.dispose();
            }

        });

        JButton logou = new JButton("LOG OUT");
        logou.setBounds(150, 300, 150, 40);
        logou.setFont(f);
        logou.setBackground(Color.GREEN);
        frame.add(logou);
        logou.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root", "3980");
                    Statement st = con.createStatement();
                    String query = "truncate table adminlo";
                    int i = st.executeUpdate(query);
                    if (i >= 0) {
                        JOptionPane.showMessageDialog(logou, "successfull logout");
                        adminlo ad = new adminlo();
                        frame.dispose();
                    }

                } catch (Exception exp) {
                    System.out.println(exp);
                }
            }

        });
        JButton back = me.getButton(frame, "<<Back", 160, 370, 90, 40);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminlo adm = new adminlo();
                frame.dispose();
            }

        });
        Container c=frame.getContentPane();
        c.setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new imfomation();
    }

}
