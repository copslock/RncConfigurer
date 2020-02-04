package com.model.rncInformationTypes;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KeyValue implements Bean {

  private String key;
  private String value;
  private String state;

  public KeyValue(String keyValueState) {
    // TODO parse values and fill key, value, state
    List<String> keyValues = Arrays.stream(keyValueState.split(" ")).filter(el -> !el.isEmpty()).collect(Collectors.toList());

    if(null != keyValues) {
      key = keyValues.get(0);

      if(keyValues.size() >= 2) {
        value = keyValues.get(1);
      }

      if(keyValues.size() == 3) {
        state = keyValues.get(2);
      }
    }

  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    if(StringUtils.isNotEmpty(value)) {
      return value;
    }
    return "";
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getState() {
    if(null != state) {
      return state;
    }
    return "";
  }

  public void setState(String state) {
    this.state = state;
  }

  @Override
  public String getName() {
    return key;
  }

  @Override
  public List<String> getItems() {
    return Arrays.asList(getName()+" "+getValue()+" "+getState());
  }

  @Override
  public boolean isValid() {
    return true;
  }
}
