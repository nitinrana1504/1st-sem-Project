import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class CustomerInfo extends JFrame implements ActionListener {
    JTable table;
    JLabel id;
    JLabel idnum;
    JLabel name;
    JLabel gender;
    JLabel country;
    JLabel Room;
    JLabel time;
    JLabel deposit;
    JButton Back;

    CustomerInfo() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#E5FCF5"));
        panel.setBounds(5, 5, 890, 590);
        panel.setLayout((LayoutManager)null);
        this.add(panel);
        this.table = new JTable();
        this.table.setBounds(10, 40, 900, 450);
        this.table.setBackground(Color.decode("#E5FCF5"));
        this.table.setForeground(Color.decode("#7FD8BE"));
        panel.add(this.table);

        try {
            Connector c = new Connector();
            String q = "select * from customer";
            ResultSet resultSet = c.statement.executeQuery(q);
            this.table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        this.id = new JLabel("ID");
        this.id.setBounds(31, 11, 46, 14);
        this.id.setForeground(Color.decode("#7FD8BE"));
        this.id.setFont(new Font("Tahoma", 1, 14));
        panel.add(this.id);
        this.idnum = new JLabel("ID Number");
        this.idnum.setBounds(140, 11, 110, 14);
        this.idnum.setForeground(Color.decode("#7FD8BE"));
        this.idnum.setFont(new Font("Tahoma", 1, 14));
        panel.add(this.idnum);
        this.name = new JLabel("Name");
        this.name.setBounds(270, 11, 46, 14);
        this.name.setForeground(Color.decode("#7FD8BE"));
        this.name.setFont(new Font("Tahoma", 1, 14));
        panel.add(this.name);
        this.gender = new JLabel("Gender");
        this.gender.setBounds(360, 11, 60, 14);
        this.gender.setForeground(Color.decode("#7FD8BE"));
        this.gender.setFont(new Font("Tahoma", 1, 14));
        panel.add(this.gender);
        this.country = new JLabel("Country");
        this.country.setBounds(480, 11, 60, 14);
        this.country.setForeground(Color.decode("#7FD8BE"));
        this.country.setFont(new Font("Tahoma", 1, 14));
        panel.add(this.country);
        this.Room = new JLabel("Room No");
        this.Room.setBounds(600, 11, 140, 14);
        this.Room.setForeground(Color.decode("#7FD8BE"));
        this.Room.setFont(new Font("Tahoma", 1, 14));
        panel.add(this.Room);
        this.time = new JLabel("CI Time");
        this.time.setBounds(700, 11, 140, 14);
        this.time.setForeground(Color.decode("#7FD8BE"));
        this.time.setFont(new Font("Tahoma", 1, 14));
        panel.add(this.time);
        this.deposit = new JLabel("Deposit");
        this.deposit.setBounds(800, 11, 140, 14);
        this.deposit.setForeground(Color.decode("#7FD8BE"));
        this.deposit.setFont(new Font("Tahoma", 1, 14));
        panel.add(this.deposit);
        this.Back = new JButton("Back");
        this.Back.addActionListener(this);
        this.Back.setBounds(390, 510, 120, 30);
        this.Back.setBackground(Color.decode("#00A676"));
        this.Back.setForeground(Color.decode("#FCEFEF"));
        panel.add(this.Back);
        this.setUndecorated(true);
        this.setLayout((LayoutManager)null);
        this.setLocation(500, 100);
        this.setSize(900, 600);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new CustomerInfo();
    }
}

