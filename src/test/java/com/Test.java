package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Test {
  public static void main(String[] args) throws IOException {
    List<String> lines = new ArrayList<>();
    Runtime runtime = Runtime.getRuntime();

    Process p = runtime.exec("cat src/main/resources/RncString.txt");

    BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

    while (reader.ready()) {
      String s = reader.readLine();
      lines.add(s);
//      System.out.println(s);
    }

    for (String line : lines) {
      System.out.println(line);
    }
  }
}
