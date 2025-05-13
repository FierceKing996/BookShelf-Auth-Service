package com.example.booklibrary.controller;

import com.example.booklibrary.model.Author;
import com.example.booklibrary.service.authorservice;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Author")
public class authorcontroller {
    private final authorservice svc;
    public authorcontroller(authorservice svc){this.svc=svc;}
    @GetMapping
    public List<Author> list(){return svc.list();}
    @PostMapping
    public ResponseEntity<Author> create(@Validated @RequestBody Author a){
        Author saved = svc.create(a);
        return ResponseEntity.ok(saved);
    }
    @GetMapping("/{id}")
    public Author get(@PathVariable Long id){return svc.get(id);}
    @DeleteMapping("/{id}")
    public ResponseEntity<Author> delete(@PathVariable Long id){
        svc.delete(id);
        return ResponseEntity.noContent().build();
    }
}
