package com.clouway.inputoutput.task5;

import java.io.IOException;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class DirectoryBrowserDemo {
  public static void main(String[] args) throws IOException {
    DirectoryBrowser browser = new DirectoryBrowser();
    browser.listContent("/home/clouway/DirectoryBrowser/");
  }

}
