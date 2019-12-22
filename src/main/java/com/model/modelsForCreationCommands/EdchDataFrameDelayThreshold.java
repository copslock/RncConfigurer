package com.model.modelsForCreationCommands;

import com.model.modelsForCreationCommands.util.CreationCommand;
import com.utils.Patterns;

import java.util.List;

public class EdchDataFrameDelayThreshold implements CreationCommand {

  /**
   * name : RncFunction=1,IubLink=CK0001,IubEdch=1
   * edchDataFrameDelayThreshold : 60
   * userLabel :
   */

  private String name;
  private int edchDataFrameDelayThreshold;
  private String userLabel;

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
  public List<?> getValues() {
    return null;
  }

  @Override
  public String getType() {
    return null;
  }
}
