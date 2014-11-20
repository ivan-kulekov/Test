package com.clouway.store.mockservice;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class RealValidator implements Validator{


  @Override
  public boolean isValid(Person user) {
    return false;
  }

  @Override
  public boolean isAdult(int user) {
    return false;
  }
}
