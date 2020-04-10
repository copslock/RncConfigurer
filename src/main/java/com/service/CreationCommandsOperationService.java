package com.service;

import com.model.LacRacUra;
import com.model.RncModification;
import com.model.modelsForCreationCommands.*;
import com.model.modelsForCreationCommands.Header;
import com.model.modelsForCreationCommands.util.CreationCommand;
import com.model.modelsForCreationCommands.util.CreationCommandFabric;
import com.model.modelsForCreationCommands.util.ModelUtils;
import com.model.rncInformationTypes.*;
import com.utils.Constants;
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
import java.util.*;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

import static com.utils.Constants.*;

@Service
public class CreationCommandsOperationService {

  private static final Logger LOG = LogManager.getLogger(CreationCommandsOperationService.class);

  private static boolean isHeaderExist = false;

  private static String rnc;

  CreationCommandsOperationService() throws IOException {
    rnc = RESULT_FILES + ModelUtils.extractSiteName(TEST_FILE_OF_COMMANDS1)+"/";

    if(!new File("src/main/resources/resultFiles/"+rnc).exists()) {
      Files.createDirectory(Paths.get("src/main/resources/resultFiles/" + rnc));
    }
  }

  CreationCommandsOperationService(String fileName) throws IOException {
    this.rnc = RESULT_FILES + ModelUtils.extractSiteName(fileName)+"/";

    if(!new File(this.rnc).exists()) {
      Files.createDirectory(Paths.get(this.rnc));
    }
  }

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

