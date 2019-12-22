package com.model.modelsForCreationCommands;

import com.model.modelsForCreationCommands.util.CreationCommand;
import com.utils.Patterns;

import java.util.List;

public class AseLoadThresholdUiSpeech implements CreationCommand {

  /**
   * name : RncFunction=1,UtranCell=CK0001K
   * absPrioCellRes : {"cellReselectionPriority":3,"sPrioritySearch1":10,"sPrioritySearch2":4,"threshServingLow":16,"measIndFach":0}
   * accessClassNBarred : [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
   * accessClassesBarredCs : [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
   * accessClassesBarredPs : [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
   * admBlockRedirection : {"gsmRrc":1,"rrc":0,"speech":1}
   * administrativeState : 1
   * agpsEnabled : 1
   * amrNbSelector : 0
   * amrWbRateDlMax : 12650
   * amrWbRateUlMax : 12650
   * anrIafUtranCellConfig : {"anrEnabled":1,"relationAddEnabled":1,"relationRemoveEnabled":0,"sib11IafAnclEnabled":0}
   * anrIefUtranCellConfig : {"anrEnabled":1,"sib11IefAnclEnabled":1}
   * antennaPosition : {"latitudeSign":0,"latitude":4610187,"longitude":1492952}
   * aseDlAdm : 500
   * aseLoadThresholdUlSpeech : {"amr12200":100,"amr7950":100,"amr5900":100}
   * aseUlAdm : 500
   * autoAcbEnabled : 0
   * autoAcbMaxPsClassesToBar : 10
   * autoAcbMinRcssrInput : 5
   * autoAcbRcssrThresh : 50
   * autoAcbRcssrWeight : 2
   * autoAcbRtwpThresh : -70
   * autoAcbRtwpWeight : 10
   * bchPower : -31
   * cId : 30563
   * cbsSchedulePeriodLength : 64
   * cellBroadcastSac : -1
   * cellReserved : 1
   * cellUpdateConfirmCsInitRepeat : 3
   * cellUpdateConfirmPsInitRepeat : 3
   * codeLoadThresholdDlSf128 : 100
   * compModeAdm : 15
   * ctchAdmMargin : 0
   * ctchOccasionPeriod : 255
   * cyclicAcb : {"acbEnabled":0,"rotationGroupSize":5}
   * cyclicAcbCs : {"acbEnabled":0,"rotationGroupSize":5}
   * cyclicAcbPs : {"acbEnabled":0,"rotationGroupSize":5}
   * dchIflsMarginCode : 0
   * dchIflsMarginPower : 0
   * dchIflsThreshCode : 0
   * dchIflsThreshPower : 0
   * directedRetryTarget :
   * dlCodeAdm : 90
   * dlCodeOffloadLimit : 100
   * dlCodePowerCmEnabled : 0
   * dlPowerOffloadLimit : 100
   * dmcrEnabled : 0
   * dnclEnabled : 0
   * downswitchTimer : -1
   * eulMcServingCellUsersAdmTti2 : 3
   * eulNonServingCellUsersAdm : 100
   * eulServingCellUsersAdm : 60
   * eulServingCellUsersAdmTti2 : 32
   * fachMeasOccaCycLenCoeff : 0
   * ganHoEnabled : 0
   * hardIfhoCorr : 3
   * hcsSib3Config : {"hcsPrio":0,"qHcs":0,"sSearchHcs":-105}
   * hcsUsage : {"idleMode":0,"connectedMode":0}
   * hoType : 1
   * hsIflsDownswitchTrigg : {"toFach":0,"toUra":0,"fastDormancy":1}
   * hsIflsHighLoadThresh : 100
   * hsIflsMarginUsers : 0
   * hsIflsPowerLoadThresh : 0
   * hsIflsRedirectLoadLimit : 0
   * hsIflsSpeechMultiRabTrigg : 0
   * hsIflsThreshUsers : 1
   * hsIflsTrigger : {"fromFach":1,"fromUra":1}
   * hsdpaUsersAdm : 60
   * hsdpaUsersOffloadLimit : 100
   * hsdschInactivityTimer : -1
   * hsdschInactivityTimerCpc : -1
   * iFCong : 621
   * iFHyst : 6000
   * ifIratHoPsIntHsEnabled : 1
   * iflsCpichEcnoThresh : -24
   * iflsMode : 2
   * iflsRedirectUarfcn : 0
   * inactivityTimeMultiPsInteractive : -1
   * inactivityTimer : -1
   * inactivityTimerEnhUeDrx : -1
   * inactivityTimerPch : -1
   * individualOffset : 0
   * interFreqFddMeasIndicator : 1
   * interPwrMax : 30
   * interRate : 845
   * iubLinkRef : {"IubLink":"CK0001"}
   * loadBasedHoSupport : 1
   * loadBasedHoType : 0
   * loadSharingGsmFraction : 100
   * loadSharingGsmThreshold : 80
   * loadSharingMargin : 0
   * localCellId : 30563
   * locationAreaRef : {"LocationArea":12710}
   * lteMeasEnabled : 1
   * maxPwrMax : 30
   * maxRate : 40690
   * maxTxPowerUl : 24
   * maximumTransmissionPower : 430
   * minPwrMax : -15
   * minPwrRl : -150
   * minimumRate : 370
   * mocnCellProfileRef : {"MocnCellProfile":"Astelit"}
   * nOutSyncInd : 21
   * pagingPermAccessCtrl : {"locRegAcb":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],"locRegRestr":0,"pagingRespRestr":0}
   * pathlossThreshold : 130
   * primaryCpichPower : 330
   * primarySchPower : -18
   * primaryScramblingCode : 361
   * primaryTpsCell : 0
   * psHoToLteEnabled : 1
   * pwrAdm : 85
   * pwrLoadThresholdDlSpeech : {"amr12200":100,"amr7950":100,"amr5900":100}
   * qHyst1 : 2
   * qHyst2 : 2
   * qQualMin : -20
   * qRxLevMin : -115
   * qualMeasQuantity : 2
   * rachOverloadProtect : 1
   * rateSelectionPsInteractive : {"channelType":0,"ulPrefRate":16,"dlPrefRate":16}
   * redirectUarfcn : 0
   * releaseRedirect : 1
   * releaseRedirectEutraTriggers : {"csFallbackCsRelease":1,"csFallbackDchToFach":0,"dchToFach":0,"fachToUra":0,"fastDormancy":0,"normalRelease":0}
   * releaseRedirectHsIfls : 0
   * reportingRange1a : 0
   * reportingRange1b : 0
   * rlFailureT : 20
   * routingAreaRef : {"LocationArea":12710,"RoutingArea":2}
   * rrcLcEnabled : 1
   * rwrEutraCc : 1
   * sHcsRat : 3
   * sInterSearch : 19
   * sIntraSearch : 23
   * sRatSearch : 0
   * secondaryCpichPower : 0
   * secondarySchPower : -35
   * servDiffRrcAdmHighPrioProfile : 3
   * serviceAreaRef : {"LocationArea":12710,"ServiceArea":30563}
   * serviceRestrictions : {"csVideoCalls":0}
   * sf128Adm : 128
   * sf16Adm : 16
   * sf16AdmUl : 16
   * sf16gAdm : 16
   * sf32Adm : 32
   * sf4AdmUl : 4
   * sf64AdmUl : 100
   * sf8Adm : 8
   * sf8AdmUl : 8
   * sf8gAdmUl : 8
   * sib11UtranCellConfig : {"minGsmRelationsInSib11":10,"minIefRelationsInSib11":20}
   * sib1PlmnScopeValueTag : 5
   * spare : 0
   * spareA : [0,0,0,0,0,0,0,0,0,0]
   * srbAdmExempt : 0
   * standAloneSrbSelector : 1
   * tCell : 6
   * timeToTrigger1a : -1
   * timeToTrigger1b : -1
   * tpsCellThresholds : {"tpsCellThreshEnabled":0,"tpsLockThreshold":5,"tpsUnlockThreshold":15}
   * tpsPeriodsRef :
   * transmissionScheme : 0
   * treSelection : 1
   * uarfcnDl : 10612
   * uarfcnUl : 9662
   * updateLocator : 0
   * uraRef : {"RncFunction":1,"Ura":12731}
   * usedFreqThresh2dEcno : -16
   * usedFreqThresh2dRscp : -110
   * userLabel :
   * utranCellPosition :
   */

