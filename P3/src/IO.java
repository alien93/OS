import javax.swing.*;

/**
 * Created by bflugon on 14.04.15.
 */
public class IO extends Unit {

    public IO(Queue queue) {
        super(queue);
        Unit.io = this;
    }

    public Process processNext() {
        Process p = (Process) getQueue().removeNext();
        setCurrentProcess(p);
        return p;
    }
}
