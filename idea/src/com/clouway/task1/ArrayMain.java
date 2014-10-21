package com.clouway.task1;

/**
 * Created by clouway on 14-9-10.
 */
public class ArrayMain {
  public static void main(String[] args) {


    Array ar = new Array();
    int[] array = {1, 2, 3, 4, 10, 5, 8};
    int a = ar.GCD(2, 4);
    System.out.println("\nThe GCD is:  " + a);

    int b = ar.LCM(7, 3);
    System.out.println("The LCM is:  " + b);

    int min = ar.getMinElement(array);
    System.out.println("Minimum element is:  " + min);

    int sum = ar.getSum(array);
    System.out.println("The sum is: " + sum);

    ar.printArray(array);

    ar.sort(array);
    System.out.print("\nAfter Quick sort ");

    ar.printArray(array);

    ar.reverseArray(array);
    System.out.println();

    ar.printArray(array);
    System.out.print(" after reverse");

    String sg = ar.generateString(20);
    System.out.println("\nThe String with variable length is: " + sg);


  }

}