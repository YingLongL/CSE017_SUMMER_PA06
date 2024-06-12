import java.util.LinkedList;
import java.util.Queue;

/**
 * The CustomerQueue class represents a queue of customers in the queueing system.
 * It uses a LinkedList to manage the customers.
 */
public class CustomerQueue {
    private Queue<Customer> customers;

    /**
     * Constructs a new CustomerQueue with an empty LinkedList.
     */
    public CustomerQueue() {
        this.customers = new LinkedList<>();
    }

    /**
     * Retrieves and removes the next customer from the front of the queue.
     *
     * @return the next customer, or null if the queue is empty
     */
    public Customer getNextCustomer() {
        return customers.poll();
    }

    /**
     * Increments the waiting time of each customer in the queue by one unit.
     */
    public void updateWaitingTime() {
        for (Customer customer : customers) {
            customer.incrementWaitingTime();
        }
    }

    /**
     * Adds a customer to the back of the queue.
     *
     * @param c the customer to add
     */
    public void addCustomer(Customer c) {
        customers.offer(c);
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return customers.isEmpty();
    }

    /**
     * Returns the number of customers in the queue.
     *
     * @return the size of the queue
     */
    public int size() {
        return customers.size();
    }

    /**
     * Returns a string representation of the customer queue.
     *
     * @return a string representation of the customer queue
     */
    @Override
    public String toString() {
        return "CustomerQueue{" +
                "customers=" + customers +
                '}';
    }
}