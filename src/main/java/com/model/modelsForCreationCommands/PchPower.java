package com.model.modelsForCreationCommands;

import com.model.modelsForCreationCommands.util.CreationCommand;
import com.utils.Patterns;

import java.util.List;

public class PchPower implements CreationCommand {

  /**
   * name : RncFunction=1,UtranCell=CK0001K,Pch=1
   * administrativeState : 1
   * pchPower : -4
   * pichPower : -7
   * sccpchOffset : 20
   * userLabel :
   */

  private String name;
  private int administrativeState;
  private int pchPower;
  private int pichPower;
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

  public int getPchPower() {
    return pchPower;
  }

  public void setPchPower(int pchPower) {
    this.pchPower = pchPower;
  }

  public int getPichPower() {
    return pichPower;
  }

  public void setPichPower(int pichPower) {
    this.pichPower = pichPower;
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
