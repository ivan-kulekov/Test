package com.clouway;

/**
 * Created by clouway on 14-9-23.
 */
public class StringSummator {
  public String sum(String a, String b) throws NegativeNumberException {
    int x = Integer.parseInt(a);
    int y = Integer.parseInt(b);

    if (x < 0 | y < 0) {
      throw new NegativeNumberException();
    }

    int sum = x + y;

    return Integer.toString(sum);
  }
}