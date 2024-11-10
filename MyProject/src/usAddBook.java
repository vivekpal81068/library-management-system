import java.awt.Container;
import java.awt.Font;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class usAddBook {
    int id =0;
     public usAddBook() {
    //public static void main(String[] args) {

        JFrame frame = new JFrame("Add book");
        frame.setBounds(30, 50, 500, 600);
        Font f = new Font("", Font.BOLD, 18);
        method me = new method();
        JLabel l1 = me.getLabel(frame, "Add Book", 170, 20, 120, 30);
        l1.setFont(f);
        me.getLabel(frame, "Book no.", 80, 80, 100, 30);
        me.getLabel(frame, "Book Name", 80, 140, 100, 30);
        me.getLabel(frame, "Author", 80, 200, 100, 30);
        me.getLabel(frame, "Publisher", 80, 260, 100, 30);
        me.getLabel(frame, "Quantity", 80, 320, 100, 30);
        me.getLabel(frame, "Added date", 80, 380, 100, 30);

        JTextField bkno = me.getText(frame, 210, 80, 150, 30);
        JTextField bkna = me.getText(frame, 210, 140, 150, 30);
        JTextField aut = me.getText(frame, 210, 200, 150, 30);
        JTextField publ = me.getText(frame, 210, 260, 150, 30);
        JTextField pri = me.getText(frame, 210, 320, 150, 30);
        JTextField addate = me.getText(frame, 210, 380, 150, 30);

        JButton add = me.getButton(frame, "Add Book", 160, 450, 120, 40);
        add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(bkno.getText().equals("") && bkna.getText().equals("") && aut.getText().equals("")
                        && publ.getText().equals("") && pri.getText().equals("") && addate.getText().equals(""))) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root",
                                "3980");
                                 Statement maxIdSt = con.createStatement();
                        String maxIdQuery = "Select max(id) as id from books";
                        ResultSet maxIdRs = maxIdSt.executeQuery(maxIdQuery);
                        if (maxIdRs.next()) {
                            id = maxIdRs.getInt("id") + 1;
                        }
                        Statement st = con.createStatement();
                        String query = "insert into books (id,bkno,bkna,aut,publ,quan,addate)values('"+id+"','" + bkno.getText() + "','" + bkna.getText() + "','"
                                + aut.getText() + "','" + publ.getText() + "','" + pri.getText() + "','"
                                + addate.getText() + "');";
                        int i = st.executeUpdate(query);
                        con.close();
                        if (i > 0) {
                            JOptionPane.showMessageDialog(add, "successfull add the Book");
                            bkno.setText("");
                            bkna.setText("");
                            aut.setText("");
                            publ.setText("");
                            pri.setText("");
                            addate.setText("");
                        } else {
                            JOptionPane.showMessageDialog(add, "failed!");

                        }
                    } catch (Exception exp) {
                        System.out.println(exp);
                    }
                } else {
                    JOptionPane.showMessageDialog(add, "please fill all fields!");
                }

            }

        });
        JButton cancel = me.getButton(frame, "Cancel", 300, 450, 90, 40);
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bkno.setText("");
                bkna.setText("");
                aut.setText("");
                publ.setText("");
                pri.setText("");
                addate.setText("");
            }

        });
        JButton back = me.getButton(frame, "<<Back", 50, 450, 90, 40);
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
