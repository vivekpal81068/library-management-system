import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class addLib {
    int id=0;
     public addLib() {
        JFrame frame = new JFrame("Add Librarian");
        frame.setBounds(30, 50, 500, 600);
        Font f = new Font("", Font.BOLD, 20);
        method me = new method();
        JLabel label = me.getLabel(frame, "Add Librarian", 160, 20, 150, 30);
        label.setFont(f);
        me.getLabel(frame, "Name:", 80, 80, 100, 30);
        me.getLabel(frame, "Password:", 80, 130, 100, 30);
        me.getLabel(frame, "Email", 80, 180, 100, 30);
        me.getLabel(frame, "Contact:", 80, 230, 100, 30);
        me.getLabel(frame, "Address:", 80, 290, 100, 30);
        me.getLabel(frame, "City:", 80, 350, 100, 30);

        JTextField name = me.getText(frame, 220, 80, 150, 30);
        JTextField pass = me.getText(frame, 220, 130, 150, 30);
        JTextField email = me.getText(frame, 220, 180, 150, 30);
        JTextField contact = me.getText(frame, 220, 230, 150, 30);
        JTextField address = me.getText(frame, 220, 290, 150, 30);
        JTextField city = me.getText(frame, 220, 350, 150, 30);
        JButton button = new JButton("Add Information");
        button.setBounds(220, 420, 140, 40);
        frame.add(button);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(name.getText().equals("") && pass.getText().equals("") && email.getText().equals("")
                        && contact.getText().equals("") && address.getText().equals("") && city.getText().equals(""))) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root",
                                "3980");
                                // get Max Id
                        Statement maxIdSt = con.createStatement();
                        String maxIdQuery = "Select max(id) as id from lib";
                        ResultSet maxIdRs = maxIdSt.executeQuery(maxIdQuery);
                        if (maxIdRs.next()) {
                            id = maxIdRs.getInt("id") + 1;                         
                        }
                        String query = "insert into lib(id,name,pass,email,contact,address,city) values('" + id + "','" + name.getText() + "','" + pass.getText() + "','"
                                + email.getText() + "','" + contact.getText() + "','" + address.getText() + "','"
                                + city.getText() + "')";
                        Statement st = con.createStatement();
                        int i = st.executeUpdate(query);
                        if (i > 0) {
                            JOptionPane.showMessageDialog(button, "Successfull added this member");
                            name.setText("");
                            pass.setText("");
                            email.setText("");
                            contact.setText("");
                            address.setText("");
                            city.setText("");
                            frame.dispose();
                            new imfomation();
                        } else {
                            JOptionPane.showMessageDialog(button, "failed!");
                        }
                    } catch (Exception exp) {
                        System.out.println(exp);
                    }

                } else {
                    JOptionPane.showMessageDialog(button, "!please fill empity fields");
                }
            }

        });

        JButton back = me.getButton(frame, "<Back", 80, 420, 80, 40);
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
