package com.service;

import com.opencsv.CSVReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

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
    if(null == fileName || fileName.isEmpty() || isValidateFileName(fileName)) {
      csvFile = "/home/atian/Documents/arturProjects/RncConfigurerParser/src/main/resources//RncMaximoTable1.csv";
    } else {
      csvFile = "/home/atian/Documents/arturProjects/RncConfigurerParser/src/main/resources/" + fileName;
    }

    CSVReader reader = null;

    try {
      reader = new CSVReader(new FileReader(csvFile));

      String[] line;
      List<String> headers = Arrays.asList(reader.readNext());

      while ((line = reader.readNext()) != null) {
        Map<String, String> values = new TreeMap<>();
        if(line.length > 0) {
          for (int i = 0; i < headers.size(); i++) {
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

    if(Files.exists(new File("/home/atian/Documents/uploads/" + file).toPath())) {
      return false;
    }

    return false;
  }

}
