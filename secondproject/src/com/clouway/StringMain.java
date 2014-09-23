package com.clouway;

/**
 * Created by clouway on 14-9-23.
 */
public class StringMain {
  public static void main(String[] args) throws NegativeNumberException {
    StringSum sum = new StringSum();
    try {
      String c = sum.sum("-1", "14");
      System.out.println("The sum of strings is: " + c);
    }catch (NegativeNumberException e){
      System.out.println(e.toString());
    }
    catch (NumberFormatException e){
      System.out.println(e.toString());

    }
  }
}
