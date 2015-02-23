/**
 * This class implements the doorman's part of the
 * Barbershop thread synchronization example.
 */
public class Doorman implements Runnable {

    private Thread doormanThread;
    private CustomerQueue queue;
    private Gui gui;

	/**
	 * Creates a new doorman.
	 * @param queue		The customer queue.
	 * @param gui		A reference to the GUI interface.
	 */
	public Doorman(CustomerQueue queue, Gui gui) { 
		this.queue = queue;
        this.gui = gui;
	}

	/**
	 * Starts the doorman running as a separate thread.
	 */
	public void startThread() {
		doormanThread = new Thread(this);
        doormanThread.start();
	}


	/**
	 * Stops the doorman thread.
	 */
	public void stopThread() {
		doormanThread.interrupt();
	}

    @Override
    public void run() {
        // Shit the thread should do
    }


    // Add more methods as needed
}
