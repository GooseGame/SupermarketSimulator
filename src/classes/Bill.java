package classes;

public class Bill {
    private int price;

    public Bill(int customerPrice) {
        this.price = customerPrice;
    }

    public int getPrice() {
        return price;
    }
}
