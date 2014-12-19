package com.clouway.networkingandgui.server_client;

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
  private boolean stop;
  private Client client;
  private final Object lock = new Object();

  public Server(Client client) {

  }

  public void startServer(final int port) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date date = new Date();

        try {
          ServerSocket serverSocket = new ServerSocket(port);
          stop = false;
          Socket clientSocket = serverSocket.accept();
          BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
          PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
          out.println("Hello. The server's date is: " + dateFormat.format(date));
          System.out.println(in.readLine());
          synchronized (lock) {
            while (!stop) {
              try {
                lock.wait();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
          }
          System.out.println("message");
          out.println("the server is down!");
          clientSocket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }).start();

  }

  public void stopServer() {
    synchronized (lock) {
      stop = true;
      lock.notifyAll();
    }
  }
}
