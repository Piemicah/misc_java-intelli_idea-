import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowImage  extends JFrame implements ActionListener
{
    private JButton btnShow;
    private JLabel label;
    private JTextField idField;
    private JPanel p,p1;

    public ShowImage()
    {
        setSize(600,450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        btnShow = new JButton("Show");
        btnShow.addActionListener(this);
        label = new JLabel("Photo");
        idField=new JTextField(4);
        p =new JPanel(new FlowLayout());
        p.add(new JLabel("ID"));
        p.add(idField);
        p.add(btnShow);
        p1 = new JPanel();
        p1.add(label);
        add(p1, BorderLayout.CENTER);
        add(p, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int id = Integer.parseInt(idField.getText());
        InputStream input=null;
        byte[] rawImage=null;
        BufferedImage img=null;
        Database db = new Database();
        try {
            ResultSet r = db.select(id);
            while(r.next())
            {
                input =r.getBinaryStream("image");
                img = ImageIO.read(input);

            }
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }

        Icon icon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH));
        label.setIcon(icon);
    }

    public static void main(String[] args) {
        ShowImage showImage = new ShowImage();
        showImage.setVisible(true);
    }
}
