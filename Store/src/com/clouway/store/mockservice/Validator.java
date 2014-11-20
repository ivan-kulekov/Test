package com.clouway.store.mockservice;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public interface Validator {
  boolean isValid(Person user);

  boolean isAdult(int age);
}
