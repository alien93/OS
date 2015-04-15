/**
 * Created by bflugon on 14.04.15.
 */
public class IO  {

    private Queue queue;
    private long avgSleepTime;
    private Process process;

    public IO(Queue queue, long avgSleep) {
        this.queue = queue;
        this.avgSleepTime = avgSleep;
    }

}
