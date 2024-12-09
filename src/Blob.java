import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Blob extends JFrame implements ActionListener
{
    JPanel p1,p2,p3,p;
    JButton btnSave,btnLoad, btnUpdate;
    JTextField pathField,idField;
    public Blob()
    {
        init();
    }

    private void init()
    {
        setSize(600,450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        p1=new JPanel();

        btnLoad=new JButton("Load");
        btnUpdate =new JButton("Update");
        btnSave=new JButton("Save");

        btnSave.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnLoad.addActionListener(this);
        pathField =new JTextField(8);
        idField =new JTextField(4);
        p2=new JPanel(new FlowLayout());
        p2.add(new JLabel("Id"));
        p2.add(idField);
        p2.add(new JLabel("load Image"));
        p2.add(pathField);
        p2.add(btnLoad);




        p3 = new JPanel(new FlowLayout());
        p3.add(btnSave);
        p3.add(btnUpdate);
        p = new JPanel(new GridLayout(0,1));

        p.add(p1);
        p.add(p2);
        p.add(p3);
        add(p,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Blob blob=new Blob();
        blob.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnLoad)
        {
            String fileName = "";
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg","png");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION)
            {
                fileName = chooser.getSelectedFile().getAbsolutePath().replace("\\","/");
                pathField.setText(fileName);

            }
            else return;

        }
        else if(e.getSource()== btnUpdate)
        {
            int id= Integer.parseInt(idField.getText());
            String path = pathField.getText();
            Database db = new Database();
            try {
                db.update(id,readImage(path));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        else if(e.getSource()==btnSave)
        {
            int id= Integer.parseInt(idField.getText());
            String path = pathField.getText();
            Database db= new Database();
            try {
                db.insert(id,readImage(path));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        else{}
    }

    private byte[] readImage(String file)
    {
        ByteArrayOutputStream bos = null;
       try
        {
            File f = new File(file);
            BufferedImage bimg = ImageIO.read(f);
            bos = new ByteArrayOutputStream();
            ImageIO.write(bimg,"png",bos);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bos!=null ?bos.toByteArray() : null;
    }

}
