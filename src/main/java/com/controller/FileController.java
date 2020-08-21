package com.controller;

//import com.dao.RncListRepository;
//import com.dao.RncRepository;
import com.google.gson.JsonObject;
import com.responses.Response;
import com.responses.UploadFileException;
import com.responses.UploadFileResponse;
import com.service.FileStorageService;
import com.service.ParseCsvFileService;
import com.service.RncParseAndSave;
import com.service.CreationCommandsOperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4201", exposedHeaders = "Content-Disposition")
@RestController
@RequestMapping("/api/v1/rnc")
public class FileController {

  private static final Logger logger = LoggerFactory.getLogger(FileController.class);
  private static String lastFileName;

  private FileStorageService fileStorageService;
  private ParseCsvFileService parseCsvFile;
  private RncParseAndSave rncParseAndSave;
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
        .path("/fileOfChanges/")
        .path(fileName)
        .toUriString();

    return new UploadFileResponse(fileName, fileDownloadUri,
        file.getContentType(), file.getSize(), Collections.emptyMap());
  }

  @PostMapping(value = "/login", produces = "application/json")
  public String isLogin() {
    return "{\"name\": \"aa\"}";
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
//    try {
//      contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
//    } catch (IOException ex) {
//      logger.info("Could not determine file type.");
//    }

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

//  @PostMapping(path="/repo/add")
//  public @ResponseBody String addNewUser (@RequestBody Rnc entity) {
//
//    entityRepository.save(entity);
//    return "Saved";
//  }

//  @GetMapping(path="/repo/all")
//  public @ResponseBody Iterable<Rnc> getAllUsers() {
//
//    return entityRepository.findAll();
//  }

//  @PostMapping("/repo/save")
//  public HttpStatus addNewRnc(@RequestBody RncList rnc) {
//
//    rncRepo.save(rnc);
//
//    return HttpStatus.OK;
//  }

//  @GetMapping("/repo/check/{id}")
//  public boolean checkRnc(@PathVariable("id") int id) {
//    if(rncRepo.existsById(id)) {
//      return true;
//    }
//
//    return false;
//  }

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
