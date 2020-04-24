package classes;

import java.util.Random;

public class Product {
    private String name;
    private int price;
    private int type;
    private boolean onSale;

    public Product(String name) {
        this.name = name;
        this.price = new RandomNum(new Data().getPriceLimit()).getSeed();
        this.onSale = new Random().nextBoolean();
        this.type = generateType(this.name);
    }

    boolean isOnSale() {
        return onSale;
    }

    int getPrice() {
        return price;
    }

    String getName() {
        return name;
    }


    int getType() {
        return type;
    }

    private int generateType(String name) {
        switch (name){
            case "Marlboro":
            case "Winston":
            case "LD":
            case "Donskoy tabak":
            case "Baltika":
            case "Bud":
            case "Talka":
            case "Jagermeister":
            case "Jateckiy Gus":
                return new Data().getAdultType();
            default:
                return new Data().getChildType();
        }
    }
}
