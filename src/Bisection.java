import java.util.*;
public class Bisection {

    public static void main(String[] args) {
        System.out.println("BISECTION ITERATION METHOD");
       Random ran = new Random();
      double a = ran.nextDouble();
      double b = ran.nextDouble();
      while(!(f(a)>0 && f(b)<0)){
          a = ran.nextDouble();
          b = ran.nextDouble();
      }
      double c=(a+b)/2;
      double error = 1;
      double epsilon = 1e-10;
      int iteration = 1;
      while(Math.abs(error)>Math.abs(epsilon))
      {
          System.out.println("a="+a+",b="+b+",c="+c+", f(c)="+f(c));
          if(f(c)>0) a=c;
          if(f(c)<0) b=c;
          double c2 = (a+b)/2;
          error = c-c2;
          c=c2;
          iteration++;
      }

      System.out.println("Number of Iterations = "+iteration);
    }

    public static double f(double x){
        return x*x*x-3*x+1;
    }
}
