package com.clouway.store.threads.thread4;



/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ThreadMain {
  public static void main(String[] args) {
    ObjectContainer objectContainer = new ObjectContainer(10);
    AddElementsThread thread1 = new AddElementsThread(objectContainer, 15);
    AddElementsThread thread2 = new AddElementsThread(objectContainer, 5);
    RemoveElementsThread thread3 = new RemoveElementsThread(objectContainer, 7);

    thread1.start();
//    thread2.start();
//    thread3.start();
  }
}
