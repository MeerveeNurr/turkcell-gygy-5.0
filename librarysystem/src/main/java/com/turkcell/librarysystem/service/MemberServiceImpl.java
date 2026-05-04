package com.turkcell.librarysystem.service;

import org.springframework.stereotype.Service;

import com.turkcell.librarysystem.repository.MembersRepository;

@Service
public class MemberServiceImpl {
private final MembersRepository membersRepository;

public MemberServiceImpl(MembersRepository membersRepository) {
    this.membersRepository = membersRepository;
}

}
