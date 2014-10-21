package com.clouway.task2.heterogeneoustree;

/**
 * Created by clouway on 14-9-16.
 */
public class Person implements Comparable<Person> {
  String name;
  int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Person person = (Person) o;

    if (age != person.age) return false;
    if (!name.equals(person.name)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + age;
    return result;
  }

  @Override
  public int compareTo(Person o) {
    return name.compareTo(o.getName());
  }

  public String getName() {
    return name;
  }
}
