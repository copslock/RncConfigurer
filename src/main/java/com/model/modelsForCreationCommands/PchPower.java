package com.model.modelsForCreationCommands;

import com.model.modelsForCreationCommands.util.CreationCommand;
import com.model.modelsForCreationCommands.util.ModelUtils;
import com.utils.Patterns;

import java.util.Map;

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
  private String[] source;

  public PchPower() {
  }

  public PchPower(String[] source) {
    this.source = source;
    name = source[0];
    administrativeState = source[1].split("\\s").length == 2 ? Integer.parseInt(source[1].split("\\s")[1]) : null;
    pchPower = source[2].split("\\s").length == 2 ? Integer.parseInt(source[2].split("\\s")[1]) : null;
    pichPower = source[3].split("\\s").length == 2 ? Integer.parseInt(source[3].split("\\s")[1]) : null;
    sccpchOffset = source[4].split("\\s").length == 2 ? Integer.parseInt(source[4].split("\\s")[1]) : null;
    userLabel = source[5].split("\\s").length == 2 ? source[5].split("\\s")[1] : null;
  }

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
  public Map<String,String> getValues() {
    Map<String, String> values = ModelUtils.createMapProperties(source);
    return values;
  }

  @Override
  public Patterns getType() {
    return Patterns.PCH_POWER;
  }

  @Override
  public String toString() {
    return "crn " + name + "\n" +
        "administrativeState " + administrativeState + "\n" +
        "pchPower " + pchPower + "\n" +
        "pichPower " + pichPower + "\n" +
        "sccpchOffset " + sccpchOffset + "\n" +
        "userLabel " + (userLabel == null ? "" : userLabel) + "\n" +
        "end\n";
  }
}
