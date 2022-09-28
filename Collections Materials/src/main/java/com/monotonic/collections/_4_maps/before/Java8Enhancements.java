package com.monotonic.collections._4_maps.before;

import java.util.HashMap;
import java.util.Map;

public class Java8Enhancements {
    public static void main(String[] args) {
        Product defaultProd = new Product(
                -1, "Whatever the customer wants", 100);

        Map<Integer, Product> idToProduct = new HashMap<>();
        idToProduct.put(1, ProductFixtures.door);
        idToProduct.put(2, ProductFixtures.floorPanel);
        idToProduct.put(3, ProductFixtures.window);

        //setting the default if unable to get id
        Product product = idToProduct.getOrDefault(4, defaultProd);
        System.out.println(product);
        System.out.println(idToProduct.get(4));

        //replacing one item
        Product oldValue = idToProduct.replace(1, new Product(1, "Big Door", 50));
        System.out.println(oldValue);
        System.out.println(idToProduct.get(1));

        //replacing all items
        idToProduct.replaceAll((id, prod) ->
                new Product(id, prod.getName(), prod.getWeight() + 10));
        System.out.println(idToProduct);

        //compute if absent function
        idToProduct.computeIfAbsent(4,
                id -> new Product(id, "Door Handle", 5));
        System.out.println(product);
        System.out.println(idToProduct.get(4));
        
        //forEach method
        idToProduct.forEach((id, prod) -> {
            System.out.println(prod.getName() + " has an id of " + id);
        });
    }
}
