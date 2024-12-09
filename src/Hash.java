import java.util.HashMap;

public class Hash {
    public static void main(String[] args) {
        HashMap<String,String> hash = new HashMap<>();
        hash.put("sss","Segun");
        hash.put("as","Arsenal");

        System.out.println(hash.get("as"));
    }
}
