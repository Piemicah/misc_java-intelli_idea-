public class StopWatch {

    private double elapsedTime;
    private double startTime;
    private double endTime;
    private boolean running;
    public StopWatch()
    {
        elapsedTime=0;
    }

    public double elaspsed()
    {
        return elapsedTime;
    }

    public StopWatch start()
    {
        running=true;
        startTime=System.nanoTime();
        return this;
    }

    public StopWatch stop()
    {
        endTime = System.nanoTime();
        elapsedTime=endTime-startTime;
        running=false;
        return this;
    }

    public StopWatch reset()
    {
        elapsedTime=0;
        endTime=0;
        startTime=0;
        return this;
    }
    public boolean isRunning()
    {
        return running;
    }
}
