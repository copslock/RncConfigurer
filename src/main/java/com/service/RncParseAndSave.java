package com.service;

import com.dao.RncRepository;
import com.model.Rnc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Service
public class RncParseAndSave {

  @Autowired
  RncRepository repository;

  public boolean parseAndSave(String filename) {

    String csvFile;
    if(null == filename || filename.isEmpty()) {
      csvFile = "/home/atian/Documents/uploads/RncMaximoTable.csv";
    } else {
      csvFile = "/home/atian/Documents/uploads/" + filename;
    }

    File file = new File(csvFile);

   try {
     List<String> strings = Files.readAllLines(file.toPath());
     strings.remove(0);
     long id = 0;

     for (String string : strings) {
       if (string.isEmpty()) {
         continue;
       }
       String[] split = string.split(",");

       Rnc rnc = new Rnc(id++, split[0], split[1], split[2], split[3], split[4], split[5], split[6], split[7], split[8], split[9], split[10]);

       repository.save(rnc);
     }

   } catch (IOException e) {

   }
    return true;
  }

}
