package com.clouway.networkingandgui.serverclientguava;

import com.google.common.util.concurrent.AbstractExecutionThreadService;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.net.Socket;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ServerTest {
  private Server server;
  private FakeClient client;
  public Synchroniser synchroniser = new Synchroniser();

  class FakeClient extends AbstractExecutionThreadService {
    private String host;
    private int port;

    public FakeClient(String host, int port) {
      this.host = host;
      this.port = port;
    }

    @Override
    protected void run() throws Exception {
      Socket socket = new Socket(host, port);
    }
  }

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery() {{
    setThreadingPolicy(synchroniser);
  }};
  @Mock
  Display display;

  @Before
  public void setUp() throws Exception {
    server = new Server(display);
    client = new FakeClient("localhost", 4444);
    server.startAsync();
    server.awaitRunning();
  }

  @After
  public void tearDown() throws Exception {
    server.shutDown();
    server.awaitTerminated();
  }

  @Test
  public void connectClientToServer() throws Exception {
    context.checking(new Expectations() {{
      oneOf(display).show("Client has been connected");
    }});
    client.startAsync().awaitTerminated();
  }


  @Test
  public void connectTwoClientsToServer() throws Exception {
    FakeClient client1 = new FakeClient("localhost", 4444);
    context.checking(new Expectations() {{
      oneOf(display).show("Client has been connected");
      oneOf(display).show("Client has been connected");
    }});
    client.startAsync().awaitTerminated();
    client1.startAsync().awaitTerminated();
  }

  @Test(expected = IllegalStateException.class)
  public void startServerTwoTimes(){
   server.startAsync();
  }
}
