/**
 * This class implements the doorman's part of the
 * Barbershop thread synchronization example.
 */
public class Doorman extends Thread{
	
	private boolean runs;
	
	/**
	 * Creates a new doorman.
	 * @param queue		The customer queue.
	 * @param gui		A reference to the GUI interface.
	 */
	public Doorman(CustomerQueue queue, Gui gui) { 
		// Incomplete
	}

	/**
	 * Starts the doorman running as a separate thread.
	 */
	public void startThread() {
		this.runs=true;
		this.start();
	}


	/**
	 * Stops the doorman thread.
	 */
	public void stopThread() {
		this.runs=false;
	}

	// Add more methods as needed
}
