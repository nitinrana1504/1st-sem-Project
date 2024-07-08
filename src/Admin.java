import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Admin extends JFrame implements ActionListener {
    JButton Add_employee = new JButton("ADD EMPLOYEE");
    JButton Add_Room;
    JButton Add_Drivers;
    JButton logout;
    JButton back;

    Admin() {
        this.Add_employee.setBounds(250, 230, 200, 30);
        this.Add_employee.setBackground(Color.decode("#00A676"));
        this.Add_employee.setForeground(Color.decode("#FCEFEF"));
        this.Add_employee.setFont(new Font("Tahoma", 1, 15));
        this.Add_employee.addActionListener(this);
        this.add(this.Add_employee);
        this.Add_Room = new JButton("ADD ROOM");
        this.Add_Room.setBounds(250, 380, 200, 30);
        this.Add_Room.setBackground(Color.decode("#00A676"));
        this.Add_Room.setForeground(Color.decode("#FCEFEF"));
        this.Add_Room.setFont(new Font("Tahoma", 1, 15));
        this.Add_Room.addActionListener(this);
        this.add(this.Add_Room);
        this.Add_Drivers = new JButton("ADD DRIVERS");
        this.Add_Drivers.setBounds(250, 530, 200, 30);
        this.Add_Drivers.setBackground(Color.decode("#00A676"));
        this.Add_Drivers.setForeground(Color.decode("#FCEFEF"));
        this.Add_Drivers.setFont(new Font("Tahoma", 1, 15));
        this.Add_Drivers.addActionListener(this);
        this.add(this.Add_Drivers);
        this.logout = new JButton("Logout");
        this.logout.setBounds(10, 750, 95, 30);
        this.logout.setBackground(Color.decode("#00A676"));
        this.logout.setForeground(Color.decode("#FCEFEF"));
        this.logout.setFont(new Font("Tahoma", 1, 15));
        this.logout.addActionListener(this);
        this.add(this.logout);
        this.back = new JButton("Back");
        this.back.setBounds(110, 750, 95, 30);
        this.back.setBackground(Color.decode("#00A676"));
        this.back.setForeground(Color.decode("#FCEFEF"));
        this.back.setFont(new Font("Tahoma", 1, 15));
        this.back.addActionListener(this);
        this.add(this.back);
        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
        Image l11 = l1.getImage().getScaledInstance(120, 120, 1);
        ImageIcon imageIcon1 = new ImageIcon(l11);
        JLabel label1 = new JLabel(imageIcon1);
        label1.setBounds(70, 180, 120, 120);
        this.add(label1);
        ImageIcon l2 = new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image l22 = l2.getImage().getScaledInstance(120, 120, 1);
        ImageIcon imageIcon2 = new ImageIcon(l22);
        JLabel label2 = new JLabel(imageIcon2);
        label2.setBounds(70, 330, 120, 120);
        this.add(label2);
        ImageIcon l3 = new ImageIcon(ClassLoader.getSystemResource("icon/driver.png"));
        Image l33 = l3.getImage().getScaledInstance(120, 120, 1);
        ImageIcon imageIcon3 = new ImageIcon(l33);
        JLabel label3 = new JLabel(imageIcon3);
        label3.setBounds(70, 480, 120, 120);
        this.add(label3);
        ImageIcon l4 = new ImageIcon(ClassLoader.getSystemResource("icon/Logo.gif"));
        Image l44 = l4.getImage().getScaledInstance(400, 400, 1);
        ImageIcon imageIcon4 = new ImageIcon(l44);
        JLabel label4 = new JLabel(imageIcon4);
        label4.setBounds(1000, 250, 400, 400);
        this.add(label4);
        this.getContentPane().setBackground(Color.decode("#E5FCF5"));
        this.setLayout((LayoutManager)null);
        this.setSize(1950, 1080);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.Add_employee) {
            new AddEmployee();
        } else if (e.getSource() == this.Add_Room) {
            new Addroom();
        } else if (e.getSource() == this.Add_Drivers) {
            new AddDriver();
        } else if (e.getSource() == this.logout) {
            System.exit(102);
        } else if (e.getSource() == this.back) {
            new Dashboard();
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Admin();
    }
}
