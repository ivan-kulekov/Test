package com.clouway.store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Store {
  private Map<String, Integer> nameToQuantity = new HashMap<String, Integer>();
  private Map<String, Product> inventoryProducts = new HashMap<String, Product>();
  private List<Product> priceList = new ArrayList<Product>();

  public void addQuantity(String name, int quantity) {
    if (!inventoryProducts.containsKey(name)){
      throw new ProductNotFoundException();
    }
    if (quantity > inventoryProducts.get(name).getMaxQuantity()){
      throw new AddMoreThanMaxQuantityException();
    }
    nameToQuantity.put(name, quantity);
  }

  public int sell(String name, int quantity) {
    if (!inventoryProducts.containsKey(name)){
      throw new ProductNotFoundException();
    }
    if (quantity > nameToQuantity.get(name)){
      throw new QuantityExceedException();
    }
    return nameToQuantity.get(name) - quantity;
  }

  public void addToInventory(Product product) {
    priceList.add(product);
    inventoryProducts.put(product.getName(), product);
  }

  public List<Product> sort() {
    List<Product> sortedProductsByPrice = new ArrayList<Product>(priceList);
    Collections.sort(sortedProductsByPrice);
    return sortedProductsByPrice;
  }
}
