package com.model.modelsForCreationCommands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.modelsForCreationCommands.util.CreationCommand;
import com.model.modelsForCreationCommands.util.VariableExtractor;
import com.service.StructureWithModels;
import com.utils.Patterns;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AtmUserPlaneTermSubrackRef implements CreationCommand {


  /**
   * name : RncFunction=1,IubLink=CK0001
   * administrativeState : 1
   * atmUserPlaneTermSubrackRef :
   * controlPlaneTransportOption : {"atm":0,"ipv4":1}
   * dlHwAdm : 99
   * l2EstReqRetryTimeNbapC : 5
   * l2EstReqRetryTimeNbapD : 5
   * linkType : 0
   * poolRedundancy : 0
   * rSiteRef :
   * rbsId : 677
   * remoteCpIpAddress1 : 10.80.158.245
   * remoteCpIpAddress2 :
   * remoteSctpPortNbapC : 5113
   * remoteSctpPortNbapD : 5114
   * rncModuleAllocWeight : 10
   * rncModulePreferredRef :
   * softCongThreshGbrBwDl : 100
   * softCongThreshGbrBwUl : 100
   * spare : 0
   * spareA : [0,0,0,0,0,0,0,0,0,677]
   * ulHwAdm : 99
   * userLabel :
   * userPlaneGbrAdmBandwidthDl : 10000
   * userPlaneGbrAdmBandwidthUl : 10000
   * userPlaneGbrAdmEnabled : 0
   * userPlaneGbrAdmMarginDl : 0
   * userPlaneGbrAdmMarginUl : 0
   * userPlaneIpResourceRef : {"IpAccessHostPool":"IUB"}
   * userPlaneTransportOption : {"atm":0,"ipv4":1}
   */

  private String name;
  private int administrativeState;
  private String atmUserPlaneTermSubrackRef;
  private ControlPlaneTransportOptionBean controlPlaneTransportOption;
  private int dlHwAdm;
  private int l2EstReqRetryTimeNbapC;
  private int l2EstReqRetryTimeNbapD;
  private int linkType;
  private int poolRedundancy;
  private String rSiteRef;
  private int rbsId;
  private String remoteCpIpAddress1;
  private String remoteCpIpAddress2;
  private int remoteSctpPortNbapC;
  private int remoteSctpPortNbapD;
  private int rncModuleAllocWeight;
  private String rncModulePreferredRef;
  private int softCongThreshGbrBwDl;
  private int softCongThreshGbrBwUl;
  private int spare;
  private int ulHwAdm;
  private String userLabel;
  private int userPlaneGbrAdmBandwidthDl;
  private int userPlaneGbrAdmBandwidthUl;
  private int userPlaneGbrAdmEnabled;
  private int userPlaneGbrAdmMarginDl;
  private int userPlaneGbrAdmMarginUl;
  private UserPlaneIpResourceRefBean userPlaneIpResourceRef;
  private UserPlaneTransportOptionBean userPlaneTransportOption;
  private List<Integer> spareA;
  private int i = 0;
  private String[] source;

  public AtmUserPlaneTermSubrackRef() {
  }

  public AtmUserPlaneTermSubrackRef(String[] source) throws IOException {
    this.source = source;
    name = source[i++];
    administrativeState = VariableExtractor.extractInteger(source[i++]);
    atmUserPlaneTermSubrackRef = VariableExtractor.extractString(source[i++]);
    controlPlaneTransportOption = source[i].split("\\s").length == 2 ? new ControlPlaneTransportOptionBean(source[i++].split("\\s")[1].split(",")) : null;
    dlHwAdm = VariableExtractor.extractInteger(source[i++]);
    l2EstReqRetryTimeNbapC = VariableExtractor.extractInteger(source[i++]);
    l2EstReqRetryTimeNbapD = VariableExtractor.extractInteger(source[i++]);
    linkType = VariableExtractor.extractInteger(source[i++]);
    poolRedundancy = VariableExtractor.extractInteger(source[i++]);
    rSiteRef = VariableExtractor.extractString(source[i++]);
    rbsId = VariableExtractor.extractInteger(source[i++]);
    remoteCpIpAddress1 = VariableExtractor.extractString(source[i++]);
    remoteCpIpAddress2 = VariableExtractor.extractString(source[i++]);
    remoteSctpPortNbapC = VariableExtractor.extractInteger(source[i++]);
    remoteSctpPortNbapD = VariableExtractor.extractInteger(source[i++]);
    rncModuleAllocWeight = VariableExtractor.extractInteger(source[i++]);
    rncModulePreferredRef = VariableExtractor.extractString(source[i++]);
    softCongThreshGbrBwDl = VariableExtractor.extractInteger(source[i++]);
    softCongThreshGbrBwUl = VariableExtractor.extractInteger(source[i++]);
    spare = VariableExtractor.extractInteger(source[i++]);
    spareA = VariableExtractor.extractArray(source[i++]);
    ulHwAdm = VariableExtractor.extractInteger(source[i++]);
    userLabel = VariableExtractor.extractString(source[i++]);
    userPlaneGbrAdmBandwidthDl = VariableExtractor.extractInteger(source[i++]);
    userPlaneGbrAdmBandwidthUl = VariableExtractor.extractInteger(source[i++]);
    userPlaneGbrAdmEnabled = VariableExtractor.extractInteger(source[i++]);
    userPlaneGbrAdmMarginDl = VariableExtractor.extractInteger(source[i++]);
    userPlaneGbrAdmMarginUl = VariableExtractor.extractInteger(source[i++]);
    userPlaneIpResourceRef = source[i].split("\\s").length == 2 ? new UserPlaneIpResourceRefBean(source[i++].split("\\s")[1].split("=")[1]) : null;
    userPlaneTransportOption = source[i].split("\\s").length == 2 ? new UserPlaneTransportOptionBean(source[i++].split("\\s")[1].split(",")) : null;
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

  public String getAtmUserPlaneTermSubrackRef() {
    return atmUserPlaneTermSubrackRef;
  }

  public void setAtmUserPlaneTermSubrackRef(String atmUserPlaneTermSubrackRef) {
    this.atmUserPlaneTermSubrackRef = atmUserPlaneTermSubrackRef;
  }

  public ControlPlaneTransportOptionBean getControlPlaneTransportOption() {
    return controlPlaneTransportOption;
  }

  public void setControlPlaneTransportOption(ControlPlaneTransportOptionBean controlPlaneTransportOption) {
    this.controlPlaneTransportOption = controlPlaneTransportOption;
  }

  public int getDlHwAdm() {
    return dlHwAdm;
  }

  public void setDlHwAdm(int dlHwAdm) {
    this.dlHwAdm = dlHwAdm;
  }

  public int getL2EstReqRetryTimeNbapC() {
    return l2EstReqRetryTimeNbapC;
  }

  public void setL2EstReqRetryTimeNbapC(int l2EstReqRetryTimeNbapC) {
    this.l2EstReqRetryTimeNbapC = l2EstReqRetryTimeNbapC;
  }

  public int getL2EstReqRetryTimeNbapD() {
    return l2EstReqRetryTimeNbapD;
  }

  public void setL2EstReqRetryTimeNbapD(int l2EstReqRetryTimeNbapD) {
    this.l2EstReqRetryTimeNbapD = l2EstReqRetryTimeNbapD;
  }

  public int getLinkType() {
    return linkType;
  }

  public void setLinkType(int linkType) {
    this.linkType = linkType;
  }

  public int getPoolRedundancy() {
    return poolRedundancy;
  }

  public void setPoolRedundancy(int poolRedundancy) {
    this.poolRedundancy = poolRedundancy;
  }

  public String getRSiteRef() {
    return rSiteRef;
  }

  public void setRSiteRef(String rSiteRef) {
    this.rSiteRef = rSiteRef;
  }

  public int getRbsId() {
    return rbsId;
  }

  public void setRbsId(int rbsId) {
    this.rbsId = rbsId;
  }

  public String getRemoteCpIpAddress1() {
    return remoteCpIpAddress1;
  }

  public void setRemoteCpIpAddress1(String remoteCpIpAddress1) {
    this.remoteCpIpAddress1 = remoteCpIpAddress1;
  }

  public String getRemoteCpIpAddress2() {
    return remoteCpIpAddress2;
  }

  public void setRemoteCpIpAddress2(String remoteCpIpAddress2) {
    this.remoteCpIpAddress2 = remoteCpIpAddress2;
  }

  public int getRemoteSctpPortNbapC() {
    return remoteSctpPortNbapC;
  }

  public void setRemoteSctpPortNbapC(int remoteSctpPortNbapC) {
    this.remoteSctpPortNbapC = remoteSctpPortNbapC;
  }

  public int getRemoteSctpPortNbapD() {
    return remoteSctpPortNbapD;
  }

  public void setRemoteSctpPortNbapD(int remoteSctpPortNbapD) {
    this.remoteSctpPortNbapD = remoteSctpPortNbapD;
  }

  public int getRncModuleAllocWeight() {
    return rncModuleAllocWeight;
  }

  public void setRncModuleAllocWeight(int rncModuleAllocWeight) {
    this.rncModuleAllocWeight = rncModuleAllocWeight;
  }

  public String getRncModulePreferredRef() {
    return rncModulePreferredRef;
  }

  public void setRncModulePreferredRef(String rncModulePreferredRef) {
    this.rncModulePreferredRef = rncModulePreferredRef;
  }

  public int getSoftCongThreshGbrBwDl() {
    return softCongThreshGbrBwDl;
  }

  public void setSoftCongThreshGbrBwDl(int softCongThreshGbrBwDl) {
    this.softCongThreshGbrBwDl = softCongThreshGbrBwDl;
  }

  public int getSoftCongThreshGbrBwUl() {
    return softCongThreshGbrBwUl;
  }

  public void setSoftCongThreshGbrBwUl(int softCongThreshGbrBwUl) {
    this.softCongThreshGbrBwUl = softCongThreshGbrBwUl;
  }

  public int getSpare() {
    return spare;
  }

  public void setSpare(int spare) {
    this.spare = spare;
  }

  public int getUlHwAdm() {
    return ulHwAdm;
  }

  public void setUlHwAdm(int ulHwAdm) {
    this.ulHwAdm = ulHwAdm;
  }

  public String getUserLabel() {
    return userLabel;
  }

  public void setUserLabel(String userLabel) {
    this.userLabel = userLabel;
  }

  public int getUserPlaneGbrAdmBandwidthDl() {
    return userPlaneGbrAdmBandwidthDl;
  }

  public void setUserPlaneGbrAdmBandwidthDl(int userPlaneGbrAdmBandwidthDl) {
    this.userPlaneGbrAdmBandwidthDl = userPlaneGbrAdmBandwidthDl;
  }

  public int getUserPlaneGbrAdmBandwidthUl() {
    return userPlaneGbrAdmBandwidthUl;
  }

  public void setUserPlaneGbrAdmBandwidthUl(int userPlaneGbrAdmBandwidthUl) {
    this.userPlaneGbrAdmBandwidthUl = userPlaneGbrAdmBandwidthUl;
  }

  public int getUserPlaneGbrAdmEnabled() {
    return userPlaneGbrAdmEnabled;
  }

  public void setUserPlaneGbrAdmEnabled(int userPlaneGbrAdmEnabled) {
    this.userPlaneGbrAdmEnabled = userPlaneGbrAdmEnabled;
  }

  public int getUserPlaneGbrAdmMarginDl() {
    return userPlaneGbrAdmMarginDl;
  }

  public void setUserPlaneGbrAdmMarginDl(int userPlaneGbrAdmMarginDl) {
    this.userPlaneGbrAdmMarginDl = userPlaneGbrAdmMarginDl;
  }

  public int getUserPlaneGbrAdmMarginUl() {
    return userPlaneGbrAdmMarginUl;
  }

  public void setUserPlaneGbrAdmMarginUl(int userPlaneGbrAdmMarginUl) {
    this.userPlaneGbrAdmMarginUl = userPlaneGbrAdmMarginUl;
  }

  public UserPlaneIpResourceRefBean getUserPlaneIpResourceRef() {
    return userPlaneIpResourceRef;
  }

  public void setUserPlaneIpResourceRef(UserPlaneIpResourceRefBean userPlaneIpResourceRef) {
    this.userPlaneIpResourceRef = userPlaneIpResourceRef;
  }

  public UserPlaneTransportOptionBean getUserPlaneTransportOption() {
    return userPlaneTransportOption;
  }

  public void setUserPlaneTransportOption(UserPlaneTransportOptionBean userPlaneTransportOption) {
    this.userPlaneTransportOption = userPlaneTransportOption;
  }

  public List<Integer> getSpareA() {
    return spareA;
  }

  public void setSpareA(List<Integer> spareA) {
    this.spareA = spareA;
  }

  @Override
  public CreationCommand getCreationCommand(Patterns pattern, String source) {
    return null;
  }

  @Override
  public Map<String,String> getValues() {
    Map<String,String> values;
    values = StructureWithModels.createMapProperties(source);

    return values;
  }

  @Override
  public Patterns getType() {
    return Patterns.ATM_USER_PLANE_TERM_SUBRACK_REF;
  }

  public static class ControlPlaneTransportOptionBean {
    /**
     * atm : 0
     * ipv4 : 1
     */

    private int atm;
    private int ipv4;

    public ControlPlaneTransportOptionBean() {
    }

    public ControlPlaneTransportOptionBean(String[] source) {
      atm = VariableExtractor.extractIntegerFromObject(source[0]);
      ipv4 = VariableExtractor.extractIntegerFromObject(source[1]);
    }

    public int getAtm() {
      return atm;
    }

    public void setAtm(int atm) {
      this.atm = atm;
    }

    public int getIpv4() {
      return ipv4;
    }

    public void setIpv4(int ipv4) {
      this.ipv4 = ipv4;
    }

    @Override
    public String toString() {
      return "atm=" + atm +
          ",ipv4=" + ipv4;
    }
  }

  public static class UserPlaneIpResourceRefBean {
    /**
     * IpAccessHostPool : IUB
     */

    private String IpAccessHostPool;

    public UserPlaneIpResourceRefBean() {
    }

    public UserPlaneIpResourceRefBean(String source) {
      IpAccessHostPool = source;
    }

    public String getIpAccessHostPool() {
      return IpAccessHostPool;
    }

    public void setIpAccessHostPool(String IpAccessHostPool) {
      this.IpAccessHostPool = IpAccessHostPool;
    }

    @Override
    public String toString() {
      return "IpAccessHostPool=" + IpAccessHostPool;
    }
  }

  public static class UserPlaneTransportOptionBean {
    /**
     * atm : 0
     * ipv4 : 1
     */

    private int atm;
    private int ipv4;

    public UserPlaneTransportOptionBean() {
    }

    public UserPlaneTransportOptionBean(String[] source) {
      atm = source[0].split("=").length == 2 ? Integer.parseInt(source[0].split("=")[1]) : null;
      ipv4 = source[1].split("=").length == 2 ? Integer.parseInt(source[1].split("=")[1]) : null;
    }

    public int getAtm() {
      return atm;
    }

    public void setAtm(int atm) {
      this.atm = atm;
    }

    public int getIpv4() {
      return ipv4;
    }

    public void setIpv4(int ipv4) {
      this.ipv4 = ipv4;
    }

    @Override
    public String toString() {
      return "atm=" + atm +
          ",ipv4=" + ipv4;
    }
  }

  @Override
  public String toString() {
    return "crn " + name + "\n" +
        "administrativeState " + administrativeState + "\n" +
        "atmUserPlaneTermSubrackRef " + (atmUserPlaneTermSubrackRef == null ? "" : atmUserPlaneTermSubrackRef) + "\n" +
        "controlPlaneTransportOption " + controlPlaneTransportOption + "\n" +
        "dlHwAdm " + dlHwAdm + "\n" +
        "l2EstReqRetryTimeNbapC " + l2EstReqRetryTimeNbapC + "\n" +
        "l2EstReqRetryTimeNbapD " + l2EstReqRetryTimeNbapD + "\n" +
        "linkType " + linkType + "\n" +
        "poolRedundancy " + poolRedundancy + "\n" +
        "rSiteRef " + (rSiteRef == null ? "" : rSiteRef) + "\n" +
        "rbsId " + rbsId + "\n" +
        "remoteCpIpAddress1 " + remoteCpIpAddress1 + "\n" +
        "remoteCpIpAddress2 " + (remoteCpIpAddress2 == null ? "" : remoteCpIpAddress2) + "\n" +
        "remoteSctpPortNbapC " + remoteSctpPortNbapC + "\n" +
        "remoteSctpPortNbapD " + remoteSctpPortNbapD + "\n" +
        "rncModuleAllocWeight " + rncModuleAllocWeight + "\n" +
        "rncModulePreferredRef " + (rncModulePreferredRef == null ? "" : rncModulePreferredRef) + "\n" +
        "softCongThreshGbrBwDl " + softCongThreshGbrBwDl + "\n" +
        "softCongThreshGbrBwUl " + softCongThreshGbrBwUl + "\n" +
        "spare " + spare + "\n" +
        "spareA " + spareA.toString().replaceAll("[\\[\\]\\s]", "") + "\n" +
        "ulHwAdm " + ulHwAdm + "\n" +
        "userLabel " + (userLabel == null ? "" : userLabel) + "\n" +
        "userPlaneGbrAdmBandwidthDl " + userPlaneGbrAdmBandwidthDl + "\n" +
        "userPlaneGbrAdmBandwidthUl " + userPlaneGbrAdmBandwidthUl + "\n" +
        "userPlaneGbrAdmEnabled " + userPlaneGbrAdmEnabled + "\n" +
        "userPlaneGbrAdmMarginDl " + userPlaneGbrAdmMarginDl + "\n" +
        "userPlaneGbrAdmMarginUl " + userPlaneGbrAdmMarginUl + "\n" +
        "userPlaneIpResourceRef " + userPlaneIpResourceRef + "\n" +
        "userPlaneTransportOption " + userPlaneTransportOption + "\n" +
        "end\n";
  }
}