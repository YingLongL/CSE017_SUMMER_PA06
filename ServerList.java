import java.util.ArrayList;

/**
 * The ServerList class represents a list of servers in the queueing system.
 * It manages a list of Server objects and provides methods to interact with the servers.
 */
public class ServerList {
    private ArrayList<Server> list;

    /**
     * Constructs a new ServerList with the specified number of servers.
     *
     * @param count the number of servers to create
     */
    public ServerList(int count) {
        list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(new Server());
        }
    }

    /**
     * Returns the index of the first free server in the list.
     *
     * @return the index of the first free server, or -1 if all servers are busy
     */
    public int getFreeServer() {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isFree()) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Sets the server at the specified index to busy with the given customer and service time.
     *
     * @param i  the index of the server
     * @param c  the customer to set
     * @param st the service time to set
     * @throws ArrayIndexOutOfBoundsException if the index is out of range
     */
    public void setServerBusy(int i, Customer c, int st) {
        if (i < 0 || i >= list.size()) {
            throw new ArrayIndexOutOfBoundsException("Invalid server index: " + i);
        }
        list.get(i).setCurrentCustomer(c);
        list.get(i).setServiceTime(st);
    }

    /**
     * Updates the service time of each busy server by decrementing it by one unit.
     */
    public void updateServiceTime() {
        for (Server server : list) {
            server.decrementServiceTime();
        }
    }

    /**
     * Returns the number of busy servers in the list.
     *
     * @return the number of busy servers
     */
    public int getBusyServers() {
        int count = 0;
        for (Server server : list) {
            if (!server.isFree()) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns a string representation of the server list.
     *
     * @return a string representation of the server list
     */
    @Override
    public String toString() {
        return "ServerList{" +
                "list=" + list +
                '}';
    }
}