import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.font.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class userLogin {
    public userLogin() {
        JFrame frame = new JFrame("User Login ");
        frame.setBounds(50, 50, 400, 400);
        Font f = new Font("", Font.BOLD, 20);

        method me = new method();
        JLabel label = me.getLabel(frame, "User Login", 120, 20, 150, 30);
        label.setFont(f);
        me.getLabel(frame, "Name:", 50, 80, 100, 30);
        me.getLabel(frame, "Password:", 50, 120, 100, 30);
        me.getLabel(frame, "Email:", 50, 160, 100, 30);
        JTextField name = me.getText(frame, 140, 80, 130, 30);
        JTextField pass = me.getText(frame, 140, 120, 130, 30);
        JTextField email = me.getText(frame, 140, 160, 130, 30);
        JButton button1 = new JButton("Login");
        button1.setBounds(150, 250, 90, 40);
        frame.add(button1);
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(name.getText().equals("") && pass.getText().equals("") && email.getText().equals(""))) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root",
                                "3980");
                        String query = "select * from userlo where pass='" + pass.getText() + "'&& email='"
                                + email.getText() + "'";
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(query);
                        if (rs.next()) {
                            if (name.getText().equals(rs.getString("name"))
                                    && pass.getText().equals(rs.getString("pass"))
                                    && email.getText().equals(rs.getString("email"))) {
                                userInformation us = new userInformation();
                                name.setText("");
                                pass.setText("");
                                email.setText("");

                            } else {
                                JOptionPane.showMessageDialog(button1, "Incorrect not match please fill right data!");
                                name.setText("");
                                pass.setText("");
                                email.setText("");
                            }
                        } else {
                            JOptionPane.showMessageDialog(button1, "please signup your email!");
                            name.setText("");
                            pass.setText("");
                            email.setText("");
                        }

                    } catch (Exception exp) {
                        System.out.println(exp);
                    }
                } else {
                    JOptionPane.showMessageDialog(button1, "!please fill all fields");
                }
            }
        });
        button1.setBackground(Color.cyan);
        JButton button2 = new JButton("Cancel");
        button2.setBounds(40, 250, 90, 40);
        frame.add(button2);
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new login1();
            }
        });
        JButton button3 = new JButton("signup");
        button3.setBounds(250, 250, 90, 40);
        frame.add(button3);
        button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                usersignup uss = new usersignup();
                frame.dispose();
            }

        });
        button3.setBackground(Color.cyan);
        button2.setBackground(Color.cyan);
        JLabel img = new JLabel(new ImageIcon("MyProject/imges/us.png"));
        img.setBounds(0, 0, 500, 500);
        frame.add(img);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    // public static void main(String[] args) {
    //     new userLogin();
    // }

}
