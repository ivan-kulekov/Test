package com.clouway.networkingandgui.downloadagent;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public interface DownloadListener {
  public int transfer(InputStream in, OutputStream out, int numberOfBytes, int offset) throws IOException;
  public int getTransferredBytes();
  public void isDead();
}
