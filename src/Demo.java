import java.util.Arrays;
public class Demo {
    public static void main(String[] args) {
        int[] x  = {3,8,1,4,9,2};
        System.out.println("Unsorted:");
        display(x);
        System.out.println("sorted:");
        Arrays.sort(x);
        display(x);

    }

    public static void display(int[] x)
    {
        for(int i : x)
            System.out.print(i+"  ");
    }
}
