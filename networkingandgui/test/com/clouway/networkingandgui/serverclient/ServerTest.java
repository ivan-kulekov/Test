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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ServerTest {
  private Server server;
  private FakeClient client;
  public Synchroniser synchroniser = new Synchroniser();

  class FakeClient {
    private final String host;
    private final int port;

    FakeClient(String host, int port) {
      this.host = host;
      this.port = port;
    }

    public void connect() {
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
    client = new FakeClient("localhost", 4444);
  }

//  @After
//  public void tearDown() throws Exception {
//    server.stopServer();
//  }

  @Test
  public void connectClient() {
    server.startServer(4444);
    context.checking(new Expectations() {{
      oneOf(display).show("/127.0.0.1");
    }});
    client.connect();
    server.stopServer();
  }

  @Test(expected = ServerAlreadyStartedException.class)
  public void startServerTwoTimesWithConnectedClient() {
    server.startServer(4444);
    client.connect();
    server.startServer(4444);
  }

  @Test(expected = ServerAlreadyStartedException.class)
  public void startServerTwoTimesWithoutClient() {
    server.startServer(4444);
    server.startServer(4444);
  }
}
