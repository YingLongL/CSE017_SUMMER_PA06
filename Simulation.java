import java.util.Random;

/**
 * The Simulation class runs the simulation of the queueing system with servers and customers.
 * It simulates customer arrivals, service times, and queue management over a specified period.
 */
public class Simulation {
    /**
     * The main method to run various test cases of the simulation.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\nTest case 1: 1 server, 15 customers/hour, 5mn service time");
        simulation(100, 1, 5, 15);
        System.out.println("\nTest case 2: 1 server, 20 customers/hour, 5mn service time");
        simulation(100, 1, 5, 20);
        System.out.println("\nTest case 3: 2 servers, 15 customers/hour, 5mn service time");
        simulation(100, 2, 5, 15);
        System.out.println("\nTest case 4: 2 servers, 20 customers/hour, 5mn service time");
        simulation(100, 2, 5, 20);
        System.out.println("\nTest case 5: 1 server, 15 customers/hour, 10mn service time");
        simulation(100, 1, 10, 15);
        System.out.println("\nTest case 6: 1 server, 20 customers/hour, 10mn service time");
        simulation(100, 1, 10, 20);
        System.out.println("\nTest case 7: 2 servers, 15 customers/hour, 10mn service time");
        simulation(100, 2, 10, 15);
        System.out.println("\nTest case 8: 2 servers, 20 customers/hour, 10mn service time");
        simulation(100, 2, 10, 20);
    }

    /**
     * Runs the simulation for a specified time period with a given number of servers, service time, and customer arrival rate.
     *
     * @param simulationTime the total simulation time in minutes
     * @param servers the number of servers
     * @param serviceTime the time it takes for a server to serve a customer (average service time in minutes)
     * @param arrivalRate the customer arrival rate (the number of customers that arrive in an hour)
     */
    public static void simulation(int simulationTime, int servers, int serviceTime, int arrivalRate) {
        ServerList serverList = new ServerList(servers);
        CustomerQueue customerQueue = new CustomerQueue();
        Random random = new Random();
        int totalCustomers = 0;
        int customersServed = 0;
        int totalWaitingTime = 0;

        System.out.println("\nSimulation Parameters");
        System.out.println("        " + "Simulation time: " + simulationTime + " minutes");
        System.out.println("        " + "Number of servers: " + servers);
        System.out.println("        " + "Customer Arrival Rate: " + arrivalRate + " customers per hour");
        System.out.println("        " + "Service time: " + serviceTime + " minutes");
        
        System.out.println("\nSimulation started...");

        for (int clock = 0; clock < simulationTime; clock++) {
            // Update server list to decrement the service time of the busy servers
            serverList.updateServiceTime();

            // If the customer’s queue is nonempty, increment the waiting time of each customer
            if (!customerQueue.isEmpty()) {
                customerQueue.updateWaitingTime();
            }

            // Check if a customer arrives
            if (random.nextDouble() < (arrivalRate / 60.0)) {
                Customer newCustomer = new Customer(totalCustomers + 1, clock, 0);
                customerQueue.addCustomer(newCustomer);
                totalCustomers++;
            }

            // If a server is free and the customer queue is nonempty, assign a customer to the free server
            while (!customerQueue.isEmpty() && serverList.getFreeServer() != -1) {
                int freeServerIndex = serverList.getFreeServer();
                Customer nextCustomer = customerQueue.getNextCustomer();
                serverList.setServerBusy(freeServerIndex, nextCustomer, serviceTime);
                totalWaitingTime += nextCustomer.getWaitingTime();
                customersServed++;
            }
        }

        System.out.println("Simulation completed.\n");

        // Print results
        System.out.println("Simulation Results");
        System.out.println("        " + "Total number of customers: " + totalCustomers);
        System.out.println("        " + "Number of customers served: " + customersServed);
        System.out.println("        " + "Number of customers still being served: " + serverList.getBusyServers());
        System.out.println("        " + "Number of customers left in the queue: " + customerQueue.size());
        if (customersServed > 0) {
            System.out.println("        " + "Average waiting time per customer: " + ((double) totalWaitingTime / customersServed));
        } else {
            System.out.println("        " + "Average waiting time per customer: 0");
        }
    }
}