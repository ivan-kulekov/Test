package com.clouway.networkingandgui.downloadagent;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class TransferObject implements DownloadListener {
  private static final int SIZE = 2048;
  private int total = 0;
  private boolean isDead;
  private int forProgressBar;


  @Override
  public int transfer(InputStream in, OutputStream out, int numberOfBytes, int offset) throws IOException {
    int size;
    total = 0;
    isDead = false;

    if (numberOfBytes >= 0) {
      size = numberOfBytes;
    } else {
      size = SIZE;
    }

    byte[] buffer = new byte[size];
    in.skip(offset);
    int readBytes;
    while ((readBytes = in.read(buffer)) != -1) {
      total += readBytes;
      out.write(buffer, 0, readBytes);
      if (numberOfBytes == readBytes || isDead) {
        break;
      }
    }
    return total;
  }

  @Override
  public int getTransferredBytes() {
    return total;
  }

  @Override
  public void isDead() {
    isDead = true;
  }

  @Override
  public boolean startDownload(String urlName, String downloadedFileName) {
    if (urlName.equals("") || downloadedFileName.equals("")){
      return false;
    }
    try {
      URL url = new URL(urlName);
      URLConnection connection = url.openConnection();
      forProgressBar = connection.getContentLength();
      InputStream in = connection.getInputStream();
      FileOutputStream outputStream = new FileOutputStream(downloadedFileName);
//      progressBar.setMaximum(connection.getContentLength());
      transfer(in, outputStream, -1, 0);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return true;
  }

  @Override
  public int getForProgressBar() {
    return forProgressBar;
  }
}
