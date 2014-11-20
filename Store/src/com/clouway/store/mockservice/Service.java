package com.clouway.store.mockservice;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Service {
  private final Validator validator;
  private final DataBase dataBase;

  public Service(Validator validator, DataBase dataBase) {

    this.validator = validator;
    this.dataBase = dataBase;
  }

  public void addUser(Person user) {
    if (validator.isValid(user)){
      dataBase.addToDb(user);
    }
  }

  public boolean getUser(Person user) {
    int age = dataBase.getUserAge(user);
    return validator.isAdult(age);
  }
}
