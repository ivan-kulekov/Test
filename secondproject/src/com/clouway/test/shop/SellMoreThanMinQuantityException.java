package com.clouway.test.shop;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class SellMoreThanMinQuantityException extends RuntimeException {
  public SellMoreThanMinQuantityException(){
    super("Can't sell more than you have!");
  }
}
