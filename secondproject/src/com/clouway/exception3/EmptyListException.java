package com.clouway.exception3;

/**
 * Created by clouway on 14-9-24.
 */
public class EmptyListException extends Exception {
  public EmptyListException(){
    super("The list is already empty!");
  }
}
