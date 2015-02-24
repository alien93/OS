/**
 * This class implements the barber's part of the
 * Barbershop thread synchronization example.
 */
public class Barber implements Runnable {

    private Thread barberThread;
    private CustomerQueue queue;
    private Gui gui;
    private int pos;
    private boolean runs;

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
        this.runs = false;
	}

	/**
	 * Starts the barber running as a separate thread.
	 */
	public void startThread() {
		barberThread = new Thread(this);
		this.runs = true;

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

    	while(this.runs){
    		//fetch the next customer from the queue    		
    		Customer customer = this.queue.getNextCustomer();
    		this.gui.fillBarberChair(pos, customer);

    		//thread sleeps through the time it takes to cut the hair
    		try{
    			// TODO: fix warning
    		 	barberThread.sleep(Globals.barberWork);
    		}catch(Exception e){
                System.out.print("");
    		}
    		
    		//finish cutting
    		this.gui.emptyBarberChair(pos);

    		//the barber is tired, have to sleep zzz...
    		try{
    			this.gui.barberIsSleeping(pos);
    			// TODO: fix warning
    			barberThread.sleep((long) (Globals.barberSleep * Math.random()));
    			
    		//after sleeping for a random time, the barber wakes up
    			this.gui.barberIsAwake(pos);
    			
    		}catch(Exception e){
                System.out.print("");
    		}
    	}
    }

}

