public class Demo4 {

    public static void main(String[] args) {
      int  x[][]={{1,2,3},{4,5,6},{7,8,9}};
      System.out.println(x.length);

      int [][] m= new int[4][4];
        int k=1;
        for(int i=0;i<4;i++)
        for(int j=0;j<4;j++)
        {

            m[i][j]=k;
            k++;
        }

        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                System.out.print(m[i][j]+"\t");
            }
            System.out.println();
        }

    }
}
