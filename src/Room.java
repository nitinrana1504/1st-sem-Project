import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class Room extends JFrame {
    JTable table;
    JButton back;

    Room() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(Color.decode("#E5FCF5"));
        panel.setLayout((LayoutManager)null);
        this.add(panel);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, 1);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon2);
        label.setBounds(600, 200, 200, 200);
        panel.add(label);
        this.table = new JTable();
        this.table.setBounds(10, 40, 500, 200);
        this.table.setBackground(Color.decode("#E5FCF5"));
        this.table.setForeground(Color.decode("#7FD8BE"));
        panel.add(this.table);

        try {
            Connector c = new Connector();
            String RoomInfo = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(RoomInfo);
            this.table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception var11) {
            var11.printStackTrace();
        }

        JLabel room = new JLabel("Room No");
        room.setForeground(Color.decode("#7FD8BE"));
        room.setBounds(12, 15, 80, 19);
        room.setFont(new Font("Tahoma", 1, 14));
        panel.add(room);
        JLabel availability = new JLabel("Availability");
        availability.setForeground(Color.decode("#7FD8BE"));
        availability.setBounds(119, 15, 80, 19);
        availability.setFont(new Font("Tahoma", 1, 14));
        panel.add(availability);
        JLabel clean = new JLabel("Clean Status");
        clean.setForeground(Color.decode("#7FD8BE"));
        clean.setBounds(216, 15, 150, 19);
        clean.setFont(new Font("Tahoma", 1, 14));
        panel.add(clean);
        JLabel price = new JLabel("Price");
        price.setForeground(Color.decode("#7FD8BE"));
        price.setBounds(330, 15, 80, 19);
        price.setFont(new Font("Tahoma", 1, 14));
        panel.add(price);
        JLabel roomType = new JLabel("Bed Type");
        roomType.setForeground(Color.decode("#7FD8BE"));
        roomType.setBounds(417, 15, 80, 19);
        roomType.setFont(new Font("Tahoma", 1, 14));
        panel.add(roomType);
        this.back = new JButton("BACK");
        this.back.setBounds(100, 500, 120, 30);
        this.back.setBackground(Color.decode("#00A676"));
        this.back.setForeground(Color.decode("#FCEFEF"));
        panel.add(this.back);
        this.back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Room.this.setVisible(false);
            }
        });
        this.setUndecorated(true);
        this.setLayout((LayoutManager)null);
        this.setLocation(500, 100);
        this.setSize(900, 600);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Room();
    }
}
