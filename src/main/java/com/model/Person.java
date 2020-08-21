package com.model;

public class Person {
  private String fullName;
  private String lastName;
  private String password;

  public Person() {
  }

  public Person(String fullName, String lastName, String password) {
    this.fullName = fullName;
    this.lastName = lastName;
    this.password = password;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "Person{" +
      "fullName='" + fullName + '\'' +
      ", lastName='" + lastName + '\'' +
      '}';
  }
}
