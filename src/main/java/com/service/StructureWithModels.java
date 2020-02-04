package com.service;

import com.model.modelsForCreationCommands.*;
import com.model.modelsForCreationCommands.util.CreationCommand;
import com.model.modelsForCreationCommands.util.CreationCommandFabric;
import com.model.rncInformationTypes.*;
import com.utils.Patterns;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

@Service
public class StructureWithModels {

  private static final Logger LOG = LogManager.getLogger(StructureWithModels.class);
  private static boolean isHeaderExist = false;

  private static final String OLD_ORIGINAL_FILE_OF_COMMANDS = "/home/atian/Documents/arturProjects/RncConfigurerParser/src/main/resources/undo_KIER7_200126-183751.mos";

  private static final String ORIGINAL_FILE_OF_COMMANDS = "/home/atian/Documents/arturProjects/RncConfigurerParser/src/main/resources/undo_KIER7_200126-183751.mos";
  private static final String FILE_OF_COMMANDS_WITH_MARKERS = "/home/atian/Documents/arturProjects/RncConfigurerParser/src/main/resources/undo_KIER7_200126-183751_div.mos";


  private static final String UTRAN_REl_FILE = "src/main/resources/resultFiles/utran_rel_CH0006.mos";
  private static final String GSM_REL_FILE = "src/main/resources/resultFiles/gsm_rel_CH0006.mos";
  private static final String EUTRAN_REL_FILE = "src/main/resources/resultFiles/Eutran_rel_CH0006.mos";
  private static final String IUB_CELL_FILE = "src/main/resources/resultFiles/iub_cell_CH0006.mos";

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

    StructureWithModels parser = new StructureWithModels();

    List<CreationCommand> creationCommands = parser.extractCreationCommands(ORIGINAL_FILE_OF_COMMANDS);

