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
    int queueLength;
    private Gui gui;
	
    public CustomerQueue(int queueLength, Gui gui) {
        this.customerQueue = new LinkedList<Customer>();
        this.gui = gui;
        this.queueLength = queueLength;
	}
    
    public Customer getNextCustomer(){
    	return customerQueue.getLast();
    }

	// Add more methods as needed

    public synchronized void putNewCustomer() throws InterruptedException {
        while (full()) {
            gui.println("Doorman is waiting for free chairs");
            wait();
        }

        Customer next = new Customer();
        customerQueue.add(next);
        gui.fillLoungeChair(next.getCustomerID() % queueLength, next);
    }

    public boolean full() {
        return customerQueue.size() >= queueLength;
    }

    public boolean empty() {
        return customerQueue.size() == 0;
    }
}
