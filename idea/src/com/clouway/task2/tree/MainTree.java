package com.clouway.task2.tree;

/**
 * Created by clouway on 14-9-15.
 */
public class MainTree {
  public static void main(String[] args) {
    Tree tree = new Tree();
    tree.insert(5);
    tree.insert(4);
    tree.insert(7);
    tree.insert(7);
    tree.insert(2);
    tree.insert(9);
    tree.print();
    System.out.println("The searching number is found: " + tree.search(5));

  }
}
