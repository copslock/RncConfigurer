package com.service;

//import com.dao.RncListRepository;
import com.exceptions.FileStorageException;
import com.exceptions.MyFileNotFoundException;
import com.model.FileOfChanges;
import com.model.RncModification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class FileStorageService {

  private static final Logger LOG = LogManager.getLogger(FileParsingService.class);

  private final Path fileStorageLocation;
  private final Path oldFilesDirectory;

  public FileStorageService() {

    this.fileStorageLocation = Paths.get("filesOfChanges/")
        .toAbsolutePath().normalize();
    this.oldFilesDirectory = Paths.get("oldFiles/")
            .toAbsolutePath().normalize();

    try {
      if(!Files.exists(this.fileStorageLocation)) {
        Files.createDirectories(this.fileStorageLocation);
      }

      if(!Files.exists(oldFilesDirectory)) {
        Files.createDirectories(this.oldFilesDirectory);
      }
    } catch (Exception ex) {
      throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
    }
  }

  public String storeFile(MultipartFile file) {
    // Normalize file name
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());

    try (InputStream in = file.getInputStream()) {
      // Check if the file's name contains invalid characters
      if (fileName.contains("..")) {
        throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
      }

      // Copy file to the target location (Replacing existing file with the same name)
      Path targetLocation = this.fileStorageLocation.resolve(fileName);

      if (Files.exists(targetLocation)) {
        Path targetLocationForOldFile = oldFilesDirectory.resolve(fileName);
        Files.copy(targetLocation, targetLocationForOldFile, StandardCopyOption.REPLACE_EXISTING);
      } else {
        Files.copy(in, targetLocation, StandardCopyOption.REPLACE_EXISTING);
      }

      return fileName;
    } catch (IOException ex) {
      throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
    }
  }

  public boolean validateFile(MultipartFile file) {

    if(!(StringUtils.cleanPath(file.getOriginalFilename()).contains("csv") || StringUtils.cleanPath(file.getOriginalFilename()).contains("xlsx"))) {
      LOG.error("given file is not valid - " + file.getName());
      return false;
    }

    List<RncModification> modifications = new ArrayList<>();

    try(BufferedReader bf = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

      List<String> strings = new ArrayList<>();

      while(bf.ready()) {
        strings.add(bf.readLine());
      }

      strings.remove(0);
      Set<String> rncNames = strings.stream().map(e -> e.split(",")[2]).collect(Collectors.toSet());

      for (String rncName : rncNames) {
        List<FileOfChanges> lines = new ArrayList<>();

        for (String string : strings) {
          if (string.split(",")[2].equals(rncName)) {
            lines.add(new FileOfChanges(string));
          }
        }

        RncModification rncModification = new RncModification(lines);
        modifications.add(rncModification);
      }

    } catch (IOException | ArrayIndexOutOfBoundsException e) {
      LOG.error("given file is not valid - " + file.getName());
      return false;
    }

    return true;
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

  public String zipArchive(String zipName, String directoryToArchive) {

    try (FileOutputStream fos = new FileOutputStream(directoryToArchive + "/" + zipName);
         ZipOutputStream zipOut = new ZipOutputStream(fos)) {

      List<String> srcFiles = new ArrayList<>();

      File folder = new File(directoryToArchive);
      File[] listOfFiles = folder.listFiles();

      if (null != listOfFiles) {
        for (File listOfFile : listOfFiles) {
          if (listOfFile.isFile()) {
            srcFiles.add(directoryToArchive + "/" + listOfFile.getName());
          }
        }
      }

      for (String srcFile : srcFiles) {
        File fileToZip = new File(srcFile);
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
        zipOut.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
          zipOut.write(bytes, 0, length);
        }
        fis.close();
      }

    } catch (IOException e) {
      LOG.error("problem with file ", e);
    }

    return zipName;
  }

  public Resource loadFilesAsResource() {

    final String zipArchive = zipArchive("multiCompressed.zip", "rncCreationCommands");
    String archivedDirectory = "rncCreationCommands";

    try {
      Path filePath = Paths.get(archivedDirectory + "/").resolve(zipArchive).normalize();
      Resource resource = new UrlResource(filePath.toUri());
      if (resource.exists()) {
        return resource;
      } else {
        throw new MyFileNotFoundException("File not found " + archivedDirectory + "/" + zipArchive);
      }
    } catch (MalformedURLException ex) {
      throw new MyFileNotFoundException("File not found " + archivedDirectory + "/" + zipArchive, ex);
    }
  }

  public Resource loadUpdatedFilesAsResource() {

    final String zipArchive = zipArchive("afterModification.zip", "afterModification");
    String archivedDirectory = "afterModification";

    try {
      Path filePath = Paths.get(archivedDirectory + "/").resolve(zipArchive).normalize();
      Resource resource = new UrlResource(filePath.toUri());
      if (resource.exists()) {
        return resource;
      } else {
        throw new MyFileNotFoundException("File not found " + archivedDirectory + "/" + zipArchive);
      }
    } catch (MalformedURLException ex) {
      throw new MyFileNotFoundException("File not found " + archivedDirectory + "/" + zipArchive, ex);
    }
  }
}
