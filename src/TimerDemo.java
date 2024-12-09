public class TimerDemo {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        for(int i = 1;i<=20;i++)
        {
            System.out.println("2^"+i+" = "+(long)Math.pow(2,i));
        }

        long endTime = System.nanoTime();
        long elapsedTime = endTime-startTime;
        System.out.println("Elapsed time = "+(float)elapsedTime/1e9+" seconds");
    }
}
