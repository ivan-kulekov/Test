package com.clouway.store.mockservice;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Person {
  private final String name;
  private final String age;

  public Person(String name, String age) {
    this.name = name;
    this.age = age;
  }

  public int getAge() {
    return Integer.parseInt(age);
  }
}