  private String name;
  private AbsPrioCellResBean absPrioCellRes;
  private AdmBlockRedirectionBean admBlockRedirection;
  private int administrativeState;
  private int agpsEnabled;
  private int amrNbSelector;
  private int amrWbRateDlMax;
  private int amrWbRateUlMax;
  private AnrIafUtranCellConfigBean anrIafUtranCellConfig;
  private AnrIefUtranCellConfigBean anrIefUtranCellConfig;
  private AntennaPositionBean antennaPosition;
  private int aseDlAdm;
  private AseLoadThresholdUlSpeechBean aseLoadThresholdUlSpeech;
  private int aseUlAdm;
  private int autoAcbEnabled;
  private int autoAcbMaxPsClassesToBar;
  private int autoAcbMinRcssrInput;
  private int autoAcbRcssrThresh;
  private int autoAcbRcssrWeight;
  private int autoAcbRtwpThresh;
  private int autoAcbRtwpWeight;
  private int bchPower;
  private int cId;
  private int cbsSchedulePeriodLength;
  private int cellBroadcastSac;
  private int cellReserved;
  private int cellUpdateConfirmCsInitRepeat;
  private int cellUpdateConfirmPsInitRepeat;
  private int codeLoadThresholdDlSf128;
  private int compModeAdm;
  private int ctchAdmMargin;
  private int ctchOccasionPeriod;
  private CyclicAcbBean cyclicAcb;
  private CyclicAcbCsBean cyclicAcbCs;
  private CyclicAcbPsBean cyclicAcbPs;
  private int dchIflsMarginCode;
  private int dchIflsMarginPower;
  private int dchIflsThreshCode;
  private int dchIflsThreshPower;
  private String directedRetryTarget;
  private int dlCodeAdm;
  private int dlCodeOffloadLimit;
  private int dlCodePowerCmEnabled;
  private int dlPowerOffloadLimit;
  private int dmcrEnabled;
  private int dnclEnabled;
  private int downswitchTimer;
  private int eulMcServingCellUsersAdmTti2;
  private int eulNonServingCellUsersAdm;
  private int eulServingCellUsersAdm;
  private int eulServingCellUsersAdmTti2;
  private int fachMeasOccaCycLenCoeff;
  private int ganHoEnabled;
  private int hardIfhoCorr;
  private HcsSib3ConfigBean hcsSib3Config;
  private HcsUsageBean hcsUsage;
  private int hoType;
  private HsIflsDownswitchTriggBean hsIflsDownswitchTrigg;
  private int hsIflsHighLoadThresh;
  private int hsIflsMarginUsers;
  private int hsIflsPowerLoadThresh;
  private int hsIflsRedirectLoadLimit;
  private int hsIflsSpeechMultiRabTrigg;
  private int hsIflsThreshUsers;
  private HsIflsTriggerBean hsIflsTrigger;
  private int hsdpaUsersAdm;
  private int hsdpaUsersOffloadLimit;
  private int hsdschInactivityTimer;
  private int hsdschInactivityTimerCpc;
  private int iFCong;
  private int iFHyst;
  private int ifIratHoPsIntHsEnabled;
  private int iflsCpichEcnoThresh;
  private int iflsMode;
  private int iflsRedirectUarfcn;
  private int inactivityTimeMultiPsInteractive;
  private int inactivityTimer;
  private int inactivityTimerEnhUeDrx;
  private int inactivityTimerPch;
  private int individualOffset;
  private int interFreqFddMeasIndicator;
  private int interPwrMax;
  private int interRate;
  private IubLinkRefBean iubLinkRef;
  private int loadBasedHoSupport;
  private int loadBasedHoType;
  private int loadSharingGsmFraction;
  private int loadSharingGsmThreshold;
  private int loadSharingMargin;
  private int localCellId;
  private LocationAreaRefBean locationAreaRef;
  private int lteMeasEnabled;
  private int maxPwrMax;
  private int maxRate;
  private int maxTxPowerUl;
  private int maximumTransmissionPower;
  private int minPwrMax;
  private int minPwrRl;
  private int minimumRate;
  private MocnCellProfileRefBean mocnCellProfileRef;
  private int nOutSyncInd;
  private PagingPermAccessCtrlBean pagingPermAccessCtrl;
  private int pathlossThreshold;
  private int primaryCpichPower;
  private int primarySchPower;
  private int primaryScramblingCode;
  private int primaryTpsCell;
  private int psHoToLteEnabled;
  private int pwrAdm;
  private PwrLoadThresholdDlSpeechBean pwrLoadThresholdDlSpeech;
  private int qHyst1;
  private int qHyst2;
  private int qQualMin;
  private int qRxLevMin;
  private int qualMeasQuantity;
  private int rachOverloadProtect;
  private RateSelectionPsInteractiveBean rateSelectionPsInteractive;
  private int redirectUarfcn;
  private int releaseRedirect;
  private ReleaseRedirectEutraTriggersBean releaseRedirectEutraTriggers;
  private int releaseRedirectHsIfls;
  private int reportingRange1a;
  private int reportingRange1b;
  private int rlFailureT;
  private RoutingAreaRefBean routingAreaRef;
  private int rrcLcEnabled;
  private int rwrEutraCc;
  private int sHcsRat;
  private int sInterSearch;
  private int sIntraSearch;
  private int sRatSearch;
  private int secondaryCpichPower;
  private int secondarySchPower;
  private int servDiffRrcAdmHighPrioProfile;
  private ServiceAreaRefBean serviceAreaRef;
  private ServiceRestrictionsBean serviceRestrictions;
  private int sf128Adm;
  private int sf16Adm;
  private int sf16AdmUl;
  private int sf16gAdm;
  private int sf32Adm;
  private int sf4AdmUl;
  private int sf64AdmUl;
  private int sf8Adm;
  private int sf8AdmUl;
  private int sf8gAdmUl;
  private Sib11UtranCellConfigBean sib11UtranCellConfig;
  private int sib1PlmnScopeValueTag;
  private int spare;
  private int srbAdmExempt;
  private int standAloneSrbSelector;
  private int tCell;
  private int timeToTrigger1a;
  private int timeToTrigger1b;
  private TpsCellThresholdsBean tpsCellThresholds;
  private String tpsPeriodsRef;
  private int transmissionScheme;
  private int treSelection;
  private int uarfcnDl;
  private int uarfcnUl;
  private int updateLocator;
  private UraRefBean uraRef;
  private int usedFreqThresh2dEcno;
  private int usedFreqThresh2dRscp;
  private String userLabel;
  private String utranCellPosition;
  private List<Integer> accessClassNBarred;
  private List<Integer> accessClassesBarredCs;
  private List<Integer> accessClassesBarredPs;
  private List<Integer> spareA;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AbsPrioCellResBean getAbsPrioCellRes() {
    return absPrioCellRes;
  }

  public void setAbsPrioCellRes(AbsPrioCellResBean absPrioCellRes) {
    this.absPrioCellRes = absPrioCellRes;
  }

  public AdmBlockRedirectionBean getAdmBlockRedirection() {
    return admBlockRedirection;
  }

  public void setAdmBlockRedirection(AdmBlockRedirectionBean admBlockRedirection) {
    this.admBlockRedirection = admBlockRedirection;
  }

  public int getAdministrativeState() {
    return administrativeState;
  }

  public void setAdministrativeState(int administrativeState) {
    this.administrativeState = administrativeState;
  }

  public int getAgpsEnabled() {
    return agpsEnabled;
  }

  public void setAgpsEnabled(int agpsEnabled) {
    this.agpsEnabled = agpsEnabled;
  }

  public int getAmrNbSelector() {
    return amrNbSelector;
  }

  public void setAmrNbSelector(int amrNbSelector) {
    this.amrNbSelector = amrNbSelector;
  }

  public int getAmrWbRateDlMax() {
    return amrWbRateDlMax;
  }

  public void setAmrWbRateDlMax(int amrWbRateDlMax) {
    this.amrWbRateDlMax = amrWbRateDlMax;
  }

  public int getAmrWbRateUlMax() {
    return amrWbRateUlMax;
  }

  public void setAmrWbRateUlMax(int amrWbRateUlMax) {
    this.amrWbRateUlMax = amrWbRateUlMax;
  }

  public AnrIafUtranCellConfigBean getAnrIafUtranCellConfig() {
    return anrIafUtranCellConfig;
  }

  public void setAnrIafUtranCellConfig(AnrIafUtranCellConfigBean anrIafUtranCellConfig) {
    this.anrIafUtranCellConfig = anrIafUtranCellConfig;
  }

  public AnrIefUtranCellConfigBean getAnrIefUtranCellConfig() {
    return anrIefUtranCellConfig;
  }

  public void setAnrIefUtranCellConfig(AnrIefUtranCellConfigBean anrIefUtranCellConfig) {
    this.anrIefUtranCellConfig = anrIefUtranCellConfig;
  }

  public AntennaPositionBean getAntennaPosition() {
    return antennaPosition;
  }

  public void setAntennaPosition(AntennaPositionBean antennaPosition) {
    this.antennaPosition = antennaPosition;
  }

  public int getAseDlAdm() {
    return aseDlAdm;
  }

  public void setAseDlAdm(int aseDlAdm) {
    this.aseDlAdm = aseDlAdm;
  }

