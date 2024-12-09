import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class demo3 {
    public static void main(String[] args) {

        PrintWriter pw = null;

        try {
            pw = new PrintWriter("data/num.txt");
            for(int i=0;i<10000;i++) {
                //System.out.println(genSim());
                pw.println(genSim());
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        pw.flush();
        pw.close();

    }

    public static String genVoucher(int n)
    {
        String st="";
        Random random = new Random();
        for(int i=0;i<n;i++)
        {
            st+= ""+random.nextInt(10);
            //if((i+1)%4==0) st+= " ";
        }

        return st;
    }

    public static String genSim()
    {
        Random random = new Random();
        String st="";
        int digit2 = 7+random.nextInt(3);
        int digit3 = random.nextInt(2);
        st = "0"+""+digit2+""+digit3;
        for(int i=0;i<8;i++)
            st+= ""+random.nextInt(10);
        return st;
    }
}
