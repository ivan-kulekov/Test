package com.clouway.store.sockets;

import java.io.IOException;
import java.net.Socket;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class qwer {
  public static void main(String[] args) {
    try {
      Socket socket= new Socket("172.16.188.17",8080);
      System.out.println("_____" +socket.getLocalAddress()+" "+socket.getLocalPort());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
