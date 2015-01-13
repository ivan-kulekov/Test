package com.clouway.networkingandgui.serverclientguava;

import com.google.common.util.concurrent.AbstractExecutionThreadService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Client extends AbstractExecutionThreadService {
  private final Display display;
  private final String localhost;
  private final int port;

  public Client(Display display, String localhost, int port) {

    this.display = display;
    this.localhost = localhost;
    this.port = port;
  }

  @Override
  protected void run() throws Exception {
    Socket socket = new Socket(localhost, port);
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    display.show(in.readLine());
  }
}
