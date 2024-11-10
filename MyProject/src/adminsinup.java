import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.font.*;

public class adminsinup {
    int id=0;
    public adminsinup() {
        JFrame frame = new JFrame("Admin Signup Page");
        frame.setBounds(30, 50, 400, 400);
        Font f = new Font("", Font.BOLD, 20);
        method me = new method();
        JLabel l = me.getLabel(frame, "Admin Signup", 110, 30, 270, 40);
        l.setFont(f);
        me.getLabel(frame, "Name", 70, 110, 100, 30);
        me.getLabel(frame, "Password", 70, 150, 100, 30);
        me.getLabel(frame, "Email", 70, 190, 100, 30);
        JTextField name = me.getText(frame, 160, 110, 150, 30);
        JTextField pass = me.getText(frame, 160, 150, 150, 30);
        JTextField email = me.getText(frame, 160, 190, 150, 30);
        JButton Cencel = new JButton("<Back");
        Cencel.setBounds(90, 260, 80, 40);
        frame.add(Cencel);
        Cencel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new adminlo();
                frame.dispose();
            }            
        });

        JButton button = new JButton("Submit");
        button.setBounds(200, 260, 80, 40);
        frame.add(button);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(name.getText().equals("") && pass.getText().equals("") && email.getText().equals(""))) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root",
                                "3980");
                                // get Max Id
                        Statement maxIdSt = con.createStatement();
                        String maxIdQuery = "Select max(id) as id from adminlo";
                        ResultSet maxIdRs = maxIdSt.executeQuery(maxIdQuery);
                        if (maxIdRs.next()) {
                            id = maxIdRs.getInt("id") + 1;                         
                        }
                        Statement st = con.createStatement();
                        String query = "insert into adminlo(id,name,pass,email) values('" + id + "','" + name.getText() + "','" + pass.getText() + "','"
                                + email.getText() + "');";
                        int i = st.executeUpdate(query);
                        if (i > 0) {
                            JOptionPane.showMessageDialog(button, "Successfull signup");
                            name.setText("");
                            pass.setText("");
                            email.setText("");
                            adminlo al = new adminlo();
                            frame.dispose();

                        } else {
                            JOptionPane.showMessageDialog(button, "failed ! signup");
                        }
                    } catch (Exception exp) {
                        System.out.println(exp);
                    }
                } else {
                    JOptionPane.showMessageDialog(button, "Please fill all fields");
                }
            }
        });
        Container c=frame.getContentPane();
        c.setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
