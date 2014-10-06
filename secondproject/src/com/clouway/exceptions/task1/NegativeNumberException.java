package com.clouway.exceptions.task1;

/**
 * Created by clouway on 14-9-23.
 */
public class NegativeNumberException extends Exception {
  public NegativeNumberException() {
    super("The numbers must be positive!");
  }

}