  public AseLoadThresholdUlSpeechBean getAseLoadThresholdUlSpeech() {
    return aseLoadThresholdUlSpeech;
  }

  public void setAseLoadThresholdUlSpeech(AseLoadThresholdUlSpeechBean aseLoadThresholdUlSpeech) {
    this.aseLoadThresholdUlSpeech = aseLoadThresholdUlSpeech;
  }

  public int getAseUlAdm() {
    return aseUlAdm;
  }

  public void setAseUlAdm(int aseUlAdm) {
    this.aseUlAdm = aseUlAdm;
  }

  public int getAutoAcbEnabled() {
    return autoAcbEnabled;
  }

  public void setAutoAcbEnabled(int autoAcbEnabled) {
    this.autoAcbEnabled = autoAcbEnabled;
  }

  public int getAutoAcbMaxPsClassesToBar() {
    return autoAcbMaxPsClassesToBar;
  }

  public void setAutoAcbMaxPsClassesToBar(int autoAcbMaxPsClassesToBar) {
    this.autoAcbMaxPsClassesToBar = autoAcbMaxPsClassesToBar;
  }

  public int getAutoAcbMinRcssrInput() {
    return autoAcbMinRcssrInput;
  }

  public void setAutoAcbMinRcssrInput(int autoAcbMinRcssrInput) {
    this.autoAcbMinRcssrInput = autoAcbMinRcssrInput;
  }

  public int getAutoAcbRcssrThresh() {
    return autoAcbRcssrThresh;
  }

  public void setAutoAcbRcssrThresh(int autoAcbRcssrThresh) {
    this.autoAcbRcssrThresh = autoAcbRcssrThresh;
  }

  public int getAutoAcbRcssrWeight() {
    return autoAcbRcssrWeight;
  }

  public void setAutoAcbRcssrWeight(int autoAcbRcssrWeight) {
    this.autoAcbRcssrWeight = autoAcbRcssrWeight;
  }

  public int getAutoAcbRtwpThresh() {
    return autoAcbRtwpThresh;
  }

  public void setAutoAcbRtwpThresh(int autoAcbRtwpThresh) {
    this.autoAcbRtwpThresh = autoAcbRtwpThresh;
  }

  public int getAutoAcbRtwpWeight() {
    return autoAcbRtwpWeight;
  }

  public void setAutoAcbRtwpWeight(int autoAcbRtwpWeight) {
    this.autoAcbRtwpWeight = autoAcbRtwpWeight;
  }

  public int getBchPower() {
    return bchPower;
  }

  public void setBchPower(int bchPower) {
    this.bchPower = bchPower;
  }

  public int getCId() {
    return cId;
  }

  public void setCId(int cId) {
    this.cId = cId;
  }

  public int getCbsSchedulePeriodLength() {
    return cbsSchedulePeriodLength;
  }

  public void setCbsSchedulePeriodLength(int cbsSchedulePeriodLength) {
    this.cbsSchedulePeriodLength = cbsSchedulePeriodLength;
  }

  public int getCellBroadcastSac() {
    return cellBroadcastSac;
  }

  public void setCellBroadcastSac(int cellBroadcastSac) {
    this.cellBroadcastSac = cellBroadcastSac;
  }

  public int getCellReserved() {
    return cellReserved;
  }

  public void setCellReserved(int cellReserved) {
    this.cellReserved = cellReserved;
  }

  public int getCellUpdateConfirmCsInitRepeat() {
    return cellUpdateConfirmCsInitRepeat;
  }

  public void setCellUpdateConfirmCsInitRepeat(int cellUpdateConfirmCsInitRepeat) {
    this.cellUpdateConfirmCsInitRepeat = cellUpdateConfirmCsInitRepeat;
  }

  public int getCellUpdateConfirmPsInitRepeat() {
    return cellUpdateConfirmPsInitRepeat;
  }

  public void setCellUpdateConfirmPsInitRepeat(int cellUpdateConfirmPsInitRepeat) {
    this.cellUpdateConfirmPsInitRepeat = cellUpdateConfirmPsInitRepeat;
  }

  public int getCodeLoadThresholdDlSf128() {
    return codeLoadThresholdDlSf128;
  }

  public void setCodeLoadThresholdDlSf128(int codeLoadThresholdDlSf128) {
    this.codeLoadThresholdDlSf128 = codeLoadThresholdDlSf128;
  }

  public int getCompModeAdm() {
    return compModeAdm;
  }

  public void setCompModeAdm(int compModeAdm) {
    this.compModeAdm = compModeAdm;
  }

  public int getCtchAdmMargin() {
    return ctchAdmMargin;
  }

  public void setCtchAdmMargin(int ctchAdmMargin) {
    this.ctchAdmMargin = ctchAdmMargin;
  }

  public int getCtchOccasionPeriod() {
    return ctchOccasionPeriod;
  }

  public void setCtchOccasionPeriod(int ctchOccasionPeriod) {
    this.ctchOccasionPeriod = ctchOccasionPeriod;
  }

  public CyclicAcbBean getCyclicAcb() {
    return cyclicAcb;
  }

  public void setCyclicAcb(CyclicAcbBean cyclicAcb) {
    this.cyclicAcb = cyclicAcb;
  }

  public CyclicAcbCsBean getCyclicAcbCs() {
    return cyclicAcbCs;
  }

  public void setCyclicAcbCs(CyclicAcbCsBean cyclicAcbCs) {
    this.cyclicAcbCs = cyclicAcbCs;
  }

  public CyclicAcbPsBean getCyclicAcbPs() {
    return cyclicAcbPs;
  }

  public void setCyclicAcbPs(CyclicAcbPsBean cyclicAcbPs) {
    this.cyclicAcbPs = cyclicAcbPs;
  }

  public int getDchIflsMarginCode() {
    return dchIflsMarginCode;
  }

  public void setDchIflsMarginCode(int dchIflsMarginCode) {
    this.dchIflsMarginCode = dchIflsMarginCode;
  }

  public int getDchIflsMarginPower() {
    return dchIflsMarginPower;
  }

  public void setDchIflsMarginPower(int dchIflsMarginPower) {
    this.dchIflsMarginPower = dchIflsMarginPower;
  }

  public int getDchIflsThreshCode() {
    return dchIflsThreshCode;
  }

  public void setDchIflsThreshCode(int dchIflsThreshCode) {
    this.dchIflsThreshCode = dchIflsThreshCode;
  }

  public int getDchIflsThreshPower() {
    return dchIflsThreshPower;
  }

  public void setDchIflsThreshPower(int dchIflsThreshPower) {
    this.dchIflsThreshPower = dchIflsThreshPower;
  }

  public String getDirectedRetryTarget() {
    return directedRetryTarget;
  }

  public void setDirectedRetryTarget(String directedRetryTarget) {
    this.directedRetryTarget = directedRetryTarget;
  }

  public int getDlCodeAdm() {
    return dlCodeAdm;
  }

  public void setDlCodeAdm(int dlCodeAdm) {
    this.dlCodeAdm = dlCodeAdm;
  }

  public int getDlCodeOffloadLimit() {
    return dlCodeOffloadLimit;
  }

  public void setDlCodeOffloadLimit(int dlCodeOffloadLimit) {
    this.dlCodeOffloadLimit = dlCodeOffloadLimit;
  }

  public int getDlCodePowerCmEnabled() {
    return dlCodePowerCmEnabled;
  }

  public void setDlCodePowerCmEnabled(int dlCodePowerCmEnabled) {
    this.dlCodePowerCmEnabled = dlCodePowerCmEnabled;
  }

  public int getDlPowerOffloadLimit() {
    return dlPowerOffloadLimit;
  }

  public void setDlPowerOffloadLimit(int dlPowerOffloadLimit) {
    this.dlPowerOffloadLimit = dlPowerOffloadLimit;
  }

  public int getDmcrEnabled() {
    return dmcrEnabled;
  }

  public void setDmcrEnabled(int dmcrEnabled) {
    this.dmcrEnabled = dmcrEnabled;
  }

  public int getDnclEnabled() {
    return dnclEnabled;
  }

  public void setDnclEnabled(int dnclEnabled) {
    this.dnclEnabled = dnclEnabled;
  }

  public int getDownswitchTimer() {
    return downswitchTimer;
  }

  public void setDownswitchTimer(int downswitchTimer) {
    this.downswitchTimer = downswitchTimer;
  }

  public int getEulMcServingCellUsersAdmTti2() {
    return eulMcServingCellUsersAdmTti2;
  }

  public void setEulMcServingCellUsersAdmTti2(int eulMcServingCellUsersAdmTti2) {
    this.eulMcServingCellUsersAdmTti2 = eulMcServingCellUsersAdmTti2;
  }

  public int getEulNonServingCellUsersAdm() {
    return eulNonServingCellUsersAdm;
  }

