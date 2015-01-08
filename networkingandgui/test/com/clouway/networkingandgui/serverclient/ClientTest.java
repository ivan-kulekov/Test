package com.clouway.networkingandgui.serverclient;

import com.clouway.networkingandgui.serverclient.view.Display;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ClientTest {
  private FakeServer server;
  private Client client;

  class FakeServer {
    private ServerSocket serverSocket;
    private boolean isStarted = false;

    public void startServer(final int port) {
      isStarted = true;
      new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            serverSocket = new ServerSocket(port);
            while (isStarted) {
              Socket clientSocket = serverSocket.accept();
              PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
              out.println("Hello " + clientSocket.getInetAddress());
              out.flush();
            }
          } catch (IOException e) {
          }
        }
      }).start();
    }

    public void stopServer() {
      isStarted = false;
      try {
        if (serverSocket != null) {
          serverSocket.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  public Synchroniser synchroniser = new Synchroniser();
  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery() {{
    setThreadingPolicy(synchroniser);
  }};
  @Mock
  Display display;

  @Before
  public void setUp() {
    server = new FakeServer();
    client = new Client(display);
    server.startServer(4444);
  }

  @Test
  public void connectClientToServer() throws Exception {
    context.checking(new Expectations() {{
      oneOf(display).show("Hello /127.0.0.1");
    }});
    client.connectClient("localhost", 4444);
    Thread.sleep(20);
    server.stopServer();
  }

  @Test
  public void connectTwoClients() throws Exception{
    context.checking(new Expectations() {{
      oneOf(display).show("Hello /127.0.0.1");
      oneOf(display).show("Hello /127.0.0.1");
    }});
    client.connectClient("localhost", 4444);
    client.connectClient("localhost", 4444);
      Thread.sleep(20);
    server.stopServer();
  }

}
