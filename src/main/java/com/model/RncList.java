package com.model;

//import javax.persistence.Entity;
//import javax.persistence.Id;

//@Entity
public class RncList {

//  @Id
  private int rncId;
  private String name;
  private String ntp17;
  private String ntp28;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNtp17() {
    return ntp17;
  }

  public void setNtp17(String ntp17) {
    this.ntp17 = ntp17;
  }

  public String getNtp28() {
    return ntp28;
  }

  public void setNtp28(String ntp28) {
    this.ntp28 = ntp28;
  }

  public int getRncId() {
    return rncId;
  }

  public void setRncId(int rncId) {
    this.rncId = rncId;
  }
}
