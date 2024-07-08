import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Addroom extends JFrame implements ActionListener {
    JTextField Room_num;
    JTextField priceText;
    JComboBox availabilityor;
    JComboBox cleaningStatusBox;
    JComboBox bedTypeBox;
    JButton Add;
    JButton Back;

    Addroom() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 875, 490);
        panel.setBackground(Color.decode("#E5FCF5"));
        panel.setLayout((LayoutManager)null);
        this.add(panel);
        JLabel l1 = new JLabel("Add Rooms");
        l1.setBounds(195, 10, 160, 22);
        l1.setFont(new Font("Tahoma", 1, 22));
        l1.setForeground(Color.decode("#7FD8BE"));
        panel.add(l1);
        JLabel roomNumber = new JLabel("Room Number");
        roomNumber.setBounds(64, 70, 152, 22);
        roomNumber.setFont(new Font("Tahoma", 1, 15));
        roomNumber.setForeground(Color.decode("#7FD8BE"));
        panel.add(roomNumber);
        this.Room_num = new JTextField();
        this.Room_num.setBounds(200, 70, 152, 20);
        this.Room_num.setFont(new Font("Tahoma", 0, 15));
        this.Room_num.setForeground(Color.WHITE);
        this.Room_num.setBackground(Color.decode("#7FD8BE"));
        panel.add(this.Room_num);
        JLabel availability = new JLabel("Availability");
        availability.setBounds(64, 110, 152, 22);
        availability.setFont(new Font("Tahoma", 1, 15));
        availability.setForeground(Color.decode("#7FD8BE"));
        panel.add(availability);
        this.availabilityor = new JComboBox(new String[]{"Available", "Occupied"});
        this.availabilityor.setBounds(200, 110, 152, 20);
        this.availabilityor.setFont(new Font("Tahoma", 0, 15));
        this.availabilityor.setForeground(Color.WHITE);
        this.availabilityor.setBackground(Color.decode("#7FD8BE"));
        panel.add(this.availabilityor);
        JLabel price = new JLabel("Price");
        price.setBounds(64, 150, 152, 22);
        price.setFont(new Font("Tahoma", 1, 15));
        price.setForeground(Color.decode("#7FD8BE"));
        panel.add(price);
        this.priceText = new JTextField();
        this.priceText.setBounds(200, 150, 152, 22);
        this.priceText.setFont(new Font("Tahoma", 0, 15));
        this.priceText.setForeground(Color.WHITE);
        this.priceText.setBackground(Color.decode("#7FD8BE"));
        panel.add(this.priceText);
        JLabel cleaningStatus = new JLabel("Cleaning Status");
        cleaningStatus.setBounds(64, 190, 152, 22);
        cleaningStatus.setFont(new Font("Tahoma", 1, 15));
        cleaningStatus.setForeground(Color.decode("#7FD8BE"));
        panel.add(cleaningStatus);
        this.cleaningStatusBox = new JComboBox(new String[]{"Cleaned", "Dirty"});
        this.cleaningStatusBox.setBounds(200, 190, 152, 22);
        this.cleaningStatusBox.setFont(new Font("Tahoma", 0, 15));
        this.cleaningStatusBox.setForeground(Color.WHITE);
        this.cleaningStatusBox.setBackground(Color.decode("#7FD8BE"));
        panel.add(this.cleaningStatusBox);
        JLabel bedType = new JLabel("Bed Type");
        bedType.setBounds(64, 230, 152, 22);
        bedType.setFont(new Font("Tahoma", 1, 15));
        bedType.setForeground(Color.decode("#7FD8BE"));
        panel.add(bedType);
        this.bedTypeBox = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        this.bedTypeBox.setBounds(200, 230, 152, 22);
        this.bedTypeBox.setFont(new Font("Tahoma", 0, 15));
        this.bedTypeBox.setForeground(Color.WHITE);
        this.bedTypeBox.setBackground(Color.decode("#7FD8BE"));
        panel.add(this.bedTypeBox);
        this.Add = new JButton("Add");
        this.Add.setBounds(64, 321, 111, 33);
        this.Add.setBackground(Color.decode("#00A676"));
        this.Add.setForeground(Color.decode("#FCEFEF"));
        this.Add.addActionListener(this);
        panel.add(this.Add);
        this.Back = new JButton("Back");
        this.Back.setBounds(198, 321, 111, 33);
        this.Back.setBackground(Color.decode("#00A676"));
        this.Back.setForeground(Color.decode("#FCEFEF"));
        this.Back.addActionListener(this);
        panel.add(this.Back);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/roomser.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, 1);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);
        this.setUndecorated(true);
        this.setLocation(20, 200);
        this.setLayout((LayoutManager)null);
        this.setSize(885, 500);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.Add) {
            try {
                Connector c = new Connector();
                String room = this.Room_num.getText();
                String ava = (String)this.availabilityor.getSelectedItem();
                String status = (String)this.cleaningStatusBox.getSelectedItem();
                String price = this.priceText.getText();
                String type = (String)this.bedTypeBox.getSelectedItem();
                String q = "insert into room values('" + room + "','" + ava + "','" + status + "','" + price + "','" + type + "')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog((Component)null, "Room Successfully Added");
                this.setVisible(false);
            } catch (Exception var9) {
                var9.printStackTrace();
            }
        } else {
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Addroom();
    }
}