    execute1();
    execute2();
    execute3();

//    List<CreationCommand> creationCommands2 = parser.extractCreationCommands(parser.TEST_FILE_OF_COMMANDS2);
//    parser.placeByDirectories(creationCommands2);
//    parser.placeCommandsBySeparatedFiles(creationCommands);
//    parser.writeNeighbors();

//    List<CreationCommand> creationCommands3 = parser.extractCreationCommands(parser.TEST_FILE_OF_COMMANDS3);
//    parser.placeByDirectories(creationCommands3);
//    parser.placeCommandsBySeparatedFiles(creationCommands);
//    parser.writeNeighbors();

  }

  public static void execute1() throws IOException {
    CreationCommandsOperationService parser = new CreationCommandsOperationService(TEST_FILE_OF_COMMANDS1);

    List<RncModification> modifications = extractAllRehomeInformation(TEST_FILE_OF_CHANGES1);

    List<String> rncNames = modifications.stream().map(e -> e.getModifications().get(0).getSite()).collect(Collectors.toList());
    List<String> creationCommandsFiles = ModelUtils.getCreationCommandsFiles();

    for (RncModification changeCommand : modifications) {

//      parser.performModification()

    }


    // TODO something like this
    /*
    List<String> rncies = extractRnciesFromChangeCommands()
    Map<String, String> existingFileForRncCreationCommands checkExistingFileWithRncCreationCommands()

    for (Map.Entry<String, String> entry : existingFileForRncCreationCommands) {
      parser.performModification(changeCommands, entry.getValue())
    }

     */

    parser.performModification(TEST_FILE_OF_CHANGES1, TEST_FILE_OF_COMMANDS1);

    List<CreationCommand> creationCommands = parser.extractCreationCommands(TEST_FILE_OF_CHANGES2);

    parser.placeCommandsBySeparatedFiles(creationCommands);
    parser.createLacRacUra(TEST_FILE_OF_CHANGES1);
    parser.writeNeighbors();
  }

  public static void execute2() throws IOException {
    CreationCommandsOperationService parser = new CreationCommandsOperationService(TEST_FILE_OF_COMMANDS2);

    parser.performModification(TEST_FILE_OF_CHANGES1, TEST_FILE_OF_COMMANDS2);
    List<CreationCommand> creationCommands = parser.extractCreationCommands(TEST_FILE_OF_CHANGES2);

    parser.placeCommandsBySeparatedFiles(creationCommands);
    parser.createLacRacUra(TEST_FILE_OF_CHANGES1);
    parser.writeNeighbors();
  }

  public static void execute3() throws IOException {
    CreationCommandsOperationService parser = new CreationCommandsOperationService(TEST_FILE_OF_COMMANDS3);

    parser.performModification(TEST_FILE_OF_CHANGES1, TEST_FILE_OF_COMMANDS3);

    List<CreationCommand> creationCommands = parser.extractCreationCommands(TEST_FILE_OF_CHANGES2);

    parser.placeCommandsBySeparatedFiles(creationCommands);
    parser.createLacRacUra(TEST_FILE_OF_CHANGES1);
    parser.writeNeighbors();
  }

  public void createLacRacUra(String fileOfChanges) {

    List<Map<String, String>> changeCommands = extractRehomeInformation(fileOfChanges);

    List<Map<String, String>> finalCommands = new ArrayList<>();

    for (Map<String, String> changeCommand : changeCommands) {

      List<Map<String, String>> contains = finalCommands.stream().filter(e -> e.get("Site").equals(changeCommand.get("Site"))).collect(Collectors.toList());

      if(contains.isEmpty()) {
        finalCommands.add(changeCommand);
      }

    }

    for (Map<String, String> finalCommand : finalCommands) {

      String site = finalCommand.get("Site");
      if(!rnc.contains(site)) continue;

      LacRacUra lacRacUra = new LacRacUra(finalCommand.get("New LAC"), finalCommand.get("New Ura"));

      if(new File(RESULT_FILES + site + "/" + LAC_RAC_URA).exists()) {
        new File(RESULT_FILES + site + "/" + LAC_RAC_URA).delete();
      }

      writeToFile(lacRacUra, RESULT_FILES + site + "/" + LAC_RAC_URA);
    }

  }

  public void writeNeighbors() {
    Set<String> neighbors = new TreeSet<>();
    List<String> siteAndNeighbors = new ArrayList<>();
    try {
      Path path = Paths.get(rnc + GSM_REL);
      List<String> strings = Files.readAllLines(path);

      if (new File(rnc+ SITES_NEIGHBORS).exists() && new File(rnc+ SITES_AND_NEIGHBORS).exists()) {
        Files.delete(Paths.get(rnc+ SITES_NEIGHBORS));
        Files.delete(Paths.get(rnc+ SITES_AND_NEIGHBORS));
      }

      if(!new File(rnc + SITES_NEIGHBORS).exists() && !new File(rnc + SITES_AND_NEIGHBORS).exists()) {
        Files.createFile(Paths.get(rnc + SITES_NEIGHBORS));
        Files.createFile(Paths.get(rnc + SITES_AND_NEIGHBORS));
      }


      for (String string : strings) {
        if(string.contains("GsmRelation")) {
          String site = string.split("[,=]")[3];
          String neighbor = string.split("[,=]")[5];
          neighbors.add(neighbor);
          siteAndNeighbors.add(site+" "+neighbor);
        }
      }

      for (String neighbor : neighbors) {
        Files.write(Paths.get(rnc+ SITES_NEIGHBORS), (neighbor+"\n").getBytes(), StandardOpenOption.APPEND);
      }

      for (String siteAndNeighbor : siteAndNeighbors) {
        Files.write(Paths.get(rnc + SITES_AND_NEIGHBORS), (siteAndNeighbor+"\n").getBytes(), StandardOpenOption.APPEND);
      }

    } catch (IOException e) {
      LOG.error("can't write to file, " + e);
    }

  }

  public boolean placeCommandsBySeparatedFiles(List<CreationCommand> creationCommands) {
    List<CreationCommand> skippedCommands = new ArrayList<>();

    validateFiles();
//    int i = 0;

    for (CreationCommand creationCommand : creationCommands) {
      if(creationCommand instanceof HcsSid11Config || creationCommand instanceof HsPathLossTreshold) {
        writeToFile(creationCommand, rnc + UTRAN_REl);
//        i++;
        continue;
      }

      if(creationCommand instanceof ExternalGsmCellRef || creationCommand instanceof BandIndicator) {
        writeToFile(creationCommand, rnc + GSM_REL);
//        i++;
        continue;
      }

      if(creationCommand instanceof BarredCnOperatorRef || creationCommand instanceof ExternalEutranCellRef) {
        writeToFile(creationCommand, rnc + EUTRAN);
//        i++;
        continue;
      }

      if(!(creationCommand instanceof Header)) {
        writeToFile(creationCommand, rnc + IUB_CELL);
//        i++;
        continue;
      }

      skippedCommands.add(creationCommand);

    }

    System.out.println(skippedCommands.size());

    for (CreationCommand skippedCommand : skippedCommands) {
      System.out.println("\n" + skippedCommand + "\n");
    }

//    System.out.println(i);
    return true;
  }

  private void validateFiles() {

    try {
      if (new File(rnc + IUB_CELL).exists()) {
        Path path = Paths.get(rnc + IUB_CELL);
        Files.delete(path);
      }

      if (new File(rnc + GSM_REL).exists()) {
        Path path = Paths.get(rnc + GSM_REL);
        Files.delete(path);
      }

      if (new File(rnc + UTRAN_REl).exists()) {
        Path path = Paths.get(rnc + UTRAN_REl);
        Files.delete(path);
      }

      if (new File(rnc + EUTRAN).exists()) {
        Path path = Paths.get(rnc + EUTRAN);
        Files.delete(path);
      }
    } catch (IOException e) {
      LOG.error("can't delete file", e);
    }

  }

  private void writeToFile(CreationCommand creationCommand, String fileName) {
    if(!new File(fileName).exists()) {
      try {
        Path path = Paths.get(fileName);
        Files.createFile(path);
      } catch (IOException e) {
        LOG.error("can't create new File because ", e);
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

  public List<CreationCommand> performModification(String fileOfChanges, String fileOfCreationCommands) {
    List<CreationCommand> creationCommands = extractCreationCommands(fileOfCreationCommands);

    List<Map<String, String>> changeCommands = extractRehomeInformation(fileOfChanges);

    List<CreationCommand> resultCommands = new ArrayList<>();
    try {
      resultCommands = updateValues(creationCommands, changeCommands, TEST_FILE_OF_CHANGES2);
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

  public static List<CreationCommand> updateValues(List<CreationCommand> parsedObjects, List<Map<String, String>> changeCommands, String fileOfResult) {

    if(parsedObjects == null || changeCommands == null) throw new IllegalArgumentException();

    List<CreationCommand> changedCreationCommands = new ArrayList<>();
    List<CreationCommand> onlyAseLoadThresholdUiSpeech = parsedObjects.stream().filter(e -> e.getType().equals(Patterns.ASE_LOAD_THRESHOLD_UI_SPEECH)).collect(Collectors.toList());
    List<CreationCommand> onlyAtmUserPlaneTermSubrackRef = parsedObjects.stream().filter(e -> e.getType().equals(Patterns.ATM_USER_PLANE_TERM_SUBRACK_REF)).collect(Collectors.toList());

    // TODO change as faster as you can
    boolean new_RBSID_1 = false;
    boolean new_RBSID_2 = false;

    for (CreationCommand atmUserPlaneTermSubrackRef : onlyAtmUserPlaneTermSubrackRef) {
      if(atmUserPlaneTermSubrackRef.getIubLink().contains("_1")) {
        new_RBSID_1 = true;
      }
      if(atmUserPlaneTermSubrackRef.getIubLink().contains("_2")) {
        new_RBSID_2 = true;
      }
    }

    List<Map<String, String>> finalCommands = new ArrayList<>();

    for (Map<String, String> changeCommand : changeCommands) {

      List<Map<String, String>> contains = finalCommands.stream().filter(e -> e.get("Site").equals(changeCommand.get("Site"))).collect(Collectors.toList());

      if(contains.isEmpty()) {
        finalCommands.add(changeCommand);
      }

    }

    for (Map<String, String> map : finalCommands) {

      String site = map.get("Site");

      if(!rnc.contains(site)) continue;

      if(!new_RBSID_1 && !new_RBSID_2) {
        ((AtmUserPlaneTermSubrackRef)onlyAtmUserPlaneTermSubrackRef.get(0)).setRbsId(Integer.parseInt(map.get("New_RBSID_1")));
      }

      for (CreationCommand creationCommand : onlyAtmUserPlaneTermSubrackRef) {
        if (new_RBSID_1 && creationCommand.getName().contains(site) && creationCommand.getIubLink().contains("_1")) {
          ((AtmUserPlaneTermSubrackRef) creationCommand).setRbsId(Integer.parseInt(map.get("New_RBSID_1")));
        }
        if (new_RBSID_2 && creationCommand.getName().contains(site) && creationCommand.getIubLink().contains("_2")) {
          String new_rbsid_2 = map.get("New_RBSID_2");

          if(new_rbsid_2 != null) {
            ((AtmUserPlaneTermSubrackRef) creationCommand).setRbsId(Integer.parseInt(map.get("New_RBSID_2")));
          }
        }
      }

    }

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

  public static List<Map<String, String>> extractRehomeInformation(String fileOfChanges) {
    ParseCsvFileService service = new ParseCsvFileService();
    return service.readMapCsv(fileOfChanges);
  }

  public static List<RncModification> extractAllRehomeInformation(String fileOfChanges) {
    ParseCsvFileService service = new ParseCsvFileService();
    return service.getAllFileChanges(fileOfChanges);
  }

  static boolean writeResult(List<CreationCommand> creationCommands, String fileOfResult) {
    final String header = creationCommands.get(0) == null ? "" : creationCommands.get(0) + "\ngs+\n\n";

    if(creationCommands.get(0) != null) creationCommands.remove(0);

    final String footer = "gs-\n";

    try {

      new File(fileOfResult).delete();
      new File(fileOfResult).createNewFile();

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
