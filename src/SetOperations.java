import java.util.*;

public class SetOperations {

    public static <T> ArrayList<T> union(ArrayList<T> list1, ArrayList<T> list2, Comparator<T> c){
        Set<T> set = new HashSet<T>();
        set.addAll(list1);
        set.addAll(list2);
        return new ArrayList<T>(set);
    }

    public static <T> ArrayList<T> intersection(ArrayList<T> list1, ArrayList<T> list2, Comparator<T> c){
        Set<T> set = new HashSet<T>();
        for(T list1_element: list1){
            for(T list2_element: list2){
                if(c.compare(list1_element,list2_element)==0) set.add(list1_element);
            }
        }

        return new ArrayList<T>(set);
    }

    public static <T> ArrayList<T> difference(ArrayList<T> list1, ArrayList<T> list2, Comparator<T> c){
        Set<T> set = new HashSet<T>();
        boolean found=false;
        for(T list1_element: list1){
            for(T list2_element: list2){
                if(c.compare(list1_element,list2_element)==0){
                    found=true;
                    break;
                }
                else found=false;
            }

            if(!found) set.add(list1_element);
        }

        return new ArrayList<T>(set);
    }

    public static <T> ArrayList<T> symDifference(ArrayList<T> list1, ArrayList<T> list2, Comparator<T> c){
        Set<T> set = new HashSet<T>();
        set.addAll(list1);
        set.addAll(list2);
        boolean found=false;
        for(T list1_element: list1){
            for(T list2_element: list2){
                if(c.compare(list1_element,list2_element)==0){
                    found=true;
                    break;
                }
                else found=false;
            }

            if(found) set.remove(list1_element);
        }

        return new ArrayList<T>(set);
    }
}
