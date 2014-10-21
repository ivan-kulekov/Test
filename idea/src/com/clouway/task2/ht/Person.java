package com.clouway.task2.ht;

/**
 * Created by clouway on 14-9-17.
 */
public class Person implements Comparable<Person> {
  private String name;
  private int age;

  public Person(String name, int age) {
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
  public int compareTo(Person o) {
    int equality = name.compareTo(o.getName());
    if(equality == 0){
      return new Integer(age).compareTo(o.getAge());
    }
    return equality;
  }

  @Override
  public String toString() {
    return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
  }
}
