package com.clouway.test.shop;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Product {
  private double price;
  private int quantity;
  private int maxQuantity;

  public Product(double price, int quantity, int maxQuantity) {
    this.price = price;
    this.quantity = quantity;
    this.maxQuantity = maxQuantity;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public int getMaxQuantity() {
    return maxQuantity;
  }
}
