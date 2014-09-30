package com.clouway.inputoutput.task2;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by clouway on 14-9-26.
 */
public class ConsoleReader {
  private Scanner scanner = new Scanner(System.in);

  public void readTextFromConsole() throws IOException {
    java.io.FileWriter fileWriter = null;
    try {

      fileWriter = new java.io.FileWriter("text.txt");
      String text;
      while (!(text = scanner.next()).equals(".")) {

        fileWriter.write(text);
        fileWriter.write("\n");
      }


    } finally {
      if (fileWriter != null)
        fileWriter.close();
    }
  }
}
