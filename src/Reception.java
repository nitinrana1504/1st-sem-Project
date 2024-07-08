import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {
    JButton New_Customer_Form;
    JButton Room;
    JButton Department;
    JButton All_Employee_Info;
    JButton Customer_Info;
    JButton Manager_Info;
    JButton Check_Out;
    JButton Update_Check_In_Details;
    JButton Update_Room_Status;
    JButton Pick_up_Service;
    JButton Search_Room;
    JButton back;

    Reception() {
        JPanel panel1 = new JPanel();
        panel1.setLayout((LayoutManager)null);
        panel1.setBounds(280, 5, 1238, 820);
        panel1.setBackground(Color.decode("#E5FCF5"));
        this.add(panel1);
        ImageIcon p1 = new ImageIcon(ClassLoader.getSystemResource("icon/cccc.gif"));
        Image i11 = p1.getImage().getScaledInstance(800, 800, 1);
        ImageIcon imageIconi1 = new ImageIcon(i11);
        JLabel label1 = new JLabel(imageIconi1);
        label1.setBounds(300, 20, 800, 800);
        panel1.add(label1);
        JPanel panel2 = new JPanel();
        panel2.setLayout((LayoutManager)null);
        panel2.setBounds(5, 5, 270, 820);
        panel2.setBackground(Color.decode("#E5FCF5"));
        this.add(panel2);
        ImageIcon p2 = new ImageIcon(ClassLoader.getSystemResource("icon/Logo.gif"));
        Image i21 = p2.getImage().getScaledInstance(250, 250, 1);
        ImageIcon imageIcon2 = new ImageIcon(i21);
        JLabel label2 = new JLabel(imageIcon2);
        label2.setBounds(5, 530, 250, 250);
        panel2.add(label2);
        this.New_Customer_Form = new JButton("NEW CUSTOMER FORM");
        this.New_Customer_Form.setBounds(30, 30, 200, 30);
        this.New_Customer_Form.setBackground(Color.decode("#00A676"));
        this.New_Customer_Form.setForeground(Color.decode("#FCEFEF"));
        this.New_Customer_Form.addActionListener(this);
        panel2.add(this.New_Customer_Form);
        this.Room = new JButton("ROOM");
        this.Room.setBounds(30, 70, 200, 30);
        this.Room.setBackground(Color.decode("#00A676"));
        this.Room.setForeground(Color.decode("#FCEFEF"));
        this.Room.addActionListener(this);
        panel2.add(this.Room);
        this.Department = new JButton("DEPARTMENT");
        this.Department.setBounds(30, 110, 200, 30);
        this.Department.setBackground(Color.decode("#00A676"));
        this.Department.setForeground(Color.decode("#FCEFEF"));
        this.Department.addActionListener(this);
        panel2.add(this.Department);
        this.All_Employee_Info = new JButton("ALL EMPLOYEE INFO");
        this.All_Employee_Info.setBounds(30, 150, 200, 30);
        this.All_Employee_Info.setBackground(Color.decode("#00A676"));
        this.All_Employee_Info.setForeground(Color.decode("#FCEFEF"));
        this.All_Employee_Info.addActionListener(this);
        panel2.add(this.All_Employee_Info);
        this.Customer_Info = new JButton("CUSTOMER INFO");
        this.Customer_Info.setBounds(30, 190, 200, 30);
        this.Customer_Info.setBackground(Color.decode("#00A676"));
        this.Customer_Info.setForeground(Color.decode("#FCEFEF"));
        this.Customer_Info.addActionListener(this);
        panel2.add(this.Customer_Info);
        this.Manager_Info = new JButton("MANAGER INFO");
        this.Manager_Info.setBounds(30, 230, 200, 30);
        this.Manager_Info.setBackground(Color.decode("#00A676"));
        this.Manager_Info.setForeground(Color.decode("#FCEFEF"));
        this.Manager_Info.addActionListener(this);
        panel2.add(this.Manager_Info);
        this.Check_Out = new JButton("CHECK OUT");
        this.Check_Out.setBounds(30, 270, 200, 30);
        this.Check_Out.setBackground(Color.decode("#00A676"));
        this.Check_Out.setForeground(Color.decode("#FCEFEF"));
        this.Check_Out.addActionListener(this);
        panel2.add(this.Check_Out);
        this.Update_Check_In_Details = new JButton("UPDATE CHECK IN DETAILS");
        this.Update_Check_In_Details.setBounds(30, 310, 200, 30);
        this.Update_Check_In_Details.setBackground(Color.decode("#00A676"));
        this.Update_Check_In_Details.setForeground(Color.decode("#FCEFEF"));
        this.Update_Check_In_Details.addActionListener(this);
        panel2.add(this.Update_Check_In_Details);
        this.Update_Room_Status = new JButton("UPDATE ROOM STATUS");
        this.Update_Room_Status.setBounds(30, 350, 200, 30);
        this.Update_Room_Status.setBackground(Color.decode("#00A676"));
        this.Update_Room_Status.setForeground(Color.decode("#FCEFEF"));
        this.Update_Room_Status.addActionListener(this);
        panel2.add(this.Update_Room_Status);
        this.Pick_up_Service = new JButton("PICK UP SERVICE");
        this.Pick_up_Service.setBounds(30, 390, 200, 30);
        this.Pick_up_Service.setBackground(Color.decode("#00A676"));
        this.Pick_up_Service.setForeground(Color.decode("#FCEFEF"));
        this.Pick_up_Service.addActionListener(this);
        panel2.add(this.Pick_up_Service);
        this.Search_Room = new JButton("SEARCH ROOM");
        this.Search_Room.setBounds(30, 430, 200, 30);
        this.Search_Room.setBackground(Color.decode("#00A676"));
        this.Search_Room.setForeground(Color.decode("#FCEFEF"));
        this.Search_Room.addActionListener(this);
        panel2.add(this.Search_Room);
        this.back = new JButton("Back");
        this.back.setBounds(30, 470, 200, 30);
        this.back.setBackground(Color.decode("#00A676"));
        this.back.setForeground(Color.decode("#FCEFEF"));
        this.back.addActionListener(this);
        panel2.add(this.back);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout((LayoutManager)null);
        this.setSize(1950, 1090);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.New_Customer_Form) {
            try {
                new NewCustomer();
            } catch (Exception var13) {
                var13.printStackTrace();
            }
        } else if (e.getSource() == this.Room) {
            try {
                new Room();
            } catch (Exception var12) {
                var12.printStackTrace();
            }
        } else if (e.getSource() == this.Department) {
            try {
                new Department();
            } catch (Exception var11) {
                var11.printStackTrace();
            }
        } else if (e.getSource() == this.All_Employee_Info) {
            try {
                new Employee();
            } catch (Exception var10) {
                var10.printStackTrace();
            }
        } else if (e.getSource() == this.Customer_Info) {
            try {
                new CustomerInfo();
            } catch (Exception var9) {
                var9.printStackTrace();
            }
        } else if (e.getSource() == this.Manager_Info) {
            try {
                new ManagerInfo();
            } catch (Exception var8) {
                var8.printStackTrace();
            }
        } else if (e.getSource() == this.Check_Out) {
            try {
                new CheckOut();
            } catch (Exception var7) {
                var7.printStackTrace();
            }
        } else if (e.getSource() == this.Update_Check_In_Details) {
            try {
                new UpdateCheck();
            } catch (Exception var6) {
                var6.printStackTrace();
            }
        } else if (e.getSource() == this.Update_Room_Status) {
            try {
                new UpdateRoom();
            } catch (Exception var5) {
                var5.printStackTrace();
            }
        } else if (e.getSource() == this.Pick_up_Service) {
            try {
                new PickUp();
            } catch (Exception var4) {
                var4.printStackTrace();
            }
        } else if (e.getSource() == this.Search_Room) {
            try {
                new SearchRoom();
            } catch (Exception var3) {
                var3.printStackTrace();
            }
        } else if (e.getSource() == this.back) {
            new Dashboard();
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Reception();
    }
}
