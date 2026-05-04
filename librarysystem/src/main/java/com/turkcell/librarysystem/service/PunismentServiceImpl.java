package com.turkcell.librarysystem.service;

import org.springframework.stereotype.Service;

import com.turkcell.librarysystem.repository.PunismentsRepository;

@Service
public class PunismentServiceImpl {
    private final PunismentsRepository punismentsRepository;

    public PunismentServiceImpl(PunismentsRepository punismentsRepository) {
        this.punismentsRepository = punismentsRepository;
    }

    

}
