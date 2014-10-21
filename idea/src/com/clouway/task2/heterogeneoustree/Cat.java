package com.clouway.task2.heterogeneoustree;

/**
 * Created by clouway on 14-9-16.
 */
public class Cat extends Mammal {
  public Cat(String name) {
    super(name);
  }

  public String toString() {
    return String.format(this.getName());
  }
}
