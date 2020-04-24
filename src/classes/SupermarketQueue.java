package classes;

import java.util.ArrayList;
import java.util.List;

class SupermarketQueue {
    private List<Customer> queue = new ArrayList<>();

    void addToQueue(Customer customer) {
        queue.add(customer);
    }
    void removeCustomerFromQueue(Customer customer) {
        queue.remove(customer);
    }
    void removeFirstCustomer() {
        queue.remove(0);
    }
    int size() {
        return queue.size();
    }
}
