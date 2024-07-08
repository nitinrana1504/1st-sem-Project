import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Dashboard extends JFrame implements ActionListener {
    JButton admin;
    JButton recp = new JButton("RECEPTION");

    Dashboard() {
        super("HOTEL MANAGEMENT SYSTEM");
        this.recp.setBounds(425, 510, 140, 30);
        this.recp.setFont(new Font("Tahoma", 1, 15));
        this.recp.setBackground(Color.decode("#00A676"));
        this.recp.setForeground(Color.decode("#FCEFEF"));
        this.recp.addActionListener(this);
        this.add(this.recp);
        ImageIcon imageRecp = new ImageIcon(ClassLoader.getSystemResource("icon/Reception.png"));
        Image i1 = imageRecp.getImage().getScaledInstance(200, 195, 1);
        ImageIcon imageIconRecp = new ImageIcon(i1);
        JLabel label1 = new JLabel(imageIconRecp);
        label1.setBounds(400, 300, 200, 195);
        this.add(label1);
        this.admin = new JButton("ADMIN");
        this.admin.setBounds(880, 510, 140, 30);
        this.admin.setFont(new Font("Tahoma", 1, 15));
        this.admin.setBackground(Color.decode("#00A676"));
        this.admin.setForeground(Color.decode("#FCEFEF"));
        this.admin.addActionListener(this);
        this.add(this.admin);
        JButton back = new JButton("Logout");
        back.setBounds(660, 700, 140, 30);
        back.setFont(new Font("Tahoma", 1, 15));
        back.setBackground(Color.decode("#00A676"));
        back.setForeground(Color.decode("#FCEFEF"));
        this.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(303);
            }
        });
        ImageIcon imageAdmin = new ImageIcon(ClassLoader.getSystemResource("icon/boss.png"));
        Image i2 = imageAdmin.getImage().getScaledInstance(200, 195, 1);
        ImageIcon imageIconAdmin = new ImageIcon(i2);
        JLabel label2 = new JLabel(imageIconAdmin);
        label2.setBounds(850, 300, 200, 195);
        this.add(label2);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/cccc.gif"));
        Image i3 = imageIcon.getImage().getScaledInstance(1950, 1090, 1);
        ImageIcon imageIcon1 = new ImageIcon(i3);
        JLabel label3 = new JLabel(imageIcon1);
        label3.setBounds(0, 0, 1950, 1090);
        this.add(label3);
        this.setLocale((Locale)null);
        this.setSize(1950, 1090);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.recp) {
            new Reception();
            this.setVisible(false);
        } else {
            new adminlogin();
        }

    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
