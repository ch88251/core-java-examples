package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogFileReader {
  public static void main(String[] args) {
    try (BufferedReader reader =
        new BufferedReader(new FileReader("application.log"))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.contains("ERROR")) {
          System.out.println(line);
        }
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }
}
