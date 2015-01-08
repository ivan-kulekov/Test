package com.clouway.networkingandgui.downloadagent;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class DownloadAgent implements DownloadListener {
  private static final int SIZE = 102400;
  private int total = 0;
  private boolean isInterrupted;
  private int forProgressBar = 0;
  private boolean isErrorOccurred;
  private ProgressListener progressListener;

  public DownloadAgent(ProgressListener progressListener) {
    this.progressListener = progressListener;
  }


  @Override
  public void isInterrupted() {
    isInterrupted = true;
  }

  @Override
  public boolean startDownload(String urlName, String downloadedFileName) {
    if (urlName.equals("") || downloadedFileName.equals("")) {
      return false;
    }
    try {
      URL url = new URI(urlName).toURL();
      URLConnection connection = url.openConnection();
      forProgressBar = connection.getContentLength();
      InputStream in = connection.getInputStream();
      FileOutputStream outputStream = new FileOutputStream(downloadedFileName);
      if (!isErrorOccurred) {
        transfer(in, outputStream, -1, 0);
        return true;
      }
    } catch (IOException e) {
      isErrorOccurred = true;
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    return false;
  }

//  @Override
//  public int getTransferredBytes() {
//    return total;
//  }

//  @Override
//  public int getForProgressBar() {
//    return forProgressBar;
//  }

  private int transfer(InputStream in, OutputStream out, int numberOfBytes, int offset) throws IOException {
    int size;
    total = 0;
    isInterrupted = false;

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
      progressListener.update(total * 100 / forProgressBar);
      System.out.println("asd");
      out.write(buffer, 0, readBytes);
      if (numberOfBytes == readBytes || isInterrupted) {
        break;
      }
    }
    return total;
  }
}
