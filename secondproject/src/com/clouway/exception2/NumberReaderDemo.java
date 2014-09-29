package com.clouway.exception2;

/**
 * Created by clouway on 14-9-23.
 */
public class NumberReaderDemo {
  public static void main(String[] args) {
    System.out.println("Type a number between 0 and 100");
    NumberReader read = new NumberReader();
    try {
      int a = read.readNumber();

      System.out.println("The number is correct!: " + a);

    } catch (IncorrectNumberException e) {
      System.out.println(e.toString());

    }
  }
}
