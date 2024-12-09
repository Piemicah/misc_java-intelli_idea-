public class GenDemo {

    public static void main(String[] args) {
        GenClass<Double> genD=new GenClass<>(8.5);

        double d= genD.getItem();
        System.out.println(d);
        System.out.println(genD.toString());
    }
}
