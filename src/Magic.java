import java.util.Scanner;

public class Magic {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many magic?: ");
        int n = input.nextInt();

        int [][] m;
        if(n%2 !=0) m=odd(n);

        else
            if(n%4==2) m=singleEven(n);

        else m=doubleEven(n);

        display(m);

        System.out.println("Sum = "+(n*(n*n+1)/2));
    }

    static int [][] odd(int n){
        int [][] m=new int[n][n];
        // initialize m elements to zero

        for(int r=0;r<n;r++)
            for(int c=0;c<n;c++)
                m[r][c]=0;

        int j=n/2;
        int i=0;

        for(int number=1;number<=n*n;number++){
            if(i<0) i=n-1;

            if(j<0) j=n-1;

            if(m[i][j]!=0){
                i+=2;
                j+=1;
            }

            if(i>=n) i=i%n;

            if(j>=n) j=j%n;

            m[i][j]=number;

            i--;
            j--;
        }

        return m;
    }
   static int [][] singleEven(int n){
        int l=n/2;
        int [][] m1=odd(l);
        int [][] m2=new int[l][l];
        int [][] m3=new int[l][l];
        int [][] m4=new int[l][l];

        for(int i=0;i<l;i++)
            for(int j=0;j<l;j++)
            {
                m2[i][j]=m1[i][j]+l*l;
                m3[i][j]=m1[i][j]+2*l*l;
                m4[i][j]=m1[i][j]+3*l*l;
            }
        for(int i=0;i<l/2;i++)
            for(int j=0;j<l/2;j++)
            {
                int hold=m1[i][j];
                m1[i][j]=m4[i][j];
                m4[i][j]=hold;
            }

        for(int i=l/2 +1;i<l/2;i++)
            for(int j=0;j<l/2;j++)
            {
                int hold=m1[i][j];
                m1[i][j]=m4[i][j];
                m4[i][j]=hold;
            }

        int i=l/2;

        for(int j=1;j<=l/2;j++)
            {
                int hold=m1[i][j];
                m1[i][j]=m4[i][j];
                m4[i][j]=hold;
            }

        for(int k=0;k<l;k++)
            for(int j=l-l/2 +1;j<l;j++)
            {
                int hold=m3[k][j];
                m3[k][j]=m2[k][j];
                m2[k][j]=hold;
            }

        int [][] m=merge(m1,m3,m4,m2);
        return m;

    }


   static int [][] doubleEven(int n){

        int [][] m = new int[n][n];
        // fill the matrix from 1 to n^2
       int k=1;
       for(int i=0;i<n;i++)
           for(int j=0;j<n;j++)
           {
               m[i][j]=k;
               k++;
           }

       //fill top left square
       for(int i=0;i<n/4;i++)
           for(int j=0;j<n/4;j++)
               m[i][j]=n*n+1-m[i][j];

       //fill top right square
       for(int i=0;i<n/4;i++)
           for(int j=3*n/4;j<n;j++)
               m[i][j]=n*n+1-m[i][j];

       //fill bottom left square
       for(int i=3*n/4;i<n;i++)
           for(int j=0;j<n/4;j++)
               m[i][j]=n*n+1-m[i][j];

       //fill bottom right square
       for(int i=3*n/4;i<n;i++)
           for(int j=3*n/4;j<n;j++)
               m[i][j]=n*n+1-m[i][j];

       //fill center square
       for(int i=n/4;i<3*n/4;i++)
           for(int j=n/4;j<3*n/4;j++)
               m[i][j]=n*n+1-m[i][j];


           return m;
    }

   static int [][] merge(int m1[][],int m3[][], int m4[][], int m2[][]){
      int n= m1.length;
      int[][] m=new int[2*n][2*n];

      for(int i=0;i<n;i++)
          for(int j=0;j<n;j++)
              m[i][j]=m1[i][j];

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                m[i][j+n]=m3[i][j];

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                m[i+n][j]=m4[i][j];

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                m[i+n][j+n]=m2[i][j];


            return m;
    }

    static void display(int [][] m)
    {
        for(int i=0;i<m.length;i++)
        {
            for(int j=0;j<m.length;j++)
            {
                System.out.print(m[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
