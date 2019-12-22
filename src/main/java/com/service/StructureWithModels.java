package com.service;

import com.model.modelsForCreationCommands.ENodeBId;
import com.model.modelsForCreationCommands.BandIndicator;
import com.model.modelsForCreationCommands.*;
import com.model.modelsForParsing.*;
import com.utils.Patterns;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StructureWithModels {

  private static final Logger LOG = LogManager.getLogger(StructureWithModels.class);
  private static boolean isHeaderExist = false;
  final static String begin = "RncFunction=[0-9]*,";
  final static String end = "[\\s\\n\\w\\.,=-]*[\\s\\n]*";

  static final Pattern E_NODEB_ID = Pattern.compile(begin + "EutraNetwork=[a-zA-Z]*,EutranFrequency=[\\d]*,ExternalEutranCell=[\\w]*" + end);
  static final Pattern BAND_INDICATOR = Pattern.compile(begin + "ExternalGsmNetwork=[a-zA-Z]*,ExternalGsmCell=[\\w]*[\\s\\n]*bandIndicator" + end);
  static final Pattern EXTERNAL_GSM_CELL_REF = Pattern.compile(begin + "UtranCell=[\\w]*,GsmRelation=[\\w]*" + end);
  static final Pattern ATM_USER_PLANE_TERM_SUBRACK_REF = Pattern.compile(begin + "IubLink=[\\w]*[\\s\\n]*administrativeState" + end);
  static final Pattern HCS_SIB_11_CONFIG = Pattern.compile(begin + "UtranCell=[\\w]*,UtranRelation=[\\w]*" + end);
  static final Pattern EXTERNAL_EUTRAN_CELL_REF = Pattern.compile(begin + "UtranCell=[\\w]*,EutranFreqRelation=[\\w]*" + end);
  static final Pattern HS_PATH_LOSS_TRESHOLD = Pattern.compile(begin + "UtranCell=[\\w]*,CoverageRelation=[\\w]*" + end);
  static final Pattern EU_DCH_BALANCING_ENABLED = Pattern.compile(begin + "UtranCell=[\\w]*,Hsdsch=[\\w]*,Eul=[\\w]*" + end);
  static final Pattern CODE_THRESHOLD_PDU_656 = Pattern.compile(begin + "UtranCell=[\\w]*,Hsdsch=[\\w]*[\\s\\n]*administrativeState" + end);
  static final Pattern MAX_FACH_1_POWER = Pattern.compile(begin + "UtranCell=[\\w]*,Fach=[\\w]*" + end);
  static final Pattern PCH_POWER = Pattern.compile(begin + "UtranCell=[\\w]*,Pch=[\\w]*" + end);
  static final Pattern AICH_TRANSMISSION_TIMING = Pattern.compile(begin + "UtranCell=[\\w]*,Rach=[\\w]*" + end);
  static final Pattern ASE_LOAD_THRESHOLD_UI_SPEECH = Pattern.compile(begin + "UtranCell=[\\w]*[\\s\\n]*absPrioCellRes" + end);
  static final Pattern SAC = Pattern.compile(begin + "LocationArea=[\\w]*,[\\s\\n]*ServiceArea=[\\w]*" + end);
  static final Pattern EDCH_DATA_FRAME_DELAY_THRESHOLD = Pattern.compile(begin + "IubLink=[\\w]*,[\\s\\n]*IubEdch=[\\w]*" + end);
  static final List<Pattern> patterns = Arrays.asList(
      E_NODEB_ID, BAND_INDICATOR, EXTERNAL_GSM_CELL_REF, ATM_USER_PLANE_TERM_SUBRACK_REF, HCS_SIB_11_CONFIG,
      EXTERNAL_EUTRAN_CELL_REF, HS_PATH_LOSS_TRESHOLD, EU_DCH_BALANCING_ENABLED, CODE_THRESHOLD_PDU_656, MAX_FACH_1_POWER,
      PCH_POWER, AICH_TRANSMISSION_TIMING, ASE_LOAD_THRESHOLD_UI_SPEECH, SAC, EDCH_DATA_FRAME_DELAY_THRESHOLD
  );

  public static void main(String[] args) throws IOException {

//    List<Bean> beans = new ArrayList<>();

//    String[] rows = Constants.anotherConfigString.split("\\n");

//    List<String> rows = SshUtils.generateTestData(null, null);
//    List<Bean> beans = parse(rows);
//
//    for (Bean bean : beans) {
//      LOG.info(bean.getName());
//      LOG.info(bean.getItems());
//      System.out.println();
//    }

    parseCreationObjects("/home/atian/Documents/arturProjects/RncConfigurerParser/src/main/resources/undo_KIER7_191118-105157.mos");
//    count("/home/atian/Documents/arturProjects/RncConfigurerParser/src/main/resources/undo_KIER7_191118-105157.mos");
  }


  static List<Bean> parse(List<String> rows) {

    List<Bean> beans = new ArrayList<>();

    try {
      for (int i = 0; i < rows.size(); i++) {

//      if(!isHeaderExist && rows.get(i).contains("RncFunction")) {
//        Header bean = new Header(rows.get(i));
//
//        if(!bean.isValid()) {
//          continue;
//        }
//
//        beans.add(bean);
//        isHeaderExist = true;
//      }

        if (!rows.get(i).contains("=") && !rows.get(i).contains("{") && !rows.get(i).contains("}")) {
          KeyValue bean = new KeyValue(rows.get(i));

          if (!bean.isValid()) {
            continue;
          }

          beans.add(bean);
        }

        if (rows.get(i).contains("{") && rows.get(i).contains("}")) {
          String count = rows.get(i).split("\\{|}")[1];
          Structure bean = new Structure(rows.subList(i, i + Integer.parseInt(count) + 1));

          if (!bean.isValid()) {
            continue;
          }

          beans.add(bean);
        }

        if (rows.get(i).contains("[") && rows.get(i).contains("]") && !rows.get(i).contains("i[")) {
          String count = rows.get(i).split("\\[|]")[1];
          ArrayObjects bean = new ArrayObjects(rows.subList(i, i + Integer.parseInt(count) + 1));

          if (!bean.isValid()) {
            continue;
          }

          beans.add(bean);
        }

        if (rows.get(i).contains("[") && rows.get(i).contains("]") && rows.get(i).contains("i[")) {
          String count = rows.get(i).split("\\[|]")[1];
          ArrayIntegers bean = new ArrayIntegers(rows.get(i), Integer.valueOf(count));

          if (!bean.isValid()) {
            continue;
          }

          beans.add(bean);
        }

      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return beans;
  }

//  public static void parseCreationObjects(String fileName) throws IOException {
//    List<String> objects = new ArrayList<>();
//    List<String> matchesStrings = new ArrayList<>();
//
//    String[] split = Files.readAllLines(new File(fileName).toPath()).stream()
//        .filter(e -> !e.contains("DoNotEditThisLine") && !e.contains("gs+") && !e.contains("gs-"))
//        .map(e -> e.isEmpty() ? "&" : e+"\n")
//        .collect(Collectors.joining())
//        .split("&");
//
//    List<String> createObjects = Arrays.stream(split)
//        .filter(e -> e.contains("crn"))
//        .map(e -> e.replace("crn ", ""))
//        .map(e -> e.replace("end", ""))
//        .collect(Collectors.toList());
//
//    int i = 0;
//    for (Pattern pattern : patterns) {
//      for (String createObject : createObjects) {
//        Matcher matcher = pattern.matcher(createObject);
//
//        if(matcher.matches()) {
////          System.out.println(createObject);
//          i++;
//        }
//      }
//    }
//    System.out.println(i);
//
//  }

  public static void parseCreationObjects(String fileName) throws IOException {
    List<String> objects = new ArrayList<>();
    List<String> matchesStrings = new ArrayList<>();

    String[] split = Files.readAllLines(new File(fileName).toPath()).stream()
        .filter(e -> !e.contains("DoNotEditThisLine") && !e.contains("gs+") && !e.contains("gs-"))
        .map(e -> e.isEmpty() ? "&" : e+"\n")
        .collect(Collectors.joining())
        .split("&");

    List<String> createObjects = Arrays.stream(split)
        .filter(e -> e.contains("crn"))
        .map(e -> e.replace("crn ", ""))
        .map(e -> e.replace("end", ""))
        .collect(Collectors.toList());

    for (Patterns pattern : Patterns.values()) {
      for (String createObject : createObjects) {
        Matcher matcher = pattern.getPattern().matcher(createObject);

        if(matcher.matches()) {
          System.out.println(createObject);
        }
      }
    }


  }

}
