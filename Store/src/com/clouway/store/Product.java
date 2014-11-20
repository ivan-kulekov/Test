package com.clouway.store;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Product implements Comparable<Product>{
  private final String name;
  private final int maxQuantity;
  private final double price;

  public Product(String name, int maxQuantity, double price) {

    this.name = name;
    this.maxQuantity = maxQuantity;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public int getMaxQuantity() {
    return maxQuantity;
  }

  public double getPrice() {
    return price;
  }

  @Override
  public int compareTo(Product o) {
    if (price > o.getPrice()){
      return 1;
    }
    if (price < o.getPrice()){
      return -1;
    }
    return 0;
  }
}
