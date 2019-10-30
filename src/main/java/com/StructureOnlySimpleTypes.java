package com;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StructureOnlySimpleTypes {
  public static void main(String[] args) {

    Map<String, String> header = new TreeMap<>();
    Map<String, Map<String, String>> values = new TreeMap<>();
    Map<String, String> firstTypeValues = new TreeMap<>();
    Map<String, String> secondTypeValues = new TreeMap<>();

    // extract header key and value
//    String a = parseString(com.Constants.configString, "=*(\\w+)\\s+");
//    String b = parseString(com.Constants.configString, "(\\w+=\\w+,\\w+=\\w+)");
//    header.put(a, b);



    // parseFirstAndSecondTypeOfInstructions
    String[] rows = Constants.configString.split("\\n");
    for (int i = 0; i < rows.length; i++) {
      if(rows[i].contains("{") && rows[i].contains("}")) {
        String name = rows[i].split("\\s+")[1];
        String count = rows[i].split("\\{|}")[1];
        secondTypeValues = parseSecondType(Arrays.copyOfRange(rows, i, i + Integer.parseInt(count)+1), name);
        List<String> firstString = Arrays.stream(rows[i].split("\\s")).filter(el -> !el.isEmpty()).collect(Collectors.toList());
        if(firstString.size() >= 2) {
          values.put(firstString.get(0), secondTypeValues);
        }
        continue;
      }

      if(!rows[i].contains("=")) {
        List<String> keyValue = Arrays.asList(rows[i].split(" ")).stream().filter(el -> null != el && !el.isEmpty()).collect(Collectors.toList());
        String firstTypeKey = !keyValue.isEmpty() ? keyValue.get(0) : null;
        String firstTypeValue = !keyValue.isEmpty() ? keyValue.get(1) : null;
//        System.out.println(firstTypeKey + " " + firstTypeValue);
        firstTypeValues.put(firstTypeKey, firstTypeValue);
      }

    }

//    for (Map.Entry<String, String> stringStringEntry : header.entrySet()) {
//      System.out.println("headers");
//      System.out.println(stringStringEntry.getKey() + " " + stringStringEntry.getValue());
//    }
    System.out.println("first type values");
    for (Map.Entry<String, String> stringStringEntry : firstTypeValues.entrySet()) {
      System.out.println();

      System.out.println(stringStringEntry.getKey() + " " + stringStringEntry.getValue());
    }

    System.out.println();
    System.out.println("second type values");
    for(Map.Entry<String, Map<String, String>> entry : values.entrySet()) {
      System.out.println();

      System.out.println(entry.getKey());
      for (Map.Entry<String, String> stringStringEntry : entry.getValue().entrySet()) {
        System.out.println(stringStringEntry.getKey() + " " + stringStringEntry.getValue());
      }
    }



  }

  public static String parseString(String config, String regex) {
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(config);

    if(matcher.find()) {
      return matcher.group(0);
    }

    return "";

  }

  public static Map<String, String> parseSecondType(String[] config, String name) {

    Map<String, String> subValues2 = new TreeMap<>();
    subValues2.put("", name);

    for (int i = 0; i < config.length; i++) {

      if(!config[i].contains(">>>")) {
        continue;
      }
      List<String> values = Arrays.stream(config[i].split(">>>|=|\\s")).filter(el -> !el.isEmpty()).collect(Collectors.toList());

      String key = "";
      String value = "";
      if(values.size() >= 2) {
        key = values.get(0);
        value = values.get(1);
      }

      if(!key.isEmpty() && !value.isEmpty()) {
        subValues2.put(key, value);
      }

    }

    return subValues2;
  }


}
