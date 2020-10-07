package com.controller;

//import com.dao.RncListRepository;
//import com.dao.RncRepository;

import com.responses.Response;
import com.responses.UploadFileException;
import com.responses.UploadFileResponse;
import com.service.CreationCommandsOperationService;
import com.service.FileStorageService;
import com.service.ParseCsvFileService;
import com.service.FtpService;
import com.service.SshService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "Content-Disposition")
@RestController
@RequestMapping("/api/v1/rnc")
public class FileController {

  private static final Logger LOG = LoggerFactory.getLogger(FileController.class);
  private static String lastFileName;

  private FileStorageService fileStorageService;
  private ParseCsvFileService parseCsvFile;
  private CreationCommandsOperationService parser;

  @Autowired
  public FileController(
          FileStorageService fileStorageService,
          ParseCsvFileService parseCsvFile,
          CreationCommandsOperationService parser
  ) {
    this.fileStorageService = fileStorageService;
    this.parseCsvFile = parseCsvFile;
    this.parser = parser;
  }

  @RequestMapping("/user")
  public Principal user(Principal user) {
    return user;
  }

  @PostMapping("/upload")
  public Response uploadRncMaximoTable(@RequestParam("file") MultipartFile file) {
    if(!fileStorageService.validateFile(file)) {
      return new UploadFileException("validation is unsuccessfully");
    }

    String fileName = fileStorageService.storeFile(file);

    FileController.lastFileName = fileName;
    String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("fileOfChanges/")
        .path(fileName)
        .toUriString();

    return new UploadFileResponse(fileName, fileDownloadUri,
        file.getContentType(), file.getSize(), Collections.emptyMap());
  }

  @PostMapping(path = "/uploadMultipleFiles")
  public List<Response> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
    return Arrays.stream(files)
        .map(this::uploadRncMaximoTable)
        .collect(Collectors.toList());
  }

  @GetMapping("/downloadFile/{fileName:.+}")
  public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {

    Resource resource = fileStorageService.loadFileAsResource(fileName);

    String contentType = null;
    try {
      contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
    } catch (IOException ex) {
      LOG.info("Could not determine file type.");
    }

    if(contentType == null) {
      contentType = "application/octet-stream";
    }

    return ResponseEntity.ok()
        .contentType(MediaType.parseMediaType(contentType))
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
        .body(resource);
  }


  @GetMapping(value = "/fileNames", produces = "application/json")
  public List<String> getFileNames() {
    List<String> fileNames = Arrays.asList("RncMaximoTable.csv", "oldFileOfChanges/RncMaximoTable1.csv", "RncMaximoTable2.csv");
    return fileNames;
  }

  @GetMapping("/fileMap/{id}")
  public List<Map<String, String>> getFileMapNames(@PathVariable String id) {
    return parseCsvFile.readMapCsv(id);
  }

  @GetMapping(value = "/download/files", produces="application/zip")
  public ResponseEntity<Resource> downloadResultFiles(HttpServletRequest request) throws Exception {

    long start = System.nanoTime();

    FileUtils.cleanDirectory(new File("D:\\Arthur\\My_Projects\\javaProjects\\RncConfigurerParser\\rncCreationCommands"));

    final List<String> strings = SshService.connectSsh3();

    FtpService.connectViaFtp(strings.get(0), "D:\\Arthur\\My_Projects\\javaProjects\\RncConfigurerParser\\rncCreationCommands");
    FtpService.connectViaFtp(strings.get(1), "D:\\Arthur\\My_Projects\\javaProjects\\RncConfigurerParser\\rncCreationCommands");

    long end = System.nanoTime();

    LOG.debug("time of execution = " + (end-start) + " nanoseconds");


    List<String> srcFiles = new ArrayList<>();

    File folder = new File("rncCreationCommands");
    File[] listOfFiles = folder.listFiles();

    if(null != listOfFiles) {
      for (File listOfFile : listOfFiles) {
        if (listOfFile.isFile()) {
          srcFiles.add("rncCreationCommands/" + listOfFile.getName());
        }
      }
    }

    FileOutputStream fos = new FileOutputStream("rncCreationCommands/multiCompressed.zip");
    ZipOutputStream zipOut = new ZipOutputStream(fos);
    for (String srcFile : srcFiles) {
      File fileToZip = new File(srcFile);
      FileInputStream fis = new FileInputStream(fileToZip);
      ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
      zipOut.putNextEntry(zipEntry);

      byte[] bytes = new byte[1024];
      int length;
      while((length = fis.read(bytes)) >= 0) {
        zipOut.write(bytes, 0, length);
      }
      fis.close();
    }
    zipOut.close();
    fos.close();

    Resource resource = fileStorageService.loadFilesAsResource();

    String contentType = null;
    try {
      contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
    } catch (IOException ex) {
      LOG.info("Could not determine file type.");
    }

    if(contentType == null) {
      contentType = "application/zip";
    }

    return ResponseEntity.ok()
      .contentLength(resource.contentLength())
      .contentType(MediaType.parseMediaType(contentType))
      .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
      .body(resource);
  }

  /*
  // TODO its code is important
  @GetMapping("/modifyFile/{filename}")
  public List<List<Map<String, String>>> preformModification(@PathVariable("filename") String fileOfChanges) {

    System.out.println(fileOfChanges);

    List<List<Map<String, String>>> listChangesAndListResults = new ArrayList<>();

    parser.execute(fileOfChanges);

    for (CreationCommand creationCommand : creationCommands) {
      valuesAfter.add(creationCommand.getValues());
    }

    for (CreationCommand creationCommand : creationCommandsBefore) {
      valuesBefore.add(creationCommand.getValues());
    }

    listChangesAndListResults.add(valuesBefore);
    listChangesAndListResults.add(valuesAfter);

    return listChangesAndListResults;
  }
   */
}
