import java.math.*;
import java.util.Scanner;

public class PrimeFactor
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
       BigInteger n = BigInteger.valueOf(600851475);
        int prime=0;
//        for( int i=2;i<=n/2;i++){
//            if(isPrime(i)==true && n%i==0) prime=i;
//        }

        System.out.println("Largest Prime = "+prime);
    }

    public static boolean isPrime(int n)
    {
        boolean status=false;
        if(n==2) status=true;
        for(int i=2;i<n;i++){
            if(n%i==0){
                status=false;
                break;
            }
            else status=true;
        }

        return status;
    }
}
