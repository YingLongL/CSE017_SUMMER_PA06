/**
 * The Server class represents a server in the queueing system.
 * It manages the current customer being served, the server's status, and the remaining service time.
 */
public class Server {
    private Customer currentCustomer;
    private boolean status;
    private int serviceTime;

    /**
     * Constructs a new Server with no current customer, free status, and zero service time.
     */
    public Server() {
        this.currentCustomer = null;
        this.status = true; // true means free
        this.serviceTime = 0;
    }

    /**
     * Checks if the server is free.
     *
     * @return true if the server is free, false otherwise
     */
    public boolean isFree() {
        return status;
    }

    /**
     * Sets the server's status to busy.
     */
    public void setBusy() {
        this.status = false;
    }

    /**
     * Sets the server's status to free, clears the current customer, and resets the service time.
     */
    public void setFree() {
        this.status = true;
        this.currentCustomer = null;
        this.serviceTime = 0;
    }

    /**
     * Returns the remaining service time for the current customer.
     *
     * @return the remaining service time
     */
    public int getServiceTime() {
        return serviceTime;
    }

    /**
     * Sets the service time for the current customer.
     *
     * @param sTime the service time to set
     */
    public void setServiceTime(int sTime) {
        this.serviceTime = sTime;
    }

    /**
     * Decrements the service time by one unit. If the service time reaches zero,
     * the server is set to free.
     */
    public void decrementServiceTime() {
        if (!status) {
            this.serviceTime--;
            if (this.serviceTime == 0) {
                setFree();
            }
        }
    }

    /**
     * Sets the current customer being served by the server and marks the server as busy.
     *
     * @param c the customer to set
     */
    public void setCurrentCustomer(Customer c) {
        this.currentCustomer = c;
        this.status = false;
    }

    /**
     * Returns the current customer being served by the server.
     *
     * @return the current customer
     */
    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    /**
     * Returns a string representation of the server.
     *
     * @return a string representation of the server
     */
    @Override
    public String toString() {
        return "Server{" +
                "currentCustomer=" + currentCustomer +
                ", status=" + status +
                ", serviceTime=" + serviceTime +
                '}';
    }
}