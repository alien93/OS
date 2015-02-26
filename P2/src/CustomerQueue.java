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
    
    public synchronized Customer getNextCustomer(){
        while (empty()) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        Customer c = customerQueue.pop();
        //return customerQueue.getLast();
        for (int i = 0; i < chairs.length; i++){
            if (chairs[i] == c.getCustomerID()) {
                chairs[i] = 0;
                gui.emptyLoungeChair(i);
            }
            break;
        }
        notify();
        return c;
    }

	// Add more methods as needed

    public synchronized void putNewCustomer() throws InterruptedException {
        while (full()) {
            gui.println("Doorman is waiting for free chairs");
            wait();
            gui.println("Doorman is notified of free chairs");
        }

        Customer next = new Customer();
        customerQueue.add(next);
        gui.fillLoungeChair(next.getCustomerID() % queueLength, next);
        notify();
    }


    public boolean full() {
        return customerQueue.size() >= queueLength;
    }

    public boolean empty() {
        return customerQueue.size() == 0;
    }
}
