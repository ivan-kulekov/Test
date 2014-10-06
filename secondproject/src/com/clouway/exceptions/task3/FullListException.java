package com.clouway.exceptions.task3;

/**
 * Created by clouway on 14-9-24.
 */
public class FullListException extends Exception {
  public FullListException() {
    super("The List is full!");
  }
}
