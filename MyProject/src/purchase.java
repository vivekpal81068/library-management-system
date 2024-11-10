import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.font.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class purchase {
   
    public purchase() {       
        JFrame frame = new JFrame();
        frame.setBounds(30, 30, 500, 700);
        method me = new method();
        Font f = new Font("", Font.BOLD, 20);
        JLabel l1 = me.getLabel(frame, "Issue Books", 200, 10, 150, 30);
        l1.setFont(f);

        JButton btn = new JButton(new ImageIcon("MyProject\\imges\\ram.png"));
        btn.setBounds(20, 110, 130, 150);
        frame.add(btn);
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bookInformation bki = new bookInformation();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root", "3980");
                    Statement st = con.createStatement();
                    String query = "select*from books where Bkno=1";
                    ResultSet rs = st.executeQuery(query);
                    if (rs.next()) {
                        bki.bkno = rs.getString("bkno");
                        bki.bkna = rs.getString("bkna");
                        bki.aut = rs.getString("aut");
                        bki.publ = rs.getString("publ");
                        bki.pri = rs.getString("pri");
                        bki.m1();
                    } else {
                        JOptionPane.showMessageDialog(frame, "data not found!");
                    }
                } catch (Exception exp) {
                    System.out.println(exp);
                }
            }
        });
        JButton relig = me.getButton(frame, "Religion", 0, 60, 163, 20);
        relig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JButton pop = me.getButton(frame, "Popular", 160, 60, 163, 20);
        pop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popular p = new popular();
                frame.dispose();
            }
        });
        JButton his = me.getButton(frame, "Historical", 320, 60, 163, 20);
        his.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                historical his = new historical();
                frame.dispose();
            }
        });
        JButton button = new JButton(new ImageIcon("MyProject\\imges\\geeta.png"));
        button.setBounds(175, 110, 130, 150);
        frame.add(button);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bookInformation bki = new bookInformation();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root", "3980");
                    Statement st = con.createStatement();
                    String query = "select*from books where Bkno=2";
                    ResultSet rs = st.executeQuery(query);
                    if (rs.next()) {
                        bki.bkno = rs.getString("bkno");
                        bki.bkna = rs.getString("bkna");
                        bki.aut = rs.getString("aut");
                        bki.publ = rs.getString("publ");
                        bki.pri = rs.getString("pri");
                        bki.m1();
                    } else {
                        JOptionPane.showMessageDialog(frame, "data not found!");
                    }
                } catch (Exception exp) {
                    System.out.println(exp);
                }
            }

        });
        JButton button2 = new JButton(new ImageIcon("MyProject\\imges\\sam.png"));
        button2.setBounds(330, 110, 130, 150);
        frame.add(button2);
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bookInformation bki = new bookInformation();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root", "3980");
                    Statement st = con.createStatement();
                    String query = "select*from books where Bkno=3";
                    ResultSet rs = st.executeQuery(query);
                    if (rs.next()) {
                        bki.bkno = rs.getString("bkno");
                        bki.bkna = rs.getString("bkna");
                        bki.aut = rs.getString("aut");
                        bki.publ = rs.getString("publ");
                        bki.pri = rs.getString("pri");
                        bki.m1();
                    } else {
                        JOptionPane.showMessageDialog(frame, "data not found!");
                    }
                } catch (Exception exp) {
                    System.out.println(exp);
                }
            }

        });
        JButton button3 = new JButton(new ImageIcon("MyProject\\imges\\rig.png"));
        button3.setBounds(20, 270, 130, 180);
        frame.add(button3);
        button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bookInformation bki = new bookInformation();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root", "3980");
                    Statement st = con.createStatement();
                    String query = "select*from books where Bkno=4";
                    ResultSet rs = st.executeQuery(query);
                    if (rs.next()) {
                        bki.bkno = rs.getString("bkno");
                        bki.bkna = rs.getString("bkna");
                        bki.aut = rs.getString("aut");
                        bki.publ = rs.getString("publ");
                        bki.pri = rs.getString("pri");
                        bki.m1();
                    } else {
                        JOptionPane.showMessageDialog(frame, "data not found!");
                    }
                } catch (Exception exp) {
                    System.out.println(exp);
                }
            }

        });
        JButton button4 = new JButton(new ImageIcon("MyProject\\imges\\yajur.png"));
        button4.setBounds(175, 270, 130, 180);
        frame.add(button4);
        button4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bookInformation bki = new bookInformation();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root", "3980");
                    Statement st = con.createStatement();
                    String query = "select*from books where Bkno=5";
                    ResultSet rs = st.executeQuery(query);
                    if (rs.next()) {
                        bki.bkno = rs.getString("bkno");
                        bki.bkna = rs.getString("bkna");
                        bki.aut = rs.getString("aut");
                        bki.publ = rs.getString("publ");
                        bki.pri = rs.getString("pri");
                        bki.m1();
                    } else {
                        JOptionPane.showMessageDialog(frame, "data not found!");
                    }
                } catch (Exception exp) {
                    System.out.println(exp);
                }
            }

        });
        JButton button5 = new JButton(new ImageIcon("MyProject\\imges\\shivp,.png"));
        button5.setBounds(330, 270, 130, 180);
        frame.add(button5);
        button5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bookInformation bki = new bookInformation();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root", "3980");
                    Statement st = con.createStatement();
                    String query = "select*from books where Bkno=6";
                    ResultSet rs = st.executeQuery(query);
                    if (rs.next()) {
                        bki.bkno = rs.getString("bkno");
                        bki.bkna = rs.getString("bkna");
                        bki.aut = rs.getString("aut");
                        bki.publ = rs.getString("publ");
                        bki.pri = rs.getString("pri");
                        bki.m1();
                    } else {
                        JOptionPane.showMessageDialog(frame, "data not found!");
                    }
                } catch (Exception exp) {
                    System.out.println(exp);
                }
            }

        });
        JButton button6 = new JButton(new ImageIcon("MyProject\\imges\\torah.png"));
        button6.setBounds(20, 460, 130, 180);
        frame.add(button6);
        button6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bookInformation bki = new bookInformation();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root", "3980");
                    Statement st = con.createStatement();
                    String query = "select*from books where Bkno=7";
                    ResultSet rs = st.executeQuery(query);
                    if (rs.next()) {
                        bki.bkno = rs.getString("bkno");
                        bki.bkna = rs.getString("bkna");
                        bki.aut = rs.getString("aut");
                        bki.publ = rs.getString("publ");
                        bki.pri = rs.getString("pri");
                        bki.m1();
                    } else {
                        JOptionPane.showMessageDialog(frame, "data not found!");
                    }
                } catch (Exception exp) {
                    System.out.println(exp);
                }
            }
        });
        JButton button7 = new JButton(
                new ImageIcon("MyProject\\imges\\buddhishm.png"));
        button7.setBounds(175, 460, 130, 180);
        frame.add(button7);
        button7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bookInformation bki = new bookInformation();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root", "3980");
                    Statement st = con.createStatement();
                    String query = "select*from books where Bkno=8";
                    ResultSet rs = st.executeQuery(query);
                    if (rs.next()) {
                        bki.bkno = rs.getString("bkno");
                        bki.bkna = rs.getString("bkna");
                        bki.aut = rs.getString("aut");
                        bki.publ = rs.getString("publ");
                        bki.pri = rs.getString("pri");
                        bki.m1();
                    } else {
                        JOptionPane.showMessageDialog(frame, "data not found!");
                    }
                } catch (Exception exp) {
                    System.out.println(exp);
                }
            }
        });
        JButton button8 = new JButton(new ImageIcon("MyProject\\imges\\bible.png"));
        button8.setBounds(330, 460, 130, 180);
        frame.add(button8);
        button8.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bookInformation bki = new bookInformation();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root", "3980");
                    Statement st = con.createStatement();
                    String query = "select*from books where Bkno=9";
                    ResultSet rs = st.executeQuery(query);
                    if (rs.next()) {
                        bki.bkno = rs.getString("bkno");
                        bki.bkna = rs.getString("bkna");
                        bki.aut = rs.getString("aut");
                        bki.publ = rs.getString("publ");
                        bki.pri = rs.getString("pri");
                        bki.m1();
                    } else {
                        JOptionPane.showMessageDialog(frame, "data not found!");
                    }
                } catch (Exception exp) {
                    System.out.println(exp);
                }
            }

        });
        JButton back = me.getButton(frame, "<<Back", 0, 0, 90, 40);
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                userInformation usi = new userInformation();
                frame.dispose();
            }

        });
        Container c=frame.getContentPane();
        c.setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);
        frame.setVisible(true);
    }

}
