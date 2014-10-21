package com.clouway.task2.ht;

import java.util.Comparator;
import java.util.Objects;

/**
 * Created by clouway on 14-9-17.
 */
public class Tree {
  private Node root;

  public void insert(Comparable valueObject) {
    root = insert(root, valueObject);
  }

  public void print() {
    print(root);
  }

  public Node search(Comparable val) {
    return search(root, val);
  }

  private Node insert(Node node, Comparable valueObject) {
    if (node == null) {
      return new Node(valueObject);
    } else {
      if (valueObject.compareTo(node.getValue()) < 0) {
        node.left = insert(node.left, valueObject);
      } else if (valueObject.compareTo(node.getValue()) >= 0) {
        node.right = insert(node.right, valueObject);
      }

      return node;
    }
  }

  private void print(Node r) {
    if (r != null) {
      print(r.getLeft());
      System.out.println(r.getValue() + " ");
      print(r.getRight());


    }
  }

  private Node search(Node node, Comparable value) {
    if (node == null) {
      return null;
    }
    if (value.compareTo(node.getValue()) < 0) {
      return search(node.left, value);
    }
    if (value.compareTo(node.getValue()) > 0) {
      return search(node.right, value);
    }

    return node;
  }
}
