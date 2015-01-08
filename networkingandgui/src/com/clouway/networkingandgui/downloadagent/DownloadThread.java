package com.clouway.networkingandgui.downloadagent;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class DownloadThread extends Thread {
  private DownloadListener downloadListener;
  private final String urlName;
  private final String downloadedFileName;

  private boolean isDead;


  public DownloadThread(DownloadListener downloadListener, String urlName, String downloadedFileName) {
    this.downloadListener = downloadListener;
    this.urlName = urlName;
    this.downloadedFileName = downloadedFileName;
  }

  public boolean isDead() {
    return isDead;
  }

  public void run() {
    while (!isDead) {
      downloadListener.startDownload(urlName, downloadedFileName);
      isDead = true;
    }
  }
}
