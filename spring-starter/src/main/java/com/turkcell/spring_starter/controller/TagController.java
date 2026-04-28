package com.turkcell.spring_starter.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.turkcell.spring_starter.entity.Tag;
import com.turkcell.spring_starter.service.TagServiceImpl;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    private final TagServiceImpl tagService;

    public TagController(TagServiceImpl tagService) {
        this.tagService = tagService;
    }

    @PostMapping
    public Tag create(@RequestBody Tag tag){
        return tagService.create(tag);
    }

    @GetMapping
    public List<Tag> getAll(){
        return tagService.getAll();
    }

    @GetMapping("/{id}")
    public Tag getById(@PathVariable UUID id){
        return tagService.getById(id);
    }

    @PutMapping("/{id}")
    public Tag update(@PathVariable UUID id, @RequestBody Tag tag){
        return tagService.update(id, tag);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        tagService.delete(id);
    }
}