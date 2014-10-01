package com.clouway.inputoutput.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class TextReverser {
  public void reverse(String inputFile, String outputFile) throws IOException {
    FileWriter fileWriter = null;
    BufferedReader fileReader = null;

    try {
      fileWriter = new FileWriter(outputFile);
      fileReader = new BufferedReader(new FileReader(inputFile));
      StringBuilder container = new StringBuilder();
      String c;

      while ((c = fileReader.readLine()) != null) {
        container.append("\n").append(c);
        container.reverse();
        c = container.toString();
        container.setLength(0);
        fileWriter.write(c);
      }
    } finally {
      if (fileReader != null) {
        fileReader.close();
      }
      if (fileWriter != null) {
        fileWriter.close();
      }
    }
  }
}
