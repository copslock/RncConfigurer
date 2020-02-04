package com.model.modelsForCreationCommands;

import com.model.modelsForCreationCommands.util.CreationCommand;
import com.service.StructureWithModels;
import com.utils.Patterns;

import java.util.List;
import java.util.Map;

public class EdchDataFrameDelayThreshold implements CreationCommand {

  /**
   * name : RncFunction=1,IubLink=CK0001,IubEdch=1
   * edchDataFrameDelayThreshold : 60
   * userLabel :
   */

  private String name;
  private int edchDataFrameDelayThreshold;
  private String userLabel;
  private String[] source;

  public EdchDataFrameDelayThreshold() {
  }

  public EdchDataFrameDelayThreshold(String[] source) {
    this.source = source;
    name = source[0];
    edchDataFrameDelayThreshold = source[1].split("\\s").length == 2 ? Integer.parseInt(source[1].split("\\s")[1]) : null;
    userLabel = source[2].split("\\s").length == 2 ? source[2].split("\\s")[1] : null;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getEdchDataFrameDelayThreshold() {
    return edchDataFrameDelayThreshold;
  }

  public void setEdchDataFrameDelayThreshold(int edchDataFrameDelayThreshold) {
    this.edchDataFrameDelayThreshold = edchDataFrameDelayThreshold;
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
    return Patterns.EDCH_DATA_FRAME_DELAY_THRESHOLD;
  }

  @Override
  public String toString() {
    return "crn " + name + "\n" +
        "edchDataFrameDelayThreshold " + edchDataFrameDelayThreshold + "\n" +
        "userLabel " + (userLabel == null ? "" : userLabel) + "\n" +
        "end\n";
  }
}
