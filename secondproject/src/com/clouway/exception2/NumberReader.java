package com.clouway.exception2;

import java.util.Scanner;

/**
 * Created by clouway on 14-9-23.
 */
public class NumberReader {

  private Scanner scanner = new Scanner(System.in);
  int a = scanner.nextInt();

  public int readNumber() throws IncorrectNumberException {

    if (a < 0 | a > 100) {
      throw new IncorrectNumberException();
    }
    return a;
  }
}
