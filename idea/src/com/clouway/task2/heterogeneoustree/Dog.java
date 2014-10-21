package com.clouway.task2.heterogeneoustree;

/**
 * Created by clouway on 14-9-16.
 */
public class Dog extends Mammal {
  public Dog(String name) {
    super(name);
  }

  public String toString() {
    return String.format(this.getName());

  }
}
