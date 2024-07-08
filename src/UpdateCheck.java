import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateCheck extends JFrame {
    UpdateCheck() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setBackground(Color.decode("#E5FCF5"));
        panel.setLayout((LayoutManager)null);
        this.add(panel);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, 1);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);
        JLabel label1 = new JLabel("Check-In Details");
        label1.setBounds(124, 11, 222, 25);
        label1.setFont(new Font("Tahoma", 1, 20));
        label1.setForeground(Color.decode("#7FD8BE"));
        panel.add(label1);
        JLabel label2 = new JLabel("ID :");
        label2.setBounds(25, 88, 46, 14);
        label2.setFont(new Font("Tahoma", 0, 14));
        label2.setForeground(Color.decode("#7FD8BE"));
        panel.add(label2);
        final Choice c = new Choice();
        c.setBounds(248, 85, 140, 20);
        c.setBackground(Color.decode("#7FD8BE"));
        c.setForeground(Color.WHITE);
        panel.add(c);

        try {
            Connector c1 = new Connector();
            ResultSet resultSet = c1.statement.executeQuery("select * from customer");

            while(resultSet.next()) {
                c.add(resultSet.getString("ID_NO"));
            }
        } catch (Exception var22) {
            var22.printStackTrace();
        }

        JLabel roomNo = new JLabel("Room No:");
        roomNo.setBounds(25, 129, 107, 14);
        roomNo.setFont(new Font("Tahoma", 0, 14));
        roomNo.setForeground(Color.decode("#7FD8BE"));
        panel.add(roomNo);
        final JTextField textFieldroom = new JTextField();
        textFieldroom.setBounds(248, 129, 140, 20);
        textFieldroom.setBackground(Color.decode("#7FD8BE"));
        textFieldroom.setForeground(Color.WHITE);
        panel.add(textFieldroom);
        JLabel name = new JLabel("Name:");
        name.setBounds(25, 174, 107, 14);
        name.setFont(new Font("Tahoma", 0, 14));
        name.setForeground(Color.decode("#7FD8BE"));
        panel.add(name);
        final JTextField textFieldname = new JTextField();
        textFieldname.setBounds(248, 174, 140, 20);
        textFieldname.setBackground(Color.decode("#7FD8BE"));
        textFieldname.setForeground(Color.WHITE);
        panel.add(textFieldname);
        JLabel checkedIn = new JLabel("Checked-In:");
        checkedIn.setBounds(25, 216, 107, 14);
        checkedIn.setFont(new Font("Tahoma", 0, 14));
        checkedIn.setForeground(Color.decode("#7FD8BE"));
        panel.add(checkedIn);
        final JTextField textFieldcheck = new JTextField();
        textFieldcheck.setBounds(248, 216, 140, 20);
        textFieldcheck.setBackground(Color.decode("#7FD8BE"));
        textFieldcheck.setForeground(Color.WHITE);
        panel.add(textFieldcheck);
        JLabel AmountPaid = new JLabel("Amount Paid (Rs):");
        AmountPaid.setBounds(25, 261, 150, 14);
        AmountPaid.setFont(new Font("Tahoma", 0, 14));
        AmountPaid.setForeground(Color.decode("#7FD8BE"));
        panel.add(AmountPaid);
        final JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248, 261, 140, 20);
        textFieldAmount.setBackground(Color.decode("#7FD8BE"));
        textFieldAmount.setForeground(Color.WHITE);
        panel.add(textFieldAmount);
        JLabel Pending = new JLabel("Pending Amount:");
        Pending.setBounds(25, 302, 150, 14);
        Pending.setFont(new Font("Tahoma", 0, 14));
        Pending.setForeground(Color.decode("#7FD8BE"));
        panel.add(Pending);
        final JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(248, 302, 140, 20);
        textFieldPending.setBackground(Color.decode("#7FD8BE"));
        textFieldPending.setForeground(Color.WHITE);
        panel.add(textFieldPending);
        JButton update = new JButton("Update");
        update.setBackground(Color.decode("#00A676"));
        update.setBounds(58, 378, 89, 23);
        update.setForeground(Color.decode("#FCEFEF"));
        panel.add(update);
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connector C = new Connector();
                    String q = c.getSelectedItem();
                    String room = textFieldroom.getText();
                    String name = textFieldname.getText();
                    String check = textFieldcheck.getText();
                    String amount = textFieldAmount.getText();
                    C.statement.executeUpdate("update customer set Room_no = '" + room + "', Name = '" + name + "',Check_In_Time = '" + check + "',Deposit = '" + amount + "'where ID_NO = '" + q + "'");
                    JOptionPane.showMessageDialog((Component)null, "Updated Successfully");
                    UpdateCheck.this.setVisible(false);
                } catch (Exception var8) {
                    var8.printStackTrace();
                }

            }
        });
        JButton back = new JButton("Back");
        back.setBackground(Color.decode("#00A676"));
        back.setBounds(168, 378, 89, 23);
        back.setForeground(Color.decode("#FCEFEF"));
        panel.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdateCheck.this.setVisible(false);
            }
        });
        JButton check = new JButton("Check");
        check.setBackground(Color.decode("#00A676"));
        check.setBounds(278, 378, 89, 23);
        check.setForeground(Color.decode("#FCEFEF"));
        panel.add(check);
        check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = c.getSelectedItem();
                String q = "select * from customer where ID_NO = '" + id + "'";

                try {
                    Connector cx = new Connector();
                    ResultSet resultSet = cx.statement.executeQuery(q);

                    while(resultSet.next()) {
                        textFieldroom.setText(resultSet.getString("Room_No"));
                        textFieldname.setText(resultSet.getString("Name"));
                        textFieldcheck.setText(resultSet.getString("Check_In_Time"));
                        textFieldAmount.setText(resultSet.getString("Deposit"));
                    }

                    ResultSet resultSet1 = cx.statement.executeQuery("select * from room where Room_no = '" + textFieldroom.getText() + "'");

                    while(resultSet1.next()) {
                        String price = resultSet1.getString("Price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldAmount.getText());
                        textFieldPending.setText("" + amountPaid);
                    }
                } catch (Exception var9) {
                    var9.printStackTrace();
                }

            }
        });
        this.setUndecorated(true);
        this.setLayout((LayoutManager)null);
        this.setLocation(500, 100);
        this.setSize(950, 500);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateCheck();
    }
}