  public void setEulNonServingCellUsersAdm(int eulNonServingCellUsersAdm) {
    this.eulNonServingCellUsersAdm = eulNonServingCellUsersAdm;
  }

  public int getEulServingCellUsersAdm() {
    return eulServingCellUsersAdm;
  }

  public void setEulServingCellUsersAdm(int eulServingCellUsersAdm) {
    this.eulServingCellUsersAdm = eulServingCellUsersAdm;
  }

  public int getEulServingCellUsersAdmTti2() {
    return eulServingCellUsersAdmTti2;
  }

  public void setEulServingCellUsersAdmTti2(int eulServingCellUsersAdmTti2) {
    this.eulServingCellUsersAdmTti2 = eulServingCellUsersAdmTti2;
  }

  public int getFachMeasOccaCycLenCoeff() {
    return fachMeasOccaCycLenCoeff;
  }

  public void setFachMeasOccaCycLenCoeff(int fachMeasOccaCycLenCoeff) {
    this.fachMeasOccaCycLenCoeff = fachMeasOccaCycLenCoeff;
  }

  public int getGanHoEnabled() {
    return ganHoEnabled;
  }

  public void setGanHoEnabled(int ganHoEnabled) {
    this.ganHoEnabled = ganHoEnabled;
  }

  public int getHardIfhoCorr() {
    return hardIfhoCorr;
  }

  public void setHardIfhoCorr(int hardIfhoCorr) {
    this.hardIfhoCorr = hardIfhoCorr;
  }

  public HcsSib3ConfigBean getHcsSib3Config() {
    return hcsSib3Config;
  }

  public void setHcsSib3Config(HcsSib3ConfigBean hcsSib3Config) {
    this.hcsSib3Config = hcsSib3Config;
  }

  public HcsUsageBean getHcsUsage() {
    return hcsUsage;
  }

  public void setHcsUsage(HcsUsageBean hcsUsage) {
    this.hcsUsage = hcsUsage;
  }

  public int getHoType() {
    return hoType;
  }

  public void setHoType(int hoType) {
    this.hoType = hoType;
  }

  public HsIflsDownswitchTriggBean getHsIflsDownswitchTrigg() {
    return hsIflsDownswitchTrigg;
  }

  public void setHsIflsDownswitchTrigg(HsIflsDownswitchTriggBean hsIflsDownswitchTrigg) {
    this.hsIflsDownswitchTrigg = hsIflsDownswitchTrigg;
  }

  public int getHsIflsHighLoadThresh() {
    return hsIflsHighLoadThresh;
  }

  public void setHsIflsHighLoadThresh(int hsIflsHighLoadThresh) {
    this.hsIflsHighLoadThresh = hsIflsHighLoadThresh;
  }

  public int getHsIflsMarginUsers() {
    return hsIflsMarginUsers;
  }

  public void setHsIflsMarginUsers(int hsIflsMarginUsers) {
    this.hsIflsMarginUsers = hsIflsMarginUsers;
  }

  public int getHsIflsPowerLoadThresh() {
    return hsIflsPowerLoadThresh;
  }

  public void setHsIflsPowerLoadThresh(int hsIflsPowerLoadThresh) {
    this.hsIflsPowerLoadThresh = hsIflsPowerLoadThresh;
  }

  public int getHsIflsRedirectLoadLimit() {
    return hsIflsRedirectLoadLimit;
  }

  public void setHsIflsRedirectLoadLimit(int hsIflsRedirectLoadLimit) {
    this.hsIflsRedirectLoadLimit = hsIflsRedirectLoadLimit;
  }

  public int getHsIflsSpeechMultiRabTrigg() {
    return hsIflsSpeechMultiRabTrigg;
  }

  public void setHsIflsSpeechMultiRabTrigg(int hsIflsSpeechMultiRabTrigg) {
    this.hsIflsSpeechMultiRabTrigg = hsIflsSpeechMultiRabTrigg;
  }

  public int getHsIflsThreshUsers() {
    return hsIflsThreshUsers;
  }

  public void setHsIflsThreshUsers(int hsIflsThreshUsers) {
    this.hsIflsThreshUsers = hsIflsThreshUsers;
  }

  public HsIflsTriggerBean getHsIflsTrigger() {
    return hsIflsTrigger;
  }

  public void setHsIflsTrigger(HsIflsTriggerBean hsIflsTrigger) {
    this.hsIflsTrigger = hsIflsTrigger;
  }

  public int getHsdpaUsersAdm() {
    return hsdpaUsersAdm;
  }

  public void setHsdpaUsersAdm(int hsdpaUsersAdm) {
    this.hsdpaUsersAdm = hsdpaUsersAdm;
  }

  public int getHsdpaUsersOffloadLimit() {
    return hsdpaUsersOffloadLimit;
  }

  public void setHsdpaUsersOffloadLimit(int hsdpaUsersOffloadLimit) {
    this.hsdpaUsersOffloadLimit = hsdpaUsersOffloadLimit;
  }

  public int getHsdschInactivityTimer() {
    return hsdschInactivityTimer;
  }

  public void setHsdschInactivityTimer(int hsdschInactivityTimer) {
    this.hsdschInactivityTimer = hsdschInactivityTimer;
  }

  public int getHsdschInactivityTimerCpc() {
    return hsdschInactivityTimerCpc;
  }

  public void setHsdschInactivityTimerCpc(int hsdschInactivityTimerCpc) {
    this.hsdschInactivityTimerCpc = hsdschInactivityTimerCpc;
  }

  public int getIFCong() {
    return iFCong;
  }

  public void setIFCong(int iFCong) {
    this.iFCong = iFCong;
  }

  public int getIFHyst() {
    return iFHyst;
  }

  public void setIFHyst(int iFHyst) {
    this.iFHyst = iFHyst;
  }

  public int getIfIratHoPsIntHsEnabled() {
    return ifIratHoPsIntHsEnabled;
  }

  public void setIfIratHoPsIntHsEnabled(int ifIratHoPsIntHsEnabled) {
    this.ifIratHoPsIntHsEnabled = ifIratHoPsIntHsEnabled;
  }

  public int getIflsCpichEcnoThresh() {
    return iflsCpichEcnoThresh;
  }

  public void setIflsCpichEcnoThresh(int iflsCpichEcnoThresh) {
    this.iflsCpichEcnoThresh = iflsCpichEcnoThresh;
  }

  public int getIflsMode() {
    return iflsMode;
  }

  public void setIflsMode(int iflsMode) {
    this.iflsMode = iflsMode;
  }

  public int getIflsRedirectUarfcn() {
    return iflsRedirectUarfcn;
  }

  public void setIflsRedirectUarfcn(int iflsRedirectUarfcn) {
    this.iflsRedirectUarfcn = iflsRedirectUarfcn;
  }

  public int getInactivityTimeMultiPsInteractive() {
    return inactivityTimeMultiPsInteractive;
  }

  public void setInactivityTimeMultiPsInteractive(int inactivityTimeMultiPsInteractive) {
    this.inactivityTimeMultiPsInteractive = inactivityTimeMultiPsInteractive;
  }

  public int getInactivityTimer() {
    return inactivityTimer;
  }

  public void setInactivityTimer(int inactivityTimer) {
    this.inactivityTimer = inactivityTimer;
  }

  public int getInactivityTimerEnhUeDrx() {
    return inactivityTimerEnhUeDrx;
  }

  public void setInactivityTimerEnhUeDrx(int inactivityTimerEnhUeDrx) {
    this.inactivityTimerEnhUeDrx = inactivityTimerEnhUeDrx;
  }

  public int getInactivityTimerPch() {
    return inactivityTimerPch;
  }

  public void setInactivityTimerPch(int inactivityTimerPch) {
    this.inactivityTimerPch = inactivityTimerPch;
  }

  public int getIndividualOffset() {
    return individualOffset;
  }

  public void setIndividualOffset(int individualOffset) {
    this.individualOffset = individualOffset;
  }

  public int getInterFreqFddMeasIndicator() {
    return interFreqFddMeasIndicator;
  }

  public void setInterFreqFddMeasIndicator(int interFreqFddMeasIndicator) {
    this.interFreqFddMeasIndicator = interFreqFddMeasIndicator;
  }

  public int getInterPwrMax() {
    return interPwrMax;
  }

  public void setInterPwrMax(int interPwrMax) {
    this.interPwrMax = interPwrMax;
  }

  public int getInterRate() {
    return interRate;
  }

  public void setInterRate(int interRate) {
    this.interRate = interRate;
  }

  public IubLinkRefBean getIubLinkRef() {
    return iubLinkRef;
  }

  public void setIubLinkRef(IubLinkRefBean iubLinkRef) {
    this.iubLinkRef = iubLinkRef;
  }

  public int getLoadBasedHoSupport() {
    return loadBasedHoSupport;
  }

