package com.model.rncInformationTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Structure implements Bean {

  private String key;
  private List<Item> structureList = new ArrayList<>();

  public Structure(List<String> structure) {
    // TODO parse structure and fill structureList

    for (String s : structure) {
      if(!s.contains(">>>")) {
        key = s.split(" ")[0];
        continue;
      }

      List<String> keyValues = Arrays.stream(s.split("\\s|\\.|=|>>>")).filter(el -> !el.isEmpty()).collect(Collectors.toList());

      if(null != keyValues) {
        Item item = new Item();

        item.setNumber(keyValues.get(0));
        item.setName(keyValues.get(1));
        item.setValue(keyValues.get(2));
        if(keyValues.size() == 4) {
          item.setStatus(keyValues.get(3));
        }
        structureList.add(item);
      }

    }

  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public List<Item> getStructureList() {
    return structureList;
  }

  public void setStructureList(List<Item> structureList) {
    this.structureList = structureList;
  }

  @Override
  public String getName() {
    return key;
  }

  @Override
  public List<?> getItems() {
    if(null != structureList) {
      return structureList;
    }
    return null;
  }

  @Override
  public boolean isValid() {
    return true;
  }


  private class Item implements ItemIntf {
    private String number;
    private String name;
    private String value;
    private String status;

    public Item() {
    }

    public Item(String number, String name, String value, String status) {
      this.number = number;
      this.name = name;
      this.value = value;
      this.status = status;
    }

    public Item(String number, String name, String value) {
      this.number = number;
      this.name = name;
      this.value = value;
    }

    public String getNumber() {
      return number;
    }

    public void setNumber(String number) {
      this.number = number;
    }

    @Override
    public String getName() {
      return name;
    }

    @Override
    public String getValues() {
      return getNumber()+" = "+getName()+" "+getValue()+" "+getStatus();
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getValue() {
      return value;
    }

    public void setValue(String value) {
      this.value = value;
    }

    public String getStatus() {
      if(null != status) {
        return status;
      }
      return "";
    }

    public void setStatus(String status) {
      this.status = status;
    }

    @Override
    public String toString() {
      return getNumber()+"."+getName()+"="+getValue()+" "+getStatus();
    }
  }

}
