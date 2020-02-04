package com.model.modelsForCreationCommands.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModelUtils {

  public static Map<String, String> createMapProperties(String[] creationCommand) {
    Map<String, String> props = new LinkedHashMap<>();

    for (String s : creationCommand) {

      if(s.matches("#DoNotEditThisLine:[\\w\\s-./=]+")) {
        String key = s.split(" ")[0];
        props.put(key, s.replace(key+" ", ""));
        continue;
      }

      if(s.matches("lset\\s(\\w+=\\w+,)+(\\w+=\\w+)+[\\w\\s\\n$]+")) {

        props.put(s, "");
        continue;
      }

      if(s.matches("crn[\\w\\s-=,\\n\\.]+")) {
        props.put("crn", s.replace("crn ", ""));
        continue;
      }

      if(s.matches("\\w+\\s+[\\w-]*")) {
        String[] keyValue = s.split(" ");
        props.put(s.split(" ")[0], keyValue.length >= 2 ? keyValue[1] : "");
        continue;
      }
      if(s.matches("\\w+\\s\\w+[=\\d\\s,]+(\\w+=\\w+,)+(\\w+=\\w+)+")) {
        String key = s.split(" ")[0];
        props.put(key, s.replace(key+" ", ""));
        continue;
      }


      if(s.matches("\\w+\\s+(\\w+=\\w+,)+[\\w=,-]+\\s?(#SystemCreated)?")) {
        String[] keyValue = s.split(" ");
        String systemProp = keyValue.length >= 3 ? keyValue[2] : "";
        props.put(s.split(" ")[0], keyValue[1] + " " +systemProp);
        continue;
      }

      if(s.matches("\\w+\\s+(\\d+,)+(\\d+)+")) {
        String[] keyValue = s.split(" ");
        props.put(s.split(" ")[0], keyValue[1]);
        continue;
      }

      if(s.matches("\\w+\\s\\w+=\\w+")) {
        String[] keyValue = s.split(" ");
        props.put(s.split(" ")[0], keyValue[1]);
        continue;
      }

    }

    return props;
  }

}
