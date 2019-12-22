package com.model.modelsForCreationCommands.util;

import com.model.modelsForCreationCommands.*;
import com.utils.Patterns;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Pattern;

public class CreationCommandFabric {

  final static String begin = "RncFunction=[0-9]*,";
  final static String end = "[\\s\\n\\w\\.,=-]*[\\s\\n]*";

  public static final Pattern[] PATTERNS = new Pattern[]{
      Pattern.compile(begin + "EutraNetwork=[a-zA-Z]*,EutranFrequency=[\\d]*,ExternalEutranCell=[\\w]*" + end),
      Pattern.compile(begin + "ExternalGsmNetwork=[a-zA-Z]*,ExternalGsmCell=[\\w]*[\\s\\n]*bandIndicator" + end),
      Pattern.compile(begin + "UtranCell=[\\w]*,GsmRelation=[\\w]*" + end),
      Pattern.compile(begin + "IubLink=[\\w]*[\\s\\n]*administrativeState" + end),
      Pattern.compile(begin + "UtranCell=[\\w]*,UtranRelation=[\\w]*" + end),
      Pattern.compile(begin + "UtranCell=[\\w]*,EutranFreqRelation=[\\w]*" + end),
      Pattern.compile(begin + "UtranCell=[\\w]*,CoverageRelation=[\\w]*" + end),
      Pattern.compile(begin + "UtranCell=[\\w]*,Hsdsch=[\\w]*,Eul=[\\w]*" + end),
      Pattern.compile(begin + "UtranCell=[\\w]*,Hsdsch=[\\w]*[\\s\\n]*administrativeState" + end),
      Pattern.compile(begin + "UtranCell=[\\w]*,Fach=[\\w]*" + end),
      Pattern.compile(begin + "UtranCell=[\\w]*,Pch=[\\w]*" + end),
      Pattern.compile(begin + "UtranCell=[\\w]*,Rach=[\\w]*" + end),
      Pattern.compile(begin + "UtranCell=[\\w]*[\\s\\n]*absPrioCellRes" + end),
      Pattern.compile(begin + "LocationArea=[\\w]*,[\\s\\n]*ServiceArea=[\\w]*" + end),
      Pattern.compile(begin + "IubLink=[\\w]*,[\\s\\n]*IubEdch=[\\w]*" + end)
  };

  public static CreationCommand createObject(Patterns pattern, Class clazz, String source) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

    switch (pattern) {
      case PCH_POWER: return new ENodeBId();
      case E_NODEB_ID: return new BandIndicator();
      case BAND_INDICATOR:return new ExtrrnalGsmCellRef();
      case MAX_FACH_1_POWER: return new AtmUserPlaneTermSubrackRef();
      case HCS_SIB_11_CONFIG: return new HcsSid11Config();
      case EXTERNAL_GSM_CELL_REF: return new ExternalEutramCellRef();
      case HS_PATH_LOSS_TRESHOLD: return new HsPathLossTreshold();
      case CODE_THRESHOLD_PDU_656: return new EuDchBalancingEnabled();
      case AICH_TRANSMISSION_TIMING: return new CodeThresholdPdu656();
      case EU_DCH_BALANCING_ENABLED: return new MaxFach1Power();
      case EXTERNAL_EUTRAN_CELL_REF: return new PchPower();
      case ATM_USER_PLANE_TERM_SUBRACK_REF: return new AichTransmissionTiming();
      case ASE_LOAD_THRESHOLD_UI_SPEECH: return new AseLoadThresholdUiSpeech();
      case SAC: return new Sac();
      case EDCH_DATA_FRAME_DELAY_THRESHOLD: return new EdchDataFrameDelayThreshold();
      default: return null;
    }

  }

}
