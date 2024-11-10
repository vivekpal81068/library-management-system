import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Defaulttabledata {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(30, 50, 500, 500);
        String[] cn = { "name", "city" };
        DefaultTableModel model = new DefaultTableModel(cn, 0);
        JTable table = new JTable(model);
        frame.add(table);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(20, 60, 400, 400);
        frame.add(pane);

        JButton button = new JButton("click");
        button.setBounds(20, 30, 100, 30);
        frame.add(button);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/ravendra", "root",
                            "3980");
                    Statement st = con.createStatement();
                    String query = "select*from tb3";
                    ResultSet rs = st.executeQuery(query);
                    while (rs.next()) {
                        String name = rs.getString("name");
                        String city = rs.getString("city");
                        Object[] rowData = { name, city };
                        model.addRow(rowData);
                    }

                } catch (Exception exp) {
                    System.out.println(exp);
                }

            }

        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

}
