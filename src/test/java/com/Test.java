package com;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test {
  public static void main(String[] args) throws IOException {

    String a = "Provider:Service";

    String s = StringUtils.substringAfter(a, ":");
    System.out.println(s);


  }
}
