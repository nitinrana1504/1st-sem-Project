import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame {
    UpdateRoom() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 440);
        panel.setBackground(Color.decode("#E5FCF5"));
        panel.setLayout((LayoutManager)null);
        this.add(panel);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, 1);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);
        JLabel label1 = new JLabel("Update Room Status");
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
        } catch (Exception var18) {
            var18.printStackTrace();
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
        JLabel Availability = new JLabel("Availability:");
        Availability.setBounds(25, 174, 107, 14);
        Availability.setFont(new Font("Tahoma", 0, 14));
        Availability.setForeground(Color.decode("#7FD8BE"));
        panel.add(Availability);
        final JTextField textFieldAvailability = new JTextField();
        textFieldAvailability.setBounds(248, 174, 140, 20);
        textFieldAvailability.setBackground(Color.decode("#7FD8BE"));
        textFieldAvailability.setForeground(Color.WHITE);
        panel.add(textFieldAvailability);
        JLabel Status = new JLabel("Clean Status:");
        Status.setBounds(25, 216, 107, 14);
        Status.setFont(new Font("Tahoma", 0, 14));
        Status.setForeground(Color.decode("#7FD8BE"));
        panel.add(Status);
        final JTextField textFieldStatus = new JTextField();
        textFieldStatus.setBounds(248, 216, 140, 20);
        textFieldStatus.setBackground(Color.decode("#7FD8BE"));
        textFieldStatus.setForeground(Color.WHITE);
        panel.add(textFieldStatus);
        JButton update = new JButton("Update");
        update.setBackground(Color.decode("#00A676"));
        update.setBounds(120, 315, 89, 23);
        update.setForeground(Color.decode("#FCEFEF"));
        panel.add(update);
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connector C = new Connector();
                    String status = textFieldStatus.getText();
                    C.statement.executeUpdate("update room set Cleaning_status = '" + status + "' where Room_no  = '" + textFieldroom.getText() + "'");
                    JOptionPane.showMessageDialog((Component)null, "Updated Successfully");
                    UpdateRoom.this.setVisible(false);
                } catch (Exception var4) {
                    var4.printStackTrace();
                }

            }
        });
        JButton back = new JButton("Back");
        back.setBackground(Color.decode("#00A676"));
        back.setBounds(180, 355, 89, 23);
        back.setForeground(Color.decode("#FCEFEF"));
        panel.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdateRoom.this.setVisible(false);
            }
        });
        JButton check = new JButton("Check");
        check.setBackground(Color.decode("#00A676"));
        check.setBounds(60, 355, 89, 23);
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
                    }

                    ResultSet resultSet1 = cx.statement.executeQuery("select * from room where Room_no = '" + textFieldroom.getText() + "'");

                    while(resultSet1.next()) {
                        textFieldAvailability.setText(resultSet1.getString("Availability"));
                        textFieldStatus.setText(resultSet1.getString("Cleaning_status"));
                    }
                } catch (Exception var7) {
                    var7.printStackTrace();
                }

            }
        });
        this.setUndecorated(true);
        this.setLayout((LayoutManager)null);
        this.setLocation(500, 100);
        this.setSize(950, 450);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateRoom();
    }
}

