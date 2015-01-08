package com.clouway.networkingandgui.informationforclients;

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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ServerTest {
  private Synchroniser synchroniser = new Synchroniser();
  private Server server;

  class FakeClient {

    public void connect(String host, int port) {
      try {
        Socket socket = new Socket(host, port);
        new Thread(new Runnable() {
          @Override
          public void run() {
            while (true) {

            }
          }
        }).start();
      } catch (IOException e) {
        e.printStackTrace();
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
  }

  @After
  public void tearDown() {
    server.stop();
  }


  @Test
  public void connectClientToServer() {
    server.start(4444);
    FakeClient client = new FakeClient();
    context.checking(new Expectations() {{
      oneOf(display).show("Client number: 1 has been connected!");
    }});
    try {
      Thread.sleep(20);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    client.connect("localhost", 4444);
  }


  @Test
  public void connectTwoClientsToServer() {
    FakeClient client = new FakeClient();
    server.start(4444);
    context.checking(new Expectations() {{
      oneOf(display).show("Client number: 1 has been connected!");
      oneOf(display).show("Client number: 2 has been connected!");
    }});
    client.connect("localhost", 4444);
    client.connect("localhost", 4444);
  }

  @Test
  public void checkClientContainerOfServer() {
    FakeClient client = new FakeClient();
    server.start(4444);
    context.checking(new Expectations() {{
      oneOf(display).show("Client number: 1 has been connected!");
      oneOf(display).show("Client number: 2 has been connected!");
      oneOf(display).show("Client number: 3 has been connected!");
    }});
    try {
      Thread.sleep(20);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    client.connect("localhost", 4444);
    client.connect("localhost", 4444);
    client.connect("localhost", 4444);
    assertThat(server.clientContainerSize(), is(3));
  }


  @Test(expected = ServerAlreadyStartedException.class)
  public void startServerTwoTimes(){
   server.start(4444);
   server.start(4444);
  }
}
