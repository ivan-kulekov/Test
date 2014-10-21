package com.clouway.task2.heterogeneoustree;

/**
 * Created by clouway on 14-9-16.
 */
public class Node {
  Node left;
  Node right;
  String value;


  public Node(String n) {
    left = null;
    right = null;
    value = n;
  }

  public Node(Comparable object) {
    
  }


  public Node getLeft() {
    return left;
  }

  public Node getRight() {
    return right;
  }

  public String getValue() {
    return value;
  }
}