  public void setLoadBasedHoSupport(int loadBasedHoSupport) {
    this.loadBasedHoSupport = loadBasedHoSupport;
  }

  public int getLoadBasedHoType() {
    return loadBasedHoType;
  }

  public void setLoadBasedHoType(int loadBasedHoType) {
    this.loadBasedHoType = loadBasedHoType;
  }

  public int getLoadSharingGsmFraction() {
    return loadSharingGsmFraction;
  }

  public void setLoadSharingGsmFraction(int loadSharingGsmFraction) {
    this.loadSharingGsmFraction = loadSharingGsmFraction;
  }

  public int getLoadSharingGsmThreshold() {
    return loadSharingGsmThreshold;
  }

  public void setLoadSharingGsmThreshold(int loadSharingGsmThreshold) {
    this.loadSharingGsmThreshold = loadSharingGsmThreshold;
  }

  public int getLoadSharingMargin() {
    return loadSharingMargin;
  }

  public void setLoadSharingMargin(int loadSharingMargin) {
    this.loadSharingMargin = loadSharingMargin;
  }

  public int getLocalCellId() {
    return localCellId;
  }

  public void setLocalCellId(int localCellId) {
    this.localCellId = localCellId;
  }

  public LocationAreaRefBean getLocationAreaRef() {
    return locationAreaRef;
  }

  public void setLocationAreaRef(LocationAreaRefBean locationAreaRef) {
    this.locationAreaRef = locationAreaRef;
  }

  public int getLteMeasEnabled() {
    return lteMeasEnabled;
  }

  public void setLteMeasEnabled(int lteMeasEnabled) {
    this.lteMeasEnabled = lteMeasEnabled;
  }

  public int getMaxPwrMax() {
    return maxPwrMax;
  }

  public void setMaxPwrMax(int maxPwrMax) {
    this.maxPwrMax = maxPwrMax;
  }

  public int getMaxRate() {
    return maxRate;
  }

  public void setMaxRate(int maxRate) {
    this.maxRate = maxRate;
  }

  public int getMaxTxPowerUl() {
    return maxTxPowerUl;
  }

  public void setMaxTxPowerUl(int maxTxPowerUl) {
    this.maxTxPowerUl = maxTxPowerUl;
  }

  public int getMaximumTransmissionPower() {
    return maximumTransmissionPower;
  }

  public void setMaximumTransmissionPower(int maximumTransmissionPower) {
    this.maximumTransmissionPower = maximumTransmissionPower;
  }

  public int getMinPwrMax() {
    return minPwrMax;
  }

  public void setMinPwrMax(int minPwrMax) {
    this.minPwrMax = minPwrMax;
  }

  public int getMinPwrRl() {
    return minPwrRl;
  }

  public void setMinPwrRl(int minPwrRl) {
    this.minPwrRl = minPwrRl;
  }

  public int getMinimumRate() {
    return minimumRate;
  }

  public void setMinimumRate(int minimumRate) {
    this.minimumRate = minimumRate;
  }

  public MocnCellProfileRefBean getMocnCellProfileRef() {
    return mocnCellProfileRef;
  }

  public void setMocnCellProfileRef(MocnCellProfileRefBean mocnCellProfileRef) {
    this.mocnCellProfileRef = mocnCellProfileRef;
  }

  public int getNOutSyncInd() {
    return nOutSyncInd;
  }

  public void setNOutSyncInd(int nOutSyncInd) {
    this.nOutSyncInd = nOutSyncInd;
  }

  public PagingPermAccessCtrlBean getPagingPermAccessCtrl() {
    return pagingPermAccessCtrl;
  }

  public void setPagingPermAccessCtrl(PagingPermAccessCtrlBean pagingPermAccessCtrl) {
    this.pagingPermAccessCtrl = pagingPermAccessCtrl;
  }

  public int getPathlossThreshold() {
    return pathlossThreshold;
  }

  public void setPathlossThreshold(int pathlossThreshold) {
    this.pathlossThreshold = pathlossThreshold;
  }

  public int getPrimaryCpichPower() {
    return primaryCpichPower;
  }

  public void setPrimaryCpichPower(int primaryCpichPower) {
    this.primaryCpichPower = primaryCpichPower;
  }

  public int getPrimarySchPower() {
    return primarySchPower;
  }

  public void setPrimarySchPower(int primarySchPower) {
    this.primarySchPower = primarySchPower;
  }

  public int getPrimaryScramblingCode() {
    return primaryScramblingCode;
  }

  public void setPrimaryScramblingCode(int primaryScramblingCode) {
    this.primaryScramblingCode = primaryScramblingCode;
  }

  public int getPrimaryTpsCell() {
    return primaryTpsCell;
  }

  public void setPrimaryTpsCell(int primaryTpsCell) {
    this.primaryTpsCell = primaryTpsCell;
  }

  public int getPsHoToLteEnabled() {
    return psHoToLteEnabled;
  }

  public void setPsHoToLteEnabled(int psHoToLteEnabled) {
    this.psHoToLteEnabled = psHoToLteEnabled;
  }

  public int getPwrAdm() {
    return pwrAdm;
  }

  public void setPwrAdm(int pwrAdm) {
    this.pwrAdm = pwrAdm;
  }

  public PwrLoadThresholdDlSpeechBean getPwrLoadThresholdDlSpeech() {
    return pwrLoadThresholdDlSpeech;
  }

  public void setPwrLoadThresholdDlSpeech(PwrLoadThresholdDlSpeechBean pwrLoadThresholdDlSpeech) {
    this.pwrLoadThresholdDlSpeech = pwrLoadThresholdDlSpeech;
  }

  public int getQHyst1() {
    return qHyst1;
  }

  public void setQHyst1(int qHyst1) {
    this.qHyst1 = qHyst1;
  }

  public int getQHyst2() {
    return qHyst2;
  }

  public void setQHyst2(int qHyst2) {
    this.qHyst2 = qHyst2;
  }

  public int getQQualMin() {
    return qQualMin;
  }

  public void setQQualMin(int qQualMin) {
    this.qQualMin = qQualMin;
  }

  public int getQRxLevMin() {
    return qRxLevMin;
  }

  public void setQRxLevMin(int qRxLevMin) {
    this.qRxLevMin = qRxLevMin;
  }

  public int getQualMeasQuantity() {
    return qualMeasQuantity;
  }

  public void setQualMeasQuantity(int qualMeasQuantity) {
    this.qualMeasQuantity = qualMeasQuantity;
  }

  public int getRachOverloadProtect() {
    return rachOverloadProtect;
  }

  public void setRachOverloadProtect(int rachOverloadProtect) {
    this.rachOverloadProtect = rachOverloadProtect;
  }

  public RateSelectionPsInteractiveBean getRateSelectionPsInteractive() {
    return rateSelectionPsInteractive;
  }

  public void setRateSelectionPsInteractive(RateSelectionPsInteractiveBean rateSelectionPsInteractive) {
    this.rateSelectionPsInteractive = rateSelectionPsInteractive;
  }

  public int getRedirectUarfcn() {
    return redirectUarfcn;
  }

  public void setRedirectUarfcn(int redirectUarfcn) {
    this.redirectUarfcn = redirectUarfcn;
  }

  public int getReleaseRedirect() {
    return releaseRedirect;
  }

  public void setReleaseRedirect(int releaseRedirect) {
    this.releaseRedirect = releaseRedirect;
  }

  public ReleaseRedirectEutraTriggersBean getReleaseRedirectEutraTriggers() {
    return releaseRedirectEutraTriggers;
  }

  public void setReleaseRedirectEutraTriggers(ReleaseRedirectEutraTriggersBean releaseRedirectEutraTriggers) {
    this.releaseRedirectEutraTriggers = releaseRedirectEutraTriggers;
  }

  public int getReleaseRedirectHsIfls() {
    return releaseRedirectHsIfls;
  }

  public void setReleaseRedirectHsIfls(int releaseRedirectHsIfls) {
    this.releaseRedirectHsIfls = releaseRedirectHsIfls;
  }

  public int getReportingRange1a() {
    return reportingRange1a;
  }

  public void setReportingRange1a(int reportingRange1a) {
    this.reportingRange1a = reportingRange1a;
  }

  public int getReportingRange1b() {
    return reportingRange1b;
  }

  public void setReportingRange1b(int reportingRange1b) {
    this.reportingRange1b = reportingRange1b;
  }

  public int getRlFailureT() {
    return rlFailureT;
  }

  public void setRlFailureT(int rlFailureT) {
    this.rlFailureT = rlFailureT;
  }

  public RoutingAreaRefBean getRoutingAreaRef() {
    return routingAreaRef;
  }

  public void setRoutingAreaRef(RoutingAreaRefBean routingAreaRef) {
    this.routingAreaRef = routingAreaRef;
  }

  public int getRrcLcEnabled() {
    return rrcLcEnabled;
  }

