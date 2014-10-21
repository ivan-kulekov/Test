package com.clouway.task2;

import javax.management.BadStringOperationException;
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
      int x = Integer.parseInt(a);
      int y = Integer.parseInt(b);
      int sum = x + y;
      return Integer.toString(sum);
  }

  public BigInteger sum(BigInteger a, BigInteger b) {
    BigInteger sum = a.add(b);

    return sum;

  }

  public BigDecimal sum(BigDecimal a, BigDecimal b) {
    BigDecimal sum = a.add(b);

    return sum;
  }
}
