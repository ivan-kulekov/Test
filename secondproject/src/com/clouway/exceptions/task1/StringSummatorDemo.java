package com.clouway.exceptions.task1;

/**
 * Created by clouway on 14-9-23.
 */
public class StringSummatorDemo {
  public static void main(String[] args) {
    StringSummator summator = new StringSummator();

    try {
      String s = summator.sum("1", "14");
      System.out.println("The sum of strings is: " + s);
    } catch (NegativeNumberException e) {
      System.out.println(e.toString());
    } catch (NumberFormatException e) {
      System.out.println(e.toString());
    }
  }
}
