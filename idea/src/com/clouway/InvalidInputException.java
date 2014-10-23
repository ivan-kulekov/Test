package com.clouway;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class InvalidInputException extends RuntimeException {
  public InvalidInputException() {
    super("Please enter valid input data!");
  }
}
