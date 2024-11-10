import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.font.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class method {
    public JLabel getLabel(JFrame frame, String title, int x, int y, int width, int height) {
        JLabel label = new JLabel(title);
        label.setBounds(x, y, width, height);
        frame.add(label);
        return label;
    }

    public JTextField getText(JFrame frame, int x, int y, int width, int height) {
        JTextField field = new JTextField();
        field.setBounds(x, y, width, height);
        frame.add(field);
        return field;
    }

    public JButton getButton(JFrame frame, String title, int x, int y, int width, int height) {
        JButton button = new JButton(title);
        button.setBounds(x, y, width, height);
        frame.add(button);
        return button;
    }   
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(30, 50, 700, 600);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
