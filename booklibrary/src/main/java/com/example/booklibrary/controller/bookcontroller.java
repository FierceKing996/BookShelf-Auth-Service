package com.example.booklibrary.controller;

import com.example.booklibrary.dto.bookdto;
import com.example.booklibrary.model.book;
import com.example.booklibrary.service.bookservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class bookcontroller {
    private final bookservice svc;
    public bookcontroller(bookservice svc){this.svc = svc;}
    @GetMapping("/{id}")
    public book get(@PathVariable Long id){return svc.get(id);}
    @GetMapping
    public List<book> list(){return svc.list();}
    @PostMapping
    public ResponseEntity<bookdto> create(@Validated @RequestBody bookdto bookdto2){
        bookdto created = svc.create(bookdto2);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(created);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<book> delete(@PathVariable Long id){
        svc.delete(id);
        return ResponseEntity.noContent().build();
    }
}
