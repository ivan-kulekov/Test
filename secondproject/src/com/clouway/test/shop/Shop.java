package com.clouway.test.shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Shop {
  private int currentQuantity = 0;
  private int productQuantity = 1;
  private List<Double> list = new ArrayList<Double>();
  private List<String> list1 = new ArrayList<String>();

  public int add(String productName, int quantity, double price, int maxQuantity) {
    if (list1.contains(productName)) {
      productQuantity--;
      currentQuantity += quantity;
    } else {
      currentQuantity = quantity;
    }
    if (quantity > maxQuantity | currentQuantity > maxQuantity) {
      throw new AddMoreThanMaxQuantityException();
    }
    list1.add(productName);
    list.add(price);
    return productQuantity++;
  }

  public int sell(String productName, int quantity) {
    if (!list1.contains(productName)) {
      throw new ProductNotFoundException();
    }
    if (quantity > currentQuantity) {
      throw new SellMoreThanMinQuantityException();
    }

    return currentQuantity -= quantity;
  }

  public double sort() {
    Collections.sort(list);
    return list.get(productQuantity - 2);
  }
}
