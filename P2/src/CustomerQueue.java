/**
 * This class implements a queue of customers as a circular buffer.
 */
public class CustomerQueue {
	/**
	 * Creates a new customer queue.
	 * @param queueLength	The maximum length of the queue.
	 * @param gui			A reference to the GUI interface.
	 */
    public CustomerQueue(int queueLength, Gui gui) {
		// Incomplete
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
        queue.put(new Customer());
    }

    public boolean full() {
        return queue.size() >= Constants.NOF_CHAIRS;
    }
}
