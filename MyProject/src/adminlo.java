import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class adminlo {
    /**
     * 
     */
    public adminlo() {
        JFrame frame = new JFrame("Admin Login ");
        frame.setBounds(30, 50, 400, 400);
        method me = new method();
        Font f = new Font("", Font.BOLD, 25);
        Font fn = new Font("", Font.BOLD, 15);
        JLabel head = me.getLabel(frame, "Admin Login", 120, 20, 160, 30);
        head.setFont(f);
        JLabel nm = me.getLabel(frame, "Name:", 50, 80, 100, 30);
        JLabel password = me.getLabel(frame, "Password:", 50, 120, 100, 30);
        JLabel Email = me.getLabel(frame, "Email:", 50, 160, 100, 30);

        JTextField name = me.getText(frame, 140, 80, 130, 30);
        JTextField pass = me.getText(frame, 140, 120, 130, 30);
        JTextField email = me.getText(frame, 140, 160, 130, 30);
        JButton button1 = new JButton("Login");
        button1.setFont(fn);
        button1.setBackground(Color.magenta);
        JButton button2 = new JButton("Cancel");
        button2.setFont(fn);
        button2.setBackground(Color.CYAN);
        button1.setBounds(150, 250, 90, 40);
        button2.setBounds(40, 250, 100, 40);
        frame.add(button1);
        frame.add(button2);
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                login1 log = new login1();
                log.m1();
                frame.dispose();
            }
        });
        JButton button = new JButton("signup");
        button.setBounds(250, 250, 90, 40);
        button.setFont(fn);
        frame.add(button);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                adminsinup as = new adminsinup();
                frame.dispose();
            }

        });
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(name.getText().equals("") && pass.getText().equals("") && email.getText().equals(""))) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root",
                                "3980");
                               
                        String query = "select * from adminlo where pass='" + pass.getText() + "'&& email= '"
                                + email.getText() + "'";                               
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(query);
                        if (rs.next()) {
                            if (name.getText().equals(rs.getString("name"))
                                    && pass.getText().equals(rs.getString("pass"))
                                    && email.getText().equals(rs.getString("email"))) {
                                imfomation ifor = new imfomation();                               
                                name.setText("");
                                pass.setText("");
                                email.setText("");
                                frame.dispose();

                            } else {
                                JOptionPane.showMessageDialog(button2, "Incorrect not match please fill right data!");
                                name.setText("");
                                pass.setText("");
                                email.setText("");
                            }
                        } else {
                            JOptionPane.showMessageDialog(button, "please signup your email!");
                            name.setText("");
                            pass.setText("");
                            email.setText("");
                        }
                    } catch (Exception exp) {
                        System.out.println(exp);
                    }
                } else {
                    JOptionPane.showMessageDialog(button2, "!please fill all fields");
                }
            }
        });
        JLabel img = new JLabel(new ImageIcon("MyProject/imges/ad.png"));
        img.setBounds(0, 0, 400, 400);
        frame.add(img);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    // public static void main(String[] args) {
    //     new adminlo();
    // }

}
