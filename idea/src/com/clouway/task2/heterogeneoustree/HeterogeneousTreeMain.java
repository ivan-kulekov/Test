package com.clouway.task2.heterogeneoustree;

/**
 * Created by clouway on 14-9-16.
 */
public class HeterogeneousTreeMain {
  public static void main(String[] args) {
    Tree tree = new Tree();

    Person person = new Person("Valentin", 15);
    tree.insert(person);

    Dog dog = new Dog("Bolt");
    //tree.insert(dog);

    Cat cat = new Cat("Kitty");
    //tree.insert(cat);

    tree.print();
  }
}
