/**
 * Created by bflugon on 14.04.15.
 */

public class CPU extends Unit{

    private long maxCpuTime;
    private Process currentProcess;

    public CPU(Queue queue, long maxCpuTime){
        super(queue);
        Unit.cpu = this;
        this.maxCpuTime=maxCpuTime;
    }

    /**
     *
     * @return the old process that was removed
     */
    public Process processNext() {
        Process p = getCurrentProcess();
        if(!getQueue().isEmpty()){
            setCurrentProcess((Process) getQueue().removeNext());
        }
        return p;
    }

}

