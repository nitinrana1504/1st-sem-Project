import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class NewCustomer extends JFrame implements ActionListener {
    JTextField textFieldNum;
    JTextField textFieldName;
    JTextField textFieldCountry;
    JTextField textFieldDeposit;
    JRadioButton ButtonMale;
    JRadioButton ButtonFemale;
    JComboBox IdBox;
    Choice c1;
    JLabel time;
    JButton add;
    JButton back;

    NewCustomer() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setLayout((LayoutManager)null);
        panel.setBackground(Color.decode("#E5FCF5"));
        this.add(panel);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, 1);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550, 150, 200, 200);
        panel.add(label);
        JLabel labelname = new JLabel("NEW CUSTOMER FORM");
        labelname.setBounds(118, 11, 260, 53);
        labelname.setFont(new Font("Tahoma", 1, 20));
        labelname.setForeground(Color.decode("#7FD8BE"));
        panel.add(labelname);
        JLabel labelID = new JLabel("ID:");
        labelID.setBounds(35, 76, 200, 14);
        labelID.setFont(new Font("Tahoma", 1, 14));
        labelID.setForeground(Color.decode("#7FD8BE"));
        panel.add(labelID);
        this.IdBox = new JComboBox(new String[]{"Passport", "Aadhar Card", "Voter ID", "Driving License"});
        this.IdBox.setBounds(271, 73, 150, 23);
        this.IdBox.setFont(new Font("Tahoma", 0, 14));
        this.IdBox.setBackground(Color.decode("#7FD8BE"));
        this.IdBox.setForeground(Color.WHITE);
        panel.add(this.IdBox);
        JLabel number = new JLabel("ID Number:");
        number.setBounds(35, 111, 200, 14);
        number.setFont(new Font("Tahoma", 1, 14));
        number.setForeground(Color.decode("#7FD8BE"));
        panel.add(number);
        this.textFieldNum = new JTextField();
        this.textFieldNum.setBounds(271, 111, 150, 20);
        this.textFieldNum.setFont(new Font("Tahoma", 0, 14));
        this.textFieldNum.setForeground(Color.WHITE);
        this.textFieldNum.setBackground(Color.decode("#7FD8BE"));
        panel.add(this.textFieldNum);
        JLabel name = new JLabel("NAME:");
        name.setBounds(35, 151, 200, 14);
        name.setFont(new Font("Tahoma", 1, 14));
        name.setForeground(Color.decode("#7FD8BE"));
        panel.add(name);
        this.textFieldName = new JTextField();
        this.textFieldName.setBounds(271, 151, 150, 22);
        this.textFieldName.setFont(new Font("Tahoma", 0, 14));
        this.textFieldName.setForeground(Color.WHITE);
        this.textFieldName.setBackground(Color.decode("#7FD8BE"));
        panel.add(this.textFieldName);
        JLabel gender = new JLabel("GENDER:");
        gender.setBounds(35, 191, 200, 22);
        gender.setFont(new Font("Tahoma", 1, 14));
        gender.setForeground(Color.decode("#7FD8BE"));
        panel.add(gender);
        this.ButtonMale = new JRadioButton("MALE");
        this.ButtonMale.setBounds(271, 191, 80, 22);
        this.ButtonMale.setFont(new Font("Tahoma", 0, 14));
        this.ButtonMale.setForeground(Color.WHITE);
        this.ButtonMale.setBackground(Color.decode("#7FD8BE"));
        panel.add(this.ButtonMale);
        this.ButtonFemale = new JRadioButton("FEMALE");
        this.ButtonFemale.setBounds(350, 191, 80, 22);
        this.ButtonFemale.setFont(new Font("Tahoma", 0, 14));
        this.ButtonFemale.setForeground(Color.WHITE);
        this.ButtonFemale.setBackground(Color.decode("#7FD8BE"));
        panel.add(this.ButtonFemale);
        JLabel country = new JLabel("COUNTRY:");
        country.setBounds(35, 231, 200, 14);
        country.setFont(new Font("Tahoma", 1, 14));
        country.setForeground(Color.decode("#7FD8BE"));
        panel.add(country);
        this.textFieldCountry = new JTextField();
        this.textFieldCountry.setBounds(271, 231, 150, 22);
        this.textFieldCountry.setFont(new Font("Tahoma", 0, 14));
        this.textFieldCountry.setForeground(Color.WHITE);
        this.textFieldCountry.setBackground(Color.decode("#7FD8BE"));
        panel.add(this.textFieldCountry);
        JLabel labelroom = new JLabel("Allocated Room Number:");
        labelroom.setBounds(35, 274, 200, 14);
        labelroom.setFont(new Font("Tahoma", 1, 14));
        labelroom.setForeground(Color.decode("#7FD8BE"));
        panel.add(labelroom);
        this.c1 = new Choice();

        try {
            Connector c = new Connector();
            ResultSet resultSet = c.statement.executeQuery("select * from room where Availability = 'Available'");

            while(resultSet.next()) {
                this.c1.add(resultSet.getString("Room_no"));
            }
        } catch (Exception var16) {
            var16.printStackTrace();
        }

        this.c1.setBounds(271, 274, 150, 20);
        this.c1.setFont(new Font("Tahoma", 1, 14));
        this.c1.setForeground(Color.WHITE);
        this.c1.setBackground(Color.decode("#7FD8BE"));
        panel.add(this.c1);
        JLabel Check_in_time = new JLabel("Checked In:");
        Check_in_time.setBounds(35, 316, 200, 14);
        Check_in_time.setFont(new Font("Tahoma", 1, 14));
        Check_in_time.setForeground(Color.decode("#7FD8BE"));
        panel.add(Check_in_time);
        Date date = new Date();
        this.time = new JLabel("" + String.valueOf(date));
        this.time.setBounds(271, 316, 200, 14);
        this.time.setFont(new Font("Tahoma", 0, 14));
        this.time.setForeground(Color.decode("#7FD8BE"));
        panel.add(this.time);
        JLabel deposit = new JLabel("Deposit:");
        deposit.setBounds(35, 359, 200, 14);
        deposit.setFont(new Font("Tahoma", 1, 14));
        deposit.setForeground(Color.decode("#7FD8BE"));
        panel.add(deposit);
        this.textFieldDeposit = new JTextField();
        this.textFieldDeposit.setBounds(271, 359, 150, 22);
        this.textFieldDeposit.setFont(new Font("Tahoma", 0, 14));
        this.textFieldDeposit.setForeground(Color.WHITE);
        this.textFieldDeposit.setBackground(Color.decode("#7FD8BE"));
        panel.add(this.textFieldDeposit);
        this.add = new JButton("ADD");
        this.add.setBounds(100, 430, 120, 30);
        this.add.setBackground(Color.decode("#00A676"));
        this.add.setForeground(Color.decode("#FCEFEF"));
        this.add.addActionListener(this);
        panel.add(this.add);
        this.back = new JButton("BACK");
        this.back.setBounds(300, 430, 120, 30);
        this.back.setBackground(Color.decode("#00A676"));
        this.back.setForeground(Color.decode("#FCEFEF"));
        this.back.addActionListener(this);
        panel.add(this.back);
        this.setUndecorated(true);
        this.setLayout((LayoutManager)null);
        this.setLocation(500, 150);
        this.setSize(850, 550);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.add) {
            String doc = (String)this.IdBox.getSelectedItem();
            String number = this.textFieldNum.getText();
            String name = this.textFieldName.getText();
            String gender = null;
            if (this.ButtonMale.isSelected()) {
                gender = "Male";
            } else if (this.ButtonFemale.isSelected()) {
                gender = "Female";
            }

            String country = this.textFieldCountry.getText();
            String room = this.c1.getSelectedItem();
            String date = this.time.getText();
            String deposit = this.textFieldDeposit.getText();

            try {
                Connector c = new Connector();
                String q = "insert into customer values('" + doc + "','" + number + "','" + name + "','" + gender + "','" + country + "','" + room + "','" + date + "','" + deposit + "')";
                String q1 = "update room set Availability = 'Occupied' where Room_no =" + room;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog((Component)null, "Added Successfully");
                this.setVisible(false);
            } catch (Exception var13) {
                var13.printStackTrace();
            }
        } else {
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
