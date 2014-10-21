package com.clouway.task2.cars;

/**
 * Created by clouway on 14-9-11.
 */
public class Car {
  public int maxSpeed;
  public String color;
  public int date;

  public Car(int maxSpeed, String color, int date) {
    this.maxSpeed = maxSpeed;
    this.color = color;
    this.date = date;
  }

  public int getMaxSpeed() {
    return maxSpeed;
  }

  public String getColor() {
    return color;
  }

  public int getDate() {
    return date;
  }

}
