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

public class Department extends JFrame {
    Department() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#E5FCF5"));
        panel.setBounds(5, 5, 690, 490);
        panel.setLayout((LayoutManager)null);
        this.add(panel);
        JTable table = new JTable();
        table.setBounds(0, 40, 700, 350);
        table.setBackground(Color.decode("#E5FCF5"));
        table.setForeground(Color.decode("#7FD8BE"));
        panel.add(table);

        try {
            Connector c = new Connector();
            String departmentInfo = "select * from department";
            ResultSet resultSet = c.statement.executeQuery(departmentInfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        JLabel Department = new JLabel("Department");
        Department.setForeground(Color.decode("#7FD8BE"));
        Department.setBounds(145, 15, 120, 19);
        Department.setFont(new Font("Tahoma", 1, 14));
        panel.add(Department);
        JLabel Budget = new JLabel("Budget");
        Budget.setForeground(Color.decode("#7FD8BE"));
        Budget.setBounds(470, 15, 80, 19);
        Budget.setFont(new Font("Tahoma", 1, 14));
        panel.add(Budget);
        JButton back = new JButton("BACK");
        back.setBounds(470, 410, 120, 30);
        back.setBackground(Color.decode("#00A676"));
        back.setForeground(Color.decode("#FCEFEF"));
        panel.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Department.this.setVisible(false);
            }
        });
        this.setUndecorated(true);
        this.setLayout((LayoutManager)null);
        this.setLocation(550, 150);
        this.setSize(700, 500);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }
}
