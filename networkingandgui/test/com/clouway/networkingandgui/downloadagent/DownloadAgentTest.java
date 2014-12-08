package com.clouway.networkingandgui.downloadagent;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class DownloadAgentTest {

  @Test
  public void downloadPicture() {
    TransferObject transferObject = new TransferObject();
    try {
      URL url = new URL("http://amydrewthompson.com/wp-content/uploads/2011/02/burnout_full1.jpg");
      URLConnection connection = url.openConnection();
      InputStream in = connection.getInputStream();
      FileOutputStream outputStream = new FileOutputStream("asd.jpg");
      transferObject.transfer(in, outputStream, -1, 0);
    } catch (IOException e) {
      e.printStackTrace();
    }//catch (MalformedURLException e) {
    // e.printStackTrace();
    // }
    assertThat(transferObject.getTransferredBytes(), is(121403));
  }

//  @Test
//  public void download5MbFile(){
//    TransferObject transferObject = new TransferObject();
//    try {
//      URL url = new URL("http://www.wswd.net/testdownloadfiles/5MB.zip");
//      URLConnection connection = url.openConnection();
//      InputStream in = connection.getInputStream();
//      FileOutputStream outputStream = new FileOutputStream("asd.zip");
//      transferObject.transfer(in, outputStream, -1, 0);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }//catch (MalformedURLException e) {
//    // e.printStackTrace();
//    // }
//    assertThat(transferObject.getTransferredBytes(), is(5242880));
//  }


}
