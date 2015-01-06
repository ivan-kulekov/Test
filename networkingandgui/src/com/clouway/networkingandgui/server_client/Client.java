package com.clouway.networkingandgui.server_client;

import com.clouway.networkingandgui.server_client.view.Display;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Client{
  private String currentDisplay;
  private Display display;

  public Client(Display display) {
    this.display = display;
  }

  public void connectClient(final String localhost, final int port) {

    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Socket socket = new Socket(localhost, port);
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          currentDisplay = in.readLine();
          display.show(currentDisplay);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }).start();

  }

  public String getCurrentDisplay() {
    return currentDisplay;
  }
}
