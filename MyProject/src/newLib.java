import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.font.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class newLib {
     public newLib() {
   
        JFrame frame = new JFrame("Librarian data");
        frame.setBounds(30, 50, 700, 600);
        Font f = new Font("", Font.BOLD, 20);

        method me = new method();
        JLabel label = me.getLabel(frame, "View  Librarian", 250, 20, 150, 30);
        label.setFont(f);       
        String[] cn = { "ID","Name", "Password", "Email", "Contact", "Address", "City" };
        DefaultTableModel model = new DefaultTableModel(cn, 0);
        JTable table = new JTable(model);
        frame.add(table);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(50, 80, 530, 350);
        frame.add(pane);
        JButton button = new JButton("Show");
        button.setBounds(350, 480, 100, 40);
        frame.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {               
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/project", "root",
                                "3980");
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
                    Object[] rowdata = {  };
                    model.addRow(rowdata);               
            }
        });
        JButton back = me.getButton(frame, "<<Back", 200, 480, 100, 40);
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
