import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame implements ActionListener {
    JLabel searchforroom;
    JLabel roomBedType;
    JLabel roomNo;
    JLabel availability;
    JLabel CleanStatus;
    JLabel Price;
    JLabel Bedtype;
    JCheckBox checkBox;
    Choice choice;
    JTable table;
    JButton search;
    JButton Back;

    SearchRoom() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#E5FCF5"));
        panel.setBounds(5, 5, 690, 490);
        panel.setLayout((LayoutManager)null);
        this.add(panel);
        this.roomBedType = new JLabel("Room Bed Type:");
        this.roomBedType.setBounds(50, 73, 120, 20);
        this.roomBedType.setForeground(Color.decode("#7FD8BE"));
        this.roomBedType.setFont(new Font("Tahoma", 1, 14));
        panel.add(this.roomBedType);
        this.roomNo = new JLabel("Room Number");
        this.roomNo.setBounds(23, 162, 120, 20);
        this.roomNo.setForeground(Color.decode("#7FD8BE"));
        this.roomNo.setFont(new Font("Tahoma", 1, 14));
        panel.add(this.roomNo);
        this.availability = new JLabel("Availability");
        this.availability.setBounds(175, 162, 120, 20);
        this.availability.setForeground(Color.decode("#7FD8BE"));
        this.availability.setFont(new Font("Tahoma", 1, 14));
        panel.add(this.availability);
        this.CleanStatus = new JLabel("Clean Status");
        this.CleanStatus.setBounds(306, 162, 120, 20);
        this.CleanStatus.setForeground(Color.decode("#7FD8BE"));
        this.CleanStatus.setFont(new Font("Tahoma", 1, 14));
        panel.add(this.CleanStatus);
        this.Price = new JLabel("Price");
        this.Price.setBounds(458, 162, 120, 20);
        this.Price.setForeground(Color.decode("#7FD8BE"));
        this.Price.setFont(new Font("Tahoma", 1, 14));
        panel.add(this.Price);
        this.Bedtype = new JLabel("Bed Type");
        this.Bedtype.setBounds(580, 162, 120, 20);
        this.Bedtype.setForeground(Color.decode("#7FD8BE"));
        this.Bedtype.setFont(new Font("Tahoma", 1, 14));
        panel.add(this.Bedtype);
        this.searchforroom = new JLabel("Search For Room");
        this.searchforroom.setBounds(250, 11, 186, 31);
        this.searchforroom.setForeground(Color.decode("#7FD8BE"));
        this.searchforroom.setFont(new Font("Tahoma", 1, 20));
        panel.add(this.searchforroom);
        this.checkBox = new JCheckBox("Only Display Available");
        this.checkBox.setBounds(400, 69, 209, 23);
        this.checkBox.setForeground(Color.decode("#7FD8BE"));
        this.checkBox.setBackground(Color.decode("#E5FCF5"));
        panel.add(this.checkBox);
        this.choice = new Choice();
        this.choice.add("Single Bed");
        this.choice.add("Double Bed");
        this.choice.setBackground(Color.decode("#7FD8BE"));
        this.choice.setForeground(Color.WHITE);
        this.choice.setBounds(180, 70, 120, 20);
        panel.add(this.choice);
        this.table = new JTable();
        this.table.setBounds(0, 189, 700, 200);
        this.table.setBackground(Color.decode("#E5FCF5"));
        this.table.setForeground(Color.decode("#7FD8BE"));
        panel.add(this.table);

        try {
            Connector c = new Connector();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            this.table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        this.search = new JButton("Search");
        this.search.setBounds(200, 400, 120, 30);
        this.search.setBackground(Color.decode("#00A676"));
        this.search.setForeground(Color.decode("#FCEFEF"));
        this.search.addActionListener(this);
        panel.add(this.search);
        this.Back = new JButton("Back");
        this.Back.setBounds(380, 400, 120, 30);
        this.Back.setBackground(Color.decode("#00A676"));
        this.Back.setForeground(Color.decode("#FCEFEF"));
        this.Back.addActionListener(this);
        panel.add(this.Back);
        this.setUndecorated(true);
        this.setLayout((LayoutManager)null);
        this.setLocation(500, 200);
        this.setSize(700, 500);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.search) {
            String Q = "select * from room where Bed_type = '" + this.choice.getSelectedItem() + "'";
            String Q1 = "select * from room where Availability = 'Available' And Bed_type = '" + this.choice.getSelectedItem() + "'";

            try {
                Connector c = new Connector();
                ResultSet resultSet = c.statement.executeQuery(Q);
                this.table.setModel(DbUtils.resultSetToTableModel(resultSet));
                if (this.checkBox.isSelected()) {
                    ResultSet resultSet1 = c.statement.executeQuery(Q1);
                    this.table.setModel(DbUtils.resultSetToTableModel(resultSet1));
                }
            } catch (Exception var7) {
                var7.printStackTrace();
            }
        } else {
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
