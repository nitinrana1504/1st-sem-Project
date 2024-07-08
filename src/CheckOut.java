import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CheckOut extends JFrame {
    Choice Customer;
    JButton buttoncheckout;
    JButton buttoncheck;
    JButton buttonback;

    CheckOut() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 790, 390);
        panel.setBackground(Color.decode("#E5FCF5"));
        panel.setLayout((LayoutManager)null);
        this.add(panel);
        JLabel label = new JLabel("Check-Out");
        label.setBounds(100, 20, 150, 30);
        label.setFont(new Font("Tahoma", 1, 20));
        label.setForeground(Color.decode("#7FD8BE"));
        panel.add(label);
        JLabel userId = new JLabel("Customer ID:");
        userId.setBounds(30, 80, 100, 30);
        userId.setFont(new Font("Tahoma", 0, 14));
        userId.setForeground(Color.decode("#7FD8BE"));
        panel.add(userId);
        this.Customer = new Choice();
        this.Customer.setBounds(200, 80, 210, 25);
        this.Customer.setBackground(Color.decode("#7FD8BE"));
        this.Customer.setForeground(Color.WHITE);
        panel.add(this.Customer);
        JLabel room = new JLabel("Room No:");
        room.setBounds(30, 130, 100, 30);
        room.setFont(new Font("Tahoma", 0, 14));
        room.setForeground(Color.decode("#7FD8BE"));
        panel.add(room);
        final JLabel Lableroom = new JLabel("");
        Lableroom.setBounds(200, 130, 210, 30);
        Lableroom.setFont(new Font("Tahoma", 0, 14));
        Lableroom.setForeground(Color.decode("#7FD8BE"));
        panel.add(Lableroom);
        JLabel Checkintime = new JLabel("Check-In Time:");
        Checkintime.setBounds(30, 180, 100, 30);
        Checkintime.setFont(new Font("Tahoma", 0, 14));
        Checkintime.setForeground(Color.decode("#7FD8BE"));
        panel.add(Checkintime);
        final JLabel LabelCheckintime = new JLabel("");
        LabelCheckintime.setBounds(200, 180, 210, 30);
        LabelCheckintime.setFont(new Font("Tahoma", 0, 14));
        LabelCheckintime.setForeground(Color.decode("#7FD8BE"));
        panel.add(LabelCheckintime);
        JLabel checkout = new JLabel("Check-Out:");
        checkout.setBounds(30, 230, 150, 30);
        checkout.setFont(new Font("Tahoma", 0, 14));
        checkout.setForeground(Color.decode("#7FD8BE"));
        panel.add(checkout);
        Date date = new Date();
        JLabel Lablecheckout = new JLabel("" + String.valueOf(date));
        Lablecheckout.setBounds(200, 230, 210, 30);
        Lablecheckout.setFont(new Font("Tahoma", 0, 14));
        Lablecheckout.setForeground(Color.decode("#7FD8BE"));
        panel.add(Lablecheckout);

        try {
            Connector c = new Connector();
            ResultSet resultSet = c.statement.executeQuery("select * from customer");

            while(resultSet.next()) {
                this.Customer.add(resultSet.getString("ID_NO"));
            }
        } catch (Exception var13) {
            var13.printStackTrace();
        }

        this.buttoncheckout = new JButton("Check-Out");
        this.buttoncheckout.setBounds(30, 300, 120, 30);
        this.buttoncheckout.setBackground(Color.decode("#00A676"));
        this.buttoncheckout.setForeground(Color.decode("#FCEFEF"));
        this.buttoncheckout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connector c = new Connector();

                try {
                    c.statement.executeUpdate("delete from customer where ID_NO = '" + CheckOut.this.Customer.getSelectedItem() + "'");
                    c.statement.executeUpdate("update room set Availability = 'Available' where Room_no = '" + Lableroom.getText() + "'");
                    JOptionPane.showMessageDialog((Component)null, "Done");
                    CheckOut.this.setVisible(false);
                } catch (Exception var4) {
                    var4.printStackTrace();
                }

            }
        });
        panel.add(this.buttoncheckout);
        this.buttoncheck = new JButton("Check");
        this.buttoncheck.setBounds(300, 300, 120, 30);
        this.buttoncheck.setBackground(Color.decode("#00A676"));
        this.buttoncheck.setForeground(Color.decode("#FCEFEF"));
        this.buttoncheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connector c = new Connector();

                try {
                    ResultSet resultSet = c.statement.executeQuery("select * from customer where ID_NO = '" + CheckOut.this.Customer.getSelectedItem() + "'");

                    while(resultSet.next()) {
                        Lableroom.setText(resultSet.getString("Room_no"));
                        LabelCheckintime.setText(resultSet.getString("Check_In_Time"));
                    }
                } catch (Exception var4) {
                    var4.printStackTrace();
                }

            }
        });
        panel.add(this.buttoncheck);
        this.buttonback = new JButton("Back");
        this.buttonback.setBounds(170, 300, 120, 30);
        this.buttonback.setBackground(Color.decode("#00A676"));
        this.buttonback.setForeground(Color.decode("#FCEFEF"));
        this.buttonback.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CheckOut.this.setVisible(false);
            }
        });
        panel.add(this.buttonback);
        this.setUndecorated(true);
        this.setLayout((LayoutManager)null);
        this.setSize(800, 400);
        this.setLocation(500, 210);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new CheckOut();
    }
}
