package com.clouway.networkingandgui.downloadagent;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public interface DownloadListener {
  public void isInterrupted();
  public boolean startDownload(String urlName, String downloadedFileName);

}
