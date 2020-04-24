package classes;

import java.util.List;

public class Customer {
    private Money money;
    private String name;
    private Basket basket;
    private int age;
    private int type;

    Customer() {
        this.age = new RandomNum(100).getSeed();
        this.money = new Money();
        this.basket = new Basket();
        this.name = new Names().getName();
        this.type = generateType(); //1-child, 2-adult, 3-old man
    }

    String buy(int price) throws Exception {
        if (type == 3){
            price = (int) (price*0.7);
        }
        if (money.getAllMoney() >= price) {
            if (money.getBonus() >= price) {
                money.setBonus(money.getBonus() - price);
                return "bonus";
            }
            else if (money.getCard() + money.getBonus() >= price) {
                money.setBonus(0);
                money.setCard(money.getCard() - price);
                return "bonus and card";
            }
            else if (money.getAllMoney() >= price) {
                money.setBonus(0);
                money.setCard(0);
                money.setCash(money.getCash() - price);
                return "bonus, card and cash";
            }
        }
        else throw new Exception();
        return null;
    }

    boolean canAfford(Product product, int count) {
        return money.getAllMoney() >= basket.getPriceOfBasket() + product.getPrice() * count;
    }

    void clearBasket(Supermarket sw) {
        basket.productsBackToSW(sw);
    }

    void addToBasket(Product product, int count) {
        basket.addProduct(product, count);
    }


    void removeFromBasket(Product product, int count) throws Exception {
        if (basket.getCountOfProduct(product) < count) {
            basket.removeCountFromProduct(product, count);
        }
        else if (basket.getCountOfProduct(product) == count) {
            basket.removeProduct(product);
        }
        else throw new Exception();
    }

    int getType() {
        return type;
    }

    String getName() {
        return name;
    }

    Basket getBasket() {
        return basket;
    }

    Money getMoney() {
        return money;
    }

    int getAge() {
        return age;
    }



    private int generateType() {
        if (age < 18) {
            return 1;
        }
        else if (age < 65) {
            return 2;
        }
        else return 3;
    }
}
