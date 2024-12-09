import java.io.*;
import java.util.*;
public class WriteDemo
{
    public static void main(String [] aaa)
    {
        PrintWriter pw =null;
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        try
        {
            pw = new PrintWriter("data/seg.txt");
            for(int i=1;i<=10;i++)
            {
                pw.println(1 + random.nextInt(20));
            }
            //pw.println("Piemicah Instistutes");
            //pw.write("Baba Titi");
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        pw.flush();
        pw.close();
    }
}