  public void setRrcLcEnabled(int rrcLcEnabled) {
    this.rrcLcEnabled = rrcLcEnabled;
  }

  public int getRwrEutraCc() {
    return rwrEutraCc;
  }

  public void setRwrEutraCc(int rwrEutraCc) {
    this.rwrEutraCc = rwrEutraCc;
  }

  public int getSHcsRat() {
    return sHcsRat;
  }

  public void setSHcsRat(int sHcsRat) {
    this.sHcsRat = sHcsRat;
  }

  public int getSInterSearch() {
    return sInterSearch;
  }

  public void setSInterSearch(int sInterSearch) {
    this.sInterSearch = sInterSearch;
  }

  public int getSIntraSearch() {
    return sIntraSearch;
  }

  public void setSIntraSearch(int sIntraSearch) {
    this.sIntraSearch = sIntraSearch;
  }

  public int getSRatSearch() {
    return sRatSearch;
  }

  public void setSRatSearch(int sRatSearch) {
    this.sRatSearch = sRatSearch;
  }

  public int getSecondaryCpichPower() {
    return secondaryCpichPower;
  }

  public void setSecondaryCpichPower(int secondaryCpichPower) {
    this.secondaryCpichPower = secondaryCpichPower;
  }

  public int getSecondarySchPower() {
    return secondarySchPower;
  }

  public void setSecondarySchPower(int secondarySchPower) {
    this.secondarySchPower = secondarySchPower;
  }

  public int getServDiffRrcAdmHighPrioProfile() {
    return servDiffRrcAdmHighPrioProfile;
  }

  public void setServDiffRrcAdmHighPrioProfile(int servDiffRrcAdmHighPrioProfile) {
    this.servDiffRrcAdmHighPrioProfile = servDiffRrcAdmHighPrioProfile;
  }

  public ServiceAreaRefBean getServiceAreaRef() {
    return serviceAreaRef;
  }

  public void setServiceAreaRef(ServiceAreaRefBean serviceAreaRef) {
    this.serviceAreaRef = serviceAreaRef;
  }

  public ServiceRestrictionsBean getServiceRestrictions() {
    return serviceRestrictions;
  }

  public void setServiceRestrictions(ServiceRestrictionsBean serviceRestrictions) {
    this.serviceRestrictions = serviceRestrictions;
  }

  public int getSf128Adm() {
    return sf128Adm;
  }

  public void setSf128Adm(int sf128Adm) {
    this.sf128Adm = sf128Adm;
  }

  public int getSf16Adm() {
    return sf16Adm;
  }

  public void setSf16Adm(int sf16Adm) {
    this.sf16Adm = sf16Adm;
  }

  public int getSf16AdmUl() {
    return sf16AdmUl;
  }

  public void setSf16AdmUl(int sf16AdmUl) {
    this.sf16AdmUl = sf16AdmUl;
  }

  public int getSf16gAdm() {
    return sf16gAdm;
  }

  public void setSf16gAdm(int sf16gAdm) {
    this.sf16gAdm = sf16gAdm;
  }

  public int getSf32Adm() {
    return sf32Adm;
  }

  public void setSf32Adm(int sf32Adm) {
    this.sf32Adm = sf32Adm;
  }

  public int getSf4AdmUl() {
    return sf4AdmUl;
  }

  public void setSf4AdmUl(int sf4AdmUl) {
    this.sf4AdmUl = sf4AdmUl;
  }

  public int getSf64AdmUl() {
    return sf64AdmUl;
  }

  public void setSf64AdmUl(int sf64AdmUl) {
    this.sf64AdmUl = sf64AdmUl;
  }

  public int getSf8Adm() {
    return sf8Adm;
  }

  public void setSf8Adm(int sf8Adm) {
    this.sf8Adm = sf8Adm;
  }

  public int getSf8AdmUl() {
    return sf8AdmUl;
  }

  public void setSf8AdmUl(int sf8AdmUl) {
    this.sf8AdmUl = sf8AdmUl;
  }

  public int getSf8gAdmUl() {
    return sf8gAdmUl;
  }

  public void setSf8gAdmUl(int sf8gAdmUl) {
    this.sf8gAdmUl = sf8gAdmUl;
  }

  public Sib11UtranCellConfigBean getSib11UtranCellConfig() {
    return sib11UtranCellConfig;
  }

  public void setSib11UtranCellConfig(Sib11UtranCellConfigBean sib11UtranCellConfig) {
    this.sib11UtranCellConfig = sib11UtranCellConfig;
  }

  public int getSib1PlmnScopeValueTag() {
    return sib1PlmnScopeValueTag;
  }

  public void setSib1PlmnScopeValueTag(int sib1PlmnScopeValueTag) {
    this.sib1PlmnScopeValueTag = sib1PlmnScopeValueTag;
  }

  public int getSpare() {
    return spare;
  }

  public void setSpare(int spare) {
    this.spare = spare;
  }

  public int getSrbAdmExempt() {
    return srbAdmExempt;
  }

  public void setSrbAdmExempt(int srbAdmExempt) {
    this.srbAdmExempt = srbAdmExempt;
  }

  public int getStandAloneSrbSelector() {
    return standAloneSrbSelector;
  }

  public void setStandAloneSrbSelector(int standAloneSrbSelector) {
    this.standAloneSrbSelector = standAloneSrbSelector;
  }

  public int getTCell() {
    return tCell;
  }

  public void setTCell(int tCell) {
    this.tCell = tCell;
  }

  public int getTimeToTrigger1a() {
    return timeToTrigger1a;
  }

  public void setTimeToTrigger1a(int timeToTrigger1a) {
    this.timeToTrigger1a = timeToTrigger1a;
  }

  public int getTimeToTrigger1b() {
    return timeToTrigger1b;
  }

  public void setTimeToTrigger1b(int timeToTrigger1b) {
    this.timeToTrigger1b = timeToTrigger1b;
  }

  public TpsCellThresholdsBean getTpsCellThresholds() {
    return tpsCellThresholds;
  }

  public void setTpsCellThresholds(TpsCellThresholdsBean tpsCellThresholds) {
    this.tpsCellThresholds = tpsCellThresholds;
  }

  public String getTpsPeriodsRef() {
    return tpsPeriodsRef;
  }

  public void setTpsPeriodsRef(String tpsPeriodsRef) {
    this.tpsPeriodsRef = tpsPeriodsRef;
  }

  public int getTransmissionScheme() {
    return transmissionScheme;
  }

  public void setTransmissionScheme(int transmissionScheme) {
    this.transmissionScheme = transmissionScheme;
  }

  public int getTreSelection() {
    return treSelection;
  }

  public void setTreSelection(int treSelection) {
    this.treSelection = treSelection;
  }

  public int getUarfcnDl() {
    return uarfcnDl;
  }

  public void setUarfcnDl(int uarfcnDl) {
    this.uarfcnDl = uarfcnDl;
  }

  public int getUarfcnUl() {
    return uarfcnUl;
  }

  public void setUarfcnUl(int uarfcnUl) {
    this.uarfcnUl = uarfcnUl;
  }

  public int getUpdateLocator() {
    return updateLocator;
  }

  public void setUpdateLocator(int updateLocator) {
    this.updateLocator = updateLocator;
  }

  public UraRefBean getUraRef() {
    return uraRef;
  }

  public void setUraRef(UraRefBean uraRef) {
    this.uraRef = uraRef;
  }

  public int getUsedFreqThresh2dEcno() {
    return usedFreqThresh2dEcno;
  }

  public void setUsedFreqThresh2dEcno(int usedFreqThresh2dEcno) {
    this.usedFreqThresh2dEcno = usedFreqThresh2dEcno;
  }

  public int getUsedFreqThresh2dRscp() {
    return usedFreqThresh2dRscp;
  }

  public void setUsedFreqThresh2dRscp(int usedFreqThresh2dRscp) {
    this.usedFreqThresh2dRscp = usedFreqThresh2dRscp;
  }

  public String getUserLabel() {
    return userLabel;
  }

  public void setUserLabel(String userLabel) {
    this.userLabel = userLabel;
  }

  public String getUtranCellPosition() {
    return utranCellPosition;
  }

  public void setUtranCellPosition(String utranCellPosition) {
    this.utranCellPosition = utranCellPosition;
  }

  public List<Integer> getAccessClassNBarred() {
    return accessClassNBarred;
  }

  public void setAccessClassNBarred(List<Integer> accessClassNBarred) {
    this.accessClassNBarred = accessClassNBarred;
  }

  public List<Integer> getAccessClassesBarredCs() {
    return accessClassesBarredCs;
  }

  public void setAccessClassesBarredCs(List<Integer> accessClassesBarredCs) {
    this.accessClassesBarredCs = accessClassesBarredCs;
  }

  public List<Integer> getAccessClassesBarredPs() {
    return accessClassesBarredPs;
  }

