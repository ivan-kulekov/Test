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
  private final Object lock = new Object();
  private String display;

  public void connectClient(final String localhost, final int port) {

    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Socket socket = new Socket(localhost, port);
//          PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          display = in.readLine();
          System.out.println(display);
//          display = in.readLine();
//          System.out.println(display);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }).start();

  }

  public String getDisplay() {
    return display;
  }
}
