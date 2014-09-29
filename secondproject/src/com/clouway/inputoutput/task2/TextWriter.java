package com.clouway.inputoutput.task2;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by clouway on 14-9-26.
 */
public class TextWriter {
  private Scanner scanner = new Scanner(System.in);

  public void textRead() throws IOException {
    FileWriter fileWriter = null;
    try {

      fileWriter = new FileWriter("text.txt");
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
