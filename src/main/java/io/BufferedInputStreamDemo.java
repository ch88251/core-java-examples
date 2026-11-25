package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamDemo {
  public static void main(String[] args) {
    int bufferSize = 16 * 1024;

    try (BufferedInputStream bis = 
        new BufferedInputStream(new FileInputStream("data20k.bin"), bufferSize)) {
      byte[] chunk = new byte[1024];
      int bytesRead;

      while ((bytesRead = bis.read(chunk)) != -1) {
        System.out.println("Read " + bytesRead + " bytes.");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
