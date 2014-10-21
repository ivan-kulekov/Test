package com.clouway.task2.ht;

/**
 * Created by clouway on 14-9-17.
 */
public class Dog implements Comparable<Dog> {
  private String name;
  private int age;

  public Dog(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  @Override
  public int compareTo(Dog o) {
    int equality = name.compareTo(o.getName());
    if(equality == 0){
      return new Integer(age).compareTo(o.getAge());
    }
    return equality;

  }

  @Override
  public String toString() {
    return "Dog{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
  }
}
