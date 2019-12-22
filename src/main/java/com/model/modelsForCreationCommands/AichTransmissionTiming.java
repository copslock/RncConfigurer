package com.model.modelsForCreationCommands;

import com.model.modelsForCreationCommands.util.CreationCommand;
import com.utils.Patterns;

import java.util.List;

public class AichTransmissionTiming implements CreationCommand {

  /**
   * name : RncFunction=1,UtranCell=CK0001K,Rach=1
   * administrativeState : 1
   * aichPower : -6
   * aichTransmissionTiming : 4
   * constantValueCprach : -24
   * increasedRachCoverageEnabled : 0
   * maxPreambleCycle : 8
   * nb01Max : 0
   * nb01Min : 0
   * powerOffsetP0 : 1
   * powerOffsetPpm : -2
   * preambleRetransMax : 32
   * preambleSignatures : 65535
   * scramblingCodeWordNo : 0
   * spreadingFactor : 32
   * subChannelNo : 4095
   * userLabel :
   */

  private String name;
  private int administrativeState;
  private int aichPower;
  private int aichTransmissionTiming;
  private int constantValueCprach;
  private int increasedRachCoverageEnabled;
  private int maxPreambleCycle;
  private int nb01Max;
  private int nb01Min;
  private int powerOffsetP0;
  private int powerOffsetPpm;
  private int preambleRetransMax;
  private int preambleSignatures;
  private int scramblingCodeWordNo;
  private int spreadingFactor;
  private int subChannelNo;
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

  public int getAichPower() {
    return aichPower;
  }

  public void setAichPower(int aichPower) {
    this.aichPower = aichPower;
  }

  public int getAichTransmissionTiming() {
    return aichTransmissionTiming;
  }

  public void setAichTransmissionTiming(int aichTransmissionTiming) {
    this.aichTransmissionTiming = aichTransmissionTiming;
  }

  public int getConstantValueCprach() {
    return constantValueCprach;
  }

  public void setConstantValueCprach(int constantValueCprach) {
    this.constantValueCprach = constantValueCprach;
  }

  public int getIncreasedRachCoverageEnabled() {
    return increasedRachCoverageEnabled;
  }

  public void setIncreasedRachCoverageEnabled(int increasedRachCoverageEnabled) {
    this.increasedRachCoverageEnabled = increasedRachCoverageEnabled;
  }

  public int getMaxPreambleCycle() {
    return maxPreambleCycle;
  }

  public void setMaxPreambleCycle(int maxPreambleCycle) {
    this.maxPreambleCycle = maxPreambleCycle;
  }

  public int getNb01Max() {
    return nb01Max;
  }

  public void setNb01Max(int nb01Max) {
    this.nb01Max = nb01Max;
  }

  public int getNb01Min() {
    return nb01Min;
  }

  public void setNb01Min(int nb01Min) {
    this.nb01Min = nb01Min;
  }

  public int getPowerOffsetP0() {
    return powerOffsetP0;
  }

  public void setPowerOffsetP0(int powerOffsetP0) {
    this.powerOffsetP0 = powerOffsetP0;
  }

  public int getPowerOffsetPpm() {
    return powerOffsetPpm;
  }

  public void setPowerOffsetPpm(int powerOffsetPpm) {
    this.powerOffsetPpm = powerOffsetPpm;
  }

  public int getPreambleRetransMax() {
    return preambleRetransMax;
  }

  public void setPreambleRetransMax(int preambleRetransMax) {
    this.preambleRetransMax = preambleRetransMax;
  }

  public int getPreambleSignatures() {
    return preambleSignatures;
  }

  public void setPreambleSignatures(int preambleSignatures) {
    this.preambleSignatures = preambleSignatures;
  }

  public int getScramblingCodeWordNo() {
    return scramblingCodeWordNo;
  }

  public void setScramblingCodeWordNo(int scramblingCodeWordNo) {
    this.scramblingCodeWordNo = scramblingCodeWordNo;
  }

  public int getSpreadingFactor() {
    return spreadingFactor;
  }

  public void setSpreadingFactor(int spreadingFactor) {
    this.spreadingFactor = spreadingFactor;
  }

  public int getSubChannelNo() {
    return subChannelNo;
  }

  public void setSubChannelNo(int subChannelNo) {
    this.subChannelNo = subChannelNo;
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
