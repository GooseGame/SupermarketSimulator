package classes;

import java.util.Set;

class Basket extends Warehouse {
 void productsBackToSW(Supermarket supermarket) {
     for (int i = 0; i < this.getProductList().size(); i++) {
         supermarket.addProduct(this.getProductByCounter(i), this.getCountOfProduct(this.getProductByCounter(i)));
     }
 }
}
