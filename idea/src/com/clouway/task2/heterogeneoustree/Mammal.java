package com.clouway.task2.heterogeneoustree;

/**
 * Created by clouway on 14-9-16.
 */
public class Mammal implements Comparable {
  String name;
  int age;

  public Mammal(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public Mammal(String name) {

  }

  @Override
  public int compareTo(Object o) {
  return 0;
  }

  public String getName() {
    return name;
  }
}
