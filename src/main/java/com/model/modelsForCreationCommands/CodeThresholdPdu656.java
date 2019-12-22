package com.model.modelsForCreationCommands;

import com.model.modelsForCreationCommands.util.CreationCommand;
import com.utils.Patterns;

import java.util.List;

public class CodeThresholdPdu656 implements CreationCommand {

  /**
   * name : RncFunction=1,UtranCell=CK0001K,Hsdsch=1
   * administrativeState : 1
   * codeThresholdPdu656 : 0
   * cqiFeedbackCycle : 8
   * deltaAck1 : 5
   * deltaAck2 : 7
   * deltaCqi1 : 4
   * deltaCqi2 : 6
   * deltaNack1 : 5
   * deltaNack2 : 7
   * hsMeasurementPowerOffset : 80
   * initialAckNackRepetitionFactor : 1
   * initialCqiRepetitionFactor : 1
   * numHsPdschCodes : 5
   * numHsScchCodes : 4
   * userLabel :
   */

  private String name;
  private int administrativeState;
  private int codeThresholdPdu656;
  private int cqiFeedbackCycle;
  private int deltaAck1;
  private int deltaAck2;
  private int deltaCqi1;
  private int deltaCqi2;
  private int deltaNack1;
  private int deltaNack2;
  private int hsMeasurementPowerOffset;
  private int initialAckNackRepetitionFactor;
  private int initialCqiRepetitionFactor;
  private int numHsPdschCodes;
  private int numHsScchCodes;
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

  public int getCodeThresholdPdu656() {
    return codeThresholdPdu656;
  }

  public void setCodeThresholdPdu656(int codeThresholdPdu656) {
    this.codeThresholdPdu656 = codeThresholdPdu656;
  }

  public int getCqiFeedbackCycle() {
    return cqiFeedbackCycle;
  }

  public void setCqiFeedbackCycle(int cqiFeedbackCycle) {
    this.cqiFeedbackCycle = cqiFeedbackCycle;
  }

  public int getDeltaAck1() {
    return deltaAck1;
  }

  public void setDeltaAck1(int deltaAck1) {
    this.deltaAck1 = deltaAck1;
  }

  public int getDeltaAck2() {
    return deltaAck2;
  }

  public void setDeltaAck2(int deltaAck2) {
    this.deltaAck2 = deltaAck2;
  }

  public int getDeltaCqi1() {
    return deltaCqi1;
  }

  public void setDeltaCqi1(int deltaCqi1) {
    this.deltaCqi1 = deltaCqi1;
  }

  public int getDeltaCqi2() {
    return deltaCqi2;
  }

  public void setDeltaCqi2(int deltaCqi2) {
    this.deltaCqi2 = deltaCqi2;
  }

  public int getDeltaNack1() {
    return deltaNack1;
  }

  public void setDeltaNack1(int deltaNack1) {
    this.deltaNack1 = deltaNack1;
  }

  public int getDeltaNack2() {
    return deltaNack2;
  }

  public void setDeltaNack2(int deltaNack2) {
    this.deltaNack2 = deltaNack2;
  }

  public int getHsMeasurementPowerOffset() {
    return hsMeasurementPowerOffset;
  }

  public void setHsMeasurementPowerOffset(int hsMeasurementPowerOffset) {
    this.hsMeasurementPowerOffset = hsMeasurementPowerOffset;
  }

  public int getInitialAckNackRepetitionFactor() {
    return initialAckNackRepetitionFactor;
  }

  public void setInitialAckNackRepetitionFactor(int initialAckNackRepetitionFactor) {
    this.initialAckNackRepetitionFactor = initialAckNackRepetitionFactor;
  }

  public int getInitialCqiRepetitionFactor() {
    return initialCqiRepetitionFactor;
  }

  public void setInitialCqiRepetitionFactor(int initialCqiRepetitionFactor) {
    this.initialCqiRepetitionFactor = initialCqiRepetitionFactor;
  }

  public int getNumHsPdschCodes() {
    return numHsPdschCodes;
  }

  public void setNumHsPdschCodes(int numHsPdschCodes) {
    this.numHsPdschCodes = numHsPdschCodes;
  }

  public int getNumHsScchCodes() {
    return numHsScchCodes;
  }

  public void setNumHsScchCodes(int numHsScchCodes) {
    this.numHsScchCodes = numHsScchCodes;
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
