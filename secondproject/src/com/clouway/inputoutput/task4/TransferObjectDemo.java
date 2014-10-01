package com.clouway.inputoutput.task4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class TransferObjectDemo {
  public static void main(String[] args) throws IOException {
    TransferObject transferObject = new TransferObject();
    FileInputStream fileInputStream = new FileInputStream("text4.txt");
    FileOutputStream fileOutputStream = new FileOutputStream("text5.txt");
    int output = transferObject.transfer(fileInputStream, fileOutputStream, -1, 0);
    System.out.println(output + " Bytes are transferred");

  }
}
