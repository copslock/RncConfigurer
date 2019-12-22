package com.model.modelsForParsing;


import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayObjects implements Bean {

  private String name;
  private List<Item> items = new ArrayList<>();

  public ArrayObjects(List<String> values) {
    // TODO parse string fill

    for (String value : values) {
      if(!value.contains(">>>")) {
        name = value.split(" ")[0];
        continue;
      }

      List<String> keyValues = Arrays.stream(value.split(">>>|\\s")).filter(el -> !el.isEmpty()).collect(Collectors.toList());

      Item item = new Item(keyValues.get(0), keyValues.get(2));

      if (null != item) {
        items.add(item);
      }
    }
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public List<Item> getItems() {
    if(null != items) {
      return items;
    }
    return Collections.emptyList();
  }

  @Override
  public boolean isValid() {
    return true;
  }

  private class Item implements ItemIntf {

    private String name;
    private Map<String, String> items = new HashMap<>();

    public Item(String name, String values) {
      if(StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(values)){
        this.name = name;

        // TODO parse string values, create map from that

        List<String> keyValues = Arrays.stream(values.split(",")).filter(el -> !el.isEmpty()).collect(Collectors.toList());

        for (String keyValue : keyValues) {
          if(StringUtils.isEmpty(keyValue)) continue;
          items.put(keyValue.split("=")[0], keyValue.split("=")[1]);
        }
      }

    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    @Override
    public String getValues() {
      if(null != items) {
        return items.entrySet().stream().map(e -> e.getKey()+e.getValue()).collect(Collectors.joining());
      }
      return null;
    }

    public void setItems(Map<String, String> values) {
      this.items = values;
    }

    @Override
    public String toString() {
      return getName() + " " + getValues() + "\n";
    }
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  @Override
  public String toString() {
    return getName() + "\n"
        +getItems();
  }
}
