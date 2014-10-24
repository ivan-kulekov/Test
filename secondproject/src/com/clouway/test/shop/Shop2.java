package com.clouway.test.shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Shop2 {
  private int currentQuantity;
  private int counter;
  Map<String, Product> products = new HashMap<String, Product>();
  private List<Double> priceList = new ArrayList<Double>();

  public List<Double> getPriceList() {
    return priceList;
  }

  public void addProduct(String name, Product product) {
    if (product.getMaxQuantity() < product.getQuantity()) {
      throw new AddMoreThanMaxQuantityException();
    }
    products.put(name, product);
    currentQuantity = products.get(name).getQuantity();
    priceList.add(products.get(name).getPrice());
  }

  public int sell(String name, int quantity) {
    if (!products.containsKey(name)) {
      throw new ProductNotFoundException();
    }
    if(quantity > currentQuantity){
      throw new SellMoreThanMinQuantityException();
    }
    if (counter > 0) {
      currentQuantity = currentQuantity - quantity;
    } else {
      currentQuantity = products.get(name).getQuantity() - quantity;
    }
    return currentQuantity;
  }

  public int add(String name, int quantity) {

    if (products.containsKey(name)) {
      currentQuantity = products.get(name).getQuantity() + quantity;
    } else {
      throw new ProductNotFoundException();
    }
    int temp = products.get(name).getQuantity() + quantity;
    if(temp > products.get(name).getMaxQuantity()){
      throw new AddMoreThanMaxQuantityException();
    }
    counter++;
    return currentQuantity;
  }

  public List sort() {
    Collections.sort(priceList);
    return priceList;
  }
}
