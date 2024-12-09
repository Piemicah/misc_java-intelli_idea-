public class Sums {

    public static void algorithm1(int n)
    {
        long sum=0;
        for(int i=0;i<n;i++)
            sum++;
    }

    public  static void algorithm2(int n)
    {
        long sum=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                sum++;
    }

    public  static void algorithm3(int n)
    {
        long sum=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<n*n;j++)
                sum++;
    }

    public  static void algorithm4(int n)
    {
        long sum=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<i;j++)
                sum++;
    }

    public  static void algorithm5(int n)
    {
        long sum=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<i*i;j++)
                for(int k=0;k<j;k++)
                    sum++;
    }

    public  static void algorithm6(int n)
    {
        long sum=0;
        for(int i=1;i<n;i++)
            for(int j=1;j<i*i;j++)
                if(j%i==0)
                    for(int k=0;k<j;k++)
                        sum++;
    }
}
