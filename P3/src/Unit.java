/**
 * Created by kes on 16.04.15.
 */
public abstract class Unit {

    private Queue queue;
    private Process currentProcess;
    public static CPU cpu;
    public static IO io;

    public Unit(Queue queue){
        this.queue=queue;
    }

    public Queue getQueue() {
        return queue;
    }

    public abstract Process processNext();

    public Process getCurrentProcess() {
        return currentProcess;
    }

    public void setCurrentProcess(Process currentProcess) {
        this.currentProcess = currentProcess;
    }
}
