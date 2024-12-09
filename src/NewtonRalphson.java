import java.util.Random;

public class NewtonRalphson {

    public static void main(String[] args) {

        System.out.println("NEWTON-RALPHSON ITERATION METHOD");

        Random ran = new Random();
        double x0 = ran.nextDouble();
        System.out.println("x0 = "+x0);
        double error = 1;
        double epsilon = 1e-10;
        int iteration = 0;
        while(Math.abs(error)>Math.abs(epsilon)){
            double x = x0 - f(x0)/df(x0);
            System.out.println("x = "+x);
            error = x-x0;
            x0 = x;
            iteration++;
        }

        System.out.println("Number of Iterations = "+iteration);
    }

    public static double f(double x){
        return x*x*x-3*x+1;
    }

    public static double df(double x){
        return  3*x*x-3;
    }
}
