package com.clouway.exception3;

/**
 * Created by clouway on 14-9-23.
 */
public class Array {
  //private int x;
  private int index;
  Object[] array;

  public Array(int x) {
    Object[] array = new Object[x];
    this.array = array;
  }

  public void printAllElements() {

    if (index > 0) {
      for (Object obj : array) {
        if (obj != null) {
          System.out.println(obj.toString());
        }
      }
  }  //else {
//      System.out.println("The array is empty!");
//    }
  }


  public void add(Object obj) throws FullListException {
    if (index == array.length - 1) {
      throw new FullListException();
    }
    array[index] = obj;
    index++;

  }

  public void remove() throws EmptyListException {
    if (index < 1) {
      throw new EmptyListException();

    }
    array[index] = null;
    index--;
  }
}
