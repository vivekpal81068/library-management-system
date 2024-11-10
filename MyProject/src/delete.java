
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.*;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.Driver;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class delete {
     public delete(){
     //public static void main(String[] args) {

        JFrame frame = new JFrame("Delete Librarian");
        frame.setBounds(30, 50, 700, 600);
        Font f = new Font("", Font.BOLD, 20);

        method me = new method();
        JLabel label = me.getLabel(frame, "Delete Librarian", 250, 20, 150, 30);
        label.setFont(f);
        me.getLabel(frame, "Name:", 30, 80, 100, 30);
        me.getLabel(frame, "Password:", 30, 130, 100, 30);
        me.getLabel(frame, "Email", 30, 180, 100, 30);
        me.getLabel(frame, "Contact:", 30, 230, 100, 30);
        me.getLabel(frame, "Address:", 30, 290, 100, 30);
        me.getLabel(frame, "City:", 30, 350, 100, 30);

        JTextField name = me.getText(frame, 100, 80, 150, 30);
        JTextField pass = me.getText(frame, 100, 130, 150, 30);
        JTextField email = me.getText(frame, 100, 180, 150, 30);
        JTextField contact = me.getText(frame, 100, 230, 150, 30);
        JTextField address = me.getText(frame, 100, 290, 150, 30);
        JTextField city = me.getText(frame, 100, 350, 150, 30);
        JButton Show = new JButton("Show");
        Show.setBounds(400, 440, 100, 40);
        frame.add(Show);
        String[] cn = { "Id","Name", "Password", "Email", "Contact", "Address", "City" };
        DefaultTableModel model = new DefaultTableModel(cn, 0);
        JTable table = new JTable(model);
        frame.add(table);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(280, 80, 370, 350);
        frame.add(pane);
        Show.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root", "3980");
                    String query = "select*from lib";
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    while (rs.next()) {
                        
                        String id = rs.getString("id");
                        String nm = rs.getString("name");
                        String pas = rs.getString("pass");
                        String em = rs.getString("email");
                        String cont = rs.getString("contact");
                        String addr = rs.getString("address");
                        String ct = rs.getString("city");
                        Object[] rowData = {id, nm, pas, em, cont, addr, ct };
                        model.addRow(rowData);
                    }

                } catch (Exception exp) {
                    System.out.println(exp);
                }
            }

        });
        table.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                String id = table.getModel().getValueAt(row, 0).toString();
                String nm = table.getModel().getValueAt(row, 1).toString();
                String pas = table.getModel().getValueAt(row, 2).toString();
                String em = table.getModel().getValueAt(row, 3).toString();
                String cont = table.getModel().getValueAt(row, 4).toString();
                String add = table.getModel().getValueAt(row, 5).toString();
                String ct = table.getModel().getValueAt(row, 6).toString();

                name.setText(nm);
                pass.setText(pas);
                email.setText(em);
                contact.setText(cont);
                address.setText(add);
                city.setText(ct);

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });
        JButton button = new JButton("Delete information");
        button.setBounds(80, 440, 150, 40);
        frame.add(button);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root",
                            "3980");
                    String query = "delete from lib where email='" + email.getText() + "'";
                    Statement st = con.createStatement();
                    int i = st.executeUpdate(query);
                    if (i > 0) {
                        JOptionPane.showMessageDialog(button, " this Librarian data deleted!");
                        name.setText("");
                        pass.setText("");
                        email.setText("");
                        contact.setText("");
                        address.setText("");
                        city.setText("");
                    } else {
                        JOptionPane.showMessageDialog(button, "data not found!");

                    }

                } catch (Exception exp) {
                    System.out.println(exp);
                }
            }

        });
        JButton back = me.getButton(frame, "<<Back", 300, 440, 90, 40);
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                imfomation inf = new imfomation();
                frame.dispose();
            }
        });
        Container c=frame.getContentPane();
        c.setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
