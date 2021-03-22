public class StopWatch {
    private long startTime;

    public void startClock(){
        try {
            if (!(this.startTime >= 0)){
                this.startTime = System.currentTimeMillis();
            }else{
                throw new Error("Clock has already started");
            }

        }catch (Exception e){
            throw new Error(e);
        }
    }

    public long getElapsedTime(){
        try{
            long endTime = System.currentTimeMillis();
            return (endTime - startTime);
        }catch (Exception e){
            throw new Error(e);
        }
    }

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

