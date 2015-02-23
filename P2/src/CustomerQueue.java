import java.util.LinkedList;

/**
 * This class implements a queue of customers as a circular buffer.
 */
public class CustomerQueue {
	/**
	 * Creates a new customer queue.
	 * @param queueLength	The maximum length of the queue.
	 * @param gui			A reference to the GUI interface.
	 */
	
	private LinkedList<Customer> customerQueue;
    private Gui gui;
	
    public CustomerQueue(int queueLength, Gui gui) {
        this.gui = gui;
	}
    
//    Just had to make this for the barberclass
//    TODO: implement methods for checking if it is a customer, wait if there is no new customers ect. 
    public Customer getNextCustomer(){
    	return customerQueue.getLast();
    }

	// Add more methods as needed

    public synchronized void putNewCustomer() throws InterruptedException{
        while (full()) {
            try {
                gui.println("Doorman is waiting for free chairs");
                wait();
            } catch (InterruptedException e) {
                if (Thread.currentThread().isInterrupted()) throw new InterruptedException();
            }
        }
        customerQueue.add(new Customer());
    }

    public boolean full() {
        return customerQueue.size() >= Constants.NOF_CHAIRS;
    }
}
