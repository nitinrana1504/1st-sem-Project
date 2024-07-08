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
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField nameText;
    JTextField ageText;
    JTextField salaryText;
    JTextField phoneText;
    JTextField aadharText;
    JTextField emailText;
    JRadioButton radioButtonM;
    JRadioButton radioButtonF;
    JComboBox comboBox;
    JButton add;
    JButton back;

    AddEmployee() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 490);
        panel.setLayout((LayoutManager)null);
        panel.setBackground(Color.decode("#E5FCF5"));
        this.add(panel);
        JLabel AED = new JLabel("ADD EMPLOYEE DETAILS");
        AED.setBounds(450, 24, 445, 35);
        AED.setFont(new Font("Tahoma", 1, 30));
        AED.setForeground(Color.decode("#7FD8BE"));
        panel.add(AED);
        JLabel name = new JLabel("NAME");
        name.setBounds(60, 30, 150, 27);
        name.setFont(new Font("serif", 1, 15));
        name.setForeground(Color.decode("#7FD8BE"));
        panel.add(name);
        this.nameText = new JTextField();
        this.nameText.setBounds(200, 30, 150, 27);
        this.nameText.setBackground(Color.decode("#7FD8BE"));
        this.nameText.setFont(new Font("Tahoma", 1, 15));
        this.nameText.setForeground(Color.white);
        panel.add(this.nameText);
        JLabel age = new JLabel("AGE");
        age.setBounds(60, 80, 150, 27);
        age.setFont(new Font("serif", 1, 15));
        age.setForeground(Color.decode("#7FD8BE"));
        panel.add(age);
        this.ageText = new JTextField();
        this.ageText.setBounds(200, 80, 150, 27);
        this.ageText.setBackground(Color.decode("#7FD8BE"));
        this.ageText.setFont(new Font("Tahoma", 1, 15));
        this.ageText.setForeground(Color.WHITE);
        panel.add(this.ageText);
        JLabel gender = new JLabel("GENDER");
        gender.setBounds(60, 120, 150, 27);
        gender.setFont(new Font("serif", 1, 15));
        gender.setForeground(Color.decode("#7FD8BE"));
        panel.add(gender);
        this.radioButtonM = new JRadioButton("MALE");
        this.radioButtonM.setBounds(200, 120, 70, 27);
        this.radioButtonM.setBackground(Color.decode("#7FD8BE"));
        this.radioButtonM.setFont(new Font("Tahoma", 1, 15));
        this.radioButtonM.setForeground(Color.WHITE);
        panel.add(this.radioButtonM);
        this.radioButtonF = new JRadioButton("FEMALE");
        this.radioButtonF.setBounds(280, 120, 100, 27);
        this.radioButtonF.setBackground(Color.decode("#7FD8BE"));
        this.radioButtonF.setFont(new Font("Tahoma", 1, 15));
        this.radioButtonF.setForeground(Color.WHITE);
        panel.add(this.radioButtonF);
        JLabel job = new JLabel("JOB");
        job.setBounds(60, 170, 150, 27);
        job.setFont(new Font("serif", 1, 15));
        job.setForeground(Color.decode("#7FD8BE"));
        panel.add(job);
        this.comboBox = new JComboBox(new String[]{"Front Desk", "Housekeeping", "Kitchen Steff", "Room Service", "Manager", "Accountant", "Chef"});
        this.comboBox.setBackground(Color.decode("#7FD8BE"));
        this.comboBox.setBounds(200, 170, 150, 30);
        this.comboBox.setFont(new Font("Tahoma", 1, 15));
        this.comboBox.setForeground(Color.WHITE);
        panel.add(this.comboBox);
        JLabel salary = new JLabel("SALARY");
        salary.setBounds(60, 220, 150, 27);
        salary.setFont(new Font("serif", 1, 15));
        salary.setForeground(Color.decode("#7FD8BE"));
        panel.add(salary);
        this.salaryText = new JTextField();
        this.salaryText.setBounds(200, 220, 150, 27);
        this.salaryText.setBackground(Color.decode("#7FD8BE"));
        this.salaryText.setFont(new Font("Tahoma", 1, 15));
        this.salaryText.setForeground(Color.WHITE);
        panel.add(this.salaryText);
        JLabel phone = new JLabel("PHONE");
        phone.setBounds(60, 270, 150, 27);
        phone.setFont(new Font("serif", 1, 15));
        phone.setForeground(Color.decode("#7FD8BE"));
        panel.add(phone);
        this.phoneText = new JTextField();
        this.phoneText.setBounds(200, 270, 150, 27);
        this.phoneText.setBackground(Color.decode("#7FD8BE"));
        this.phoneText.setFont(new Font("Tahoma", 1, 15));
        this.phoneText.setForeground(Color.WHITE);
        panel.add(this.phoneText);
        JLabel aadhar = new JLabel("AADHAR");
        aadhar.setBounds(60, 320, 150, 27);
        aadhar.setFont(new Font("serif", 1, 15));
        aadhar.setForeground(Color.decode("#7FD8BE"));
        panel.add(aadhar);
        this.aadharText = new JTextField();
        this.aadharText.setBounds(200, 320, 150, 27);
        this.aadharText.setBackground(Color.decode("#7FD8BE"));
        this.aadharText.setFont(new Font("Tahoma", 1, 15));
        this.aadharText.setForeground(Color.WHITE);
        panel.add(this.aadharText);
        JLabel email = new JLabel("EMAIL");
        email.setBounds(60, 370, 150, 27);
        email.setFont(new Font("serif", 1, 15));
        email.setForeground(Color.decode("#7FD8BE"));
        panel.add(email);
        this.emailText = new JTextField();
        this.emailText.setBounds(200, 370, 150, 27);
        this.emailText.setBackground(Color.decode("#7FD8BE"));
        this.emailText.setFont(new Font("Tahoma", 1, 15));
        this.emailText.setForeground(Color.WHITE);
        panel.add(this.emailText);
        this.add = new JButton("ADD");
        this.add.setBounds(80, 420, 100, 30);
        this.add.setBackground(Color.decode("#00A676"));
        this.add.setForeground(Color.decode("#FCEFEF"));
        this.add.addActionListener(this);
        panel.add(this.add);
        this.back = new JButton("BACK");
        this.back.setBounds(200, 420, 100, 30);
        this.back.setBackground(Color.decode("#00A676"));
        this.back.setForeground(Color.decode("#FCEFEF"));
        this.back.addActionListener(this);
        panel.add(this.back);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/addemp.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, 1);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 100, 300, 300);
        panel.add(label);
        this.setUndecorated(true);
        this.setLocation(60, 160);
        this.setLayout((LayoutManager)null);
        this.setSize(900, 500);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.add) {
            String name = this.nameText.getText();
            String age = this.ageText.getText();
            String salary = this.salaryText.getText();
            String phone = this.phoneText.getText();
            String email = this.emailText.getText();
            String aadhar = this.aadharText.getText();
            String job = (String)this.comboBox.getSelectedItem();
            String gender = null;
            if (this.radioButtonM.isSelected()) {
                gender = "Male";
            } else if (this.radioButtonF.isSelected()) {
                gender = "Female";
            }

            try {
                Connector c = new Connector();
                String q = "insert into employee values('" + name + "','" + age + "','" + gender + "','" + job + "','" + salary + "','" + phone + "','" + email + "','" + aadhar + "')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog((Component)null, "Employee Added");
                this.setVisible(false);
            } catch (Exception var12) {
                var12.printStackTrace();
            }
        } else {
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
