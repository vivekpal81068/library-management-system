import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.font.*;
import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class upurchasedetail {
    int id=0;
    public upurchasedetail() {

        JFrame frame = new JFrame();
        frame.setBounds(30, 50, 400, 400);
        Font f = new Font("", Font.BOLD, 20);
        method me = new method();
        JLabel l1 = me.getLabel(frame, "Your Details", 130, 10, 140, 30);
        l1.setFont(f);
        me.getLabel(frame, "Book No.", 50, 50, 100, 30);
        me.getLabel(frame, "Your Name", 50, 100, 100, 30);
        me.getLabel(frame, "Mobile no", 50, 160, 110, 30);
        me.getLabel(frame, "Email id", 50, 210, 110, 30);
        me.getLabel(frame, "Address", 50, 270, 100, 30);
        JTextField bookno = me.getText(frame, 190, 50, 150, 30);
        JTextField name = me.getText(frame, 190, 100, 150, 30);
        JTextField mobile = me.getText(frame, 190, 160, 150, 30);
        JTextField email = me.getText(frame, 190, 210, 150, 30);
        JTextField address = me.getText(frame, 190, 270, 150, 30);
        JButton button = me.getButton(frame, "Submit", 120, 320, 100, 30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(bookno.getText().equals("") && name.getText().equals("") && mobile.getText().equals("")
                        && email.getText().equals("") && address.getText().equals(""))) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root",
                                "3980");
                                Statement maxIdSt = con.createStatement();
                                String maxIdQuery = "Select max(id) as id from userlo";
                                ResultSet maxIdRs = maxIdSt.executeQuery(maxIdQuery);
                                if (maxIdRs.next()) {
                                    id = maxIdRs.getInt("id") + 1;                         
                                }
                        Statement st = con.createStatement();
                        String query = "insert into bookin(id,bookno,name,mobile,email,address) values('" + id + "','" + bookno.getText() + "','" + name.getText() + "','"
                                + mobile.getText() + "','" + email.getText() + "','" + address.getText() + "');";
                        int i = st.executeUpdate(query);
                        if (i > 0) {
                            JOptionPane.showMessageDialog(button, "Successful purchase the book");
                            frame.dispose();
                        } else {
                            JOptionPane.showMessageDialog(button, "process failed! try  again");
                        }
                    } catch (Exception exp) {
                        System.out.println(exp);
                    }
                } else {
                    JOptionPane.showMessageDialog(button, "Please fill your Details!");
                }
            }
        });
        Container c=frame.getContentPane();
        c.setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);
        frame.setVisible(true);
    }

}
