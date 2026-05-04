package com.turkcell.librarysystem.service;

import org.springframework.stereotype.Service;

import com.turkcell.librarysystem.repository.LendsRepository;

@Service
public class LendServiceImpl {
 private final LendsRepository lendsRepository;

 public LendServiceImpl(LendsRepository lendsRepository) {
    this.lendsRepository = lendsRepository;
 }
 
}
