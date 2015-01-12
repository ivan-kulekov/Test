package com.clouway.networkingandgui.informationforclientsguava;

import com.google.common.util.concurrent.AbstractExecutionThreadService;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import java.net.Socket;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ServerTest {
  private Synchroniser synchroniser = new Synchroniser();
  private Server server;

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
    server.startAsync();
    server.awaitRunning();
  }

  @Test
  public void connectClientToServer() throws Exception {
    FakeClient client = new FakeClient("localhost", 4444);
    context.checking(new Expectations() {{
      oneOf(display).show("Client number 1 has been connected!");
    }});
    client.startAsync().awaitTerminated();
    server.shutDown();
    server.awaitTerminated();
  }

  @Test
  public void connectTwoClients() throws Exception {
    FakeClient client = new FakeClient("localhost", 4444);
    FakeClient client1 = new FakeClient("localhost", 4444);
    context.checking(new Expectations() {{
      oneOf(display).show("Client number 1 has been connected!");
      oneOf(display).show("Client number 2 has been connected!");
    }});
    client.startAsync().awaitTerminated();
    client1.startAsync().awaitTerminated();
    server.shutDown();
    server.awaitTerminated();
  }

  @Test
  public void connectThreeClients() throws Exception {
    FakeClient client = new FakeClient("localhost", 4444);
    FakeClient client1 = new FakeClient("localhost", 4444);
    FakeClient client2 = new FakeClient("localhost", 4444);
    context.checking(new Expectations() {{
      oneOf(display).show("Client number 1 has been connected!");
      oneOf(display).show("Client number 2 has been connected!");
      oneOf(display).show("Client number 3 has been connected!");
    }});
    client.startAsync().awaitTerminated();
    client1.startAsync().awaitTerminated();
    client2.startAsync().awaitTerminated();
    server.shutDown();
    server.awaitTerminated();
  }

  @Test
  public void checkClientContainer() throws Exception {
    FakeClient client = new FakeClient("localhost", 4444);
    FakeClient client1 = new FakeClient("localhost", 4444);
    FakeClient client2 = new FakeClient("localhost", 4444);
    context.checking(new Expectations() {{
      oneOf(display).show("Client number 1 has been connected!");
      oneOf(display).show("Client number 2 has been connected!");
      oneOf(display).show("Client number 3 has been connected!");
    }});
    client.startAsync().awaitTerminated();
    client1.startAsync().awaitTerminated();
    client2.startAsync().awaitTerminated();
    server.shutDown();
    server.awaitTerminated();
    assertThat(server.containerSize(), is(3));
  }

}
