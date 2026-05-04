package com.turkcell.librarysystem.service;

import org.springframework.stereotype.Service;

import com.turkcell.librarysystem.repository.RefundsRepository;

@Service
public class RefundServiceImpl {
    private final RefundsRepository refundsRepository;

    public RefundServiceImpl(RefundsRepository refundsRepository) {
        this.refundsRepository = refundsRepository;
    }
    

}
