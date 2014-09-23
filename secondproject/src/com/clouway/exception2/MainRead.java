package com.clouway.exception2;

/**
 * Created by clouway on 14-9-23.
 */
public class MainRead {
  public static void main(String[] args) throws IncorrectNumberException {
    Read read = new Read();
    try {
      read.numberRead();
    } catch (IncorrectNumberException e) {
      System.out.println(e.toString());

    }
  }
}
