package com.clouway.task2.tree;

/**
 * Created by clouway on 14-9-15.
 */
public class Tree {
  private Node root;

  public void insert(int key) {
    root = insert(root, key);
  }

  public void print() {
    print(root);
  }

  public boolean search(int val) {
    return search(root, val);
  }

  private Node insert(Node node, int data) {
    if (node == null) {
      return new Node(data);
    } else {
      if (data < node.getValue()) {
        node.left = insert(node.left, data);
      } else if (data > node.getValue()) {
        node.right = insert(node.right, data);
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

  private boolean search(Node node, int value) {
    if (node == null) {
      return false;
    }
    if (node.getValue() > value) {
      return search(node.left, value);
    }
    if (node.getValue() < value){
      return search(node.right, value);
    }

      return true;
  }

}