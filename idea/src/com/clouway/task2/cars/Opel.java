package com.clouway.task2.cars;

/**
 * Created by clouway on 14-9-11.
 */
public class Opel extends Car {
  private int weight;
  private int passengers;

  public Opel(int maxspeed, String color, int date, int weight, int passengers) {
    super(maxspeed, color, date);
    this.passengers = passengers;
    this.weight = weight;
  }

  public int getWeight() {
    return weight;
  }

  public int getPassengers() {
    return passengers;
  }

  public String toString() {
    return String.format("Opel max speed is: %d , color is: %s , and createdate is: %d , weight is: %d , passengers: %d",
            this.getMaxSpeed(), this.getColor(), this.getDate(), this.getWeight(), this.getPassengers());

  }
}
