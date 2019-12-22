package com.model.modelsForCreationCommands;

import com.model.modelsForCreationCommands.util.CreationCommand;
import com.utils.Patterns;

import java.util.List;
import java.util.regex.Pattern;

public class ExtrrnalGsmCellRef implements CreationCommand {


  /**
   * name : RncFunction=1,UtranCell=CK0029J,GsmRelation=CK00013
   * externalGsmCellRef : {"ExternalGsmNetwork":"Astelit","ExternalGsmCell":"CK00013"}
   * mobilityRelationType : 0
   * qOffset1sn : 7
   * selectionPriority : 1
   */

  private String name;
  private ExternalGsmCellRefBean externalGsmCellRef;
  private int mobilityRelationType;
  private int qOffset1sn;
  private int selectionPriority;

  final String begin = "RncFunction=[0-9]*,";
  final String end = "[\\s\\n\\w\\.,=-]*[\\s\\n]*";

  final Pattern compile3 = Pattern.compile(begin + "UtranCell=[\\w]*,GsmRelation=[\\w]*" + end);

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ExternalGsmCellRefBean getExternalGsmCellRef() {
    return externalGsmCellRef;
  }

  public void setExternalGsmCellRef(ExternalGsmCellRefBean externalGsmCellRef) {
    this.externalGsmCellRef = externalGsmCellRef;
  }

  public int getMobilityRelationType() {
    return mobilityRelationType;
  }

  public void setMobilityRelationType(int mobilityRelationType) {
    this.mobilityRelationType = mobilityRelationType;
  }

  public int getQOffset1sn() {
    return qOffset1sn;
  }

  public void setQOffset1sn(int qOffset1sn) {
    this.qOffset1sn = qOffset1sn;
  }

  public int getSelectionPriority() {
    return selectionPriority;
  }

  public void setSelectionPriority(int selectionPriority) {
    this.selectionPriority = selectionPriority;
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

  public static class ExternalGsmCellRefBean {
    /**
     * ExternalGsmNetwork : Astelit
     * ExternalGsmCell : CK00013
     */

    private String ExternalGsmNetwork;
    private String ExternalGsmCell;

    public String getExternalGsmNetwork() {
      return ExternalGsmNetwork;
    }

    public void setExternalGsmNetwork(String ExternalGsmNetwork) {
      this.ExternalGsmNetwork = ExternalGsmNetwork;
    }

    public String getExternalGsmCell() {
      return ExternalGsmCell;
    }

    public void setExternalGsmCell(String ExternalGsmCell) {
      this.ExternalGsmCell = ExternalGsmCell;
    }
  }
}