package com.clouway.exception3;

/**
 * Created by clouway on 14-9-23.
 */
public class Person {
  int age;

  public Person(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" +
            "age=" + age +
            '}';
  }
}
