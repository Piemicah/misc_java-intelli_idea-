import java.io.PrintWriter;
import java.math.*;
import java.util.*;
public class TestMultiplication {
    public static void main(String[] args) {

        PrintWriter pw =null;
        Random ran=new Random();

        StopWatch watch = new StopWatch();
        System.out.println("Size,Time(microsec.)");
        try
        {
            pw = new PrintWriter("multi.csv");
            pw.println("Size,Time(microsec.)");
            for(int i=1;i<=20;i++)
            {
                watch.reset();
                BigInteger a=BigInteger.valueOf(1+ran.nextInt(60000));
                BigInteger b=BigInteger.valueOf(1+ran.nextInt(60000));
                watch.start();
                BigInteger c=a.multiply(b);
                watch.stop();
                System.out.println(c+", "+watch.elaspsed()/1e3);
                pw.println(c+", "+watch.elaspsed()/1e3);

            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        pw.flush();
        pw.close();




    }

}
