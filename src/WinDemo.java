import javax.swing.*;
import java.awt.*;

public class WinDemo extends JFrame {

    private JButton b1,b2,b3,b4;
    private JPanel p;

    public WinDemo()
    {

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 8;
        gbc.gridy=0;
        setSize(600,450);
        p=new JPanel(new GridLayout(2,2));
        b1 = new JButton("Button1");
        p.add(b1);

        b2 = new JButton("Button2");
        p.add(b2);

        b3 = new JButton("Button3");
        p.add(b3);

        b4 = new JButton("Button4");
        p.add(b4);

        add(p,gbc);
    }

    public static void main(String[] args) {
        WinDemo win = new WinDemo();
        win.setVisible(true);
    }
}
