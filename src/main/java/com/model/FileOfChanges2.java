package com.model;

import java.util.ArrayList;
import java.util.List;

public class FileOfChanges2 {

  private List<String> headers = new ArrayList<>();
  private List<List<String>> values = new ArrayList<>();

  public FileOfChanges2() {
  }

  public FileOfChanges2(List<String> headers, List<List<String>> values) {
    this.headers = headers;
    this.values = values;
  }

  public List<String> getHeaders() {
    return headers;
  }

  public void setHeaders(List<String> headers) {
    this.headers = headers;
  }

  public List<List<String>> getValues() {
    return values;
  }

  public void setValues(List<List<String>> values) {
    this.values = values;
  }
}
