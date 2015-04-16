/**
 * Created by bflugon on 14.04.15.
 */

public class CPU {

    private Queue cpuQueue;
    private long maxCpuTime;
    private Process currentProcess;
    private Gui gui;

    public CPU(Queue queue, long maxCpuTime, Gui gui){
        this.cpuQueue=queue;
        this.maxCpuTime=maxCpuTime;
        this.gui = gui;
    }

    public Queue getQueue() {
        return cpuQueue;
    }

    public Process getCurrentProcess() {
        return currentProcess;
    }

    public void setCurrentProcess(Process currentProcess) {
        gui.setCpuActive(currentProcess);
        this.currentProcess = currentProcess;
    }

    public Process processNext() {
        Process p = (Process) cpuQueue.removeNext();
        setCurrentProcess(p);
        return p;
    }
}

