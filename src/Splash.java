import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Splash extends JFrame {
    Splash() {
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/splash1.gif"));
        JLabel lable = new JLabel(imageIcon);
        lable.setBounds(0, 0, 1152, 648);
        this.add(lable);
        this.setLayout((LayoutManager)null);
        this.setLocation(300, 80);
        this.setSize(1152, 648);
        this.setVisible(true);

        try {
            Thread.sleep(5000L);
            new Login();
            this.setVisible(false);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Splash();
    }
}
