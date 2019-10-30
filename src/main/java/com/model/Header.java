package com.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Header implements Bean{

  private String key;
  private Map<String, String> values = new HashMap<>();

  public Header(String headers) {
    // TODO parse headers and fill values
    List<String> nameAndKeysValues = Arrays.asList(headers.split(" ")).stream().filter(el -> !el.isEmpty()).collect(Collectors.toList());
    key = nameAndKeysValues.get(0);

    List<String> keysValues = Arrays.asList(nameAndKeysValues.get(1).split(",")).stream().filter(el -> !el.isEmpty()).collect(Collectors.toList());

    keysValues.stream().map(v -> values.put(v.split("=")[0], v.split("=")[1])).collect(Collectors.toList());
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public Map<String, String> getValues() {
    return values;
  }

  public void setValues(Map<String, String> values) {
    this.values = values;
  }

  @Override
  public String getName() {
    return key;
  }

  @Override
  public List<String> getItems() {
    if(!values.isEmpty()) {
      return values.entrySet().stream().map(v -> v.getKey() + " " + v.getValue()).collect(Collectors.toList());
    }

    return null;
  }

  @Override
  public boolean isValid() {
    return true;
  }
}
