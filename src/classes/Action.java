package classes;

import java.util.ArrayList;
import java.util.List;

public class Action {
    CommandList commandList = new CommandList();
    private Supermarket supermarket;
    private Report report = new Report();


    Action() throws Exception {
        supermarket = new Supermarket();
        report.makeTopic("Pyaterochka", 0);
        report.makeProductListReport(supermarket.getProductsInSupermarket());
        int countOfCustomers = new RandomNum(new Data().getCountOfCustomersLimit()).getSeed();
        generateCustomers(countOfCustomers);
    }

    private void generateCustomers(int count) throws Exception {
        int timeWhenCustomerCome;
        List<Integer> timesWhenCustomersCome = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            timeWhenCustomerCome = new RandomNum(new Data().getGameLoop() - 1).getSeed();
            timesWhenCustomersCome.add(timeWhenCustomerCome);
            makeNewCustomer(timeWhenCustomerCome);
        }
        generatePicks(timesWhenCustomersCome);
    }

    private void generatePicks(List<Integer> times) throws Exception {
        for (int i = 0; i < supermarket.getCountOfCustomers(); i++) {
            times.set(i,customerPickProduct(supermarket.getCustomers().get(i), times.get(i)));
        }
        generateQueue(times);
    }

    private void generateQueue(List<Integer> times) throws Exception {
        for (int i = 0; i < supermarket.getCountOfCustomers(); i++) {
            times.set(i,customerGoToQueue(supermarket.getCustomers().get(i), times.get(i)));
        }
        generatePay(times);
    }

    private void generatePay(List<Integer> times) throws Exception {
        Queue queue = new Queue();
        int orderTime;
        for (int i = 0; i < supermarket.getCountOfCustomers(); i++) {
            orderTime = times.get(i) + queue.getQueueByTime(times.get(i));
            if (orderTime < new Data().getGameLoop()) {
                customerMakeOrder(supermarket.getCustomers().get(i), orderTime);
                times.set(i, orderTime);
            } else {
                customerLeaveByTime(supermarket.getCustomers().get(i));
            }
        }
        generateLeave(times);
    }

    private void generateLeave(List<Integer> times) {
        for (int i = 0; i < supermarket.getCountOfCustomers(); i++) {
            customerGoOut(supermarket.getCustomers().get(i), times.get(i));
        }
    }

    void finish() {
        report.makeProductListSoldReport(supermarket.getCopy());
        report.sort();
        for (int i = 0; i < report.size(); i++) {
            System.out.println(report.get(i));
        }
    }

    private void makeNewCustomer(int loop) {
        Customer customer = new Customer();
        supermarket.addCustomer(customer);
        report.makeCustomerArriveReport(customer, loop);
    }



    private int customerPickProduct(Customer customer, int loop) {
        int rn = new RandomNum(10).getSeed();
        Product product;
        int count;

        for (int i = 0; i < rn; i++) {
            if (loop < new Data().getGameLoop()) {
                loop += 1;
                product = supermarket.generateProductForCustomerPicking();
                count = new RandomNum(supermarket.getCountOfProduct(product)).getSeed();
                if (customer.canAfford(product, count)) {
                    if ((product.getType() == new Data().getAdultType()) && (customer.getType() == new Data().getChildType())) {
                        report.makeLittleCustomerNotTakeAdultThings(customer, product, loop);
                    } else {
                        customer.addToBasket(product, count);
                        supermarket.removeCountOfProduct(product, count);
                        report.makeCustomerPickReport(customer, product, count, loop);
                    }
                }
            }
            else {
                customerLeaveByTime(customer);
            }
        }
        return loop;
    }

    private int customerGoToQueue(Customer customer, int loop) {
        supermarket.addCustomerToQueue(customer);
        if (loop+1 >= new Data().getGameLoop()) {
            customerLeaveByTime(customer);
        }
        else report.makeCustomerAddToQueueReport(customer, loop+1);
        return loop+1;
    }

    private void firstCustomerGoOutOfQueue() {
    }

    private void customerLeaveByTime(Customer customer) {
        //customer.clearBasket(supermarket);
        report.makeCustomerLeaveByTime(customer);
    }

    private void customerGoOut(Customer customer, int loop) {
        report.makeCustomerGoOutOfSupermarketReport(customer, loop);
    }

    private void customerMakeOrder(Customer customer, int loop) throws Exception {
        report.makeCustomerBillReport(customer, customer.getBasket().getPriceOfBasket(), loop);
        report.makeCustomerPayReport(customer, customer.getBasket().getPriceOfBasket(), customer.buy(customer.getBasket().getPriceOfBasket()), loop);
        firstCustomerGoOutOfQueue();
    }

    public List<String> getReport() {
        return report.getActionReport();
    }
}
