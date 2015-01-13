package com.clouway.networkingandgui.serverclientguava;

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

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ClientTest {
  private FakeServer fakeServer;
  private Client client;
  private Display display;
  private Clock clock;
  public Synchroniser synchroniser = new Synchroniser();

  private class FakeServer extends AbstractExecutionThreadService {
    private final int port;
    private final Clock clock;
    private ServerSocket serverSocket;

    public FakeServer(int port, Clock clock) {

      this.port = port;
      this.clock = clock;
    }

    @Override
    protected void run() throws Exception {
      try {
        serverSocket = new ServerSocket(port);
        while (isRunning()) {
          Socket clientSocket = serverSocket.accept();
          PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
          out.println("Hello, the date is:  " + clock.currentTime());
          clientSocket.close();
        }
      } catch (IOException e) {
//        e.printStackTrace();
//        System.out.println("asd");
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
  public void setUp() {
    display = context.mock(Display.class);
    clock = context.mock(Clock.class);
    fakeServer = new FakeServer(4444, clock);
    client = new Client(display, "localhost", 4444);
    fakeServer.startAsync();
    fakeServer.awaitRunning();
  }

  @After
  public void setDown() throws Exception {
    fakeServer.shutDown();
    fakeServer.awaitTerminated();
  }


  @Test
  public void connectClientToServer() {
    context.checking(new Expectations() {{
      oneOf(clock).currentTime();
      will(returnValue(CalendarUtil.date(7, 2, 2015)));

      oneOf(display).show("Hello, the date is:  07-Feb-2015");
    }});
    client.startAsync().awaitTerminated();
  }

  @Test
  public void connectTwoClients() {
    Client client1 = new Client(display, "localhost", 4444);
    context.checking(new Expectations() {{
      oneOf(clock).currentTime();
      will(returnValue(CalendarUtil.date(7, 2, 2015)));
      oneOf(clock).currentTime();
      will(returnValue(CalendarUtil.date(7, 2, 2015)));

      oneOf(display).show("Hello, the date is:  07-Feb-2015");
      oneOf(display).show("Hello, the date is:  07-Feb-2015");
    }});
    client.startAsync().awaitTerminated();
    client1.startAsync().awaitTerminated();
  }

  @Test
  public void connectTwoClientsAndServerSendTwoDifferentDates() {
    Client client1 = new Client(display, "localhost", 4444);
    context.checking(new Expectations() {{
      oneOf(clock).currentTime();
      will(returnValue(CalendarUtil.date(18, 3, 2015)));
      oneOf(clock).currentTime();
      will(returnValue(CalendarUtil.date(7, 2, 2015)));

      oneOf(display).show("Hello, the date is:  18-Mar-2015");
      oneOf(display).show("Hello, the date is:  07-Feb-2015");
    }});
    client.startAsync().awaitTerminated();
    client1.startAsync().awaitTerminated();
  }
}
