package com.clouway.task2.ht;

/**
 * Created by clouway on 14-9-17.
 */
public class Node {
  Node left;
  Node right;
  Comparable value;

  public Node(Comparable n) {
    left = null;
    right = null;
    value = n;
  }

  @Override
  public String toString() {
    return "Node{" +
            "value=" + value +
            '}';
  }

  public Node getLeft() {
    return left;
  }

  public Node getRight() {
    return right;
  }

  public Object getValue() {
    return value;
  }
}
