package com.clouway.task2.tree;

/**
 * Created by clouway on 14-9-15.
 */
public class Node {
  Node left;
  Node right;
  int value;

  public Node(int n) {
    left = null;
    right = null;
    value = n;
  }

  public Node getLeft() {
    return left;
  }

  public Node getRight() {
    return right;
  }

  public int getValue() {
    return value;
  }
}
