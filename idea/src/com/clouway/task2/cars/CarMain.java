package com.clouway.task2.cars;

/**
 * Created by clouway on 14-9-11.
 */
public class CarMain {
  public static void main(String[] args) {
    Mercedes car = new Mercedes(221, "black", 1990);
    System.out.println(car);
    VW car1 = new VW(173, "red", 2000);
    System.out.println(car1);
    Opel car2 = new Opel(200, "blue", 2003, 900, 5);
    System.out.println(car2);

  }

}
