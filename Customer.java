/**
 * The Customer class represents a customer in the queueing system.
 * It contains information about the customer's number, arrival time, and waiting time.
 */
public class Customer {
    private int customerNo;
    private int arrivalTime;
    private int waitingTime;

    /**
     * Constructs a new Customer with the specified customer number, arrival time, and waiting time.
     *
     * @param cn the customer number
     * @param at the arrival time
     * @param wt the waiting time
     */
    public Customer(int cn, int at, int wt) {
        this.customerNo = cn;
        this.arrivalTime = at;
        this.waitingTime = wt;
    }

    /**
     * Returns the customer number.
     *
     * @return the customer number
     */
    public int getCustomerNo() {
        return customerNo;
    }

    /**
     * Returns the arrival time.
     *
     * @return the arrival time
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Returns the waiting time.
     *
     * @return the waiting time
     */
    public int getWaitingTime() {
        return waitingTime;
    }

    /**
     * Sets the customer number.
     *
     * @param cn the customer number to set
     */
    public void setCustomerNo(int cn) {
        this.customerNo = cn;
    }

    /**
     * Sets the arrival time.
     *
     * @param at the arrival time to set
     */
    public void setArrivalTime(int at) {
        this.arrivalTime = at;
    }

    /**
     * Sets the waiting time.
     *
     * @param wt the waiting time to set
     */
    public void setWaitingTime(int wt) {
        this.waitingTime = wt;
    }

    /**
     * Increments the waiting time by one unit.
     */
    public void incrementWaitingTime() {
        this.waitingTime++;
    }

    /**
     * Returns a string representation of the customer.
     *
     * @return a string representation of the customer
     */
    @Override
    public String toString() {
        return "Customer{" +
                "customerNo=" + customerNo +
                ", arrivalTime=" + arrivalTime +
                ", waitingTime=" + waitingTime +
                '}';
    }
}