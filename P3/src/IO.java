/**
 * Created by bflugon on 14.04.15.
 */
public class IO implements Runnable {

    private Queue queue;
    private long avgSleepTime;
    private Thread ioThread;
    private Process process;

    public IO(Queue queue, long avgSleep) {
        this.queue = queue;
        this.avgSleepTime = avgSleep;
        this.ioThread = new Thread(this);
        this.ioThread.start();
    }

    @Override
    public void run() {
        while (true) {
            this.process = (Process) queue.removeNext();
            try {
                ioThread.sleep(avgSleepTime);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void stopThread() {
        ioThread.interrupt();
    }

}
