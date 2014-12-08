package com.clouway.store.threads.thread4;



/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ThreadMain {
  public static void main(String[] args) {

    ObjectContainer objectContainer = new ObjectContainer(10);

    Thread addElements = new Thread(new AddElements(objectContainer, 15));
    Thread removeElements = new Thread(new RemoveElements(objectContainer, 7));

    addElements.start();
    removeElements.start();
  }
}
