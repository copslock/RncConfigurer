package com.model;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayIntegers implements Bean {

  private String name;
  List<Item> values = new ArrayList<>();

  public ArrayIntegers(String rows, int size) {

    // TODO think maybe it is possible to make it better

    name = rows.split("\\s")[0];
    List<String> keyValueArrays = Arrays.stream(rows.split("\\(|=|\\)")).filter(el -> !el.isEmpty()).collect(Collectors.toList());

    List<String> vals = Arrays.asList(keyValueArrays.get(1).split("\\s")).stream().filter(el -> !el.isEmpty()).collect(Collectors.toList());

    List<String> statuses = new ArrayList<>();
    if(keyValueArrays.size() == 3) {
      statuses = Arrays.asList(keyValueArrays.get(2).split("\\s"));
    }

    for (int i = 0; i < size; i++) {
      if(!CollectionUtils.isEmpty(statuses)) {
        if (StringUtils.isNotEmpty(vals.get(i)) && StringUtils.isNotEmpty(statuses.get(i))) {
          Item item = new Item(vals.get(i), statuses.get(i));
          values.add(item);
        }
      } else {
        Item item = new Item(vals.get(i), null);
        values.add(item);
      }
    }

  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public List<Item> getItems() {
    if(null != values) {
      return values;
    }
    return Collections.emptyList();
  }

  @Override
  public boolean isValid() {
    return true;
  }

  private class Item implements ItemIntf {
    private String value;
    private String status;

    public Item(String value, String status) {
      this.value = value;
      this.status = status;
    }

    public String getValue() {
      return value;
    }

    public void setValue(String value) {
      this.value = value;
    }

    public String getStatus() {
      if(StringUtils.isNotEmpty(status)) {
        return status;
      }
      return "";
    }

    public void setStatus(String status) {
      this.status = status;
    }

    @Override
    public String getName() {
      return value;
    }

    @Override
    public String getValues() {
      return status;
    }

    @Override
    public String toString() {
      return getValue() + " " + getStatus();
    }
  }

}
