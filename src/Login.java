import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
    JTextField textField1;
    JPasswordField passwordField1;
    JButton b1;
    JButton b2;

    Login() {
        JLabel label1 = new JLabel("Username");
        label1.setBounds(40, 20, 100, 30);
        label1.setFont(new Font("Tahoma", 1, 16));
        label1.setForeground(Color.decode("#7FD8BE"));
        this.add(label1);
        this.textField1 = new JTextField();
        this.textField1.setBounds(150, 20, 150, 30);
        this.textField1.setForeground(Color.WHITE);
        this.textField1.setFont(new Font("Tahom", 0, 15));
        this.textField1.setBackground(Color.decode("#7FD8BE"));
        this.add(this.textField1);
        JLabel label2 = new JLabel("Password");
        label2.setBounds(40, 70, 100, 30);
        label2.setFont(new Font("Tahoma", 1, 16));
        label2.setForeground(Color.decode("#7FD8BE"));
        this.add(label2);
        this.passwordField1 = new JPasswordField();
        this.passwordField1.setBounds(150, 70, 150, 30);
        this.passwordField1.setForeground(Color.WHITE);
        this.passwordField1.setBackground(Color.decode("#7FD8BE"));
        this.add(this.passwordField1);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Logo.gif"));
        Image i1 = imageIcon.getImage().getScaledInstance(300, 300, 1);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(318, -30, 300, 300);
        this.add(label);
        this.b1 = new JButton("Login");
        this.b1.setBounds(40, 140, 120, 30);
        this.b1.setFont(new Font("serif", 1, 15));
        this.b1.setBackground(Color.decode("#00A676"));
        this.b1.setForeground(Color.decode("#FCEFEF"));
        this.b1.addActionListener(this);
        this.add(this.b1);
        this.b2 = new JButton("Cancel");
        this.b2.setBounds(180, 140, 120, 30);
        this.b2.setFont(new Font("serif", 1, 15));
        this.b2.setBackground(Color.decode("#00A676"));
        this.b2.setForeground(Color.decode("#FCEFEF"));
        this.b2.addActionListener(this);
        this.add(this.b2);
        this.getContentPane().setBackground(Color.decode("#E5FCF5"));
        this.setLayout((LayoutManager)null);
        this.setLocation(400, 270);
        this.setSize(650, 300);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.b1) {
            try {
                Connector c = new Connector();
                String user = this.textField1.getText();
                String pass = this.passwordField1.getText();
                String q = "select * from login where username = '" + user + "' and password = '" + pass + "'";
                ResultSet resultset = c.statement.executeQuery(q);
                if (resultset.next()) {
                    new Dashboard();
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "Invalid");
                }
            } catch (Exception var7) {
                var7.printStackTrace();
            }
        } else {
            System.exit(102);
        }

    }

    public static void main(String[] args) {
        new Login();
    }
}

