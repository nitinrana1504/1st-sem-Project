import java.awt.Choice;
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

public class PickUp extends JFrame {
    JLabel pus;
    JLabel toc;
    JLabel name;
    JLabel age;
    JLabel gender;
    JLabel company;
    JLabel carname;
    JLabel available;
    JLabel location;
    JTable table;
    JButton display;
    JButton back;

    PickUp() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#E5FCF5"));
        panel.setBounds(5, 5, 790, 590);
        panel.setLayout((LayoutManager)null);
        this.add(panel);
        this.pus = new JLabel("Pick Up Service");
        this.pus.setBounds(90, 11, 160, 20);
        this.pus.setForeground(Color.decode("#7FD8BE"));
        this.pus.setFont(new Font("Tahoma", 1, 14));
        panel.add(this.pus);
        this.toc = new JLabel("Type of Car");
        this.toc.setBounds(32, 97, 90, 20);
        this.toc.setForeground(Color.decode("#7FD8BE"));
        this.toc.setFont(new Font("Tahoma", 1, 14));
        panel.add(this.toc);
        final Choice c = new Choice();
        c.setBounds(123, 94, 150, 25);
        c.setBackground(Color.decode("#7FD8BE"));
        c.setForeground(Color.WHITE);
        panel.add(c);

        Connector c1;
        String q;
        ResultSet resultSet;
        try {
            c1 = new Connector();
            q = "select * from driver";
            resultSet = c1.statement.executeQuery(q);

            while(resultSet.next()) {
                c.add(resultSet.getString("car_name"));
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        this.table = new JTable();
        this.table.setBounds(10, 233, 800, 250);
        this.table.setBackground(Color.decode("#E5FCF5"));
        this.table.setForeground(Color.decode("#7FD8BE"));
        panel.add(this.table);

        try {
            c1 = new Connector();
            q = "select * from driver";
            resultSet = c1.statement.executeQuery(q);
            this.table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        this.name = new JLabel("Name");
        this.name.setBounds(24, 208, 46, 14);
        this.name.setForeground(Color.decode("#7FD8BE"));
        panel.add(this.name);
        this.age = new JLabel("Age");
        this.age.setBounds(165, 208, 46, 14);
        this.age.setForeground(Color.decode("#7FD8BE"));
        panel.add(this.age);
        this.gender = new JLabel("Gender");
        this.gender.setBounds(264, 208, 100, 14);
        this.gender.setForeground(Color.decode("#7FD8BE"));
        panel.add(this.gender);
        this.company = new JLabel("Company");
        this.company.setBounds(366, 208, 100, 14);
        this.company.setForeground(Color.decode("#7FD8BE"));
        panel.add(this.company);
        this.carname = new JLabel("Car Name");
        this.carname.setBounds(486, 208, 100, 14);
        this.carname.setForeground(Color.decode("#7FD8BE"));
        panel.add(this.carname);
        this.available = new JLabel("Available");
        this.available.setBounds(600, 208, 100, 14);
        this.available.setForeground(Color.decode("#7FD8BE"));
        panel.add(this.available);
        this.location = new JLabel("Location");
        this.location.setBounds(720, 208, 100, 14);
        this.location.setForeground(Color.decode("#7FD8BE"));
        panel.add(this.location);
        this.display = new JButton("Display");
        this.display.setBounds(200, 500, 120, 30);
        this.display.setBackground(Color.decode("#00A676"));
        this.display.setForeground(Color.decode("#FCEFEF"));
        panel.add(this.display);
        this.display.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String q = "select * from driver where car_name = '" + c.getSelectedItem() + "'";

                try {
                    Connector cx = new Connector();
                    ResultSet resultSet = cx.statement.executeQuery(q);
                    PickUp.this.table.setModel(DbUtils.resultSetToTableModel(resultSet));
                } catch (Exception var5) {
                    var5.printStackTrace();
                }

            }
        });
        this.back = new JButton("Back");
        this.back.setBounds(420, 500, 120, 30);
        this.back.setBackground(Color.decode("#00A676"));
        this.back.setForeground(Color.decode("#FCEFEF"));
        panel.add(this.back);
        this.back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PickUp.this.setVisible(false);
            }
        });
        this.setUndecorated(true);
        this.setLayout((LayoutManager)null);
        this.setLocation(500, 100);
        this.setSize(800, 600);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new PickUp();
    }
}
