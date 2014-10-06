package com.clouway.exceptions.task2;

/**
 * Created by clouway on 14-9-23.
 */
public class IncorrectNumberException extends Exception {
  public IncorrectNumberException() {
    super("The number must be between 0 and 100!");
  }

}
