package com.model.modelsForCreationCommands.util;

import com.model.modelsForCreationCommands.AseLoadThresholdUiSpeech;
import com.model.modelsForCreationCommands.AtmUserPlaneTermSubrackRef;
import com.utils.Constants;
import com.utils.Patterns;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

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

  public static String extractSiteName(String fileName) {

    List<CreationCommand> creationCommands = extractCreationCommands(fileName);

    AtmUserPlaneTermSubrackRef atmUserPlaneTermSubrackRef = Objects.requireNonNull(creationCommands).stream().filter(e -> e instanceof AtmUserPlaneTermSubrackRef).map(e -> (AtmUserPlaneTermSubrackRef) e).findFirst().get();

    String name = atmUserPlaneTermSubrackRef.getName().split("[=,_]")[3];

    return name;
  }

  public static List<String> extractRncNames(List<Map<String, String>> changeCommands) {
    return changeCommands.stream().map(e -> e.get("Site")).collect(Collectors.toList());
  }

  public static List<String> getCreationCommandsFiles() {
    File creationCommandsDir = new File(Constants.CREATION_COMMANDS_DIRECTORY);

    if(creationCommandsDir.exists() && creationCommandsDir.list() != null && creationCommandsDir.list().length != 0) {
      return Arrays.stream(creationCommandsDir.list()).collect(Collectors.toList());
    }

    return Collections.emptyList();
  }

  public static List<CreationCommand> extractCreationCommands(String fileOfCreationCommands) {
    List<CreationCommand> creationCommands = new ArrayList<>();

    try {
      String[] split = Files.readAllLines(new File(fileOfCreationCommands).toPath()).stream()
              .filter(e -> !e.contains("gs+") && !e.contains("gs-"))
              .map(e -> e.isEmpty() ? "&" : e + "\n")
              .collect(Collectors.joining())
              .split("&");

      List<String> createObjects = Arrays.stream(split)
              .map(e -> e.replace("crn ", ""))
              .map(e -> e.replace("end", ""))
              .collect(Collectors.toList());


      for (String createObject : createObjects) {
        for (Patterns pattern : Patterns.values()) {
          Matcher matcher = pattern.getPattern().matcher(createObject);

          if (matcher.matches()) {
            CreationCommand creationCommand = CreationCommandFabric.createObject(pattern, createObject);
            creationCommands.add(creationCommand);
            break;
          }
        }
      }
    } catch (IOException e) {
//      LOG.error("file not found or something else ", e);
      return null;
    }
    return creationCommands;
  }

//  public static <N extends CreationCommand>List<N> getCreationCommandsByType() {
//
//    List<CreationCommand> creationCommands = extractCreationCommands(fileName);
//
//    creationCommands.stream().filter(e -> e instanceof N).collect(Collectors.toList());
//
//  }

}
