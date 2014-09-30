package com.clouway.inputoutput.task4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class TransferObject {
  public int transfer(InputStream in, OutputStream out, int numberOfBytes, int offset) throws IOException {
    int i=10;
    byte[] bytes = new byte[i];

    //int length = 0;
    int total = 0;
    in.skip(offset);

    int readBytes;
    while ((readBytes = in.read(bytes)) != -1) {

      //   length += bytes.length;
      total += readBytes;
      //System.out.println("c: " + readBytes);
      // System.out.println("len" + length);

//      if (numberOfBytes < length && numberOfBytes != -1) {
//        int number = numberOfBytes % i;
//        out.write(bytes, 0, number);
//        total -= readBytes % number;
//        if(numberOfBytes < i){
//          total = numberOfBytes;
//        }
//        break;
//      }

      if (numberOfBytes < readBytes) {
        out.write(bytes, 0, numberOfBytes);
        break;
      }
//      if (readBytes < bytes.length) {
//        out.write(bytes, 0, readBytes);
//        continue;
//      }
      out.write(bytes, 0, readBytes);
    }
    System.out.println(total);
    return total;
  }
}
