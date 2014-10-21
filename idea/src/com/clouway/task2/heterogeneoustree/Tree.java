package com.clouway.task2.heterogeneoustree;

/**
 * Created by clouway on 14-9-16.
 */
public class Tree {
  private Node root;
  //Comparable valueObject;
  private Object node;


  public void insert(Comparable valueObject) {
   root = insert(root, valueObject);

  }

  public void print() {
    print(root);
  }


  private Node insert(Node node, Comparable valueObject) {

    if (this.node == null) {
      node = new Node(valueObject);

    }
    else {
      if (valueObject.compareTo(node.getValue()) < 0) {
        node.left = insert(node.left, valueObject);
      } else {
        node.right = insert(node.right, valueObject);

      }

    }
    return node;


  }

  private void print(Node r) {
    if (r != null) {
      print(r.getLeft());
      System.out.println(r.getValue() + " ");
      print(r.getRight());


    }
  }

}
