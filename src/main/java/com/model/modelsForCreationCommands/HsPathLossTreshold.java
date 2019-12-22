package com.model.modelsForCreationCommands;

import com.model.modelsForCreationCommands.util.CreationCommand;
import com.utils.Patterns;

import java.util.List;

public class HsPathLossTreshold implements CreationCommand {

  /**
   * name : RncFunction=1,UtranCell=CK0001K,CoverageRelation=CK0001G
   * coverageIndicator : 1
   * hsIflsDownswitch : 1
   * hsPathlossThreshold : 0
   * relationCapability : {"dchLoadSharing":1,"hsCellSelection":0,"hsLoadSharing":1,"powerSave":0}
   * utranCellRef : {"UtranCell":"CK0001G"}
   */

  private String name;
  private int coverageIndicator;
  private int hsIflsDownswitch;
  private int hsPathlossThreshold;
  private RelationCapabilityBean relationCapability;
  private UtranCellRefBean utranCellRef;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCoverageIndicator() {
    return coverageIndicator;
  }

  public void setCoverageIndicator(int coverageIndicator) {
    this.coverageIndicator = coverageIndicator;
  }

  public int getHsIflsDownswitch() {
    return hsIflsDownswitch;
  }

  public void setHsIflsDownswitch(int hsIflsDownswitch) {
    this.hsIflsDownswitch = hsIflsDownswitch;
  }

  public int getHsPathlossThreshold() {
    return hsPathlossThreshold;
  }

  public void setHsPathlossThreshold(int hsPathlossThreshold) {
    this.hsPathlossThreshold = hsPathlossThreshold;
  }

  public RelationCapabilityBean getRelationCapability() {
    return relationCapability;
  }

  public void setRelationCapability(RelationCapabilityBean relationCapability) {
    this.relationCapability = relationCapability;
  }

  public UtranCellRefBean getUtranCellRef() {
    return utranCellRef;
  }

  public void setUtranCellRef(UtranCellRefBean utranCellRef) {
    this.utranCellRef = utranCellRef;
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

  public static class RelationCapabilityBean {
    /**
     * dchLoadSharing : 1
     * hsCellSelection : 0
     * hsLoadSharing : 1
     * powerSave : 0
     */

    private int dchLoadSharing;
    private int hsCellSelection;
    private int hsLoadSharing;
    private int powerSave;

    public int getDchLoadSharing() {
      return dchLoadSharing;
    }

    public void setDchLoadSharing(int dchLoadSharing) {
      this.dchLoadSharing = dchLoadSharing;
    }

    public int getHsCellSelection() {
      return hsCellSelection;
    }

    public void setHsCellSelection(int hsCellSelection) {
      this.hsCellSelection = hsCellSelection;
    }

    public int getHsLoadSharing() {
      return hsLoadSharing;
    }

    public void setHsLoadSharing(int hsLoadSharing) {
      this.hsLoadSharing = hsLoadSharing;
    }

    public int getPowerSave() {
      return powerSave;
    }

    public void setPowerSave(int powerSave) {
      this.powerSave = powerSave;
    }
  }

  public static class UtranCellRefBean {
    /**
     * UtranCell : CK0001G
     */

    private String UtranCell;

    public String getUtranCell() {
      return UtranCell;
    }

    public void setUtranCell(String UtranCell) {
      this.UtranCell = UtranCell;
    }
  }
}
