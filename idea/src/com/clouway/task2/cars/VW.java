package com.clouway.task2.cars;

/**
 * Created by clouway on 14-9-11.
 */
public class VW extends Car {

  public VW(int maxspeed, String color, int date) {
    super(maxspeed, color, date);

  }

  public String toString() {
    return String.format("VW max speed is: %d , color is: %s , and createdate is: %d",
            this.getMaxSpeed(), this.getColor(), this.getDate());

  }
}
