package com.service;

import com.model.FileOfChanges;
import com.model.RncModification;
import com.opencsv.CSVReader;
import com.utils.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParseCsvFileService {

  private static final Logger LOG = LogManager.getLogger(ParseCsvFileService.class);

  public List<List<String>> readCsv(String fileName) {
    List<List<String>> lines = new ArrayList<>();
    String csvFile;
    if(null == fileName || fileName.isEmpty() || isValidateFileName(fileName)) {
      csvFile = "/home/atian/Documents/uploads/RncMaximoTable.csv";
    } else {
      csvFile = "/home/atian/Documents/uploads/" + fileName;
    }

    CSVReader reader = null;

    try {

      Files.readAllLines(new File(csvFile).toPath()).stream().filter(e -> e.length() > 0).forEach(e -> lines.add(Arrays.asList(e)));

//      reader = new CSVReader(new FileReader(csvFile));
//
//      String[] line;
//      while ((line = reader.readNext()) != null) {
//        if(line.length > 0) {
//          lines.add(Arrays.asList(line));
//        }
//      }

    } catch (IOException e) {
      LOG.error("something went wrong ", e);
    }

    return  lines;
  }

  public List<Map<String, String>> readMapCsv(String fileName) {
    List<Map<String, String>> lines = new ArrayList<>();
    String csvFile;
    int id = 1;
    if(null == fileName || fileName.isEmpty() || !isValidateFileName(fileName)) {
      csvFile = Constants.TEST_FILE_OF_CHANGES1;
    } else {
      csvFile = fileName;
    }

    CSVReader reader = null;

    try {
      reader = new CSVReader(new FileReader(csvFile));

      String[] line;
      List<String> headers = Arrays.asList(reader.readNext());

      while ((line = reader.readNext()) != null) {
        Map<String, String> values = new TreeMap<>();
        if(line.length > 0) {
          for (int i = 0; i < line.length; i++) {
            values.put(headers.get(i), line[i]);
          }
        }
        values.put("id", ""+id++);
        if(!values.isEmpty()) {
          lines.add(values);
        }
      }

    } catch (IOException e) {
      LOG.error("something went wrong ", e);
    }

    return  lines;
  }

  public List<RncModification> getAllFileChanges(String fileName) {
    List<RncModification> modifications = new ArrayList<>();
    List<FileOfChanges> lines = new ArrayList<>();

    try {

      List<String> strings = Files.readAllLines(Paths.get(fileName));
      strings.remove(0);
      Set<String> rncNames = strings.stream().map(e -> e.split(",")[2]).collect(Collectors.toSet());

      for (String rncName : rncNames) {

        for (String string : strings) {
          if(string.contains(rncName)) {
            lines.add(new FileOfChanges(string));
          }
        }

        RncModification rncModification = new RncModification(lines);
        modifications.add(rncModification);
        lines.clear();
      }


    } catch (IOException e) {
      LOG.error("something went wrong ", e);
    }

    return modifications;
  }

  public Set<String> checkedFields(String ... columns) {

    Set<String> rncNames = new HashSet<>();

    List<Map<String, String>> maps = readMapCsv(columns[0]);

    for (Map<String, String> map : maps) {
      for (String param : Arrays.copyOfRange(columns, 1, columns.length)) {
        rncNames.add(map.get(param));
      }
    }

    return rncNames;
  }

  private boolean isValidateFileName(String file) {

    if(new File(file).exists()) {
      return true;
    }

    return false;
  }

}
