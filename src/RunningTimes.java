import java.io.PrintWriter;

public class RunningTimes {

    public static void main(String[] args) {


        StopWatch watch=new StopWatch();

        int n_min=0;
        int n_max=500;

        //Algorithm1

        try {
            PrintWriter pw1 = null;
            pw1 = new PrintWriter("algorithm1.csv");
            pw1.println("N,Time(ms.)");
            for (int n = n_min; n < n_max; n += 10) {
                watch.start();
                Sums.algorithm1(n);
                watch.stop();
                pw1.println(n + ", " + watch.elaspsed() / 1e6);
                watch.reset();
            }

            pw1.flush();
            pw1.close();

        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }


            //Algorithm2


        try {
            PrintWriter pw2 = null;
            pw2 = new PrintWriter("algorithm2.csv");
            pw2.println("N,Time(ms.)");
            for (int n = n_min; n < n_max; n += 10) {
                watch.start();
                Sums.algorithm2(n);
                watch.stop();
                pw2.println(n + ", " + watch.elaspsed() / 1e6);
                watch.reset();
            }
            pw2.flush();
            pw2.close();

        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }


        //Algorithm3

        try {
            PrintWriter pw3 = null;
            pw3 = new PrintWriter("algorithm3.csv");
            pw3.println("N,Time(ms.)");
            for (int n = n_min; n < n_max; n += 10) {
                watch.start();
                Sums.algorithm3(n);
                watch.stop();
                pw3.println(n + ", " + watch.elaspsed() / 1e6);
                watch.reset();
            }

            pw3.flush();
            pw3.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }


        //Algorithm4

        try {
            PrintWriter pw4 = null;
            pw4 = new PrintWriter("algorithm4.csv");
            pw4.println("N,Time(ms.)");
            for (int n = n_min; n < n_max; n += 10) {
                watch.start();
                Sums.algorithm4(n);
                watch.stop();
                pw4.println(n + ", " + watch.elaspsed() / 1e6);
                watch.reset();
            }

            pw4.flush();
            pw4.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }


        //Algorithm5

        try {
            PrintWriter pw5 = null;
            pw5 = new PrintWriter("algorithm5.csv");
            pw5.println("N,Time(ms.)");
            for (int n = 0; n < 100; n += 2) {
                watch.start();
                Sums.algorithm5(n);
                watch.stop();
                pw5.println(n + ", " + watch.elaspsed() / 1e6);
                watch.reset();
            }

            pw5.flush();
            pw5.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }


        //Algorithm6

        try {
            PrintWriter pw6 = null;
            pw6 = new PrintWriter("algorithm6.csv");
            pw6.println("N,Time(ms.)");
            for (int n = n_min; n < n_max; n += 10) {
                watch.start();
                Sums.algorithm6(n);
                watch.stop();
                pw6.println(n + ", " + watch.elaspsed() / 1e6);
                watch.reset();
            }

            pw6.flush();
            pw6.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }



    }
}
