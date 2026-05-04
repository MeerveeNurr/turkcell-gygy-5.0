package com.turkcell.librarysystem.dto;

import java.sql.Date;

public class CreateEmployeeRequest {
  private String name;
  private String surname;
  private String tckn;
  private Date termOfOffice;
  
  public Date getTermOfOffice() {
    return termOfOffice;
  }
  public void setTermOfOffice(Date termOfOffice) {
    this.termOfOffice = termOfOffice;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getSurname() {
    return surname;
  }
  public void setSurname(String surname) {
    this.surname = surname;
  }
  public String getTckn() {
    return tckn;
  }
  public void setTckn(String tckn) {
    this.tckn = tckn;
  }
  
}
