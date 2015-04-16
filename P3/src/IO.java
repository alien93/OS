import javax.swing.*;

/**
 * Created by bflugon on 14.04.15.
 */
public class IO implements Constants {

    private Queue queue;
    private Process currentProcess;
    private Gui gui;
    private EventQueue eventQueue;


    public IO(Queue queue, Gui gui, EventQueue evqueue) {
        this.queue = queue;
        this.gui = gui;
        this.eventQueue = evqueue;
    }

    public Queue getQueue() {
        return queue;
    }

    public Process getCurrentProcess() {
        return currentProcess;
    }

    public void setCurrentProcess(Process currentProcess) {
        gui.setCpuActive(currentProcess);
        this.currentProcess = currentProcess;
    }

    public void processNext() {
        Process p = (Process) queue.removeNext();
        setCurrentProcess(p);
        //eventQueue.insertEvent(new Event(END_IO, this.clock + (long) (avgIOTime*2*Math.random()))); TODO
    }
}
