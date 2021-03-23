public class Stopwatch1 {

    private final long startTime;

    /**
     * Initializes a new stopwatch.
     */
    public Stopwatch1() {
        startTime = System.currentTimeMillis();
    }


    /**
     * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
     *
     * @return elapsed CPU time (in seconds) since the stopwatch was created
     */

    public long getElapsedTimeInSecond(){
        try{
            long endTime = System.currentTimeMillis();
            return (endTime - startTime)/1000;
        }catch (Exception e){
            throw new Error(e);
        }
    }

    public long getTimeLeftInSecond(long maxTimeoutInSecond){
        try{
            return maxTimeoutInSecond - this.getElapsedTimeInSecond();
        }catch (Exception e){
            throw new Error(e);
        }
    }
}