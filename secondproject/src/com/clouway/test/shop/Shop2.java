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

  public void addProduct(String name, Product product) {
    products.put(name, product);
    priceList.add(products.get(name).getPrice());
  }

  public int sell(String name, int quantity) {
    if(!products.containsKey(name)){
      throw new ProductNotFoundException();
    }
    if (counter > 0) {
      currentQuantity = currentQuantity - quantity;
    }else {
      currentQuantity = products.get(name).getQuantity() - quantity;
    }
    return currentQuantity;
  }

  public int add(String name, int quantity) {
    if (products.containsKey(name)) {
      currentQuantity = products.get(name).getQuantity() + quantity;
    }else{
      throw new ProductNotFoundException();
    }

    counter++;
    return currentQuantity;
  }
 
  public List sort() {
    Collections.sort(priceList);
   return priceList;
  }

  public List<Double> getPriceList() {
    return priceList;
  }
}
