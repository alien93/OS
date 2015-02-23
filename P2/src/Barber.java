/**
 * This class implements the barber's part of the
 * Barbershop thread synchronization example.
 */
public class Barber implements Runnable {

    private Thread barberThread;
    private CustomerQueue queue;
    private Gui gui;
    private int pos;

	/**
	 * Creates a new barber.
	 * @param queue		The customer queue.
	 * @param gui		The GUI.
	 * @param pos		The position of this barber's chair
	 */
	public Barber(CustomerQueue queue, Gui gui, int pos) {
        this.queue = queue;
        this.gui = gui;
        this.pos = pos;
	}

	/**
	 * Starts the barber running as a separate thread.
	 */
	public void startThread() {
		barberThread = new Thread(this, "Barber #" + pos);
        barberThread.start();
	}
	
	/**
	 * Stops the barber thread.
	 */
	public void stopThread() {
		barberThread.interrupt();
	}

    @Override
    public void run() {
        // Shit the thread should do
    }

    // Add more methods as needed
}

