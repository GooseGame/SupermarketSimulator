package classes;

import java.util.ArrayList;
import java.util.List;

public class Supermarket {
    private CashDesk cashDesk;
    private SupermarketWarehouse copy = new SupermarketWarehouse();
    private SupermarketWarehouse productsInSupermarket;
    private SupermarketQueue queue;
    private List<Customer> customers = new ArrayList<>();

    public Supermarket() {

        this.cashDesk = new CashDesk();
        this.queue = new SupermarketQueue();
        this.productsInSupermarket = new SupermarketWarehouse();
        new GenerateProducts(this.productsInSupermarket);
        generateCopy();
    }

    SupermarketWarehouse getCopy() {
        return copy;
    }

    int getCountOfCustomers() {
        return customers.size();
    }

    SupermarketWarehouse getProductsInSupermarket() {
        return productsInSupermarket;
    }

    void addProduct(Product product, int count) {
        productsInSupermarket.addProduct(product, count);
    }

    int getQueueSize() {
        return queue.size();
    }

    boolean containsProduct(Product product, int count) {return productsInSupermarket.contains(product, count);}

    void addCustomer(Customer customer) {
        customers.add(customer);
    }

    void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    List<Customer> getCustomers() {
        return customers;
    }

    void addCustomerToQueue(Customer customer) {
        queue.addToQueue(customer);
    }

    void removeFirstCustomerFromQueue() {
        queue.removeFirstCustomer();
    }

    void removeCustomerFromQueue(Customer customer) {
        queue.removeCustomerFromQueue(customer);
    }

    void removeProduct(Product product) {
        productsInSupermarket.removeProduct(product);
    }
    void removeCountOfProduct(Product product, int count) {
        productsInSupermarket.removeCountFromProduct(product, count);
        copy.addProduct(product, count);

    }
    int getCountOfProduct(Product product) {return productsInSupermarket.getCountOfProduct(product);}
    Product generateProductForCustomerPicking() {
        int rn = new RandomNum(productsInSupermarket.size()).getSeed();

        return productsInSupermarket.getProductByCounter(rn);
    }

    private void generateCopy() {
        Product p;
        for (int i = 0; i < this.productsInSupermarket.size(); i++) {
            p = this.productsInSupermarket.getProductByCounter(i);
            this.copy.addProduct(p, 0);
        }
    }
}
