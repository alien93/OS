/**
 * This class implements the doorman's part of the
 * Barbershop thread synchronization example.
 */
public class Doorman implements Runnable {

    private Thread doormanThread;
    private CustomerQueue queue;
    private Gui gui;
    private boolean runs;

	/**
	 * Creates a new doorman.
	 * @param queue		The customer queue.
	 * @param gui		A reference to the GUI interface.
	 */
	public Doorman(CustomerQueue queue, Gui gui) {
		this.queue = queue;
        this.gui = gui;
        this.runs = false;
	}

	/**
	 * Starts the doorman running as a separate thread.
	 */
	public void startThread() {
		doormanThread = new Thread(this);
        doormanThread.start();
        this.runs = true;
	}


	/**
	 * Stops the doorman thread.
	 */
	public void stopThread() {
		doormanThread.interrupt();
        this.runs = false;
	}

    @Override
    public void run() {
        while(this.runs){

            //adds customer to the queue, functionality for the add method is in the customerqueue class
            queue.addCustomer(new Customer());

            //the doorman is also tired zzz...
            try{
                doormanThread.sleep((long) (Globals.doormanSleep*Math.random()));
            }catch (Exception e){
                System.out.print("");
            }
        }

    }

}
