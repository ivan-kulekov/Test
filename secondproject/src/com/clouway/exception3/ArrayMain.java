package com.clouway.exception3;

/**
 * Created by clouway on 14-9-23.
 */
public class ArrayMain {
  public static void main(String[] args) throws FullListException, EmptyListException {
    Array array = new Array(4);
    Person person = new Person(3);
    Person person1 = new Person(6);
    Person person2 = new Person(8);
    Person person3 = new Person(12);
      array.add(person);
      array.add(person1);
      array.add(person2);
      //array.add(person3);
    array.printAllElements();
      array.remove();
      array.remove();
      array.remove();
      //array.remove();
      //array.remove();
    array.printAllElements();

  }

}
