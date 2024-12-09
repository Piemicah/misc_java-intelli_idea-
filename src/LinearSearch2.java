import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class LinearSearch2
{
    public static void main(String[] args) {


        String fileName = "";
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION)
        {
            fileName = chooser.getSelectedFile().getAbsolutePath().replace("\\","/");

        }
        else return;


        List<String>str = null;
        try {
            str = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] x = new int[str.size()];
        int j=0;

        linearSearch(str);


    }

    public static void linearSearch(List<String> x)
    {
        Scanner input = new Scanner(System.in);
        boolean found = false;
        System.out.print("Enter number to search:  ");
        String n = input.nextLine();
        long startTime,endTime,elapsedTime;
        startTime = System.nanoTime();
        for(String s: x)
        {
            if(n.equals(s)){
                found = true;
                break;
            }
            else found=false;
        }
        endTime = System.nanoTime();
        if(found) System.out.println(n+" found!");
        else System.out.println(n+" not found!");
        elapsedTime = endTime-startTime;
        System.out.println("Elapsed time = "+(float)elapsedTime/1e9+" seconds");
    }
}