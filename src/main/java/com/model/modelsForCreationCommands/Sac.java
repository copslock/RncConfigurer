package com.model.modelsForCreationCommands;

import com.model.modelsForCreationCommands.util.CreationCommand;
import com.service.StructureWithModels;
import com.utils.Patterns;

import java.util.List;
import java.util.Map;

public class Sac implements CreationCommand {

  /**
   * name : RncFunction=1,LocationArea=12710,ServiceArea=30563
   * sac : 30563
   * userLabel :
   */

  private String name;
  private int sac;
  private String userLabel;
  private String[] source;

  public Sac() {
  }

  public Sac(String[] source) {
    this.source = source;
    name = source[0];
    sac = source[1].split("\\s").length == 2 ? Integer.parseInt(source[1].split("\\s")[1]) : null;
    userLabel = source[2].split("\\s").length == 2 ? source[2].split("\\s")[1] : null;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getSac() {
    return sac;
  }

  public void setSac(int sac) {
    this.sac = sac;
  }

  public String getUserLabel() {
    return userLabel;
  }

  public void setUserLabel(String userLabel) {
    this.userLabel = userLabel;
  }

  @Override
  public CreationCommand getCreationCommand(Patterns pattern, String source) {
    return null;
  }

  @Override
  public Map<String,String> getValues() {
    Map<String, String> values = StructureWithModels.createMapProperties(source);
    return values;
  }

  @Override
  public Patterns getType() {
    return Patterns.SAC;
  }

  @Override
  public String toString() {
    return "crn " + name + "\n" +
        "sac " + sac + "\n" +
        "userLabel " + (userLabel == null ? "" : userLabel) + "\n" +
        "end\n";
  }
}
