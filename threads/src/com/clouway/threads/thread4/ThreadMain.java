package com.clouway.threads.thread4;



/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ThreadMain {
  public static void main(String[] args) {
    int listSize = 10;
    ObjectContainer objectContainer = new ObjectContainer(listSize);

    Thread addElements = new Thread(new AddElements(objectContainer, 200));
    Thread removeElements = new Thread(new RemoveElements(objectContainer, 15));

    addElements.start();
    removeElements.start();
  }
}
