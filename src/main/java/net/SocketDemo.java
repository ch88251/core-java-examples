package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.IOException;

import java.net.Socket;
import java.net.ServerSocket;

public class SocketDemo {

  public static void main(String[] args) throws IOException {
    var hostname = "www.example.com";
    var port = 80;
    var filename = "/index.html";

    try (var sock = new Socket(hostname, port);
        var from = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        var to = new PrintWriter(new OutputStreamWriter(sock.getOutputStream())); ) {
        
      to.print("GET " + filename +
          "HTTP/1.1\r\nHost: " + hostname + "\r\n\r\n");
      to.flush();

      for (String l = null; (l = from.readLine()) != null; )
        System.out.println(l);
    }
  }
}
