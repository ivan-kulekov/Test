package com.clouway;

/**
 * Created by clouway on 14-9-23.
 */
public class NegativeNumberException extends Exception {
  public NegativeNumberException() {
    super("The number must be positive!");
  }

}
