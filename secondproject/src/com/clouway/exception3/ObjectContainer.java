package com.clouway.exception3;

/**
 * Created by clouway on 14-9-23.
 */
public class ObjectContainer {
  private int size;
  private Object[] array;

  public ObjectContainer(int length) {
    this.array = new Object[length];
  }

  public void printElements() {
    if (size < 1) {
      System.out.println("The array is empty!");
    }

    for (Object o : array) {
      if (o != null) {
        System.out.println(o);
      }
    }
  }

  public void add(Object obj) throws FullListException {
    if (size == array.length) {
      throw new FullListException();
    }

    array[size++] = obj;
  }

  public void remove() throws EmptyListException {
    if (size < 1) {
      throw new EmptyListException();

    }

    array[--size] = null;
  }
}
