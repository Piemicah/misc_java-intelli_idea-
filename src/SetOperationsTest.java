import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SetOperationsTest {

    public static void main(String[] args) throws IOException {

        List<String> str = Files.readAllLines(Path.of("6digits-A.txt"));
        List<String> str2 = Files.readAllLines(Path.of("6digits-B.txt"));

        ArrayList<Integer>list1=new ArrayList<Integer>();
        ArrayList<Integer>list2=new ArrayList<Integer>();

        for (String s:str) list1.add(Integer.parseInt(s));
        for(String s:str2) list2.add(Integer.parseInt(s));

        Comparator<Integer> c=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        ArrayList<Integer> union= SetOperations.union(list1,list2,c);

        ArrayList<Integer> intersection = SetOperations.intersection(list1,list2,c);

        ArrayList<Integer> difference= SetOperations.difference(list1,list2,c);

        ArrayList<Integer> symDiff= SetOperations.symDifference(list1,list2,c);


        try {
            PrintWriter pw = null;
            PrintWriter pw2 = null;
            PrintWriter pw3 = null;
            PrintWriter pw4 = null;
            pw = new PrintWriter("union.txt");
            for (Integer i: union)  pw.println(i);

            pw2 = new PrintWriter("intersection.txt");
            for (Integer i: intersection)  pw2.println(i);

            pw3 = new PrintWriter("difference.txt");
            for (Integer i: difference)  pw3.println(i);

            pw4 = new PrintWriter("symDiff.txt");
            for (Integer i: symDiff)  pw4.println(i);
            pw.flush();
            pw.close();

            pw2.flush();
            pw2.close();

            pw3.flush();
            pw3.close();

            pw4.flush();
            pw4.close();

        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
