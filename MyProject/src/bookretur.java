import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class bookretur {
    public bookretur() {    
        JFrame frame = new JFrame("Return Book");
        frame.setBounds(30, 50, 400, 400);
        Font f = new Font("", Font.BOLD, 20);

        method me = new method();
        JLabel l1 = me.getLabel(frame, "Return Book", 150, 20, 150, 30);
        l1.setFont(f);
        me.getLabel(frame, "Book No", 50, 60, 100, 30);
        me.getLabel(frame, "Your Name", 50, 120, 100, 30);
        me.getLabel(frame, "email_id", 50, 180, 100, 30);
        me.getLabel(frame, "Address", 50, 240, 100, 30);
        JTextField book = me.getText(frame, 150, 60, 150, 30);
        JTextField name = me.getText(frame, 150, 120, 150, 30);
        JTextField email = me.getText(frame, 150, 180, 150, 30);
        JTextField address = me.getText(frame, 150, 240, 150, 30);
        JButton button = me.getButton(frame, "Return", 200, 290, 100, 30);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(book.getText().equals("") && name.getText().equals("") && email.getText().equals("")
                        && address.getText().equals(""))) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root",
                                "3980");
                              
                        Statement st = con.createStatement();
                        String query = "select*from bookin where bookno='" + book.getText() + "' && name='"
                                + name.getText() + "'&& email='" + email.getText() + "'&& address='"
                                + address.getText()
                                + "'";                                
                        ResultSet rs = st.executeQuery(query);
                        if (rs.next()) {
                            if (book.getText().equals(rs.getString("bookno"))
                                    && name.getText().equals(rs.getString("name"))
                                    && email.getText().equals(rs.getString("email"))
                                    && address.getText().equals(rs.getString("address"))) {
                                JOptionPane.showMessageDialog(button, "Successfull return your book");
                                book.setText("");                              
                                name.setText("");
                                email.setText("");
                                address.setText("");

                            }
                        } else {
                            JOptionPane.showMessageDialog(button, "incorrect your data");
                        }

                    } catch (Exception exp) {
                        System.out.println(exp);
                    }

                } else {
                    JOptionPane.showMessageDialog(button, "Please fill all fields!");
                }
            }

        });
        JButton back = me.getButton(frame, "<<Back", 80, 290, 90, 30);
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
