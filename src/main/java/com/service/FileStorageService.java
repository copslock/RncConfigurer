package com.service;

//import com.dao.RncListRepository;
import com.exceptions.FileStorageException;
import com.exceptions.MyFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Service
public class FileStorageService {

//  @Autowired
//  private RncListRepository rncRepository;

  @Autowired
  private ParseCsvFileService service;

  private final Path fileStorageLocation;

  @Value("${file.upload-dir}")
  private String pathToUploads;

  @Autowired
  public FileStorageService() {
    this.fileStorageLocation = Paths.get("/home/atian/Documents/uploads")
        .toAbsolutePath().normalize();

    try {
      Files.createDirectories(this.fileStorageLocation);
    } catch (Exception ex) {
      throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
    }
  }

//  public Map<String,List<String>> checkRncExisting(String fileName) {
//    Set<String> rncNames = service.checkedFields(fileName, "BSC", "New BSC");
//    Map<String,List<String>> notFinedRnc = new HashMap<>();
//    notFinedRnc.put("rnc", new ArrayList<>());
//
//    for (String rncName : rncNames) {
//      if(rncRepository.findByName(rncName).isEmpty()) {
//        notFinedRnc.get("rnc").add(rncName);
//      }
//    }
//
//    if(!notFinedRnc.get("rnc").isEmpty()) {
//      notFinedRnc.put("isValid", Arrays.asList("false"));
//      return  notFinedRnc;
//    }
//    notFinedRnc.put("isValid", Arrays.asList("true"));
//    return  notFinedRnc;
//  }

  public String storeFile(MultipartFile file) {
    // Normalize file name
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());

    try {
      // Check if the file's name contains invalid characters
      if (fileName.contains("..")) {
        throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
      }

      // Copy file to the target location (Replacing existing file with the same name)
      Path targetLocation = this.fileStorageLocation.resolve(fileName);
      Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

      return fileName;
    } catch (IOException ex) {
      throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
    }
  }

  public Resource loadFileAsResource(String fileName) {
    try {
      Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
      Resource resource = new UrlResource(filePath.toUri());
      if (resource.exists()) {
        return resource;
      } else {
        throw new MyFileNotFoundException("File not found " + fileName);
      }
    } catch (MalformedURLException ex) {
      throw new MyFileNotFoundException("File not found " + fileName, ex);
    }
  }
}