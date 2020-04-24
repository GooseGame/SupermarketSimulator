package classes;

import java.util.ArrayList;
import java.util.Map;

public class GenerateProducts {
    private Map<Product, Integer> result = null;

    public GenerateProducts(SupermarketWarehouse warehouse) {
        ArrayList products = generateNamesAndCounts();
        int count;
        for (int i = 0; i < products.size(); i++) {
            count = new RandomNum(new Data().getGenerateProductsLimit()).getSeed();
            warehouse.addProduct(new Product((String) products.get(i)), count);
        }
    }

    private ArrayList<String> generateNamesAndCounts() {
        ArrayList<String> products = new ArrayList<>();
        int rand;
        Products productNames = new Products();
        String name;

        for (int i = 0; i < new Data().getGenerateProductIteration(); i++) {
            rand = new RandomNum(productNames.getSize()).getSeed();
            name = productNames.getName(rand);

            if (!products.contains(name)){
                products.add(name);
            }
        }
        return products;
    }

}
