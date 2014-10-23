package com.clouway.task2;

import com.clouway.InvalidInputException;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by clouway on 14-9-10.
 */
public class Sumator {
  public int sum(int a, int b) {
    return a + b;
  }

  public double sum(double a, double b) {
    return a + b;
  }

  public String sum(String a, String b) {
    if(a == "" | b == ""){
      throw new IllegalArgumentException();
    }
    try {
      int x = Integer.parseInt(a);
      int y = Integer.parseInt(b);
      int sum = x + y;
      return Integer.toString(sum);
    }catch (NumberFormatException e){
      throw new InvalidInputException();
    }
  }

  public BigInteger sum(BigInteger a, BigInteger b) {

    return a.add(b);

  }

  public BigDecimal sum(BigDecimal a, BigDecimal b) {

    return a.add(b);
  }
}
