package com.turkcell.spring_starter.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.spring_starter.entity.Tag;
import com.turkcell.spring_starter.repository.TagRepository;

@Service
public class TagServiceImpl {

    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag create(Tag tag){
        return tagRepository.save(tag);
    }

    public List<Tag> getAll(){
        return tagRepository.findAll();
    }

    public Tag getById(UUID id){
        return tagRepository.findById(id).orElseThrow();
    }

    public Tag update(UUID id, Tag tag){
        Tag existing = tagRepository.findById(id).orElseThrow();
        existing.setName(tag.getName());
        return tagRepository.save(existing);
    }

    public void delete(UUID id){
        Tag tag = tagRepository.findById(id).orElseThrow();
        tagRepository.delete(tag);
    }
}