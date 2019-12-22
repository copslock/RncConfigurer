package com.controller;

import com.dao.RncListRepository;
import com.dao.RncRepository;
import com.model.Rnc;
import com.model.RncList;
import com.model.UploadFileResponse;
import com.service.FileStorageService;
import com.service.ParseCsvFileService;
import com.service.RncParseAndSave;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", exposedHeaders = "Content-Disposition")
@RestController
@RequestMapping("/api")
public class FileController {

  private static final Logger logger = LoggerFactory.getLogger(FileController.class);
  private static String lastFileName;

  @Autowired
  private FileStorageService fileStorageService;

  @Autowired
  private ParseCsvFileService parseCsvFile;

  @Autowired
  private RncParseAndSave rncParseAndSave;

  @Autowired
  private RncRepository entityRepository;

  @Autowired
  private RncListRepository rncRepo;

  @PostMapping("/uploadFile")
  public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
    String fileName = fileStorageService.storeFile(file);

    FileController.lastFileName = fileName;
    String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/downloadFile/")
        .path(fileName)
        .toUriString();

    rncParseAndSave.parseAndSave(fileName);
    Map<String,List<String>> validation = fileStorageService.checkRncExisting(fileName);

    return new UploadFileResponse(fileName, fileDownloadUri,
        file.getContentType(), file.getSize(), validation);
  }

  @GetMapping("/fileMap")
  public List<Map<String, String>> getFileMapName() {
    return parseCsvFile.readMapCsv(FileController.lastFileName);
  }

  @PostMapping(path = "/uploadMultipleFiles")
  public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
    return Arrays.stream(files)
        .map(this::uploadFile)
        .collect(Collectors.toList());
  }

  @GetMapping("/downloadFile/{fileName:.+}")
  public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {

    Resource resource = fileStorageService.loadFileAsResource(fileName);

    String contentType = null;
    try {
      contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
    } catch (IOException ex) {
      logger.info("Could not determine file type.");
    }

    if(contentType == null) {
      contentType = "application/octet-stream";
    }

    return ResponseEntity.ok()
        .contentType(MediaType.parseMediaType(contentType))
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
        .body(resource);
  }

  @GetMapping("/downloadStrings")
  public List<List<String>> downloadcsv() {
    return parseCsvFile.readCsv(null);
  }

  @GetMapping("/fileNames")
  public List<String> getFileNames() {
    List<String> fileNames = Arrays.asList("RncMaximoTable.csv", "RncMaximoTable1.csv", "RncMaximoTable2.csv");
    return fileNames;
  }

  @GetMapping("/file/{id}")
  public List<List<String>> getFileNames(@PathVariable String id) {
    return parseCsvFile.readCsv(id);
  }

  @GetMapping("/fileMap/{id}")
  public List<Map<String, String>> getFileMapNames(@PathVariable String id) {
    return parseCsvFile.readMapCsv(id);
  }

  @PostMapping(path="/repo/add")
  public @ResponseBody String addNewUser (@RequestBody Rnc entity) {

    entityRepository.save(entity);
    return "Saved";
  }

  @GetMapping(path="/repo/all")
  public @ResponseBody Iterable<Rnc> getAllUsers() {

    return entityRepository.findAll();
  }

  @PostMapping("/repo/save")
  public HttpStatus addNewRnc(@RequestBody RncList rnc) {

    rncRepo.save(rnc);

    return HttpStatus.OK;
  }

  @GetMapping("/repo/check/{id}")
  public boolean checkRnc(@PathVariable("id") int id) {
    if(rncRepo.existsById(id)) {
      return true;
    }

    return false;
  }

}
