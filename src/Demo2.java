import java.util.*;
public class Demo2 {

    public static void main(String[] args) {

        ArrayList<Integer> items = new ArrayList<>();

        int[] x = {5,3,6,9,2};
        for(int i : x)  items.add(i);
        for(int n: items) System.out.printf("%d  ",n);
    }

}
