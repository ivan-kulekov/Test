package com.clouway.networkingandgui.informationforclientsguava;

import com.google.common.util.concurrent.AbstractExecutionThreadService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Client extends AbstractExecutionThreadService {
  private final Display display;
  private final String host;
  private final int port;
  private final List<Socket> clientList;
  private Socket socket;

  public Client(Display display, String host, int port, List<Socket> clientList) {

    this.display = display;
    this.host = host;
    this.port = port;
    this.clientList = clientList;
  }

  @Override
  protected void run() throws IOException {
    socket = new Socket(host, port);
//      while (isRunning()) {
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    display.show(in.readLine());
    if (clientList.size() > 1){
      display.show(in.readLine());
    }
//        System.out.println(in.readLine());
//        if (in.readLine() == null){
//          System.out.println("asd");
//        }
//      }
  }

  @Override
  protected void shutDown() throws Exception {
    if (socket != null) {
      socket.close();
    }
    super.shutDown();
  }
}
