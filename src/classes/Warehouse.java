package classes;

import java.util.*;

public class Warehouse {
    private Map<Product, Integer> productsInWarehouse = new HashMap<>();
    private ArrayList<Product> products = new ArrayList<>();

    int getPriceOfBasket() {
        Set<Product> productList = getProductList();
        return productList.stream().mapToInt(p -> p.getPrice() * getCountOfProduct(p)).sum();
    }


    void clear() {
        productsInWarehouse.clear();
    }

    Set<Product> getProductList(){
        return productsInWarehouse.keySet();
    }

    void addProduct(Product product, int count) {
        if (getProductList().contains(product)) {
            addCountToProduct(product, count);
        }
        else {
            productsInWarehouse.put(product, count);
            products.add(product);
        }

    }

    private void addCountToProduct(Product product, int count) {
        productsInWarehouse.replace(product, count);
    }

    Product getProductByCounter(int i) {
        return products.get(i);
    }

    void removeProduct(Product product) {
        productsInWarehouse.remove(product);
        products.remove(product);
    }

    void removeCountFromProduct(Product product, int count) {
        if (count == productsInWarehouse.get(product)) {
            removeProduct(product);
        }
        else {
            productsInWarehouse.replace(product, count);
        }
    }

    boolean contains(Product product, int count) {
        if (productsInWarehouse.containsKey(product)) {
            return productsInWarehouse.get(product) >= count;
        }
        else return false;
    }

    int getCountOfProduct(Product product) {
        return productsInWarehouse.get(product);
    }
}
