package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Report {
    private List<String> actionReport = new ArrayList<>();

    void sort() {
        Collections.sort(actionReport);
    }

    void makeTopic(String supermarketName, int loop) {
        Time time = new Time(loop);
        actionReport.add(time.get()+"Supermarket " + supermarketName + " has been formed \nProduct list:\n");
    }

    void makeProductListReport(SupermarketWarehouse warehouse) {
        Time time = new Time(1);
        for (int i = 0; i < warehouse.size(); i++) {
            actionReport.add(time.get()+"Product "+warehouse.getProductByCounter(i).getName()+" x: "+ warehouse.getCountOfProduct(warehouse.getProductByCounter(i))+" has been formed");
        }
//        warehouse.getProductList().forEach(
//                (Product p)-> actionReport.add(time.get()+"Product "+p.getName()+" x: "+ warehouse.getCountOfProduct(p)+"has been formed")
//        );
    }

    void makeProductListSoldReport(SupermarketWarehouse copy) {
        Time time = new Time(new Data().getGameLoop() + 30);
        copy.getProductList().forEach(
                (Product p)-> actionReport.add(time.get()+"Product "+p.getName()+" x: "+ copy.getCountOfProduct(p)+" sold")
        );
    }

    void makeCustomerArriveReport(Customer customer, int loop) {
        Time time = new Time(loop);
        actionReport.add(time.get()+ customer.getName() + " " +  customer.getAge() + " years old" + " has arrived");
    }

    void makeCustomerGoOutOfSupermarketReport(Customer customer, int loop) {
        Time time = new Time(loop);
        actionReport.add(time.get()+customer.getName() + " went from supermarket");
    }

    void makeCustomerAddToQueueReport(Customer customer, int loop) {
        Time time = new Time(loop);
        actionReport.add(time.get()+customer.getName() + " went to queue");
    }

    String get(int i) {
        return actionReport.get(i);
    }

    int size() {
        return actionReport.size();
    }

    void makeLittleCustomerNotTakeAdultThings(Customer customer, Product product, int loop) {
        Time time = new Time(loop);
        actionReport.add(time.get()+customer.getName()+ " "+ customer.getAge()+ " years old" + " wanted to pick " + product.getName() + ", but he's too young for it. Grow up, faggot.");
    }

    void makeCustomerPickReport(Customer customer, Product product, int count, int loop) {
        Time time = new Time(loop);
        actionReport.add(time.get()+customer.getName()+ " "+ customer.getAge()+ " years old" + " picked " + count + " units of " + product.getName()+" ("+product.getPrice()+" per one)");
    }

    void makeCustomerLeaveByTime(Customer customer) {
        Time time = new Time(1080);
        actionReport.add(time.get()+customer.getName()+" came too late. He(She) went from supermarket.");
    }

    void makeCustomerPayReport(Customer customer, int count, String type, int loop) {
        Time time = new Time(loop);
        actionReport.add(time.get()+customer.getName() + " paid " + count + " by " + type);
    }

    void makeCustomerBillReport(Customer customer, int count, int loop) {
        Time time = new Time(loop);
        actionReport.add(time.get()+customer.getName() + " at the cash desk, amount to pay: " + count+" ("+customer.getMoney().getAllMoney()+" he(she) have)");
    }

    void makeSupermarketOpenReport() {
        actionReport.add("Supermarket is open");
    }

    void makeSupermarketClosedReport(int loop) {
        Time time = new Time(loop);
        actionReport.add(time.get()+"Supermarket is closed");
    }

    List<String> getActionReport() {
        return actionReport;
    }
}
