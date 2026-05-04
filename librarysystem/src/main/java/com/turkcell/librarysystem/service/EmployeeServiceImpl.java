package com.turkcell.librarysystem.service;

import org.springframework.stereotype.Service;

import com.turkcell.librarysystem.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl {
 private final EmployeeRepository employeeRepository;

 public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
 }
 
}
