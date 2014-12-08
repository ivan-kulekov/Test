package com.clouway.networkingandgui.downloadagent;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class DownloadThread extends Thread {
  private DownloadListener downloadListener;
  private InputStream in;
  private FileOutputStream outputStream;
  private boolean isDead;



  public DownloadThread(DownloadListener downloadListener, InputStream in, FileOutputStream outputStream) {
    this.downloadListener = downloadListener;
    this.in = in;
    this.outputStream = outputStream;
  }

  public boolean isDead() {
    return isDead;
  }

  public void run() {
    while (!isDead) {
      try {
       downloadListener.transfer(in, outputStream, -1, 0);

      } catch (IOException e) {
        e.printStackTrace();
      }
      isDead = true;
    }
  }
}
