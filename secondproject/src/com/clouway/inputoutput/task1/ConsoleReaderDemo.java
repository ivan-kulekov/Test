package com.clouway.inputoutput.task1;

import java.util.InputMismatchException;

/**
 * Created by clouway on 14-9-26.
 */
public class ConsoleReaderDemo {
  public static void main(String[] args) {
    ConsoleReader reader = new ConsoleReader();

    System.out.print("Type string: ");
    String s = reader.readString();
    System.out.println(s);

    try {
      System.out.print("Type int: ");
      int i = reader.readInt();
      System.out.println(i);

    } catch (InputMismatchException e) {
      System.out.println(e.toString());
    }

    System.out.print("Type char: ");
    char c = reader.readChar();
    System.out.println(c);

    try {
      System.out.print("Type float: ");
      float f = reader.readFloat();
      System.out.println(f);
    } catch (InputMismatchException e) {
      System.out.println(e.toString());
    }
  }
}
