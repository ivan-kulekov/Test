package com.clouway.inputoutput.task5;

import java.io.IOException;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class DirectoryBrowserDemo {
  public static void main(String[] args) throws IOException {
    DirectoryBrowser browser = new DirectoryBrowser();
   String path = browser.listContent("/home/clouway/DirectoryBrowser/");
    System.out.println(path);
  }

}
