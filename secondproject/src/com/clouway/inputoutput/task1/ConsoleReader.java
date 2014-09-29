package com.clouway.inputoutput.task1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by clouway on 14-9-26.
 */
public class ConsoleReader {
  private Scanner scanner = new Scanner(System.in);

  public String readString() {
    return scanner.next();
  }

  public int readInt() throws InputMismatchException {
    scanner.nextLine();
    return scanner.nextInt();
  }

  public char readChar() {
    scanner.nextLine();
    return scanner.next().charAt(0);
  }

  public float readFloat() throws InputMismatchException {
    scanner.nextLine();
    return scanner.nextFloat();
  }


}
