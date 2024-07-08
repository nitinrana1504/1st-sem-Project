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

public class ManagerInfo extends JFrame {
    ManagerInfo() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#E5FCF5"));
        panel.setBounds(5, 5, 990, 590);
        panel.setLayout((LayoutManager)null);
        this.add(panel);
        JTable table = new JTable();
        table.setBounds(10, 34, 980, 450);
        table.setBackground(Color.decode("#E5FCF5"));
        table.setForeground(Color.decode("#7FD8BE"));
        panel.add(table);

        try {
            Connector c = new Connector();
            String q = "select * from employee where job = 'manager'";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception var12) {
            var12.printStackTrace();
        }

        JLabel name = new JLabel("NAME");
        name.setForeground(Color.decode("#7FD8BE"));
        name.setBounds(41, 11, 70, 19);
        name.setFont(new Font("Tahoma", 1, 14));
        panel.add(name);
        JLabel AGE = new JLabel("AGE");
        AGE.setForeground(Color.decode("#7FD8BE"));
        AGE.setBounds(159, 11, 70, 19);
        AGE.setFont(new Font("Tahoma", 1, 14));
        panel.add(AGE);
        JLabel GANDER = new JLabel("GANDER");
        GANDER.setForeground(Color.decode("#7FD8BE"));
        GANDER.setBounds(277, 11, 70, 19);
        GANDER.setFont(new Font("Tahoma", 1, 14));
        panel.add(GANDER);
        JLabel JOB = new JLabel("JOB");
        JOB.setForeground(Color.decode("#7FD8BE"));
        JOB.setBounds(416, 11, 70, 19);
        JOB.setFont(new Font("Tahoma", 1, 14));
        panel.add(JOB);
        JLabel SALARY = new JLabel("SALARY");
        SALARY.setForeground(Color.decode("#7FD8BE"));
        SALARY.setBounds(536, 11, 70, 19);
        SALARY.setFont(new Font("Tahoma", 1, 14));
        panel.add(SALARY);
        JLabel PHONE = new JLabel("PHONE NO");
        PHONE.setForeground(Color.decode("#7FD8BE"));
        PHONE.setBounds(646, 11, 110, 19);
        PHONE.setFont(new Font("Tahoma", 1, 14));
        panel.add(PHONE);
        JLabel GMAIL = new JLabel("GMAIL");
        GMAIL.setForeground(Color.decode("#7FD8BE"));
        GMAIL.setBounds(786, 11, 70, 19);
        GMAIL.setFont(new Font("Tahoma", 1, 14));
        panel.add(GMAIL);
        JLabel AADHAR = new JLabel("AADHAR");
        AADHAR.setForeground(Color.decode("#7FD8BE"));
        AADHAR.setBounds(896, 11, 70, 19);
        AADHAR.setFont(new Font("Tahoma", 1, 14));
        panel.add(AADHAR);
        JButton back = new JButton("BACK");
        back.setBounds(450, 500, 120, 30);
        back.setBackground(Color.decode("#00A676"));
        back.setForeground(Color.decode("#FCEFEF"));
        panel.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ManagerInfo.this.setVisible(false);
            }
        });
        this.setUndecorated(true);
        this.setLayout((LayoutManager)null);
        this.setLocation(430, 100);
        this.setSize(1000, 600);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ManagerInfo();
    }
}
