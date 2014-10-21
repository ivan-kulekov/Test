package com.clouway.task2;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by clouway on 14-9-10.
 */
public class SumatorMain {
  public static void main(String[] args) {
    Sumator sumator = new Sumator();
    int a = sumator.sum(3, 4);
    System.out.println("The sum of integer numbers is:  " + a);

    double b = sumator.sum(6.5, 1.6);
    System.out.println("The sum of double numbers is: " + b);

    String c = sumator.sum("75", "7");
    System.out.println("The sum of String numbers is: " + c);

    BigInteger d = sumator.sum(new BigInteger("1515648"), new BigInteger("456123187"));
    System.out.println("The sum of Biginteger numbers is: " + d);

    BigDecimal z = sumator.sum(new BigDecimal("123.21"), new BigDecimal("23658.1236"));
    System.out.println("The sum of Bigdecimal numbers is: " + z);
  }

}
