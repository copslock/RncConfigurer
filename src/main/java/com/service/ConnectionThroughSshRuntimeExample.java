package com.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class ConnectionThroughSshRuntimeExample {
  public static void main(String[] args) throws IOException, InterruptedException {
    Runtime runtime = Runtime.getRuntime();
    Process process = runtime.exec("ssh elfdev4.dev.ict");
    PrintStream out = new PrintStream(process.getOutputStream());
    BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));

    out.println("ls /opt/");
    while (in.ready()) {
      String s = in.readLine();
      System.out.println(s);
    }
    out.println("exit");
    process.waitFor();

  }
}
