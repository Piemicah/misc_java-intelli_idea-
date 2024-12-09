import java.util.Random;

public class SuccessiveIteration {

    public static void main(String[] args) {

        System.out.println("SUCCESSIVE ITERATION METHOD");

        Random ran = new Random();
        double x0 = ran.nextDouble();
        System.out.println("x0 = "+x0);
        double error = 1;
        double epsilon = 1e-10;
        int iteration = 0;
        while(Math.abs(error)>Math.abs(epsilon)){
            double x = f(x0);
            System.out.println("x = "+x);
            error = x-x0;
            x0 = x;

            iteration++;
        }

        System.out.println("Number of Iterations = "+iteration);
    }

    public static double f(double x){
        return -1/(x*x-3);
    }
}
