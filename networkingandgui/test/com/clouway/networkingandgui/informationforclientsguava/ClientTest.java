package com.clouway.networkingandgui.informationforclientsguava;

import com.google.common.util.concurrent.AbstractExecutionThreadService;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ClientTest {
  private Synchroniser synchroniser = new Synchroniser();
  private FakeServer fakeServer;
  private Client client;
  private Display display;

  private class FakeServer extends AbstractExecutionThreadService {
    private final int port;
    private ServerSocket serverSocket;
    private List<Socket> clientList = new ArrayList<Socket>();

    public FakeServer(int port) {

      this.port = port;
    }

    public List<Socket> getClientList() {
      return clientList;
    }

    @Override
    protected void run() {
      int clientCounter = 0;
      try {
        serverSocket = new ServerSocket(port);
        while (isRunning()) {
          clientCounter++;
          Socket clientSocket = serverSocket.accept();
          PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
          clientList.add(clientSocket);
          out.println("Your client number is: " + clientCounter);
          if (clientList.size() > 1) {
            out.println("Client with number: " + clientCounter + " has been connected");
          }
        }
      } catch (IOException e) {
//          e.printStackTrace();
      }

    }

    @Override
    protected void shutDown() throws Exception {
      if (serverSocket != null) {
        serverSocket.close();
      }
      super.shutDown();
    }
  }

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery() {{
    setThreadingPolicy(synchroniser);
  }};

  @Before
  public void setUp() throws Exception {
    display = context.mock(Display.class);
    fakeServer = new FakeServer(4441);
    List<Socket> clientList = fakeServer.getClientList();
    client = new Client(display, "localhost", 4441, clientList);
    fakeServer.startAsync();
    fakeServer.awaitRunning();
  }

  @After
  public void tearDown() throws Exception {
    fakeServer.shutDown();
    fakeServer.awaitTerminated();
  }


  @Test
  public void connectClientToServer() throws Exception {
    context.checking(new Expectations() {{
      oneOf(display).show("Your client number is: 1");
    }});
    client.startAsync().awaitTerminated();
  }


  @Test
  public void connectTwoClientsToServer() throws Exception {
    List<Socket> clientList = fakeServer.getClientList();
    Client client1 = new Client(display, "localhost", 4441, clientList);
    context.checking(new Expectations() {{
      oneOf(display).show("Your client number is: 1");
      oneOf(display).show("Client with number: 2 has been connected");
      oneOf(display).show("Your client number is: 2");
    }});
    client.startAsync().awaitTerminated();
    client1.startAsync().awaitTerminated();
  }

  @Test
  public void sendResponseFromServerToClientForAnotherConnectedClient() {
    List<Socket> clientList = fakeServer.getClientList();
    Client client1 = new Client(display, "localhost", 4441, clientList);
    Client client2 = new Client(display, "localhost", 4441, clientList);
    context.checking(new Expectations() {{
      oneOf(display).show("Your client number is: 1");
      oneOf(display).show("Client with number: 2 has been connected");
      oneOf(display).show("Your client number is: 2");
      oneOf(display).show("Client with number: 3 has been connected");
      oneOf(display).show("Your client number is: 3");
    }});
    client.startAsync().awaitTerminated();
    client1.startAsync().awaitTerminated();
    client2.startAsync().awaitTerminated();
  }

}
