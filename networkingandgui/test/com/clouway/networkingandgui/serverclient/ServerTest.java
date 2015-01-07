package com.clouway.networkingandgui.serverclient;

import com.clouway.networkingandgui.server_client.Server;
import com.clouway.networkingandgui.server_client.ServerAlreadyStartedException;
import com.clouway.networkingandgui.server_client.view.Display;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.net.Socket;


/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ServerTest {
  private Server server;
  private FakeClient client;
  public Synchroniser synchroniser = new Synchroniser();

  class FakeClient {

    public void connect(String host, int port) {
      try {
        Socket socket = new Socket(host, port);
      } catch (IOException e) {
      }
    }
  }

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery() {{
    setThreadingPolicy(synchroniser);
  }};

  @Mock
  Display display;

  @Before
  public void setUp() {
    server = new Server(display);
    client = new FakeClient();
  }

  @After
  public void tearDown() throws Exception {
    server.stopServer();
  }

  @Test
  public void connectClient() throws Exception {
    server.startServer(4441);
    context.checking(new Expectations() {{
      oneOf(display).show("/127.0.0.1");
    }});
    Thread.sleep(40);
    client.connect("localhost", 4441);
  }

  @Test(expected = ServerAlreadyStartedException.class)
  public void startServerTwoTimesWithConnectedClient() {
    server.startServer(4441);
    client.connect("localhost", 4441);
    server.startServer(4441);
  }

  @Test(expected = ServerAlreadyStartedException.class)
  public void startServerTwoTimesWithoutConnectedClient() {
    server.startServer(4441);
    server.startServer(4441);
  }

//  @Test
//  public void sendMessageFromServerToClient() {
//    Client client1 = new Client(display);
//    server.startServer(4444);
//    context.checking(new Expectations() {{
//      oneOf(display).show("/127.0.0.1");
//    }});
//    client1.connectClient("localhost", 4444);
//    try {
//      Thread.sleep(100);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    assertThat(client1.getCurrentDisplay(), is("Hello. The server's date is: 2015/01/06"));
//  }
}
