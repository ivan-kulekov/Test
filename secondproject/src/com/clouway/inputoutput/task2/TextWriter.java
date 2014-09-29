package com.clouway.inputoutput.task2;

<<<<<<< HEAD

import java.io.FileWriter;
import java.io.IOException;
=======
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
>>>>>>> af2b8d6d0855b09b32c44e84ba0c05af042dfebc
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
