package com.clouway.task2.ht;


/**
 * Created by clouway on 14-9-17.
 */
public class Mainht {
  public static void main(String[] args) {
    Tree tree = new Tree();
    Person person = new Person("Andrei", 5);
    Person person1 = new Person("Andrei", 20);
    Person person2 = new Person("Nikolai", 26);
    Person person3 = new Person("Zlatan", 78);
    Person person5 = new Person("Angel", 12);
    Dog dog = new Dog("Sharo", 5);
    Dog dog1 = new Dog("Asd", 6);
    Cat cat = new Cat("Kitty", 5);
    tree.insert(person);
    tree.insert(person1);
    tree.insert(person2);
    tree.insert(person3);
    tree.insert(person5);
    //tree.insert(dog);
    //tree.insert(dog1);
    //tree.insert(cat);
    tree.print();
    System.out.print("The searching object is found: " + tree.search(person5));
  }
}
