package com.clouway;

/**
 * Created by clouway on 14-9-23.
 */
public class StringSum {
  public String sum(String a, String b) throws NumberFormatException, NegativeNumberException {

      int x = Integer.parseInt(a);
      int y = Integer.parseInt(b);
      int sum = x + y;
      if (x < 0 | y < 0) {
        throw new NegativeNumberException();
      }

      return Integer.toString(sum);

    //} //catch (NumberFormatException e) {
      //System.out.println(e.toString());
      //return "invalid input!";
    //}

  }
}