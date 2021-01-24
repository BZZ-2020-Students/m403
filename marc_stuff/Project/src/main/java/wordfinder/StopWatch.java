package wordfinder;

public class StopWatch {
    /**
     * Measures time
     *
     * @author Marc-Andri Fuchs
     * @version 1.0
     */
    private long startTime;
    private long stopTime = -1;

    /**
     * Starts the timer
     */
    public void start() {
        startTime = System.currentTimeMillis();
    }

    /**
     * Stops the timer
     */
    public void stop() {
        stopTime = System.currentTimeMillis();
    }

    /**
     * @return if stopwatch is stopped the return value is Start Time minus Stop Time, else it is Current Time - Start Time
     */
    public long elapsed() {
        if (stopTime >= 0) {
            return stopTime - startTime;
        }
        return System.currentTimeMillis() - startTime;
    }

    /**
     *
     * @return Time formatted in HH:MM:SS:ms format
     */
    @Override
    public String toString() {
        long milliseconds = elapsed();
        int seconds = (int) (milliseconds / 1000) % 60 ;
        int minutes = (int) ((milliseconds / (1000*60)) % 60);
        int hours   = (int) ((milliseconds / (1000*60*60)) % 24);
        int millis  = (int) (milliseconds - (seconds * 1000) - (minutes * 1000 * 60) - (hours * 1000 * 60 * 60));
        return String.format("%dh, %dmin, %ds, %dms", hours, minutes, seconds, millis);
    }
}

