/**
 * Created by bflugon on 14.04.15.
 */

public class CPU {

    private Queue cpuQueue;
    private long maxCpuTime;
    private Process currentProcess;

    public CPU(Queue queue, long maxCpuTime){
        this.cpuQueue=queue;
        this.maxCpuTime=maxCpuTime;
    }

    public Queue getQueue() {
        return cpuQueue;
    }

    public Process getCurrentProcess() {
        return currentProcess;
    }

    public void setCurrentProcess(Process currentProcess) {
        this.currentProcess = currentProcess;
    }
}

