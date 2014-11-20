package com.clouway.store.mockservice;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public interface DataBase {
  void addToDb(Person user);

  int getUserAge(Person user);
}
