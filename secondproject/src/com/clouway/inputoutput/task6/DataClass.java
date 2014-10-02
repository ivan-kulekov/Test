package com.clouway.inputoutput.task6;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class DataClass {
  public void saveObject(OutputStream out, Object o) throws IOException {
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
    objectOutputStream.writeObject(o);

  }


  public Object getObject(InputStream in) throws ClassNotFoundException, IOException {
    ObjectInputStream objectInputStream = new ObjectInputStream(in);
    return objectInputStream.readObject();

  }
}
