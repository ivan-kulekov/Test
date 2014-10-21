package com.clouway.task1;

import java.util.Random;

/**
 * Created by clouway on 14-9-10.
 */
public class Array {
  private static final int SMALL_A = 97;
  private static final int OFFSET_TO_Z = 25;

  public int GCD(int a, int b) {
    int c;
    do {
      if (a < b) {
        c = a;
        a = b;
        b = c;
      }
      a = a - b;
    } while (a != b);

    return a;

  }

  public int LCM(int a, int b) {
    return a * (b / GCD(a, b));
  }

  public int getMinElement(int[] array) {
    int minElement = array[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] < minElement) {
        minElement = array[i];
      }
    }
    return minElement;

  }

  public int getSum(int[] array) {
    int sum = 0;
    for (int i : array) {
      sum += i;

    }
    return sum;

  }

  public void printArray(int[] array) {
    System.out.print("The array is: ");
    for (int i : array) {
      System.out.print(i + " ");
    }

  }


  public void sort(int[] array) {

    int low = 0;
    int high = array.length - 1;

    sort(array, low, high);


  }

  public void reverseArray(int[] array) {
    for (int i = 0; i < array.length / 2; i++) {
      int temp = array[i];
      array[i] = array[array.length - 1 - i];
      array[array.length - 1 - i] = temp;

    }

  }

  public String generateString(int size) {


    StringBuilder sb = new StringBuilder();
    Random rnd = new Random();

    for (int i = 0; i < size; i++) {

      int code = SMALL_A;
      code += rnd.nextInt(OFFSET_TO_Z);
      sb.append((char) code);
    }


    String output = sb.toString();


    return output;
  }

  private void sort(int[] array, int low, int high) {
    if (array == null || array.length == 0)
      return;
    if (low >= high)
      return;
    int middle = low + (high - low) / 2;
    int pivot = array[middle];
    int i = low;
    int j = high;
    while (i <= j) {
      while (array[i] < pivot) {
        i++;
      }
      while (array[j] > pivot) {
        j--;
      }
      if (i <= j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        i++;
        j--;
      }
    }
    if (low < j)
      sort(array, low, j);
    if (high > i)
      sort(array, i, high);
  }


}


