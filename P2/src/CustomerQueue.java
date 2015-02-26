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
    private int[] chairs;
	
    public CustomerQueue(int queueLength, Gui gui) {
        this.customerQueue = new LinkedList<Customer>();
        this.gui = gui;
        this.queueLength = queueLength;
	}
    
    public synchronized Customer getNextCustomer() throws InterruptedException {
        while (empty()) {
            gui.println("Barber is waiting for new customer");
            wait();
            gui.println("Barber is notified of new customer");
        }

        Customer next = customerQueue.pop();
        gui.emptyLoungeChair(next.getCustomerID() % queueLength);
        notify();

        return next;
    }

    public synchronized void putNewCustomer() throws InterruptedException {
        while (full()) {
            gui.println("Doorman is waiting for free chairs");
            wait();
            gui.println("Doorman is notified of free chairs");
        }

        Customer newCustomer = new Customer();
        customerQueue.add(newCustomer);
        gui.fillLoungeChair(newCustomer.getCustomerID() % queueLength, newCustomer);
        notify();
    }


    public boolean full() {
        return customerQueue.size() >= queueLength;
    }

    public boolean empty() {
        return customerQueue.size() == 0;
    }
}
