import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.font.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class historical {
    public historical() {

        JFrame frame = new JFrame();
        frame.setBounds(30, 50, 500, 700);
        method me = new method();
        Font f = new Font("", Font.BOLD, 20);
        JLabel l1 = me.getLabel(frame, "Historical Books", 180, 30, 180, 30);
        l1.setFont(f);
        JButton back = me.getButton(frame, "< back", 10, 30, 80, 40);
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                purchase pur = new purchase();
                frame.dispose();
            }

        });

        JButton btn = new JButton(new ImageIcon("C:\\Users\\HP\\Desktop\\JAVAV\\MyProject\\imges\\akand.png"));
        btn.setBounds(20, 100, 130, 180);
        frame.add(btn);
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bookInformation bki = new bookInformation();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root", "3980");
                    Statement st = con.createStatement();
                    String query = "select*from books where Book_no=19";
                    ResultSet rs = st.executeQuery(query);
                    if (rs.next()) {
                        bki.bkno = rs.getString("Book_no");
                        bki.bkna = rs.getString("Book_name");
                        bki.aut = rs.getString("Author");
                        bki.publ = rs.getString("Publisher");
                        bki.pri = rs.getString("Quantity");
                        bki.m1();
                    } else {
                        JOptionPane.showMessageDialog(frame, "data not found!");
                    }
                } catch (Exception exp) {
                    System.out.println(exp);
                }
            }

        });
        JButton button = new JButton(new ImageIcon("MyProject\\imges\\prachin.png"));
        button.setBounds(175, 100, 130, 180);
        frame.add(button);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bookInformation bki = new bookInformation();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root", "1234");
                    Statement st = con.createStatement();
                    String query = "select*from books where Book_no=20";
                    ResultSet rs = st.executeQuery(query);
                    if (rs.next()) {
                        bki.bkno = rs.getString("Book_no");
                        bki.bkna = rs.getString("Book_name");
                        bki.aut = rs.getString("Author");
                        bki.publ = rs.getString("Publisher");
                        bki.pri = rs.getString("Quantity");
                        bki.m1();
                    } else {
                        JOptionPane.showMessageDialog(frame, "data not found!");
                    }
                } catch (Exception exp) {
                    System.out.println(exp);
                }
            }

        });
        JButton button2 = new JButton(new ImageIcon("MyProject\\imges\\jaliya.png"));
        button2.setBounds(330, 100, 130, 180);
        frame.add(button2);
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bookInformation bki = new bookInformation();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root", "1234");
                    Statement st = con.createStatement();
                    String query = "select*from books where Book_no=21";
                    ResultSet rs = st.executeQuery(query);
                    if (rs.next()) {
                        bki.bkno = rs.getString("Book_no");
                        bki.bkna = rs.getString("Book_name");
                        bki.aut = rs.getString("Author");
                        bki.publ = rs.getString("Publisher");
                        bki.pri = rs.getString("Quantity");
                        bki.m1();
                    } else {
                        JOptionPane.showMessageDialog(frame, "data not found!");
                    }
                } catch (Exception exp) {
                    System.out.println(exp);
                }
            }

        });
        JButton button3 = new JButton(new ImageIcon("MyProject\\imges\\indhis.png"));
        button3.setBounds(20, 290, 130, 180);
        frame.add(button3);
        button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bookInformation bki = new bookInformation();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root", "1234");
                    Statement st = con.createStatement();
                    String query = "select*from books where Book_no=22";
                    ResultSet rs = st.executeQuery(query);
                    if (rs.next()) {
                        bki.bkno = rs.getString("Book_no");
                        bki.bkna = rs.getString("Book_name");
                        bki.aut = rs.getString("Author");
                        bki.publ = rs.getString("Publisher");
                        bki.pri = rs.getString("Quantity");
                        bki.m1();
                    } else {
                        JOptionPane.showMessageDialog(frame, "data not found!");
                    }
                } catch (Exception exp) {
                    System.out.println(exp);
                }
            }

        });
        JButton button4 = new JButton(new ImageIcon("MyProject\\imges\\samv.png"));
        button4.setBounds(175, 290, 130, 180);
        frame.add(button4);
        button4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bookInformation bki = new bookInformation();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root", "1234");
                    Statement st = con.createStatement();
                    String query = "select*from books where Book_no=23";
                    ResultSet rs = st.executeQuery(query);
                    if (rs.next()) {
                        bki.bkno = rs.getString("Book_no");
                        bki.bkna = rs.getString("Book_name");
                        bki.aut = rs.getString("Author");
                        bki.publ = rs.getString("Publisher");
                        bki.pri = rs.getString("Quantity");
                        bki.m1();
                    } else {
                        JOptionPane.showMessageDialog(frame, "data not found!");
                    }
                } catch (Exception exp) {
                    System.out.println(exp);
                }
            }

        });
        JButton button5 = new JButton(new ImageIcon("MyProject\\imges\\civics.png"));
        button5.setBounds(330, 290, 130, 180);
        frame.add(button5);
        button5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bookInformation bki = new bookInformation();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root", "3980");
                    Statement st = con.createStatement();
                    String query = "select*from books where Book_no=24";
                    ResultSet rs = st.executeQuery(query);
                    if (rs.next()) {
                        bki.bkno = rs.getString("Book_no");
                        bki.bkna = rs.getString("Book_name");
                        bki.aut = rs.getString("Author");
                        bki.publ = rs.getString("Publisher");
                        bki.pri = rs.getString("Quantity");
                        bki.m1();
                    } else {
                        JOptionPane.showMessageDialog(frame, "data not found!");
                    }
                } catch (Exception exp) {
                    System.out.println(exp);
                }
            }

        });
        JButton button6 = new JButton(new ImageIcon("MyProject\\imges\\pal.png"));
        button6.setBounds(20, 480, 130, 200);
        frame.add(button6);
        button6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bookInformation bki = new bookInformation();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root", "1234");
                    Statement st = con.createStatement();
                    String query = "select*from books where Book_no=25";
                    ResultSet rs = st.executeQuery(query);
                    if (rs.next()) {
                        bki.bkno = rs.getString("Book_no");
                        bki.bkna = rs.getString("Book_name");
                        bki.aut = rs.getString("Author");
                        bki.publ = rs.getString("Publisher");
                        bki.pri = rs.getString("Quantity");
                        bki.m1();
                    } else {
                        JOptionPane.showMessageDialog(frame, "data not found!");
                    }
                } catch (Exception exp) {
                    System.out.println(exp);
                }
            }

        });
        JButton button7 = new JButton(new ImageIcon("MyProject\\imges\\magadh.png"));
        button7.setBounds(175, 480, 130, 200);
        frame.add(button7);
        button7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bookInformation bki = new bookInformation();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root", "1234");
                    Statement st = con.createStatement();
                    String query = "select*from books where Book_no=26";
                    ResultSet rs = st.executeQuery(query);
                    if (rs.next()) {
                        bki.bkno = rs.getString("Book_no");
                        bki.bkna = rs.getString("Book_name");
                        bki.aut = rs.getString("Author");
                        bki.publ = rs.getString("Publisher");
                        bki.pri = rs.getString("Quantity");
                        bki.m1();
                    } else {
                        JOptionPane.showMessageDialog(frame, "data not found!");
                    }
                } catch (Exception exp) {
                    System.out.println(exp);
                }
            }
        });
        JButton button8 = new JButton(new ImageIcon("MyProject\\imges\\gupt.png"));
        button8.setBounds(330, 480, 130, 206);
        frame.add(button8);
        button8.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bookInformation bki = new bookInformation();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root", "1234");
                    Statement st = con.createStatement();
                    String query = "select*from books where Book_no=27";
                    ResultSet rs = st.executeQuery(query);
                    if (rs.next()) {
                        bki.bkno = rs.getString("Book_no");
                        bki.bkna = rs.getString("Book_name");
                        bki.aut = rs.getString("Author");
                        bki.publ = rs.getString("Publisher");
                        bki.pri = rs.getString("Quantity");
                        bki.m1();
                    } else {
                        JOptionPane.showMessageDialog(frame, "data not found!");
                    }
                } catch (Exception exp) {
                    System.out.println(exp);
                }
            }
        });
        Container c=frame.getContentPane();
        c.setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);
        frame.setVisible(true);
    }

}