  public void setAccessClassesBarredPs(List<Integer> accessClassesBarredPs) {
    this.accessClassesBarredPs = accessClassesBarredPs;
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
  public List<?> getValues() {
    return null;
  }

  @Override
  public String getType() {
    return null;
  }

  public static class AbsPrioCellResBean {
    /**
     * cellReselectionPriority : 3
     * sPrioritySearch1 : 10
     * sPrioritySearch2 : 4
     * threshServingLow : 16
     * measIndFach : 0
     */

    private int cellReselectionPriority;
    private int sPrioritySearch1;
    private int sPrioritySearch2;
    private int threshServingLow;
    private int measIndFach;

    public int getCellReselectionPriority() {
      return cellReselectionPriority;
    }

    public void setCellReselectionPriority(int cellReselectionPriority) {
      this.cellReselectionPriority = cellReselectionPriority;
    }

    public int getSPrioritySearch1() {
      return sPrioritySearch1;
    }

    public void setSPrioritySearch1(int sPrioritySearch1) {
      this.sPrioritySearch1 = sPrioritySearch1;
    }

    public int getSPrioritySearch2() {
      return sPrioritySearch2;
    }

    public void setSPrioritySearch2(int sPrioritySearch2) {
      this.sPrioritySearch2 = sPrioritySearch2;
    }

    public int getThreshServingLow() {
      return threshServingLow;
    }

    public void setThreshServingLow(int threshServingLow) {
      this.threshServingLow = threshServingLow;
    }

    public int getMeasIndFach() {
      return measIndFach;
    }

    public void setMeasIndFach(int measIndFach) {
      this.measIndFach = measIndFach;
    }
  }

  public static class AdmBlockRedirectionBean {
    /**
     * gsmRrc : 1
     * rrc : 0
     * speech : 1
     */

    private int gsmRrc;
    private int rrc;
    private int speech;

    public int getGsmRrc() {
      return gsmRrc;
    }

    public void setGsmRrc(int gsmRrc) {
      this.gsmRrc = gsmRrc;
    }

    public int getRrc() {
      return rrc;
    }

    public void setRrc(int rrc) {
      this.rrc = rrc;
    }

    public int getSpeech() {
      return speech;
    }

    public void setSpeech(int speech) {
      this.speech = speech;
    }
  }

  public static class AnrIafUtranCellConfigBean {
    /**
     * anrEnabled : 1
     * relationAddEnabled : 1
     * relationRemoveEnabled : 0
     * sib11IafAnclEnabled : 0
     */

    private int anrEnabled;
    private int relationAddEnabled;
    private int relationRemoveEnabled;
    private int sib11IafAnclEnabled;

    public int getAnrEnabled() {
      return anrEnabled;
    }

    public void setAnrEnabled(int anrEnabled) {
      this.anrEnabled = anrEnabled;
    }

    public int getRelationAddEnabled() {
      return relationAddEnabled;
    }

    public void setRelationAddEnabled(int relationAddEnabled) {
      this.relationAddEnabled = relationAddEnabled;
    }

    public int getRelationRemoveEnabled() {
      return relationRemoveEnabled;
    }

    public void setRelationRemoveEnabled(int relationRemoveEnabled) {
      this.relationRemoveEnabled = relationRemoveEnabled;
    }

    public int getSib11IafAnclEnabled() {
      return sib11IafAnclEnabled;
    }

    public void setSib11IafAnclEnabled(int sib11IafAnclEnabled) {
      this.sib11IafAnclEnabled = sib11IafAnclEnabled;
    }
  }

  public static class AnrIefUtranCellConfigBean {
    /**
     * anrEnabled : 1
     * sib11IefAnclEnabled : 1
     */

    private int anrEnabled;
    private int sib11IefAnclEnabled;

    public int getAnrEnabled() {
      return anrEnabled;
    }

    public void setAnrEnabled(int anrEnabled) {
      this.anrEnabled = anrEnabled;
    }

    public int getSib11IefAnclEnabled() {
      return sib11IefAnclEnabled;
    }

    public void setSib11IefAnclEnabled(int sib11IefAnclEnabled) {
      this.sib11IefAnclEnabled = sib11IefAnclEnabled;
    }
  }

  public static class AntennaPositionBean {
    /**
     * latitudeSign : 0
     * latitude : 4610187
     * longitude : 1492952
     */

    private int latitudeSign;
    private int latitude;
    private int longitude;

    public int getLatitudeSign() {
      return latitudeSign;
    }

    public void setLatitudeSign(int latitudeSign) {
      this.latitudeSign = latitudeSign;
    }

    public int getLatitude() {
      return latitude;
    }

    public void setLatitude(int latitude) {
      this.latitude = latitude;
    }

    public int getLongitude() {
      return longitude;
    }

    public void setLongitude(int longitude) {
      this.longitude = longitude;
    }
  }

  public static class AseLoadThresholdUlSpeechBean {
    /**
     * amr12200 : 100
     * amr7950 : 100
     * amr5900 : 100
     */

    private int amr12200;
    private int amr7950;
    private int amr5900;

    public int getAmr12200() {
      return amr12200;
    }

    public void setAmr12200(int amr12200) {
      this.amr12200 = amr12200;
    }

    public int getAmr7950() {
      return amr7950;
    }

    public void setAmr7950(int amr7950) {
      this.amr7950 = amr7950;
    }

    public int getAmr5900() {
      return amr5900;
    }

    public void setAmr5900(int amr5900) {
      this.amr5900 = amr5900;
    }
  }

  public static class CyclicAcbBean {
    /**
     * acbEnabled : 0
     * rotationGroupSize : 5
     */

    private int acbEnabled;
    private int rotationGroupSize;

    public int getAcbEnabled() {
      return acbEnabled;
    }

    public void setAcbEnabled(int acbEnabled) {
      this.acbEnabled = acbEnabled;
    }

    public int getRotationGroupSize() {
      return rotationGroupSize;
    }

    public void setRotationGroupSize(int rotationGroupSize) {
      this.rotationGroupSize = rotationGroupSize;
    }
  }

  public static class CyclicAcbCsBean {
    /**
     * acbEnabled : 0
     * rotationGroupSize : 5
     */

    private int acbEnabled;
    private int rotationGroupSize;

    public int getAcbEnabled() {
      return acbEnabled;
    }

    public void setAcbEnabled(int acbEnabled) {
      this.acbEnabled = acbEnabled;
    }

    public int getRotationGroupSize() {
      return rotationGroupSize;
    }

    public void setRotationGroupSize(int rotationGroupSize) {
      this.rotationGroupSize = rotationGroupSize;
    }
  }

  public static class CyclicAcbPsBean {
    /**
     * acbEnabled : 0
     * rotationGroupSize : 5
     */

    private int acbEnabled;
    private int rotationGroupSize;

    public int getAcbEnabled() {
      return acbEnabled;
    }

    public void setAcbEnabled(int acbEnabled) {
      this.acbEnabled = acbEnabled;
    }

    public int getRotationGroupSize() {
      return rotationGroupSize;
    }

    public void setRotationGroupSize(int rotationGroupSize) {
      this.rotationGroupSize = rotationGroupSize;
    }
  }

  public static class HcsSib3ConfigBean {
    /**
     * hcsPrio : 0
     * qHcs : 0
     * sSearchHcs : -105
     */

    private int hcsPrio;
    private int qHcs;
    private int sSearchHcs;

    public int getHcsPrio() {
      return hcsPrio;
    }

    public void setHcsPrio(int hcsPrio) {
      this.hcsPrio = hcsPrio;
    }

    public int getQHcs() {
      return qHcs;
    }

    public void setQHcs(int qHcs) {
      this.qHcs = qHcs;
    }

    public int getSSearchHcs() {
      return sSearchHcs;
    }

    public void setSSearchHcs(int sSearchHcs) {
      this.sSearchHcs = sSearchHcs;
    }
  }

  public static class HcsUsageBean {
    /**
     * idleMode : 0
     * connectedMode : 0
     */

    private int idleMode;
    private int connectedMode;

    public int getIdleMode() {
      return idleMode;
    }

    public void setIdleMode(int idleMode) {
      this.idleMode = idleMode;
    }

    public int getConnectedMode() {
      return connectedMode;
    }

    public void setConnectedMode(int connectedMode) {
      this.connectedMode = connectedMode;
    }
  }

  public static class HsIflsDownswitchTriggBean {
    /**
     * toFach : 0
     * toUra : 0
     * fastDormancy : 1
     */

    private int toFach;
    private int toUra;
    private int fastDormancy;

    public int getToFach() {
      return toFach;
    }

    public void setToFach(int toFach) {
      this.toFach = toFach;
    }

    public int getToUra() {
      return toUra;
    }

    public void setToUra(int toUra) {
      this.toUra = toUra;
    }

    public int getFastDormancy() {
      return fastDormancy;
    }

    public void setFastDormancy(int fastDormancy) {
      this.fastDormancy = fastDormancy;
    }
  }

  public static class HsIflsTriggerBean {
    /**
     * fromFach : 1
     * fromUra : 1
     */

    private int fromFach;
    private int fromUra;

    public int getFromFach() {
      return fromFach;
    }

    public void setFromFach(int fromFach) {
      this.fromFach = fromFach;
    }

    public int getFromUra() {
      return fromUra;
    }

    public void setFromUra(int fromUra) {
      this.fromUra = fromUra;
    }
  }

  public static class IubLinkRefBean {
    /**
     * IubLink : CK0001
     */

    private String IubLink;

    public String getIubLink() {
      return IubLink;
    }

    public void setIubLink(String IubLink) {
      this.IubLink = IubLink;
    }
  }

  public static class LocationAreaRefBean {
    /**
     * LocationArea : 12710
     */

    private int LocationArea;

    public int getLocationArea() {
      return LocationArea;
    }

    public void setLocationArea(int LocationArea) {
      this.LocationArea = LocationArea;
    }
  }

  public static class MocnCellProfileRefBean {
    /**
     * MocnCellProfile : Astelit
     */

    private String MocnCellProfile;

    public String getMocnCellProfile() {
      return MocnCellProfile;
    }

    public void setMocnCellProfile(String MocnCellProfile) {
      this.MocnCellProfile = MocnCellProfile;
    }
  }

  public static class PagingPermAccessCtrlBean {
    /**
     * locRegAcb : [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
     * locRegRestr : 0
     * pagingRespRestr : 0
     */

    private int locRegRestr;
    private int pagingRespRestr;
    private List<Integer> locRegAcb;

    public int getLocRegRestr() {
      return locRegRestr;
    }

    public void setLocRegRestr(int locRegRestr) {
      this.locRegRestr = locRegRestr;
    }

    public int getPagingRespRestr() {
      return pagingRespRestr;
    }

    public void setPagingRespRestr(int pagingRespRestr) {
      this.pagingRespRestr = pagingRespRestr;
    }

    public List<Integer> getLocRegAcb() {
      return locRegAcb;
    }

    public void setLocRegAcb(List<Integer> locRegAcb) {
      this.locRegAcb = locRegAcb;
    }
  }

  public static class PwrLoadThresholdDlSpeechBean {
    /**
     * amr12200 : 100
     * amr7950 : 100
     * amr5900 : 100
     */

    private int amr12200;
    private int amr7950;
    private int amr5900;

    public int getAmr12200() {
      return amr12200;
    }

    public void setAmr12200(int amr12200) {
      this.amr12200 = amr12200;
    }

    public int getAmr7950() {
      return amr7950;
    }

    public void setAmr7950(int amr7950) {
      this.amr7950 = amr7950;
    }

    public int getAmr5900() {
      return amr5900;
    }

    public void setAmr5900(int amr5900) {
      this.amr5900 = amr5900;
    }
  }

  public static class RateSelectionPsInteractiveBean {
    /**
     * channelType : 0
     * ulPrefRate : 16
     * dlPrefRate : 16
     */

    private int channelType;
    private int ulPrefRate;
    private int dlPrefRate;

    public int getChannelType() {
      return channelType;
    }

    public void setChannelType(int channelType) {
      this.channelType = channelType;
    }

    public int getUlPrefRate() {
      return ulPrefRate;
    }

    public void setUlPrefRate(int ulPrefRate) {
      this.ulPrefRate = ulPrefRate;
    }

    public int getDlPrefRate() {
      return dlPrefRate;
    }

    public void setDlPrefRate(int dlPrefRate) {
      this.dlPrefRate = dlPrefRate;
    }
  }

  public static class ReleaseRedirectEutraTriggersBean {
    /**
     * csFallbackCsRelease : 1
     * csFallbackDchToFach : 0
     * dchToFach : 0
     * fachToUra : 0
     * fastDormancy : 0
     * normalRelease : 0
     */

    private int csFallbackCsRelease;
    private int csFallbackDchToFach;
    private int dchToFach;
    private int fachToUra;
    private int fastDormancy;
    private int normalRelease;

    public int getCsFallbackCsRelease() {
      return csFallbackCsRelease;
    }

    public void setCsFallbackCsRelease(int csFallbackCsRelease) {
      this.csFallbackCsRelease = csFallbackCsRelease;
    }

    public int getCsFallbackDchToFach() {
      return csFallbackDchToFach;
    }

    public void setCsFallbackDchToFach(int csFallbackDchToFach) {
      this.csFallbackDchToFach = csFallbackDchToFach;
    }

    public int getDchToFach() {
      return dchToFach;
    }

    public void setDchToFach(int dchToFach) {
      this.dchToFach = dchToFach;
    }

    public int getFachToUra() {
      return fachToUra;
    }

    public void setFachToUra(int fachToUra) {
      this.fachToUra = fachToUra;
    }

    public int getFastDormancy() {
      return fastDormancy;
    }

    public void setFastDormancy(int fastDormancy) {
      this.fastDormancy = fastDormancy;
    }

    public int getNormalRelease() {
      return normalRelease;
    }

    public void setNormalRelease(int normalRelease) {
      this.normalRelease = normalRelease;
    }
  }

  public static class RoutingAreaRefBean {
    /**
     * LocationArea : 12710
     * RoutingArea : 2
     */

    private int LocationArea;
    private int RoutingArea;

    public int getLocationArea() {
      return LocationArea;
    }

    public void setLocationArea(int LocationArea) {
      this.LocationArea = LocationArea;
    }

    public int getRoutingArea() {
      return RoutingArea;
    }

    public void setRoutingArea(int RoutingArea) {
      this.RoutingArea = RoutingArea;
    }
  }

  public static class ServiceAreaRefBean {
    /**
     * LocationArea : 12710
     * ServiceArea : 30563
     */

    private int LocationArea;
    private int ServiceArea;

    public int getLocationArea() {
      return LocationArea;
    }

    public void setLocationArea(int LocationArea) {
      this.LocationArea = LocationArea;
    }

    public int getServiceArea() {
      return ServiceArea;
    }

    public void setServiceArea(int ServiceArea) {
      this.ServiceArea = ServiceArea;
    }
  }

  public static class ServiceRestrictionsBean {
    /**
     * csVideoCalls : 0
     */

    private int csVideoCalls;

    public int getCsVideoCalls() {
      return csVideoCalls;
    }

    public void setCsVideoCalls(int csVideoCalls) {
      this.csVideoCalls = csVideoCalls;
    }
  }

  public static class Sib11UtranCellConfigBean {
    /**
     * minGsmRelationsInSib11 : 10
     * minIefRelationsInSib11 : 20
     */

    private int minGsmRelationsInSib11;
    private int minIefRelationsInSib11;

    public int getMinGsmRelationsInSib11() {
      return minGsmRelationsInSib11;
    }

    public void setMinGsmRelationsInSib11(int minGsmRelationsInSib11) {
      this.minGsmRelationsInSib11 = minGsmRelationsInSib11;
    }

    public int getMinIefRelationsInSib11() {
      return minIefRelationsInSib11;
    }

    public void setMinIefRelationsInSib11(int minIefRelationsInSib11) {
      this.minIefRelationsInSib11 = minIefRelationsInSib11;
    }
  }

  public static class TpsCellThresholdsBean {
    /**
     * tpsCellThreshEnabled : 0
     * tpsLockThreshold : 5
     * tpsUnlockThreshold : 15
     */

    private int tpsCellThreshEnabled;
    private int tpsLockThreshold;
    private int tpsUnlockThreshold;

    public int getTpsCellThreshEnabled() {
      return tpsCellThreshEnabled;
    }

    public void setTpsCellThreshEnabled(int tpsCellThreshEnabled) {
      this.tpsCellThreshEnabled = tpsCellThreshEnabled;
    }

    public int getTpsLockThreshold() {
      return tpsLockThreshold;
    }

    public void setTpsLockThreshold(int tpsLockThreshold) {
      this.tpsLockThreshold = tpsLockThreshold;
    }

    public int getTpsUnlockThreshold() {
      return tpsUnlockThreshold;
    }

    public void setTpsUnlockThreshold(int tpsUnlockThreshold) {
      this.tpsUnlockThreshold = tpsUnlockThreshold;
    }
  }

  public static class UraRefBean {
    /**
     * RncFunction : 1
     * Ura : 12731
     */

    private int RncFunction;
    private int Ura;

    public int getRncFunction() {
      return RncFunction;
    }

    public void setRncFunction(int RncFunction) {
      this.RncFunction = RncFunction;
    }

    public int getUra() {
      return Ura;
    }

    public void setUra(int Ura) {
      this.Ura = Ura;
    }
  }
}
