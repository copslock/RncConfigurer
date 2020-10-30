package com.service;

import com.controller.FileController;
import com.model.RncModification;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class FileService {

  private static final Logger LOG = LoggerFactory.getLogger(FileController.class);

  private FileStorageService fileStorageService;
  private FileParsingService parseCsvFileService;
  private CreationCommandsOperationService creationCommandsOperationService;

  public FileService(FileStorageService fileStorageService, FileParsingService parseCsvFileService, CreationCommandsOperationService creationCommandsOperationService) {
    this.fileStorageService = fileStorageService;
    this.parseCsvFileService = parseCsvFileService;
    this.creationCommandsOperationService = creationCommandsOperationService;
  }

  public Resource getFileFromRemote() throws Exception {

    String pathToCreationCommands = "filesOfChanges/fileOfChanges.csv";
    long start = System.nanoTime();

    final List<RncModification> filesChanges = parseCsvFileService.getAllFileChanges(pathToCreationCommands);

    FileUtils.cleanDirectory(new File(pathToCreationCommands));

    final List<String> strings = SshService.createFilesInRemote(filesChanges);

    FtpService.connectViaFtp(strings.get(0), pathToCreationCommands);
    FtpService.connectViaFtp(strings.get(1), pathToCreationCommands);

    long end = System.nanoTime();

    creationCommandsOperationService.execute(pathToCreationCommands);

    LOG.debug("time of execution = " + (end-start) + " nanoseconds");

    Resource resource = fileStorageService.loadUpdatedFilesAsResource();

    return resource;
  }

}
