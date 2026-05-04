package com.turkcell.librarysystem.dto;
import java.util.UUID;

public class CreatedEmployeeResponse {
 private UUID id;
 private String name;
 private String surname;
 private String tckn;
 private String termOfOffice;
 
 public String getTermOfOffice() {
    return termOfOffice;
}
 public void setTermOfOffice(String termOfOffice) {
    this.termOfOffice = termOfOffice;
 }
 public UUID getId() {
    return id;
 }
 public void setId(UUID id) {
    this.id = id;
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
