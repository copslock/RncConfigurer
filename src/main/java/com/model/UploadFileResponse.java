package com.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class UploadFileResponse {
  private String fileName;
  private String fileDownloadUri;
  private String fileType;
  private long size;
  private Map<String,List<String>> validation;

  public UploadFileResponse(String fileName, String fileDownloadUri, String fileType, long size, Map<String,List<String>> validation) {
    this.fileName = fileName;
    this.fileDownloadUri = fileDownloadUri;
    this.fileType = fileType;
    this.size = size;
    this.validation = validation;
  }


}
