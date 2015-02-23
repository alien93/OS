/**
 * This class implements the barber's part of the
 * Barbershop thread synchronization example.
 */
public class Barber extends Thread{
	
	private boolean runs;
	
	/**
	 * Creates a new barber.
	 * @param queue		The customer queue.
	 * @param gui		The GUI.
	 * @param pos		The position of this barber's chair
	 */
	public Barber(CustomerQueue queue, Gui gui, int pos) { 
		
	}

	/**
	 * Starts the barber running as a separate thread.
	 */
	public void startThread() {
		this.runs=true;
		this.start();
	}
	
	/**
	 * Stops the barber thread.
	 */
	public void stopThread() {
		this.runs=false;
	}

    @Override
    public void run() {
        super.run();
    }

    // Add more methods as needed
}

