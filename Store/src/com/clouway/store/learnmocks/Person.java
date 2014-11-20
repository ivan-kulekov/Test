package com.clouway.store.learnmocks;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Person {
  private final String name;
  private final int biometricData;

  public Person(String name, int biometricData) {

    this.name = name;
    this.biometricData = biometricData;
  }

  public int getBiometricData() {
    return biometricData;
  }
}
