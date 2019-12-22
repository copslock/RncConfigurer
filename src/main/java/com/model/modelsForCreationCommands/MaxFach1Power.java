package com.model.modelsForCreationCommands;

import com.model.modelsForCreationCommands.util.CreationCommand;
import com.utils.Patterns;

import java.util.List;

public class MaxFach1Power implements CreationCommand {

  /**
   * name : RncFunction=1,UtranCell=CK0001K,Fach=1
   * administrativeState : 1
   * maxFach1Power : 38
   * maxFach2Power : 19
   * pOffset1Fach : 0
   * pOffset3Fach : 0
   * sccpchOffset : 0
   * userLabel :
   */

  private String name;
  private int administrativeState;
  private int maxFach1Power;
  private int maxFach2Power;
  private int pOffset1Fach;
  private int pOffset3Fach;
  private int sccpchOffset;
  private String userLabel;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAdministrativeState() {
    return administrativeState;
  }

  public void setAdministrativeState(int administrativeState) {
    this.administrativeState = administrativeState;
  }

  public int getMaxFach1Power() {
    return maxFach1Power;
  }

  public void setMaxFach1Power(int maxFach1Power) {
    this.maxFach1Power = maxFach1Power;
  }

  public int getMaxFach2Power() {
    return maxFach2Power;
  }

  public void setMaxFach2Power(int maxFach2Power) {
    this.maxFach2Power = maxFach2Power;
  }

  public int getPOffset1Fach() {
    return pOffset1Fach;
  }

  public void setPOffset1Fach(int pOffset1Fach) {
    this.pOffset1Fach = pOffset1Fach;
  }

  public int getPOffset3Fach() {
    return pOffset3Fach;
  }

  public void setPOffset3Fach(int pOffset3Fach) {
    this.pOffset3Fach = pOffset3Fach;
  }

  public int getSccpchOffset() {
    return sccpchOffset;
  }

  public void setSccpchOffset(int sccpchOffset) {
    this.sccpchOffset = sccpchOffset;
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
