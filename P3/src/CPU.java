/**
 * Created by bflugon on 14.04.15.
 */

public class CPU extends Unit{

    private long maxCpuTime;
    private Process currentProcess;

    public CPU(Queue queue, long maxCpuTime){
        super(queue);
        this.maxCpuTime=maxCpuTime;
    }

    public Process processNext() {
        Process p = getCurrentProcess();
        if(!getQueue().isEmpty()){
            setCurrentProcess((Process) getQueue().removeNext());
        }
        return p;
    }

}

