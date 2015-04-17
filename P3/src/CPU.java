/**
 * Created by bflugon on 14.04.15.
 */

public class CPU extends Unit{

    private long maxCpuTime;

    public CPU(Queue queue, long maxCpuTime){
        super(queue);
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

