import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
class ReadDemo
{
    public static void main(String [] aaa) throws IOException {
        Scanner input = null;

        List<String> str = Files.readAllLines(Path.of("data/seg.txt"));

      int n = str.size();
      int[] x = new int[n];
      int j=0;
        for (String s:str)
        {
          x[j++] = Integer.parseInt(s);
        }
    System.out.println(str);
        System.out.println("x="+x[3]);
    }
}