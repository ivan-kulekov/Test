package com.clouway.inputoutput.Task6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class DataClassMain {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    String file = "text6.ser";
    FileInputStream fileInputStream = new FileInputStream(file);
    FileOutputStream fileOutputStream = new FileOutputStream(file);
    Person person = new Person("Petar", 25);
    DataClass dataClass = new DataClass();
    dataClass.saveObject(fileOutputStream, person);
    Object o = dataClass.getObject(fileInputStream);
    System.out.println(o);
    fileOutputStream.close();
    fileInputStream.close();
  }
}
