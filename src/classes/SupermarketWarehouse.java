package classes;


class SupermarketWarehouse extends Warehouse {
    int size() {
        return getProductList().size();
    }
}
