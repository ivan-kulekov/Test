package com.clouway.task1;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class InvalidInputException extends RuntimeException {
  public InvalidInputException(){
    super("Please enter valid input data!");
  }
}
