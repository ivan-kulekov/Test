package com.clouway.store.threads.thread5;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class TimeoutRemoverMain {
  public static void main(String[] args) {
    TimeoutHashTable timeoutHashTable = new TimeoutHashTable(2);
    Person person = new Person();
    Person person1 = new Person();

    timeoutHashTable.put("Ivan", person);
    System.out.println(person + " person");
    System.out.println(person1 + " person1");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    timeoutHashTable.get("Ivan");
    System.out.println("==========");

    try {
      Thread.sleep(1900);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    timeoutHashTable.get("Ivan");

//    try {
//      Thread.sleep(1900);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    timeoutHashTable.put("Iva", person);
  }
}
