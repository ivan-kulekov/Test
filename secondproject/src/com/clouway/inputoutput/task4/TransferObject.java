package com.clouway.inputoutput.task4;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class TransferObject {
  public int transfer(InputStream in, OutputStream out, int numberOfBytes, int offset) throws IOException {
    FileReader fileReader = null;
    StringBuilder stringBuilder = new StringBuilder();
    StringBuilder stringBuilder1 = new StringBuilder();
    int c;
    int length = 0;
    int a = numberOfBytes* 3;
    while ((c = in.read()) != -1) {
      //out.write(c);
      stringBuilder.append(c);
      //stringBuilder1.append(c);
      out.write(Integer.parseInt(String.valueOf(stringBuilder)));
      stringBuilder.setLength(0);
      //stringBuilder.delete(offset, a);
      System.out.println(stringBuilder.toString());
      length++;
      System.out.println(c);

    }
    System.out.println("The transferred bytes are: " + length * 2);

    return length;
  }

}