    parser.placeByFiles(creationCommands);

  }


  public boolean placeByFiles(List<CreationCommand> creationCommands) {

    validateFiles();

    for (CreationCommand creationCommand : creationCommands) {
      if(creationCommand instanceof HcsSid11Config) {
        writeToFile(creationCommand, UTRAN_REl_FILE);
        continue;
      }

      if(creationCommand instanceof ExternalGsmCellRef) {
        writeToFile(creationCommand, GSM_REL_FILE);
        continue;
      }

      if(creationCommand instanceof BarredCnOperatorRef || creationCommand instanceof ExternalEutranCellRef) {
        writeToFile(creationCommand, EUTRAN_REL_FILE);
        continue;
      }

      if(!(creationCommand instanceof HsPathLossTreshold) && !(creationCommand instanceof BandIndicator)) {
        writeToFile(creationCommand, IUB_CELL_FILE);
      }
    }

    return true;
  }

  private void validateFiles() {

    try {
      if (Paths.get(IUB_CELL_FILE).toFile().exists()) {
        Path path = Paths.get(IUB_CELL_FILE);
        Files.delete(path);
      }

      if (Paths.get(GSM_REL_FILE).toFile().exists()) {
        Path path = Paths.get(GSM_REL_FILE);
        Files.delete(path);
      }

      if (Paths.get(UTRAN_REl_FILE).toFile().exists()) {
        Path path = Paths.get(UTRAN_REl_FILE);
        Files.delete(path);
      }

      if (Paths.get(EUTRAN_REL_FILE).toFile().exists()) {
        Path path = Paths.get(EUTRAN_REL_FILE);
        Files.delete(path);
      }
    } catch (IOException e) {
      LOG.error("can't delete file", e);
    }

  }

  private void writeToFile(CreationCommand creationCommand, String fileName) {
    if(!Paths.get(fileName).toFile().exists()) {
      try {
        Path path = Paths.get(fileName);
        Files.createFile(path);
      } catch (IOException e) {
        LOG.error("can't create new File becouse ", e);
        return;
      }
    }

    try {
      Files.write(Paths.get(fileName), creationCommand.toString().getBytes(), StandardOpenOption.APPEND);
      Files.write(Paths.get(fileName), "\n".getBytes(), StandardOpenOption.APPEND);
    } catch (IOException e) {
      LOG.error("can't write objects to File ", e);
    }

  }

  public List<CreationCommand> performModification(String fileOfChanges) {
    List<CreationCommand> creationCommands = extractCreationCommands("/home/atian/Documents/arturProjects/RncConfigurerParser/src/main/resources/undo_KIER7_191118-105157.mos");

    List<Map<String, String>> changeCommands = extractRehomeInformation(fileOfChanges);

    List<CreationCommand> resultCommands = new ArrayList<>();
    try {
      resultCommands = updateValues(creationCommands,
          changeCommands,
          "/home/atian/Documents/arturProjects/RncConfigurerParser/src/main/resources/RncMaximoTable2.csv");
    } catch (IllegalArgumentException e) {
      LOG.error("transfered empty list of changes", e);
    }

    return resultCommands;
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
      LOG.error("something went wrong ", e);
    }

    return beans;
  }

  public List<CreationCommand> extractCreationCommands(String fileOfCreationCommands) {
    List<CreationCommand> creationCommands = new ArrayList<>();

    try {
      String[] split = Files.readAllLines(new File(fileOfCreationCommands).toPath()).stream()
          .filter(e -> !e.contains("gs+") && !e.contains("gs-"))
          .map(e -> e.isEmpty() ? "&" : e + "\n")
          .collect(Collectors.joining())
          .split("&");

      List<String> createObjects = Arrays.stream(split)
          .map(e -> e.replace("crn ", ""))
          .map(e -> e.replace("end", ""))
          .collect(Collectors.toList());


      for (String createObject : createObjects) {
        for (Patterns pattern : Patterns.values()) {
          Matcher matcher = pattern.getPattern().matcher(createObject);

          if (matcher.matches()) {
            CreationCommand creationCommand = CreationCommandFabric.createObject(pattern, createObject);
            creationCommands.add(creationCommand);
            break;
          }
        }
      }
    } catch (IOException e) {
      LOG.error("file not found or something else ", e);
      return null;
    }
    return creationCommands;
  }

  public static  List<CreationCommand> updateValues(List<CreationCommand> parsedObjects, List<Map<String, String>> changeCommands, String fileOfResult) {

    if(parsedObjects == null || changeCommands == null) throw new IllegalArgumentException();

    List<CreationCommand> changedCreationCommands = new ArrayList<>();
    List<CreationCommand> onlyAseLoadThresholdUiSpeech = parsedObjects.stream().filter(e -> e.getType().equals(Patterns.ASE_LOAD_THRESHOLD_UI_SPEECH)).collect(Collectors.toList());

    for (Map<String, String> map : changeCommands) {
      for (CreationCommand creationCommand : onlyAseLoadThresholdUiSpeech) {
        if (((AseLoadThresholdUiSpeech) creationCommand).getCId() == Integer.parseInt(map.get("CI"))
            && ((AseLoadThresholdUiSpeech) creationCommand).getLocationAreaRef().getLocationArea() == Integer.parseInt(map.get("LAC"))) {
          ((AseLoadThresholdUiSpeech) creationCommand).setCId(Integer.parseInt(map.get("New CI")));
          ((AseLoadThresholdUiSpeech) creationCommand).getLocationAreaRef().setLocationArea(Integer.parseInt(map.get("New LAC")));
          changedCreationCommands.add(creationCommand);
        }
      }
    }

    boolean b = writeResult(parsedObjects, fileOfResult);

    if (b) {
      LOG.info("writing successfully\n");
    } else {
      LOG.error("error during writing\n");
      throw new RuntimeException("error during exception");
    }

    return changedCreationCommands;
  }

  public List<CreationCommand> prepareObjectsToChange(List<CreationCommand> parsedObjects, List<Map<String, String>> changeCommands) {

    List<CreationCommand> changedCreationCommands = new ArrayList<>();
    List<CreationCommand> onlyAseLoadThresholdUiSpeech = parsedObjects.stream().filter(e -> e.getType().equals(Patterns.ASE_LOAD_THRESHOLD_UI_SPEECH)).collect(Collectors.toList());

    for (Map<String, String> map : changeCommands) {
      for (CreationCommand creationCommand : onlyAseLoadThresholdUiSpeech) {
        if (((AseLoadThresholdUiSpeech) creationCommand).getCId() == Integer.parseInt(map.get("CI"))
            && ((AseLoadThresholdUiSpeech) creationCommand).getLocationAreaRef().getLocationArea() == Integer.parseInt(map.get("LAC"))) {

          changedCreationCommands.add(creationCommand);
        }
      }
    }

    return changedCreationCommands;
  }

  public List<Map<String, String>> extractRehomeInformation(String fileOfChanges) {
    ParseCsvFileService service = new ParseCsvFileService();
    return service.readMapCsv(fileOfChanges);
  }

  static boolean writeResult(List<CreationCommand> creationCommands, String fileOfResult) {
    final String header = creationCommands.get(0) == null ? "" : creationCommands.get(0) + "\ngs+\n\n";

    if(creationCommands.get(0) != null) creationCommands.remove(0);

    final String footer = "gs-\n";

    try {

      if (new File(fileOfResult).exists()) {

        Files.write(new File(fileOfResult).toPath(), header.getBytes());
        for (CreationCommand creationCommand : creationCommands) {
          Files.write(new File(fileOfResult).toPath(), creationCommand.toString().getBytes(), StandardOpenOption.APPEND);
          Files.write(new File(fileOfResult).toPath(), "\n".getBytes(), StandardOpenOption.APPEND);
        }
        Files.write(new File(fileOfResult).toPath(), footer.getBytes(), StandardOpenOption.APPEND);
      }
    } catch (IOException e) {
      LOG.error("something went wrong, ", e);
      return false;
    }

    return true;
  }



}
