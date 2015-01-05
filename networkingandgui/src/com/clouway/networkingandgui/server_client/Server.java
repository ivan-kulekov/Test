package com.clouway.networkingandgui.server_client;

import com.clouway.networkingandgui.server_client.view.Display;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Server {
//  private boolean stop;
  private ServerSocket serverSocket;
  private Socket clientSocket;
  private Display display;
  private boolean isStarted = false;

  public Server(Display display) {
    this.display = display;
  }

  public void startServer(final int port) {

    if(isStarted){
      throw new ServerAlreadyStartedException();
    }
    isStarted = true;
    new Thread(new Runnable() {
      @Override
      public void run() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        try {
          serverSocket = new ServerSocket(port);
//          stop = false;
          while (true) {
            clientSocket = serverSocket.accept();
            display.show(clientSocket.getInetAddress().toString());
//            System.out.println(display + "asd");
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Hello. The server's date is: " + dateFormat.format(date));
          }
        } catch (IOException e) {
        }
      }
    }).start();

  }

  public void stopServer() {
//    stop = true;
    try {
//      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//      out.println("The server is stopped!");
      serverSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
