package com.clouway.inputoutput.task4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class TransferObject {
  private static final int SIZE = 2048;
  public int transfer(InputStream in, OutputStream out, int numberOfBytes, int offset) throws IOException {
    int size;
    if (numberOfBytes >= 0) {
      size = numberOfBytes;
    } else {
      size = SIZE;
    }
    byte[] buffer = new byte[size];
    int total = 0;
    in.skip(offset);
    int readBytes;

    while ((readBytes = in.read(buffer)) != -1) {
      total += readBytes;
      out.write(buffer, 0, readBytes);
      if (numberOfBytes == readBytes) {
        break;
      }
    }
    return total;
  }
}
