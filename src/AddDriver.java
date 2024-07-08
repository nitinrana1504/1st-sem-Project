import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener {
    JTextField nameText;
    JTextField ageText;
    JTextField carcText;
    JTextField carnText;
    JTextField locationText;
    JComboBox genderBox;
    JComboBox availableBox;
    JButton add;
    JButton back;

    AddDriver() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 490);
        panel.setBackground(Color.decode("#E5FCF5"));
        panel.setLayout((LayoutManager)null);
        this.add(panel);
        JLabel label = new JLabel("ADD DRIVERS");
        label.setBounds(194, 10, 200, 22);
        label.setForeground(Color.decode("#7FD8BE"));
        label.setFont(new Font("Tahoma", 1, 22));
        panel.add(label);
        JLabel name = new JLabel("NAME");
        name.setBounds(64, 70, 102, 22);
        name.setFont(new Font("Tahoma", 1, 15));
        name.setForeground(Color.decode("#7FD8BE"));
        panel.add(name);
        this.nameText = new JTextField();
        this.nameText.setBounds(174, 70, 156, 20);
        this.nameText.setFont(new Font("Tahoma", 1, 15));
        this.nameText.setForeground(Color.WHITE);
        this.nameText.setBackground(Color.decode("#7FD8BE"));
        panel.add(this.nameText);
        JLabel age = new JLabel("AGE");
        age.setBounds(64, 110, 102, 22);
        age.setFont(new Font("Tahoma", 1, 15));
        age.setForeground(Color.decode("#7FD8BE"));
        panel.add(age);
        this.ageText = new JTextField();
        this.ageText.setBounds(174, 110, 156, 20);
        this.ageText.setFont(new Font("Tahoma", 1, 15));
        this.ageText.setForeground(Color.WHITE);
        this.ageText.setBackground(Color.decode("#7FD8BE"));
        panel.add(this.ageText);
        JLabel gender = new JLabel("GENDER");
        gender.setBounds(64, 150, 102, 22);
        gender.setFont(new Font("Tahoma", 1, 15));
        gender.setForeground(Color.decode("#7FD8BE"));
        panel.add(gender);
        this.genderBox = new JComboBox(new String[]{"Male", "Female"});
        this.genderBox.setBounds(174, 150, 156, 20);
        this.genderBox.setFont(new Font("Tahoma", 1, 15));
        this.genderBox.setForeground(Color.WHITE);
        this.genderBox.setBackground(Color.decode("#7FD8BE"));
        panel.add(this.genderBox);
        JLabel carc = new JLabel("CAR COMPANY");
        carc.setBounds(64, 190, 110, 22);
        carc.setFont(new Font("Tahoma", 1, 14));
        carc.setForeground(Color.decode("#7FD8BE"));
        panel.add(carc);
        this.carcText = new JTextField();
        this.carcText.setBounds(174, 190, 156, 20);
        this.carcText.setFont(new Font("Tahoma", 1, 15));
        this.carcText.setForeground(Color.WHITE);
        this.carcText.setBackground(Color.decode("#7FD8BE"));
        panel.add(this.carcText);
        JLabel carn = new JLabel("CAR NAME");
        carn.setBounds(64, 230, 102, 22);
        carn.setFont(new Font("Tahoma", 1, 15));
        carn.setForeground(Color.decode("#7FD8BE"));
        panel.add(carn);
        this.carnText = new JTextField();
        this.carnText.setBounds(174, 230, 156, 20);
        this.carnText.setFont(new Font("Tahoma", 1, 15));
        this.carnText.setForeground(Color.WHITE);
        this.carnText.setBackground(Color.decode("#7FD8BE"));
        panel.add(this.carnText);
        JLabel available = new JLabel("AVAILABLE");
        available.setBounds(64, 270, 102, 22);
        available.setFont(new Font("Tahoma", 1, 15));
        available.setForeground(Color.decode("#7FD8BE"));
        panel.add(available);
        this.availableBox = new JComboBox(new String[]{"YES", "NO"});
        this.availableBox.setBounds(174, 270, 156, 20);
        this.availableBox.setFont(new Font("Tahoma", 1, 15));
        this.availableBox.setForeground(Color.WHITE);
        this.availableBox.setBackground(Color.decode("#7FD8BE"));
        panel.add(this.availableBox);
        JLabel location = new JLabel("LOCATION");
        location.setBounds(64, 310, 102, 22);
        location.setFont(new Font("Tahoma", 1, 15));
        location.setForeground(Color.decode("#7FD8BE"));
        panel.add(location);
        this.locationText = new JTextField();
        this.locationText.setBounds(174, 310, 156, 20);
        this.locationText.setFont(new Font("Tahoma", 1, 15));
        this.locationText.setForeground(Color.WHITE);
        this.locationText.setBackground(Color.decode("#7FD8BE"));
        panel.add(this.locationText);
        this.add = new JButton("ADD");
        this.add.setBackground(Color.decode("#00A676"));
        this.add.setBounds(64, 380, 111, 33);
        this.add.setForeground(Color.decode("#FCEFEF"));
        this.add.addActionListener(this);
        panel.add(this.add);
        this.back = new JButton("BACK");
        this.back.setBackground(Color.decode("#00A676"));
        this.back.setBounds(198, 380, 111, 33);
        this.back.setForeground(Color.decode("#FCEFEF"));
        this.back.addActionListener(this);
        panel.add(this.back);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/license.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, 1);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label1 = new JLabel(imageIcon1);
        label1.setBounds(500, 60, 300, 300);
        panel.add(label1);
        this.setUndecorated(true);
        this.setLocation(20, 200);
        this.setLayout((LayoutManager)null);
        this.setSize(900, 500);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.add) {
            try {
                Connector c = new Connector();
                String name = this.nameText.getText();
                String age = this.ageText.getText();
                String gender = (String)this.genderBox.getSelectedItem();
                String company = this.carcText.getText();
                String carname = this.carnText.getText();
                String available = (String)this.availableBox.getSelectedItem();
                String location = this.locationText.getText();
                String q = "insert into driver values('" + name + "','" + age + "','" + gender + "','" + company + "','" + carname + "','" + available + "','" + location + "')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog((Component)null, "Driver Successfully Added");
                this.setVisible(false);
            } catch (Exception var11) {
                var11.printStackTrace();
            }
        } else {
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AddDriver();
    }
}
