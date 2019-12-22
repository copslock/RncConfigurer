package com.model.modelsForCreationCommands;

import com.model.modelsForCreationCommands.util.CreationCommand;
import com.utils.Patterns;

import java.util.List;
import java.util.regex.Pattern;

public class ENodeBId implements CreationCommand {


  /**
   * name : RncFunction=1,EutraNetwork=Astelit,EutranFrequency=1300,ExternalEutranCell=CK0001L31
   * cellId : 31
   * eNodeBId : 940001
   * physicalCellIdentity : -1
   * tac : 12710
   * userLabel :
   */

  private String name;
  private int cellId;
  private int eNodeBId;
  private int physicalCellIdentity;
  private int tac;
  private String userLabel;

  final String begin = "RncFunction=[0-9]*,";
  final String end = "[\\s\\n\\w\\.,=-]*[\\s\\n]*";
  final Pattern pattern = Pattern.compile(begin + "EutraNetwork=[a-zA-Z]*,EutranFrequency=[\\d]*,ExternalEutranCell=[\\w]*" + end);

  public ENodeBId() {
  }

  public ENodeBId(String[] values) {
    name = values[0];
    cellId = values[1].split("\\s").length == 2 ? Integer.parseInt(values[0].split("\\s")[1]) : null;
    eNodeBId = values[2].split("\\s").length == 2 ? Integer.parseInt(values[0].split("\\s")[1]) : null;
    physicalCellIdentity = values[3].split("\\s").length == 2 ? Integer.parseInt(values[0].split("\\s")[1]) : null;
    tac = values[4].split("\\s").length == 2 ? Integer.parseInt(values[0].split("\\s")[1]) : null;
    userLabel = values[5].split("\\s").length == 2 ? values[0].split("\\s")[1] : null;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCellId() {
    return cellId;
  }

  public void setCellId(int cellId) {
    this.cellId = cellId;
  }

  public int getENodeBId() {
    return eNodeBId;
  }

  public void setENodeBId(int eNodeBId) {
    this.eNodeBId = eNodeBId;
  }

  public int getPhysicalCellIdentity() {
    return physicalCellIdentity;
  }

  public void setPhysicalCellIdentity(int physicalCellIdentity) {
    this.physicalCellIdentity = physicalCellIdentity;
  }

  public int getTac() {
    return tac;
  }

  public void setTac(int tac) {
    this.tac = tac;
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
