package com.clouway.exception2;

import java.util.Scanner;

/**
 * Created by clouway on 14-9-23.
 */
public class Read {
  public void numberRead() throws IncorrectNumberException {
    Scanner scnr = new Scanner(System.in);
    int a = scnr.nextInt();
    if (a < 0 | a > 100) {
      throw new IncorrectNumberException();
    }
    System.out.println("The number: " + a + " is between 0 and 100");

  }
}
