package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rnc {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private long table_id;
  private String Rehom_Order;
  private String BSC;
  private String Site;
  private String Cell;
  private String LON;
  private String LAT;
  private String LAC;
  private String CI;
  private String New_Bsc;
  private String New_LAC;
  private String New_Ci;

  public Rnc() {
  }

  public Rnc(long table_id, String rehom_Order, String BSC, String site, String cell, String LON, String LAT, String LAC, String CI, String new_Bsc, String new_LAC, String new_Ci) {
    this.table_id = table_id;
    this.Rehom_Order = rehom_Order;
    this.BSC = BSC;
    this.Site = site;
    this.Cell = cell;
    this.LON = LON;
    this.LAT = LAT;
    this.LAC = LAC;
    this.CI = CI;
    this.New_Bsc = new_Bsc;
    this.New_LAC = new_LAC;
    this.New_Ci = new_Ci;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getTable_id() {
    return table_id;
  }

  public void setTable_id(long table_id) {
    this.table_id = table_id;
  }

  public String getRehom_Order() {
    return Rehom_Order;
  }

  public void setRehom_Order(String rehom_Order) {
    Rehom_Order = rehom_Order;
  }

  public String getBSC() {
    return BSC;
  }

  public void setBSC(String BSC) {
    this.BSC = BSC;
  }

  public String getSite() {
    return Site;
  }

  public void setSite(String site) {
    Site = site;
  }

  public String getCell() {
    return Cell;
  }

  public void setCell(String cell) {
    Cell = cell;
  }

  public String getLON() {
    return LON;
  }

  public void setLON(String LON) {
    this.LON = LON;
  }

  public String getLAT() {
    return LAT;
  }

  public void setLAT(String LAT) {
    this.LAT = LAT;
  }

  public String getLAC() {
    return LAC;
  }

  public void setLAC(String LAC) {
    this.LAC = LAC;
  }

  public String getCI() {
    return CI;
  }

  public void setCI(String CI) {
    this.CI = CI;
  }

  public String getNew_Bsc() {
    return New_Bsc;
  }

  public void setNew_Bsc(String new_Bsc) {
    New_Bsc = new_Bsc;
  }

  public String getNew_LAC() {
    return New_LAC;
  }

  public void setNew_LAC(String new_LAC) {
    New_LAC = new_LAC;
  }

  public String getNew_Ci() {
    return New_Ci;
  }

  public void setNew_Ci(String new_Ci) {
    New_Ci = new_Ci;
  }

  @Override
  public String toString() {
    return "Rnc{" +
        "id=" + id +
        ", table_id=" + table_id +
        ", Rehom_Order='" + Rehom_Order + '\'' +
        ", BSC='" + BSC + '\'' +
        ", Site='" + Site + '\'' +
        ", Cell='" + Cell + '\'' +
        ", LON='" + LON + '\'' +
        ", LAT='" + LAT + '\'' +
        ", LAC='" + LAC + '\'' +
        ", CI='" + CI + '\'' +
        ", New_Bsc='" + New_Bsc + '\'' +
        ", New_LAC='" + New_LAC + '\'' +
        ", New_Ci='" + New_Ci + '\'' +
        '}';
  }
}
