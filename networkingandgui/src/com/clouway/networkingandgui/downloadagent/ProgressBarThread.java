package com.clouway.networkingandgui.downloadagent;

import javax.swing.*;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ProgressBarThread extends Thread {

  private final DownloadListener downloadListener;
  private final JProgressBar progressBar;
  private final DownloadThread downloadThread;

  public ProgressBarThread(DownloadListener downloadListener, JProgressBar progressBar, DownloadThread downloadThread) {

    this.downloadListener = downloadListener;
    this.progressBar = progressBar;
    this.downloadThread = downloadThread;
  }

  public void run(){
    while (!downloadThread.isDead()){
      progressBar.setValue(downloadListener.getTransferredBytes());
    }
  }
}
