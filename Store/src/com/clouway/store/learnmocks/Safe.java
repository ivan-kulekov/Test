package com.clouway.store.learnmocks;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Safe {
  private final FingerScanner fingerScanner;
  private final DataBase dataBase;
  private boolean openDoor = false;

  public Safe(FingerScanner fingerScanner, DataBase dataBase) {

    this.fingerScanner = fingerScanner;
    this.dataBase = dataBase;
  }

  public void checkPerson(Person person) {
    int biometricData = fingerScanner.scanFinger(person);
    if (dataBase.checkInDb(biometricData)){
      openDoor = true;
    }
  }

  public boolean openDoor() {
    return openDoor;
  }
}
