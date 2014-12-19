package com.clouway.networkingandgui.server_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Client {

  public void connectClient(String localhost, int port) {
    try {

      Socket socket = new Socket(localhost, port);
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      System.out.println(in.readLine());
      out.println("The client has been connected.");
      System.out.println("client");
      System.out.println(in.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
