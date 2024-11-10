import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import java.awt.font.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class unewBook {
    public unewBook() {       
        JFrame frame = new JFrame();
        Font f = new Font("", Font.BOLD, 20);
        method me = new method();
        JLabel label = new JLabel(
                new ImageIcon(
                        "MyProject\\imges\\1551224852page-turning-book-animation-19.gif"));
        label.setBounds(0, 0, 180, 80);
        frame.add(label);
        JButton btn = me.getButton(frame, "View Books", 180, 10, 160, 40);
        btn.setBackground(Color.GRAY);
        btn.setFont(f);
        frame.setBounds(30, 50, 500, 600);
        String[] cn = { "Book No", "Book Name", "Author", "Publisher", "Rate", "Prescribed" };
        DefaultTableModel model = new DefaultTableModel(cn, 0);
        JTable table = new JTable(model);
        frame.add(table);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(2, 80, 480, 450);
        frame.add(pane);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root", "3980");
                    Statement st = con.createStatement();
                    String query = "select*from books";
                    ResultSet rs = st.executeQuery(query);
                    while (rs.next()) {
                        String bkno = rs.getString("Bkno");
                        String bkna = rs.getString("bkna");
                        String aut = rs.getString("aut");
                        String publ = rs.getString("publ");
                        String pri = rs.getString("pri");
                        String addate = rs.getString("addate");
                        Object[] rowdata = { bkno, bkna, aut, publ, pri, addate };
                        model.addRow(rowdata);
                    }
                } catch (Exception exp) {
                    System.out.println(exp);
                }
            }
        });
        method met = new method();
        JButton back = met.getButton(frame, "<<Back", 370, 10, 100, 40);
        back.setBackground(Color.GRAY);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInformation us = new userInformation();
                frame.dispose();
            }
        });
        Container c=frame.getContentPane();
        c.setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);
        frame.setVisible(true);
    }    
}
