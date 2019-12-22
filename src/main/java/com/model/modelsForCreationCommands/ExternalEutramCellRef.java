package com.model.modelsForCreationCommands;

import com.model.modelsForCreationCommands.util.CreationCommand;
import com.utils.Patterns;

import java.util.List;

public class ExternalEutramCellRef implements CreationCommand {


  /**
   * name : RncFunction=1,UtranCell=CK0001K,EutranFreqRelation=1300,EutranCellRelation=1
   * coSited : 1
   * externalEutranCellRef : {"EutraNetwork":"Astelit","EutranFrequency":1300,"ExternalEutranCell":"CK0001L31"}
   * userLabel :
   */

  private String name;
  private int coSited;
  private ExternalEutranCellRefBean externalEutranCellRef;
  private String userLabel;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCoSited() {
    return coSited;
  }

  public void setCoSited(int coSited) {
    this.coSited = coSited;
  }

  public ExternalEutranCellRefBean getExternalEutranCellRef() {
    return externalEutranCellRef;
  }

  public void setExternalEutranCellRef(ExternalEutranCellRefBean externalEutranCellRef) {
    this.externalEutranCellRef = externalEutranCellRef;
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

  public static class ExternalEutranCellRefBean {
    /**
     * EutraNetwork : Astelit
     * EutranFrequency : 1300
     * ExternalEutranCell : CK0001L31
     */

    private String EutraNetwork;
    private int EutranFrequency;
    private String ExternalEutranCell;

    public String getEutraNetwork() {
      return EutraNetwork;
    }

    public void setEutraNetwork(String EutraNetwork) {
      this.EutraNetwork = EutraNetwork;
    }

    public int getEutranFrequency() {
      return EutranFrequency;
    }

    public void setEutranFrequency(int EutranFrequency) {
      this.EutranFrequency = EutranFrequency;
    }

    public String getExternalEutranCell() {
      return ExternalEutranCell;
    }

    public void setExternalEutranCell(String ExternalEutranCell) {
      this.ExternalEutranCell = ExternalEutranCell;
    }
  }
}
