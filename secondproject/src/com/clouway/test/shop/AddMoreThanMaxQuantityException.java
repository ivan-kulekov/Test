package com.clouway.test.shop;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class AddMoreThanMaxQuantityException extends RuntimeException {
  public AddMoreThanMaxQuantityException(){
    super("You can't add more than max quantity!");
  }
}
